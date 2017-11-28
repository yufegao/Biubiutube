package ui.network.university.college.viewer;

import biz.account.Account;
import biz.ad.Ad;
import biz.video.Video;
import ui.components.BiubiuBrowser;
import ui.components.ChildComponent;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.my.RedeemJPanel;

import javax.swing.*;
import java.awt.*;

public class ViewVideo extends JPanel implements HasTitle, ChildComponent {
    private Account account;
    private Video video;
    private ParentUI parent;

    private JSplitPane jSplitPane;

    private int countDown;
    private JButton btnSkip;

    public ViewVideo(ParentUI parent, Video video, Account account) {
        this.account = account;
        this.video = video;
        this.parent = parent;
        video.getViewHistoryCatalog().newViewHistory(account);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        Ad ad = video.getAd();
        if (ad == null) {
            System.out.println("no ad");
            System.out.println(video.getAdType());
            loadVideo();
        } else {
            loadAd(ad);
        }
    }

    private void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    private void updateBtnSkip() {
        if (countDown > 0) {
            countDown -= 1;
            btnSkip.setText(String.format("Skip  Ad(%d) >>", countDown));
        }
    }

    private void loadAd(Ad ad) {
        removeAll();
        JPanel adPanel = new JPanel();
        adPanel.setLayout(new BorderLayout());
        EventQueue.invokeLater(() -> {
            BiubiuBrowser.getInstance().browser.loadURL(ad.getUrl());
            adPanel.add(BiubiuBrowser.getInstance().view);

            setTimeout(() -> {
                if (parent.isTop(this)) {
                    loadVideo();
                }
            }, 15000);

            for (int i = 1; i < 16; i++) {
                setTimeout(this::updateBtnSkip, 1000 * i);
            }
            revalidate();
            repaint();
        });

        countDown = 15;
        btnSkip = new JButton(String.format("Skip  Ad(%d) >>", countDown));
        btnSkip.addActionListener(e -> {
            if (account.getPrimeMembership().isExpired()) {
                int res = JOptionPane.showConfirmDialog(
                        this,
                        "Only Prime member can skip ad, Redeem?",
                        "Error",
                        JOptionPane.YES_NO_OPTION
                );
                if (res == JOptionPane.YES_OPTION) {
                    parent.pushComponent(new RedeemJPanel(parent, account));
                }
                return;
            }
            countDown = 0;
            loadVideo();
        });
        adPanel.add(btnSkip, BorderLayout.PAGE_END);
        add(adPanel);

        revalidate();
        repaint();
    }

    private void loadVideo() {
        removeAll();

        // jSplitPane
        jSplitPane = new JSplitPane();
        jSplitPane.setDividerLocation(720);
        jSplitPane.setEnabled(false);
        add(jSplitPane);

        // rightPanel
        populateCommentList();

        // leftPanel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        jSplitPane.setLeftComponent(leftPanel);

        // watchJPanel
        JPanel watchJPanel = new JPanel();
        watchJPanel.setLayout(new BoxLayout(watchJPanel, BoxLayout.X_AXIS));

        watchJPanel.setMaximumSize(new Dimension(720, 405));
        watchJPanel.setMinimumSize(new Dimension(720, 405));
        watchJPanel.setPreferredSize(new Dimension(720, 405));

        EventQueue.invokeLater(() -> {
            watchJPanel.add(BiubiuBrowser.getInstance().view);
            BiubiuBrowser.getInstance().browser.loadURL(video.getUrl());
            revalidate();
            repaint();
        });
        leftPanel.add(watchJPanel);

        // info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
        infoPanel.add(new JLabel(String.format("Views: %d", video.getViewHistoryCatalog().getViewHistoryArrayList().size())));
        infoPanel.add(Box.createHorizontalGlue());
        JLabel voteLabel = new JLabel(String.format("Up Votes: %d", video.getVoteCatalog().getVoteArrayList().size()));
        infoPanel.add(voteLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        JButton btnVote = new JButton();
        if (video.getVoteCatalog().getVoteArrayList().stream().anyMatch(v -> v.getAccount().equals(account))) {
            btnVote.setText("Already Voted");
            btnVote.setEnabled(false);
        } else {
            btnVote.setText("Vote");
            btnVote.addActionListener(event -> {
                try {
                    video.getVoteCatalog().newVote(account);
                    voteLabel.setText(String.format("Up Votes: %d", video.getVoteCatalog().getVoteArrayList().size()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
                btnVote.setText("Already Voted");
                btnVote.setEnabled(false);
            });
        }
        infoPanel.add(btnVote);
        leftPanel.add(infoPanel);

        // comment
        JPanel commentPanel = new JPanel();
        commentPanel.setLayout(new BorderLayout());
        commentPanel.add(new JLabel("Your Comment:"), BorderLayout.PAGE_START);
        JTextArea txtComment = new JTextArea();
        commentPanel.add(txtComment);
        JButton btnComment = new JButton("Comment");
        btnComment.addActionListener(event -> {
            String comment = txtComment.getText();
            if (comment.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You Must Write Something.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            video.getCommentCatalog().newComment(account, comment);
            txtComment.setText("");
            JOptionPane.showMessageDialog(this, "Comment Success!");
            populateCommentList();
        });
        commentPanel.add(btnComment, BorderLayout.PAGE_END);
        leftPanel.add(commentPanel);

        revalidate();
        repaint();
    }

    private void populateCommentList() {
        JPanel commentContainer = new JPanel();
        commentContainer.setBackground(Color.white);
        commentContainer.setLayout(new BorderLayout());
        JLabel lblComment = new JLabel("Comments");
        Font f = lblComment.getFont();
        lblComment.setFont(new Font(f.getName(), Font.BOLD, 22));
        commentContainer.add(lblComment, BorderLayout.PAGE_START);

        JPanel commentPanel = new JPanel();
        commentPanel.setBackground(Color.white);
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
        commentContainer.add(commentPanel);

        video.getCommentCatalog().getCommentArrayList().forEach(c -> {
            commentPanel.add(new CommentBox(c));
            commentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        });

        JScrollPane jScrollPane = new JScrollPane(commentContainer);
        jScrollPane.setMaximumSize(new Dimension(240, 650));
        jSplitPane.setRightComponent(jScrollPane);
    }

    @Override
    public String getTitle() {
        return String.format("%s - %s", video.getUploaderAccount().getPerson(), video);
    }

    @Override
    public void exposed() {
        loadVideo();
    }
}

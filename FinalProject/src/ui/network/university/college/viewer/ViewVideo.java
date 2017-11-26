package ui.network.university.college.viewer;

import biz.account.Account;
import biz.video.Video;
import ui.components.BiubiuBrowser;
import ui.components.HasTitle;

import javax.swing.*;
import java.awt.*;

public class ViewVideo extends JPanel implements HasTitle {
    private Account account;
    private Video video;

    public ViewVideo(Video video, Account account) {
        this.account = account;
        this.video = video;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        // TODO: play ad and prime
        loadVideo();
    }

    private void loadVideo() {
        removeAll();

        // jSplitPane
        JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setDividerLocation(720);
        jSplitPane.setEnabled(false);
        add(jSplitPane);

        // leftPanel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.orange);
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
            // TODO: populate all comment list
        });
        commentPanel.add(btnComment, BorderLayout.PAGE_END);
        leftPanel.add(commentPanel);
    }

//    private void populateCommentList() {
//        JPanel commentContainer = new JPanel();
//        commentContainer.setLayout(new BorderLayout());
//        commentContainer.add(new JLabel("Comments"), BorderLayout.PAGE_START);
//        JPanel commentPanel = new JPanel();
//        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.set));
//        JScrollPane jScrollPane = new JScrollPane(commentPanel);
//
//    }

    @Override
    public String getTitle() {
        return String.format("%s - %s", video.getUploaderAccount().getPerson(), video);
    }
}

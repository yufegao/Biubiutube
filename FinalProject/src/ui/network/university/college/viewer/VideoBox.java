/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.viewer;

import biz.account.Account;
import biz.video.Video;
import biz.video.VideoTag;
import ui.components.ParentUI;
import ui.my.RedeemJPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author hezj
 */
public class VideoBox extends JPanel {
    private Video video;
    private ParentUI parent;
    private Account account;

    public VideoBox(ParentUI parent, Video video, Account account) {
        this.parent = parent;
        this.account = account;
        this.video = video;
        initComponents();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                watchListener(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
    
    private void setComponentSize(Component c, int width, int height) {
        setComponentSize(c, new Dimension(width, height));
    }

    private void setComponentSize(Component c, Dimension d) {
        c.setPreferredSize(d);
        c.setMaximumSize(d);
        c.setMinimumSize(d);
    }

    private void initComponents() {
        setBackground(new Color(204, 204, 204));
        setComponentSize(this, 700, 300);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel picLabel = new JLabel();
        setComponentSize(picLabel, 300, 300);
        try {
            URL url = new URL(video.getPicPath());
            BufferedImage image = ImageIO.read(url);
            picLabel = new JLabel(new ImageIcon(image));
        } catch (Exception ignored) {
        }
        add(picLabel);

        JPanel right = new JPanel();
        setComponentSize(right, 400, 300);
        right.setLayout(new BorderLayout());
        add(right);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        right.add(titlePanel, BorderLayout.PAGE_START);

        String title = video.getTitle();
        JLabel lblTitle = new JLabel(title, JLabel.CENTER);
        Font f = lblTitle.getFont();
        lblTitle.setFont(new Font(f.getName(), f.getStyle(), 22));
        titlePanel.add(lblTitle, BorderLayout.PAGE_START);

        if (video.isPrimeOnly()) {
            JLabel lblSubTitle = new JLabel("(Prime Only)", JLabel.CENTER);
            titlePanel.add(lblSubTitle, BorderLayout.PAGE_END);
        }

        JPanel rightMiddle = new JPanel();
        rightMiddle.setLayout(new BorderLayout());

        JTextArea txtDesc = new JTextArea(video.getDescription());
        txtDesc.setLineWrap(true);
        txtDesc.setEditable(false);
        EventQueue.invokeLater(() -> rightMiddle.add(txtDesc));

        JButton btnWatch = new JButton("Watch >>");
        btnWatch.addActionListener(this::watchListener);
        rightMiddle.add(btnWatch, BorderLayout.PAGE_END);

        right.add(rightMiddle);

        JPanel rightFooter = new JPanel();
        rightFooter.setLayout(new BoxLayout(rightFooter, BoxLayout.X_AXIS));
        for (VideoTag tag: video.getTagHashSet()) {
            JLabel tagLabel = new JLabel(tag.getName());
            tagLabel.setBackground(new Color(153, 153, 153));
            tagLabel.setOpaque(true);
            tagLabel.setBorder(new EmptyBorder(0, 2, 0, 2));
            rightFooter.add(tagLabel);
            rightFooter.add(Box.createRigidArea(new Dimension(5, 0)));
        }

        int height = 25;
        Dimension minSize = new Dimension(5, height);
        Dimension prefSize = new Dimension(5, height);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, height);
        rightFooter.add(new Box.Filler(minSize, prefSize, maxSize));

        rightFooter.add(new JLabel(String.format("Views: %d", video.getViewHistoryCatalog().getViewHistoryArrayList().size())));
        rightFooter.add(Box.createRigidArea(new Dimension(5, 0)));
        rightFooter.add(new JLabel(String.format("Up Votes: %d", video.getVoteCatalog().getVoteArrayList().size())));

        right.add(rightFooter, BorderLayout.PAGE_END);
    }


    private void watchListener(AWTEvent e) {
        if (video.isPrimeOnly() && account.getPrimeMembership().isExpired()) {
            int res = JOptionPane.showConfirmDialog(
                    this,
                    "Only Prime member can view this video, Redeem?",
                    "Error",
                    JOptionPane.YES_NO_OPTION
            );
            if (res == JOptionPane.YES_OPTION) {
                parent.pushComponent(new RedeemJPanel(parent, account));
            }
            return;
        }
        parent.pushComponent(new ViewVideo(parent, video, account));
    }

}

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
import ui.network.university.college.departmentSupervisor.WatchVideo;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

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
                parent.pushComponent(new ViewVideo(video, account));
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

        JLabel lblTitle = new JLabel(video.getTitle(), JLabel.CENTER);
        Font f = lblTitle.getFont();
        lblTitle.setFont(new Font(f.getName(), f.getStyle(), 22));
        right.add(lblTitle, BorderLayout.PAGE_START);

        JPanel rightMiddle = new JPanel();
        rightMiddle.setLayout(new BorderLayout());

        JTextArea txtDesc = new JTextArea(video.getDescription());
        txtDesc.setLineWrap(true);
        txtDesc.setEditable(false);
        rightMiddle.add(txtDesc);

        JButton btnWatch = new JButton("Watch >>");
        btnWatch.addActionListener(e -> parent.pushComponent(new ViewVideo(video, account)));
        rightMiddle.add(btnWatch, BorderLayout.PAGE_END);

        right.add(rightMiddle);

        JPanel rightFooter = new JPanel();
        rightFooter.setLayout(new BoxLayout(rightFooter, BoxLayout.X_AXIS));
        for (VideoTag tag: video.getTagHashSet()) {
            rightFooter.add(new JLabel(tag.getName()));
            rightFooter.add(Box.createRigidArea(new Dimension(5, 0)));
        }
        rightFooter.add(Box.createHorizontalGlue());
        rightFooter.add(new JLabel(String.format("Up Votes: %d", video.getVoteCatalog().getVoteArrayList().size())));
        rightFooter.add(Box.createRigidArea(new Dimension(5, 0)));
        rightFooter.add(new JLabel(String.format("Views: %d", video.getViewHistoryCatalog().getViewHistoryArrayList().size())));

        right.add(rightFooter, BorderLayout.PAGE_END);
    }

}

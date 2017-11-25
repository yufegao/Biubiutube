/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.viewer;

import biz.video.Video;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author hezj
 */
public class VideoBox extends JPanel {
    private Video video;
    
    public VideoBox(Video video) {
        this.video = video;
        initComponents();
    }
    
    private int rand255() {
        return (int)(Math.random() * 255); 
    }
    
    private void initComponents() {
        Dimension size = new Dimension(600, 200);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setBackground(new Color(rand255(), rand255(), rand255()));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
    }
}

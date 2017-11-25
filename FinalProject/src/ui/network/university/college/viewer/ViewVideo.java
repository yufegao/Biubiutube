package ui.network.university.college.viewer;

import biz.account.Account;
import biz.video.Video;
import ui.components.HasTitle;

import javax.swing.*;

public class ViewVideo extends JPanel implements HasTitle {
    // TODO
    private Account account;
    private Video video;

    public ViewVideo(Video video, Account account) {
        this.video = video;
        this.account = account;
    }

    @Override
    public String getTitle() {
        return video.toString();
    }
}

package biz.video;

import biz.account.Account;

import java.util.ArrayList;

public class VideoCatalog {
    private ArrayList<Video> videoArrayList;
//    private Network network;

    public VideoCatalog() {
        this.videoArrayList = new ArrayList<>();
    }

    public Video newVideo(Account account) {
        Video video = new Video(account);
        this.videoArrayList.add(video);
        return video;
    }
}

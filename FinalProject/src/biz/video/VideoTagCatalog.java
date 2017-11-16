package biz.video;

import java.util.ArrayList;

public class VideoTagCatalog {
    private ArrayList<VideoTag> tagArrayList;

    public VideoTagCatalog() {
        this.tagArrayList = new ArrayList<>();
    }

    public VideoTag newTag() {
        VideoTag t = new VideoTag();
        this.tagArrayList.add(t);
        return t;
    }
}

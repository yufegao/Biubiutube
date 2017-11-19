package biz.video;

import biz.nw.Network;

import java.util.HashMap;

public class VideoTagCatalog {
    private Network network;
    private HashMap<String, VideoTag> videoTagHashMap;

    public VideoTagCatalog(Network network) {
        this.network = network;
        this.videoTagHashMap = new HashMap<>();
    }

    public VideoTag getOrNewTag(String name) {
        VideoTag t = videoTagHashMap.getOrDefault(name, new VideoTag(name));
        this.videoTagHashMap.put(name, t);
        return t;
    }

    public Network getNetwork() {
        return network;
    }
}

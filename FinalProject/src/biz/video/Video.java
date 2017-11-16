package biz.video;

import biz.account.Account;

public class Video {
    private Account uploader;
    private VideoAdType adType;
    private VoteCatalog voteCatalog;
    private CommentCatalog commentCatalog;
    private ViewHistoryCatalog viewHistoryCatalog;

    public enum VideoAdType {
        NoAdd("No Advertisement"),
        AnyAdd("Any Advertisement"),
        CommOnly("Commercial Advertisements Only"),
        PSAOnly("PSAs Only");

        VideoAdType(String value) {
            this.value = value;
        }

        private String value;
    }

    public VideoAdType getAdType() {
        return adType;
    }

    public Account getUploader() {
        return uploader;
    }

    public void setAdType(VideoAdType adType) {
        this.adType = adType;
    }

    public VoteCatalog getVoteCatalog() {
        return voteCatalog;
    }

    public CommentCatalog getCommentCatalog() {
        return commentCatalog;
    }

    public ViewHistoryCatalog getViewHistoryCatalog() {
        return viewHistoryCatalog;
    }


    Video(Account uploader) {
        this.uploader = uploader;
        this.voteCatalog = new VoteCatalog(this);
        this.commentCatalog = new CommentCatalog(this);
        this.viewHistoryCatalog = new ViewHistoryCatalog(this);
        this.adType = VideoAdType.NoAdd;  // default no ad
    }
}

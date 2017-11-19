package biz.wrk;

import biz.account.Account;
import biz.video.Video;

import java.util.Calendar;

public class VideoUploadRequest extends WorkRequest {
    private Account organizationSupervisor;
    private Account enterpriseSupervisor;
    private Video video;

    private VideoUploadRequest(Account sender) {
        super(sender);
    }

    public VideoUploadRequest(Account sender, Video video) {
        super(sender);
        this.video = video;
    }

    public Account getOrganizationSupervisor() {
        return organizationSupervisor;
    }

    public Video getVideo() {
        return video;
    }

    public Account getEnterpriseSupervisor() {
        return enterpriseSupervisor;
    }

    public void setEnterpriseSupervisor(Account enterpriseSupervisor) {
        this.enterpriseSupervisor = enterpriseSupervisor;
        this.updatedAt = Calendar.getInstance();
    }

    public void setOrganizationSupervisor(Account organizationSupervisor) {
        this.organizationSupervisor = organizationSupervisor;
        this.updatedAt = Calendar.getInstance();
    }
}

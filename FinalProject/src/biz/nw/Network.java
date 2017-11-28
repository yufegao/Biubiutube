package biz.nw;

import biz.ad.AdCatalog;
import biz.enterprises.AdCompanyEnterpriseCatalog;
import biz.enterprises.ECOEnterpriseCatalog;
import biz.enterprises.NPOEnterpriseCatalog;
import biz.enterprises.UniversityEnterprise;
import biz.org.unv.UniverseCollegeOrganization;
import biz.video.VideoCatalog;
import biz.video.VideoTagCatalog;

public class Network {
    private VideoCatalog videoCatalog;
    private AdCatalog adCatalog;

    private VideoTagCatalog videoTagCatalog;

    private UniversityEnterprise university;
    private ECOEnterpriseCatalog ecoCatalog;
    private AdCompanyEnterpriseCatalog adCompanyCatalog;
    private NPOEnterpriseCatalog npoCatalog;

    private String name;

    public Network(String name) {
        this.name = name;
        this.university = new UniversityEnterprise(name, this);
        this.videoCatalog = new VideoCatalog(this);
        this.adCatalog = new AdCatalog(this);

        this.videoTagCatalog = new VideoTagCatalog(this);

        this.ecoCatalog = new ECOEnterpriseCatalog(this);
        this.adCompanyCatalog = new AdCompanyEnterpriseCatalog(this);
        this.npoCatalog = new NPOEnterpriseCatalog(this);
    }

    @Override
    public String toString() {
        return name;
    }

    public VideoCatalog getVideoCatalog() {
        return videoCatalog;
    }

    public AdCatalog getAdCatalog() {
        return adCatalog;
    }

    public UniversityEnterprise getUniversity() {
        return university;
    }

    public ECOEnterpriseCatalog getEcoCatalog() {
        return ecoCatalog;
    }

    public AdCompanyEnterpriseCatalog getAdCompanyCatalog() {
        return adCompanyCatalog;
    }

    public NPOEnterpriseCatalog getNpoCatalog() {
        return npoCatalog;
    }

    public VideoTagCatalog getVideoTagCatalog() {
        return videoTagCatalog;
    }
}

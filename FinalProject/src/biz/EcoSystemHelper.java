package biz;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;
import biz.video.Video;
import biz.video.VideoTag;

public class EcoSystemHelper {
    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        Network nw = system.newNetwork("NEU");
        UniverseCollegeOrganization coe = nw.getUniversity().getCollegeCatalog().newOrganization("COE");

        Person person;
        Account account;

        person = system.getSystemPersonCatalog().newPerson("Andy", "Zhao");
        try {
            system.getSystemAccountCatalog().newAccount("admin", "admin", system.getSystemAdminRole(), person);
        } catch (Exception ignored) {}

        person = coe.getPersonCatalog().newPerson("Bruce", "Qian");
        try {
            account = coe.getAccountCatalog().newAccount("qls", "qls", coe.getCollegeLecturerRole(), person);
            String[] urls = new String[] {
                "https://www.youtube.com/embed/3XB3in9Xqy8",
                "https://www.youtube.com/embed/3ifwR5feRQI",
                "https://www.youtube.com/embed/qVdRxODXBcU",
                "https://www.youtube.com/embed/wApG8SHBJ24",
                "https://www.youtube.com/embed/dKnRUuYVR0Q",
                "https://www.youtube.com/embed/IMhiGyxF4as",
                "https://www.youtube.com/embed/JmiyAlvm6Ds",
                "https://www.youtube.com/embed/mgnWYBaJuUk",
                "https://www.youtube.com/embed/ya_kEknUNIE",
                "https://www.youtube.com/embed/y9SvMg5CxA4",
                "https://www.youtube.com/embed/wFgeUC5dw_4",
                "https://www.youtube.com/embed/mSbFrQfgq7A",
                "https://www.youtube.com/embed/j-zAbYs9J7w",
                "https://www.youtube.com/embed/iZcfMa2Fagg"
            };
            for (int i = 0; i < urls.length; i++) {
                Video v = nw.getVideoCatalog().newVideo(account);
                v.setTitle(String.format("Swing Tutorial %02d", i + 1));
                v.setAdType(Video.VideoAdType.NoAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://i.imgur.com/ijtKGes.png");
                v.setUrl(urls[i]);
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Swing"));
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Java"));
                v.setDescription(String.format("Java Swing Tutorial %02d", i + 1));
            }
            coe.getAccountCatalog().newAccount("qlsa", "qlsa", coe.getUniversityDepartmentSupervisorRole(), person);
        } catch (Exception ignored) {}

        person = coe.getPersonCatalog().newPerson("Cathy", "Sun");
        try {
            account = coe.getAccountCatalog().newAccount("sls", "sls", coe.getCollegeLecturerRole(), person);
            for (int i = 1; i < 9; i++) {
                Video v = nw.getVideoCatalog().newVideo(account);
                v.setTitle(String.format("INFO5100-Lab%d", i));
                v.setAdType(Video.VideoAdType.AnyAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://i.imgur.com/ijtKGes.png");
                v.setUrl("https://www.youtube.com/embed/RqvCNb7fKsg");
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("INFO"));
                v.setDescription(String.format("INFO5100-Lab%d Description", i));
                if (i > 3) {
                    v.setStatus(Video.VideoStatus.DSApproved);
                }
                
                if (i > 7) {
                    v.setStatus(Video.VideoStatus.Uploaded);
                }
            }
        } catch (Exception ignored) {}

        person = nw.getUniversity().getSupervisorOrganization().getPersonCatalog().newPerson("David", "Li");
        try {
            nw.getUniversity().getSupervisorOrganization().getAccountCatalog().newAccount("li", "li", nw.getUniversity().getSupervisorOrganization().getUniversitySupervisorRole(), person);
        } catch (Exception ignored) {}

        return system;
    }
}

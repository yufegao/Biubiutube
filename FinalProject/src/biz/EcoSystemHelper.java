package biz;

import biz.account.Account;
import biz.account.AccountCatalog;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;
import biz.person.PersonCatalog;
import biz.role.Role;
import biz.video.Video;
import biz.video.VideoTag;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;

public class EcoSystemHelper {
    private static Faker faker = new Faker();
    private static String[] videoURLs = new String[] { // TODO: more video URL
            "https://www.youtube.com/embed/RqvCNb7fKsg"
    };
    private static String[] picPaths = new String[] { // TODO: more pic path
            "https://i.imgur.com/ijtKGes.png"
    };

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        Network nw = system.newNetwork("NEU");

        // auto fake college COE
        HashSet<VideoTag> tags = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String tagName = faker.hacker().abbreviation();
            tags.add(nw.getVideoTagCatalog().getOrNewTag(tagName));
        }
        UniverseCollegeOrganization college = fakeCollege(nw, tags);
        college.setName("COE");

        // manual fake college CPS
        UniverseCollegeOrganization coe = nw.getUniversity().getCollegeCatalog().newOrganization("CPS");

        Person person;
        Account account;

        person = system.getSystemPersonCatalog().newPerson("Andy", "Zhao");
        try {
            system.getSystemAccountCatalog().newAccount("admin", "admin", system.getSystemAdminRole(), person);
        } catch (Exception ignored) {
        }

        person = coe.getPersonCatalog().newPerson("Bruce", "Qian");
        try {
            account = coe.getAccountCatalog().newAccount("qls", "qls", coe.getCollegeLecturerRole(), person);
            String[] urls = new String[]{
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
        } catch (Exception ignored) {
        }

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
        } catch (Exception ignored) {
        }

        person = nw.getUniversity().getSupervisorOrganization().getPersonCatalog().newPerson("David", "Li");
        try {
            nw.getUniversity().getSupervisorOrganization().getAccountCatalog().newAccount("li", "li", nw.getUniversity().getSupervisorOrganization().getUniversitySupervisorRole(), person);
        } catch (Exception ignored) {
        }

        try {
            account = coe.getAccountCatalog().newAccount("sxm", "sxm", coe.getViewerRole(), person);
            account.setActive(false);
        } catch (Exception ignored) {
        }

        return system;
    }

    public static Person fakePerson(PersonCatalog personCatalog) {
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        Person p = personCatalog.newPerson(fName, lName);
        p.setEmail(faker.internet().emailAddress());
        return p;
    }

    public static Account fakeAccount(AccountCatalog accountCatalog, Person p, Role r) {
        Account account = null;
        try {
            account = accountCatalog.newAccount(faker.name().username(),faker.internet().password(),r,p);;;;;;;
        } catch (Exception ignored) {

        }
        return account;
    }

    public static UniverseCollegeOrganization fakeCollege(Network nw, HashSet<VideoTag> tags) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String collegeName = "C";
        int num = faker.random().nextInt(2) + 2;
        for (int i = 0; i < num; i++) {
            collegeName += s.charAt(faker.random().nextInt(s.length()));
        }
        UniverseCollegeOrganization college = nw.getUniversity().getCollegeCatalog().newOrganization(collegeName);

        Person p = null;
        Account a = null;
        Video v = null;

        // 1. supervisor
        num = faker.random().nextInt(3) + 1; // 1 ~ 4 supervisor
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            fakeAccount(college.getAccountCatalog(), p, college.getUniversityDepartmentSupervisorRole());
            if (i > 1) {  // some of them are also lecturer
                fakeAccount(college.getAccountCatalog(), p, college.getCollegeLecturerRole());
            }
        }

        // 2. lecturer
        num = faker.random().nextInt(10) + 10; // 10 ~ 20 lecturer
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getCollegeLecturerRole());
            int numVideo = faker.random().nextInt(90) + 10; // 10 ~ 100 videos
            for (int j = 0; j < numVideo; j++) {
                fakeVideo(nw, a, tags);
            }
        }

        // 3. viewer
        num = faker.random().nextInt(500) + 20;  // 20 ~ 520 viewer
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getViewerRole());
            if (faker.random().nextInt(100) == 0) { // 1% of them are InActive
                a.setActive(false);
            }
        }

        return college;
    }

    private static Video fakeVideo(Network nw, Account account, HashSet<VideoTag> tags) {
        Video v = nw.getVideoCatalog().newVideo(account);
        v.setDescription(faker.shakespeare().hamletQuote());
        v.setPicPath(picPaths[faker.random().nextInt(picPaths.length)]);

        int val = faker.random().nextInt(10);
        if (val < 5) {  // 50% ESApproved
            v.setStatus(Video.VideoStatus.ESApproved);
        } else if (val < 7) {  // 20% Uploaded
            v.setStatus(Video.VideoStatus.Uploaded);
        } else if (val < 9) {  // 20% DSApproved
            v.setStatus(Video.VideoStatus.DSApproved);
        } else {  // 10% Banned
            v.setStatus(Video.VideoStatus.Banned);
        }

        val = faker.random().nextInt(4);  // 25% each ad type
        switch (val) {
            case 0:
                v.setAdType(Video.VideoAdType.NoAdd);
                break;
            case 1:
                v.setAdType(Video.VideoAdType.AnyAdd);
                break;
            case 2:
                v.setAdType(Video.VideoAdType.CommOnly);
                break;
            case 3:
                v.setAdType(Video.VideoAdType.PSAOnly);
                break;
        }

        int numTags = faker.random().nextInt(4) + 1; // 1 ~ 4 tags;
        for (int i = 0; i < numTags; i++) {
            int item = faker.random().nextInt(tags.size());
            int j = 0;
            for (VideoTag tag: tags) {
                if (item == j) {
                    v.addTag(tag);
                }
                j++;
            }
        }

        VideoTag tag = v.getTagHashSet().stream().findAny().orElse(null);

        String title = faker.superhero().power();
        v.setTitle(tag.getName() + " " + title);

        return v;
    }

}

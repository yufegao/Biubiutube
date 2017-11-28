package biz.fakerHelper;

import biz.EcoSystem;
import biz.account.Account;
import biz.enterprises.UniversityEnterprise;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;
import biz.video.Video;
import biz.video.VideoTag;
import com.github.javafaker.Faker;

import java.util.HashSet;

import static biz.fakerHelper.EcoSystemCollegeHelper.fakeCollege;
import static biz.fakerHelper.EcoSystemCommonHelper.fakeAccount;
import static biz.fakerHelper.EcoSystemCommonHelper.fakePerson;

public class EcoSystemHelper {
    private static Faker faker = new Faker();

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        Network nw = system.newNetwork("NEU");
        UniversityEnterprise university = nw.getUniversity();

        // admin
        Person adminPerson = fakePerson(university.getAdminOrganization().getPersonCatalog());
        Account adminAccount = fakeAccount(university.getAdminOrganization().getAccountCatalog(), adminPerson, university.getAdminOrganization().getAdmin());
        System.out.printf("NEU Admin username: %s\n", adminAccount);

        // accounting
        Person acPerson = fakePerson(university.getAccountingOrganization().getPersonCatalog());
        Account acAccount = fakeAccount(university.getAccountingOrganization().getAccountCatalog(), acPerson, university.getAccountingOrganization().getUniversityAccountingRole());
        System.out.printf("NEU Accounting username: %s\n\n", acAccount);

        // auto fake a college with hacker abbrev tags
        // and rename it to COE
        HashSet<VideoTag> tags = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String tagName = faker.hacker().abbreviation();
            tags.add(nw.getVideoTagCatalog().getOrNewTag(tagName));
        }
        UniverseCollegeOrganization college = fakeCollege(nw, tags);
        college.setName("COE");

        // auto fake a college with gameOfThrones character tags
        for (int j = 0; j < 10; j++) {
            String tagName = faker.gameOfThrones().character();
            tags.add(nw.getVideoTagCatalog().getOrNewTag(tagName));
        }
        fakeCollege(nw, tags);

        // auto fake a college with gameOfThrones city tags
        tags = new HashSet<>();
        for (int j = 0; j < 10; j++) {
            String tagName = faker.gameOfThrones().city();
            tags.add(nw.getVideoTagCatalog().getOrNewTag(tagName));
        }
        fakeCollege(nw, tags);

        // manual fake college CPS
        UniverseCollegeOrganization cps = university.getCollegeCatalog().newOrganization("CPS");

        Person person;
        Account account;

        person = system.getSystemPersonCatalog().newPerson("Andy", "Zhao");
        try {
            system.getSystemAccountCatalog().newAccount("admin", "admin", system.getSystemAdminRole(), person);
        } catch (Exception ignored) {
        }

        person = cps.getPersonCatalog().newPerson("Bruce", "Qian");
        try {
            account = cps.getAccountCatalog().newAccount("qls", "qls", cps.getCollegeLecturerRole(), person);
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
                    "https://www.youtube.com/embed/iZcfMa2Fagg",
//                  machine learning
                    "https://www.youtube.com/embed/OGxgnH8y2NM",     
                    "https://www.youtube.com/embed/JcI5Vnw0b2c",    
                    "https://www.youtube.com/embed/lN5jesocJjk",     
                    "https://www.youtube.com/embed/r4mwkS2T9aI",    
                    "https://www.youtube.com/embed/QLVMqwpOLPk",     
                    "https://www.youtube.com/embed/za5s7RB_VLw",     
                    "https://www.youtube.com/embed/V59bYfIomVk",     
                    "https://www.youtube.com/embed/SvmueyhSkgQ",     
                    "https://www.youtube.com/embed/KLGfMGsgP34",     
                    "https://www.youtube.com/embed/-fgYp74SNtk",     
                    "https://www.youtube.com/embed/QUyAFokOmow",     
                    "https://www.youtube.com/embed/Kpxwl2u-Wgk",     
                    "https://www.youtube.com/embed/44jq6ano5n0",     
                    "https://www.youtube.com/embed/1i0zu9jHN6U",     
                    "https://www.youtube.com/embed/hl3bQySs8sM",     
                    "https://www.youtube.com/embed/n3RqsMz3-0A",     
                    "https://www.youtube.com/embed/GWHG3cS2PKc",     
                    "https://www.youtube.com/embed/3XPhmnf96s0",     
                    "https://www.youtube.com/embed/r_D5TTV9-2c",     
                    "https://www.youtube.com/embed/mA5nwGoRAOo",
//                  java tutorial
                    "https://www.youtube.com/embed/Hl-zzrqQoSE",     
                    "https://www.youtube.com/embed/5u8rFbpdvds",    
                    "https://www.youtube.com/embed/CE8UIbb_4iM",     
                    "https://www.youtube.com/embed/SHIT5VkNrCg",     
                    "https://www.youtube.com/embed/gtQJXzi3Yns",     
                    "https://www.youtube.com/embed/5DdacOkrTgo",     
                    "https://www.youtube.com/embed/ANuuSFY2BbY",     
                    "https://www.youtube.com/embed/8ZaTSedtf9M",     
                    "https://www.youtube.com/embed/ydcTx6idTs0",     
                    "https://www.youtube.com/embed/iMeaovDbgkQ",     
                    "https://www.youtube.com/embed/PAaqgTr7Cx4",     
                    "https://www.youtube.com/embed/RVRPmeccFT0",     
                    "https://www.youtube.com/embed/8ZuWD2CBjgs",     
                    "https://www.youtube.com/embed/XqTg2buXS5o",     
                    "https://www.youtube.com/embed/7MBgaF8wXls",     
                    "https://www.youtube.com/embed/9t78g0U8VyQ",     
                    "https://www.youtube.com/embed/tPFuVRbUTwA",     
                    "https://www.youtube.com/embed/Y4xFGCyt1ww",     
                    "https://www.youtube.com/embed/C0YRYVn_BeI",     
                    "https://www.youtube.com/embed/Y6NheSwTsDs",
//                  NASA
                    "https://www.youtube.com/embed/FMhSbdoamYY",     
                    "https://www.youtube.com/embed/dp4efcbqLzM",     
                    "https://www.youtube.com/embed/EkbUffRtjXk",     
                    "https://www.youtube.com/embed/8e4PHUByX6k",     
                    "https://www.youtube.com/embed/VM5nOaLU7XM",     
                    "https://www.youtube.com/embed/jWtLYScfKR0",     
                    "https://www.youtube.com/embed/NeGXO01ILVA",     
                    "https://www.youtube.com/embed/t21PiEIBhgs",     
                    "https://www.youtube.com/embed/TDyeJ3hcCZY",     
                    "https://www.youtube.com/embed/NyVz2IniF3U",     
                    "https://www.youtube.com/embed/M8M9A_sV3As",     
                    "https://www.youtube.com/embed/T9lh6xrPw1A",     
                    "https://www.youtube.com/embed/0WZS1FMyiU8",     
                    "https://www.youtube.com/embed/vKdxnSLlAcs",     
                    "https://www.youtube.com/embed/p1mrhLQCJO4",     
                    "https://www.youtube.com/embed/y9OZ4_T7udQ",     
                    "https://www.youtube.com/embed/O1s64UGUn2k",     
                    "https://www.youtube.com/embed/P6sCjXISmEU",     
                    "https://www.youtube.com/embed/GR3fuigi1_g",     
                    "https://www.youtube.com/embed/_ulv65FoMoc",     
//                  RedCross
                    "https://www.youtube.com/embed/AFQpa2kURas",     
                    "https://www.youtube.com/embed/Dm3qwVw0K-0",     
                    "https://www.youtube.com/embed/ZcI3eJ3ePWY",     
                    "https://www.youtube.com/embed/E1qOO-Q1iNw",     
                    "https://www.youtube.com/embed/5wa-SYwgSaM",     
                    "https://www.youtube.com/embed/ob5ZT-_-TFo",     
                    "https://www.youtube.com/embed/28qTNTymfWY",     
                    "https://www.youtube.com/embed/9nV4atXhWII",     
                    "https://www.youtube.com/embed/KOlM-UkmobI",     
                    "https://www.youtube.com/embed/kZqFSN2c7TA",     
                    "https://www.youtube.com/embed/Y-ggSmxjhIo",     
                    "https://www.youtube.com/embed/OoYnZw9Anv4",     
                    "https://www.youtube.com/embed/c8ek_2oH_AY",     
                    "https://www.youtube.com/embed/tWJjAlLb7KU",     
                    "https://www.youtube.com/embed/iSIK7dnBEfQ",     
                    "https://www.youtube.com/embed/gpH0JpevWDE",     
                    "https://www.youtube.com/embed/PdgEJ6sLL0Y",     
                    "https://www.youtube.com/embed/U1WF-Irwlf4",     
                    "https://www.youtube.com/embed/Uclmq-mqrn8",     
                    "https://www.youtube.com/embed/ZUWUllYtVWo"                
            };
            for (int i = 0; i < urls.length; i++) {
                Video v = nw.getVideoCatalog().newVideo(account);
                v.setTitle(String.format("Swing Tutorial %02d", i + 1));
                v.setAdType(Video.VideoAdType.NoAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://imgur.com/a/tcTZC");
                v.setUrl(urls[i]);
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Swing"));
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Java"));
                v.setDescription(String.format("Java Swing Tutorial %02d", i + 1));
            }
            cps.getAccountCatalog().newAccount("qlsa", "qlsa", cps.getUniversityDepartmentSupervisorRole(), person);
        } catch (Exception ignored) {
        }

        person = cps.getPersonCatalog().newPerson("Cathy", "Sun");
        try {
            account = cps.getAccountCatalog().newAccount("sls", "sls", cps.getCollegeLecturerRole(), person);
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

        person = university.getSupervisorOrganization().getPersonCatalog().newPerson("David", "Li");
        try {
            university.getSupervisorOrganization().getAccountCatalog().newAccount("li", "li", university.getSupervisorOrganization().getUniversitySupervisorRole(), person);
        } catch (Exception ignored) {
        }

        person = cps.getPersonCatalog().newPerson("Bad", "Guy");
        try {
            account = cps.getAccountCatalog().newAccount("bad", "bad", cps.getViewerRole(), person);
            account.setActive(false);
        } catch (Exception ignored) {
        }

        person = cps.getPersonCatalog().newPerson("Xiaoming", "Li");
        try {
            account = cps.getAccountCatalog().newAccount("xiaoming.li", "1", cps.getViewerRole(), person);
        } catch (Exception ignored) {
        }
        person = cps.getPersonCatalog().newPerson("Dachui", "Wang");
        try {
            account = cps.getAccountCatalog().newAccount("dachui.wang", "1", cps.getViewerRole(), person);
            university.getRollUpOrderCatalog().newRollUpOrder(account, 100, "AliPay 12345");
            account.getWallet().modifyCoin(35);
        } catch (Exception ignored) {
        }
        return system;
    }
}

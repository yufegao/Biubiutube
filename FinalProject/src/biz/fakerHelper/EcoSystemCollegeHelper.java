package biz.fakerHelper;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;
import biz.video.Video;
import biz.video.VideoTag;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;

import static biz.fakerHelper.EcoSystemCommonHelper.fakeAccount;
import static biz.fakerHelper.EcoSystemCommonHelper.fakePerson;

public class EcoSystemCollegeHelper {
    private static Faker faker = new Faker();
    private static String[] videoURLs = new String[]{ 
            "https://www.youtube.com/embed/RqvCNb7fKsg",
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
        
        //Java Class
            "https://www.youtube.com/embed/ZpBtDTCgalw",
            
    };
    private static String[] picPaths = new String[]{ // TODO: more pic path
            "https://i.imgur.com/ijtKGes.png",
            "https://imgur.com/51yxbFv.jpg",
            "https://imgur.com/Tq2ZOS3.jpg",
            "https://imgur.com/zkenvrm.jpg",
            "https://imgur.com/zfYeczQ.jpg",
            "https://imgur.com/FfoyzRd.jpg",
            "https://imgur.com/SaP1umA.jpg",
            "https://imgur.com/Z10Ngrw.jpg",
            "https://imgur.com/blPwucV.jpg",
            "https://imgur.com/q1CDImF.jpg",
            "https://imgur.com/2ntNoI1.jpg",
            "https://imgur.com/xlqUPP7.jpg",
            "https://imgur.com/3JZE1dj.jpg",
            "https://imgur.com/h5kFtRS.jpg",
            "https://imgur.com/c6Leyb0.jpg",
            "https://imgur.com/o9drTBT.jpg",
            "https://imgur.com/NQItmzI.jpg",
            "https://imgur.com/Jmdksc4.jpg",
            "https://imgur.com/YkvqRPD.jpg",
            "https://imgur.com/4FDqVIw.jpg",
            "https://imgur.com/JNKnrwW.jpg",
            "https://imgur.com/vxOJCDh.jpg",
            "https://imgur.com/YzwxXcU.jpg",
            "https://imgur.com/DkSBkMZ.jpg",
            "https://imgur.com/MJoQXM4.jpg",
            "https://imgur.com/aLaTt6U.jpg",
            "https://imgur.com/8oRyXq1.jpg",
            "https://imgur.com/QExsgW3.jpg",
            "https://imgur.com/UroGtj4.jpg",
            "https://imgur.com/nBGHUyO.jpg",
            "https://imgur.com/1LKnoJH.jpg",
            "https://imgur.com/ElhLH7B.jpg",
            "https://imgur.com/PRBmhAS.jpg",
            "https://imgur.com/yyayKot.jpg",
            "https://imgur.com/u2LS5OI.jpg",
            "https://imgur.com/hoBt92N.jpg"

            
    };

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

        System.out.printf("Faking college %s...\n", college);

        // 1. supervisor
        num = faker.random().nextInt(3) + 1; // 1 ~ 4 supervisor
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getUniversityDepartmentSupervisorRole());
            if (i == num - 1) {
                System.out.printf("Last supervisor account username in %s: %s\n", college, a.getUsername());
            }

            if (i > 1) {  // some of them are also lecturer
                a = fakeAccount(college.getAccountCatalog(), p, college.getCollegeLecturerRole());
            }
        }

        // 2. viewer
        num = faker.random().nextInt(500) + 20;  // 20 ~ 520 viewer
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getViewerRole());
            if (faker.random().nextInt(100) == 0) { // 1% of them are InActive
                a.setActive(false);
            }
        }
        System.out.printf("Last viewer account username in %s: %s\n", college, a.getUsername());

        // 3. lecturer
        num = faker.random().nextInt(10) + 10; // 10 ~ 20 lecturer
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getCollegeLecturerRole());
            int numVideo = faker.random().nextInt(90) + 10; // 10 ~ 100 videos
            for (int j = 0; j < numVideo; j++) {
                fakeVideo(nw, a, tags);
            }
        }
        System.out.printf("Last lecturer account username in %s: %s\n", college, a.getUsername());

        System.out.printf("College %s faked\n\n", college);

        return college;
    }


    private static Video fakeVideo(Network nw, Account account, HashSet<VideoTag> tags) {
        Video v = nw.getVideoCatalog().newVideo(account);
        String desc = "";
        for (int i = 0; i < 5; i++) {
            desc += faker.shakespeare().hamletQuote() + "\n";
        }
        v.setDescription(desc);
        v.setPicPath(picPaths[faker.random().nextInt(picPaths.length)]);
        v.setUrl(videoURLs[faker.random().nextInt(videoURLs.length)]);

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
            for (VideoTag tag : tags) {
                if (item == j) {
                    v.addTag(tag);
                }
                j++;
            }
        }

        if (faker.random().nextInt(2) == 0) { // 50% prime only
            v.setPrimeOnly(true);
        }

        VideoTag tag = v.getTagHashSet().stream().findAny().orElse(null);

        String title = faker.superhero().power();
        v.setTitle(tag.getName() + " " + title);

        if (v.getStatus().equals(Video.VideoStatus.ESApproved)) {  // fake view for ESApproved video
            for (int i = 0; i < faker.random().nextInt(400) + 100; i++) {  // 100 ~ 500 view
                Account viewer = randomViewerForVideo(nw, v);
                v.getViewHistoryCatalog().newViewHistory(account);
                if (faker.random().nextInt(4) == 0) {  // 25% to vote
                    try {
                        v.getVoteCatalog().newVote(viewer);
                    } catch (Exception ignored) {
                    }
                }
                if (faker.random().nextInt(5) == 0) {  // 20% to comment
                    try {
                        v.getCommentCatalog().newComment(viewer, faker.shakespeare().asYouLikeItQuote());
                    } catch (Exception ignored) {
                    }
                }
            }
        }

        return v;
    }


    private static Account randomViewerForVideo(Network nw, Video video) {
        UniverseCollegeOrganization college;

        if (faker.random().nextInt(2) == 0) {  // 50% chance from same college
            college = (UniverseCollegeOrganization) video.getUploaderAccount().getOrg();
        } else {  // 50% chance random
            ArrayList<UniverseCollegeOrganization> collegeArrayList = nw.getUniversity().getCollegeCatalog().getOrganizations();
            college = collegeArrayList.get(faker.random().nextInt(collegeArrayList.size()));
        }

        Object[] arr = college.getAccountCatalog().getAccountArrayList().stream()
                .filter(acc -> acc.getRole().equals(college.getViewerRole())).toArray();
        return (Account) arr[faker.random().nextInt(arr.length)];
    }

    private static void fakeComment(Network nw, Video video, int num) {
        for (int i = 0; i < num; i++) {
            Account account = randomViewerForVideo(nw, video);
            String comment = faker.shakespeare().asYouLikeItQuote();
            video.getCommentCatalog().newComment(account, comment);
        }
    }

    private static void fakeVote(Network nw, Video video, int num) {
        for (int i = 0; i < num; i++) {
            Account account = randomViewerForVideo(nw, video);
            try {
                video.getVoteCatalog().newVote(account);
            } catch (Exception ignored) {
            }
        }
    }
}

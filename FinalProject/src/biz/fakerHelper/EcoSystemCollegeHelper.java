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
    private static String[] videoURLs = new String[]{ // TODO: more video URL
            "https://www.youtube.com/embed/RqvCNb7fKsg"
    };
    private static String[] picPaths = new String[]{ // TODO: more pic path
            "https://i.imgur.com/ijtKGes.png"
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

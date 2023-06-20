package com.javarush.jira.profile.web;

import com.javarush.jira.MatcherFactory;
import com.javarush.jira.profile.ContactTo;
import com.javarush.jira.profile.ProfileTo;
import com.javarush.jira.profile.internal.Profile;

import java.util.Set;

public class ProfileTestData {
    public static final MatcherFactory.Matcher<ProfileTo> PROFILE_TO_MATCHER = MatcherFactory.usingEqualsComparator(ProfileTo.class);
    public static final MatcherFactory.Matcher<Profile> PROFILE_MATCHER = MatcherFactory.usingEqualsComparator(Profile.class);
    public static final  ProfileTo USER_PROFILE_TO = getUserProfileTo();
    public static final ProfileTo ADMIN_PROFILE_TO = getAdminProfileTo();

    private static ProfileTo getUserProfileTo() {
        Set<String> mailNotification = Set.of(
                "deadline",
                "assigned",
                "overdue");
        Set<ContactTo> contacts = Set.of(
                new ContactTo("skype", "userSkype"),
                new ContactTo("website", "user.com"),
                new ContactTo("mobile", "+01234567890"));

        return new ProfileTo(1L, mailNotification, contacts);
    }

    private static ProfileTo getAdminProfileTo(){
        Set<String> mailNotification = Set.of(
                "two_days_before_deadline",
                "three_days_before_deadline",
                "one_day_before_deadline");
        Set<ContactTo> contacts = Set.of(
                new ContactTo("vk", "adminVk"),
                new ContactTo("tg", "adminTg"),
                new ContactTo("github", "adminGitHub"));

        return new ProfileTo(2L, mailNotification, contacts);
    }
}

package com.company;

/*
Simple class to manage a pseudo user profile
*/
public class Profile {
    private static User currentUser;
    public static void login(User user){
        currentUser = user;

        Util.print("Welcome back, " + user.username + "!");
        Util.print("What do you wish to do?");
        Data.profileWindowOptions.promptOptions();
    }
}

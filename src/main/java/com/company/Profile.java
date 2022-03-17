package com.company;

/*
Simple class to manage a pseudo user profile
*/
public class Profile {
    public static User currentUser;
    public static void login(User user){
        currentUser = user;

        Util.print("Welcome back, " + user.getUsername() + "!");
        Util.print("What do you wish to do?\n");
        Data.profileWindowOptions.promptOptions();
    }
}

package com.company;

/*
Simple class to manage a pseudo user profile

    Static methods:
        login
            Description: logs in into given user

            Arguments:
                user : User -> User that you wish to log in into
*/
public class Profile {
    public static User currentUser;

    public static void logout(){
        currentUser = null;
    }

    public static void login(User user){
        try{
            currentUser = user;

            Util.print("Welcome back, " + user.getUsername() + "!");
            Util.print("What do you wish to do?\n");
        }catch(NullPointerException e){
            return;
        }
    }
}

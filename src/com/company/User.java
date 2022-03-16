package com.company;

public class User {
    String username;
    String password; //Should be hashed
    String phoneNumber;
    String email;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean setPhoneNumber(String newPhoneNumber){
        return false;
    }

    public boolean setEmail(String newEmail){
        return false;
    }
}

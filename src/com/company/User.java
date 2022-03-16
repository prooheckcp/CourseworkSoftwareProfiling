package com.company;

public class User {
    Privilege privilege;
    String username;
    String password; //Should be hashed
    String phoneNumber;
    String email;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.privilege = Privilege.GUEST;
    }

    public User(String username, String password, Privilege privilege){
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    public boolean setPhoneNumber(String newPhoneNumber){
        return false;
    }

    public boolean setEmail(String newEmail){
        return false;
    }
}

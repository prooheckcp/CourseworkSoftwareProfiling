package com.company;

public class User {
    private Privilege privilege;
    private AuthenticationMethod authenticationMethod;
    private String username;
    private String password; //Should be hashed
    private String phoneNumber;
    private String email;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.privilege = Privilege.GUEST;
        this.authenticationMethod = AuthenticationMethod.NONE;
    }

    public User(String username, String password, Privilege privilege){
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.authenticationMethod = AuthenticationMethod.NONE;
    }

    public User(String username, String password, Privilege privilege, AuthenticationMethod authenticationMethod){
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.authenticationMethod = authenticationMethod;
    }

    public Privilege getPrivilege(){
        return this.privilege;
    }

    public AuthenticationMethod getAuthenticationMethod(){
        return this.authenticationMethod;
    }

    public Boolean setAuthenticationMethod(AuthenticationMethod authenticationMethod){
        this.authenticationMethod = authenticationMethod;
        return true;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public boolean setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
        return true;
    }

    public String getEmail(){
        return this.email;
    }

    public boolean setEmail(String newEmail){
        this.email = newEmail;
        return true;
    }
}

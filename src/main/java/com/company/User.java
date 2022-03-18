package com.company;

/*
The user class is used to contain the information
about the users within the pseudo-database

    Public methods:
        getPrivilege
            Description: A getter for the user privilege

            Returns:
                Privilege -> User privilege

        getAuthenticationMethod
            Description: A getter for the user authentication method

            Returns:
                AuthenticationMethod -> User AuthenticationMethod

        setAuthenticationMethod
            Description: A setter for the user authentication method

            Arguments:
                authenticationMethod : AuthenticationMethod -> new authentication method

            Returns:
                Boolean -> Whether the authentication method was changed or not

        getUsername
            Description: A getter for the user username

            Returns:
                Privilege -> User privilege

        getPassword
            Description: A getter for the user password

            Returns:
                String -> User password

        getPhoneNumber
            Description: A getter for the user phone number

            Returns:
                String -> User phone number

        getEmail
            Description: A getter for the user email

            Returns:
                String -> User email
*/

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

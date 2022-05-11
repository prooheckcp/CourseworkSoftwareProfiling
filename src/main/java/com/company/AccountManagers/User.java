package com.company.AccountManagers;

//Imports
import com.company.enums.AuthenticationMethod;
import com.company.enums.Privilege;

/*
The user class is used to contain the information
about the users within the pseudo-database

    Public methods:
        getPrivilege
            Description:
                A getter for the user privilege

            Returns:
                Privilege -> User privilege

        getAuthenticationMethod
            Description:
                A getter for the user authentication method

            Returns:
                AuthenticationMethod -> User AuthenticationMethod

        getUsername
            Description:
                A getter for the user username

            Returns:
                String -> username

        getPassword
            Description:
                A getter for the user password

            Returns:
                String -> User password

        getPhoneNumber
            Description:
                A getter for the user phone number

            Returns:
                String -> User phone number

        getEmail
            Description:
                A getter for the user email

            Returns:
                String -> User email

        setAuthenticationMethod
            Description:
                A setter for the user authentication method

            Arguments:
                authenticationMethod : AuthenticationMethod -> New authentication method

            Returns:
                Boolean -> Whether the authentication method was changed or not

        setPhoneNumber
            Description:
                A setter for the users phone number

                Arguments:
                    newPhoneNumber : String -> The new phone number

                Returns:
                    Boolean -> Whether the phone number was changed or not

        setEmail
            Description:
                A setter for the users email

            Arguments:
                newEmail : String -> The new email for the user

            Returns:
                Boolean -> Whether the email was changed or not
*/

public class User {

    //Variables
    private Privilege privilege;
    private AuthenticationMethod authenticationMethod;
    private String username;
    private String password; //Should be hashed
    private String phoneNumber;
    private String email;

    //Constructors
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

    //Methods
    public Privilege getPrivilege(){
        return this.privilege;
    }

    public AuthenticationMethod getAuthenticationMethod(){
        return this.authenticationMethod;
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

    public String getEmail(){
        return this.email;
    }

    public Boolean setAuthenticationMethod(AuthenticationMethod authenticationMethod){
        this.authenticationMethod = authenticationMethod;
        return true;
    }

    public boolean setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
        return true;
    }

    public boolean setEmail(String newEmail){
        this.email = newEmail;
        return true;
    }
}

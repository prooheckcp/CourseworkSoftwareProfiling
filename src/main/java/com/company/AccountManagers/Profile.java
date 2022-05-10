package com.company.AccountManagers;

//Imports
import com.company.Authentication.Authentication;
import com.company.Utiliity.Data;
import com.company.Utiliity.Tuple;
import com.company.Utiliity.Util;
import com.company.enums.AuthenticationMethod;

/*
    This class manages user profile actions such as current profile, login and register.

    Private Static methods:
        usernameSanityCheck
            Description:
                Validates if the user input for the username is in the correct form

            Arguments:
                username : String -> The username that you want to validate

            Returns:
                Tuple<Boolean, String> -> Returns if it passed the sanity check and the error message in case of false

        passwordSanityCheck
            Description:
                Validates if the user input for the password is in the correct form

            Arguments:
                password : String -> the password that you want to validate

            Returns:
                Tuple<Boolean, String> -> Returns if it passed the sanity check and the error message in case of false

        login
            Description:
                Logs in into given user

            Arguments:
                user : User -> User that you wish to log in into

    Public Static methods:
        getCurrentUser
            Description:
                Returns the current user that is logged in. Will return NULL is no user is logged.

            Returns:
                User -> Logged user

        logout
            Description:
                Logouts the current user

        login
            Description:
                Logs into the account of the given user.

            Arguments:
                user : User -> User you wish to log into

        loginAttempt
            Description:
                Attempts to log in with the given user input. Returns the result of whether the log in worked or not and the followed by an error message

            Arguments:
                username : String -> the username of the account you wish to log in into
                password : String -> the password of the account that you wish to log in into

            Returns:
                Tuple<Boolean, String> -> Returns if the login worked followed by an error message if it fails

        registerAttempt
            Description:
                Attempts to add a new account with the given user input into the pseudo-database. In case it fails it will give feedback to the user

            Arguments:
                username : String -> the username of the account you wish to create
                password : String -> the password of the account that you wish to create

            Returns:
                Tuple<Boolean, String> -> Returns if the register worked followed by an error message if it fails
*/
public class Profile {

    //Constants
    static private final int MINIMUM_USERNAME_LENGTH = 3;
    static private final int MAXIMUM_USERNAME_LENGTH = 12;
    static private final int MINIMUM_PASSWORD_LENGTH = 3;
    static private final int MAXIMUM_PASSWORD_LENGTH = 12;

    static private final String USERNAME_TOO_SHORT_ERROR = "Inserted username is too short. Should be at least: " + MINIMUM_USERNAME_LENGTH + " characters long!";
    static private final String USERNAME_TOO_LONG_ERROR = "Inserted username is too long. Should be at least: " + MAXIMUM_USERNAME_LENGTH + " characters long!";
    static private final String PASSWORD_TOO_SHORT_ERROR = "Inserted password is too long. Should be at least: " + MINIMUM_PASSWORD_LENGTH + " characters long!";
    static private final String PASSWORD_TOO_LONG_ERROR =  "Inserted password is too long. Should be at least: " + MAXIMUM_PASSWORD_LENGTH + " characters long!";
    static private final String USERNAME_TAKEN = "Inserted username is already taken!";

    //Variables
    private static User currentUser;

    //Methods
    private static Tuple<Boolean, String> usernameSanityCheck(String username){
        int usernameLength = username.length();

        if(usernameLength < MINIMUM_USERNAME_LENGTH)
            return Util.responseTuple(false, USERNAME_TOO_SHORT_ERROR);

        if(usernameLength > MAXIMUM_USERNAME_LENGTH)
            return Util.responseTuple(false, USERNAME_TOO_LONG_ERROR);

        return Util.responseTuple(true);
    }

    private static Tuple<Boolean, String> passwordSanityCheck(String password){
        int passwordLength = password.length();

        if(passwordLength < MINIMUM_PASSWORD_LENGTH)
            return Util.responseTuple(false, PASSWORD_TOO_SHORT_ERROR);

        if(passwordLength > MAXIMUM_PASSWORD_LENGTH)
            return Util.responseTuple(false, PASSWORD_TOO_LONG_ERROR);

        return Util.responseTuple(true);
    }

    public static User getCurrentUser(){
        return currentUser;
    }

    public static void logout(){
        currentUser = null;
    }

    public static void login(User user){
        try{
            currentUser = user;
        }catch(NullPointerException e){
            return;
        }
    }

    public static Tuple<Boolean, String> loginAttempt(String username, String password){
        Tuple<Boolean, User> getUserResponse = Data.getUser(username);

        //Check if the user exists
        if(!getUserResponse.getValue1())
            return new Tuple<>(false, "The user by the name of: " + username + " does not exist");

        User user = getUserResponse.getValue2();

        //Check if the password is correct
        Authentication passwordAuthentication = Data.authenticationList.get(AuthenticationMethod.PASSWORD);
        boolean passwordMatches = passwordAuthentication.loginAttempt(user, password);

        if(!passwordMatches)
            return new Tuple<>(false, "Inserted password is incorrect!");

        //Checks for authentication method
        if(user.getAuthenticationMethod() != null && Data.authenticationList.containsKey(user.getAuthenticationMethod())){
            Authentication authentication = Data.authenticationList.get(user.getAuthenticationMethod());
            Boolean success = authentication.loginAttempt(user, password);

            if(!success)
                return new Tuple<>(false, "Failed authentication");
        }

        //Logs into the account
        login(user);

        return new Tuple<>(true, "");
    }

    public static Tuple<Boolean, String> registerAttempt(String username, String password){
        Tuple<Boolean, String> usernameSanityResult = usernameSanityCheck(username);
        Tuple<Boolean, String> passwordSanityResult = passwordSanityCheck(password);

        if(!usernameSanityResult.getValue1())
            return Util.responseTuple(false, usernameSanityResult.getValue2());

        if(!passwordSanityResult.getValue1())
            return Util.responseTuple(false, passwordSanityResult.getValue2());

        Tuple<Boolean, User> getUserResponse = Data.getUser(username);

        if(getUserResponse.getValue1())
            return Util.responseTuple(false, USERNAME_TAKEN);

        User user = Data.createUser(username, password);
        login(user);

        return Util.responseTuple(true);
    }
}

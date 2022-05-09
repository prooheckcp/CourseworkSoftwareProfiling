package com.company.AccountManagers;

import com.company.Authentication.Authentication;
import com.company.Utiliity.Data;
import com.company.Utiliity.Tuple;
import com.company.Utiliity.Util;
import com.company.enums.AuthenticationMethod;

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
        Tuple<Boolean, User> getUserResponse = Data.getUser(username);

        if(getUserResponse.getValue1())
            return new Tuple<>(false, "Inserted username is already taken");

        User user = Data.createUser(username, password);
        login(user);

        return new Tuple<>(true, "");
    }
}

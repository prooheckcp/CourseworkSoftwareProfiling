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
        Authentication authentication = Data.authenticationList.get(AuthenticationMethod.PASSWORD);
        boolean passwordMatches = authentication.loginAttempt(user, password);

        if(!passwordMatches)
            return new Tuple<>(false, "Inserted password is incorrect!");

        login(user);

        return new Tuple<>(true, "");
    }
}

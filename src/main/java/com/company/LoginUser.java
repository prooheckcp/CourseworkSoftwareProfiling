package com.company;

/*
This is one of the actions present in the main menu.
It allows the user to get into his account.

    Static methods:
        loginAttempt
            Description: Attempts to log in into a given user. Starts by checking
            if this user has authentication methods and if yes it prompts them.

            Arguments:
                user : User -> User that you're attempting to log into

    Public methods:
        Main
            Description: Option that gets called upon the selection of the "Log out" on the profile.

            Return:
                Boolean -> True if ready to leave this option. False if still not ready.
*/

public class LoginUser extends MenuAction {
    LoginUser(String actionName){
        super(actionName);
    }

    public static void loginAttempt(User user){
        if(Data.authenticationList.containsKey(user.getAuthenticationMethod())){
            if(!Data.authenticationList.get(user.getAuthenticationMethod()).loginAttempt(user, ""))
                return;
        }

        Profile.login(user);
    }

    public void Main(){
        Util.print("Login:");
        Util.printInLine("Username: ");
        String insertedUsername = Util.getLine();
        Util.printInLine("Password: ");
        String insertedPassword = Util.getLine();

        Tuple<Boolean, User> getUserResult = Data.getUser(insertedUsername);
        if(!getUserResult.getValue1()){
            Util.print("Couldn't find any user by the name of: " + insertedUsername);
            if(Util.retryPrompt())
                Main();

            return;
        }

        //First authentication step
        Boolean passedFirstGate =  Data.authenticationList.get(AuthenticationMethod.PASSWORD).loginAttempt(getUserResult.getValue2(), insertedPassword);
        if(!passedFirstGate){
            Util.print("Incorrect password!");
            if(Util.retryPrompt())
                Main();

            return;
        }

        loginAttempt(getUserResult.getValue2());

        return;
    }
}

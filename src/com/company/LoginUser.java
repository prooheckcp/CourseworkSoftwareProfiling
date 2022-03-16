package com.company;

public class LoginUser extends MenuAction {
    LoginUser(String actionName){
        super(actionName);
    }

    public static void loginAttempt(User user){
        if(Data.AuthenticationList.containsKey(user.authenticationMethod)){
            if(!Data.AuthenticationList.get(user.authenticationMethod).loginAttempt(user, ""))
                return;
        }

        Profile.login(user);
    }

    public Boolean Main(){
        Util.print("Login:");
        Util.printInLine("Username: ");
        String insertedUsername = Util.getLine();
        Util.printInLine("Password: ");
        String insertedPassword = Util.getLine();

        Tuple<Boolean, User> getUserResult = Data.getUser(insertedUsername);
        if(!getUserResult.getValue1()){
            Util.print("Couldn't find any user by the name of: " + insertedUsername);
            return Util.retryPrompt();
        }

        //First authentication step
        Boolean passedFirstGate = PasswordAuthentication.loginAttempt(getUserResult.getValue2(), insertedPassword);
        if(!passedFirstGate){
            Util.print("Incorrect password!");
            return Util.retryPrompt();
        }

        loginAttempt(getUserResult.getValue2());

        return false;
    }
}

package com.company;

public class RegisterUser extends MenuAction{
    RegisterUser(String actionName){
        super(actionName);
    }

    public Boolean Main(){
        Util.print("Register:");
        Util.printInLine("Username: ");
        String insertedUsername = Util.getLine();
        Util.printInLine("Password: ");
        String insertedPassword = Util.getLine();

        Tuple<Boolean, String> creationResult = Data.createUser(insertedUsername, insertedPassword);
        if(!creationResult.getValue1()){
            Util.print(creationResult.getValue2());
            return Util.retryPrompt();
        }

        Util.print("Account created!");

        //No need to check if value1 is true because we just made this user
        LoginUser.loginAttempt(Data.getUser(insertedUsername.strip()).getValue2());

        return true;
    }
}

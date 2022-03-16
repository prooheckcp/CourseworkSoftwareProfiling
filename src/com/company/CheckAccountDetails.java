package com.company;

public class CheckAccountDetails extends MenuAction {
    CheckAccountDetails(String actionName){
        super(actionName);
    }

    public Boolean Main(){
        User user = Profile.currentUser;
        Util.print("||Account details||");
        Util.print("Username: " + user.username);
        Util.print("Email: " + user.email);
        Util.print("Phone number: " + user.phoneNumber);
        Util.print("Privilege: " + Data.privilegeStrings.get(user.privilege));
        Util.print("Authentication Method: " + Data.authenticationStrings.get(user.authenticationMethod) + "\n");

        return true;
    };
}

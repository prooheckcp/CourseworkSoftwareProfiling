package com.company;

public class CheckAccountDetails extends MenuAction {
    CheckAccountDetails(String actionName){
        super(actionName);
    }

    public Boolean Main(){
        User user = Profile.currentUser;
        Util.print("||Account details||");
        Util.print("Username: " + user.getUsername());
        Util.print("Email: " + user.getEmail());
        Util.print("Phone number: " + user.getPhoneNumber());
        Util.print("Privilege: " + Data.privilegeStrings.get(user.getPrivilege()));
        Util.print("Authentication Method: " + Data.authenticationStrings.get(user.getAuthenticationMethod()) + "\n");

        return true;
    };
}

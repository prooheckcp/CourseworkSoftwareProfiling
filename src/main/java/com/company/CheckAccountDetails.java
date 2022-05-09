package com.company;

/*
This is one of the actions present in the profile menu.
It shows to the user the information present on his account.

    Public methods:
        Main
            Description: Option that gets called upon the selection of the "CheckAccountDetails" on the profile.

            Return:
                Boolean -> True if ready to leave this option. False if still not ready.
*/

public class CheckAccountDetails extends MenuAction {
    CheckAccountDetails(String actionName){
        super(actionName);
    }

    public void Main(){
        if(Profile.currentUser == null){
            Util.print("Error: Current user is invalid!");
            return;
        }

        User user = Profile.currentUser;
        Util.print("||Account details||");
        Util.print("Username: " + user.getUsername());
        Util.print("Email: " + user.getEmail());
        Util.print("Phone number: " + user.getPhoneNumber());
        Util.print("Privilege: " + Data.privilegeStrings.get(user.getPrivilege()));
        Util.print("Authentication Method: " + Data.authenticationStrings.get(user.getAuthenticationMethod()) + "\n");
    };
}

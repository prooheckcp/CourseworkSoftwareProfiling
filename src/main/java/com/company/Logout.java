package com.company;

/*
This is one of the actions present in the profile menu.
This options logs out the user from his account.

    Public methods:
        Main
            Description: Option that gets called upon the selection of the "Log out" on the profile.

            Return:
                Boolean -> True if ready to leave this option. False if still not ready.
*/

public class Logout extends MenuAction {
    Logout(String actionName){
        super(actionName);
    }

    public Boolean Main(){
        //Log out user
        Profile.currentUser = null;
        return false;
    };
}

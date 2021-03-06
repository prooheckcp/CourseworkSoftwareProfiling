package com.company.Utility;

/*
This is an abstract class used to implement
menu actions. It essentially supports the
strategy patterns by allowing us to store methods
that will be called upon selecting a certain option

    Public methods:
        Main
            Description:
                Called upon the selection of a certain option

            Returns:
                Boolean -> True if ready to leave this option. False if still not ready.
*/

public class MenuAction {
    //Constants
    private final String IMPLEMENTATION_ERROR = "This Menu action has not been implemented yet!";

    //Members
    public String actionName = "N/A";

    public MenuAction(){

    }

    public MenuAction(String actionName){
        this.actionName = actionName;
    }

    //Manages the following steps for this menu action
    public void Main(){
        Util.print(IMPLEMENTATION_ERROR);
    };

}

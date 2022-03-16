package com.company;

import java.util.Scanner;

public class RegisterUser extends MenuAction{
    RegisterUser(String actionName){
        super(actionName);
    }

    public void Main(){
        Util.printDivision();
        Util.print("Register menu:");
        Util.printInLine("username: ");
        String insertedUsername = Util.getLine();
        Util.printInLine("password: ");
        String insertedPassword = Util.getLine();
    }
}

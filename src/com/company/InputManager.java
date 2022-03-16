package com.company;

/*
    This file has the purpose of requesting and managing user input
    while using this console application
*/

import java.util.Scanner;

public class InputManager {

    static final MenuAction[] MENU_ACTIONS = {
        new RegisterUser("Register"),
        new LoginUser("Log-in")
    };

    static final private String INITIAL_MESSAGE =
    "Welcome to the IT" +
    " services of the University of Bradford!\n" +
    "What do you wish to do?\n\n";

    private static String GetOptionsList(){
        String result = "";

        if(MENU_ACTIONS.length <= 0){
            return "No options were found!";
        }

        for(int index = 0; index < MENU_ACTIONS.length; index++){
            MenuAction menuAction = MENU_ACTIONS[index];
            result += String.valueOf(index + 1) + ". " + menuAction.actionName + "\n";
        }
        return result;
    }

    public static Integer parseOption(String option){
        try{
            return Integer.parseInt(option);
        }catch (NumberFormatException e){
            return -1;
        }
    }

    private static boolean isValidOption(int index){
        return (index > 0 && index < MENU_ACTIONS.length + 1);
    }

    static void MainWindow(){
        Scanner scanner = new Scanner(System.in);
        Util.print(INITIAL_MESSAGE + GetOptionsList());
        Integer userSelectedOption = parseOption(scanner.nextLine());

        if(!isValidOption(userSelectedOption)){
            Util.print("Error: Selected option is not valid!\n");
            return;
        }

        MenuAction menuAction = MENU_ACTIONS[userSelectedOption - 1];
        menuAction.Main();
    }
}

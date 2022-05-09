package com.company;

/*
This class prompts an X amount of options
to the given user to select from which will
play a custom method

    Static Methods:
        parseOption
            Description: Given a string that should represent user input,
            convert this string into an integer. E.g "3" -> 3

            Arguments:
                option : String -> String to be parsed

            Return:
                Integer -> Option in integer format

    Public Methods:
        promptOptions
            Description: Displays the actions to the user and awaits for user input.

    Private Methods:
        isValidOption
            Description: Given an integer option this method should return true if it
            is a valid option to be selected or false if it isn't.

            Arguments:
                index : Integer -> Option index

            Return:
                Boolean -> Whether it is a valid option or not

        getOptionsList
            Description: Returns a pretty string with all the options
            that the user can select.

            Return:
                String -> Cleaned string with options.
*/

public class Options {
    MenuAction[] menuActions;
    String menuName;

    Options(String menuName, MenuAction[] menuActions){
        this.menuName = menuName;
        this.menuActions = menuActions;
    }

    public static Integer parseOption(String option){
        try{
            return Integer.parseInt(option);
        }catch (NumberFormatException e){
            return -1;
        }
    }

    public void promptOptions(){
        Util.print(menuName + ":");
        Util.print(getOptionsList());
        Integer userSelectedOption = parseOption(Util.getLine());
        if(!isValidOption(userSelectedOption)){
            Util.print("Error: Selected option is not valid!\n");
            promptOptions();
            return;
        }
        MenuAction menuAction = menuActions[userSelectedOption - 1];;
    }

    private Boolean isValidOption(Integer index){
        return (index > 0 && index < menuActions.length + 1);
    }

    private String getOptionsList(){
        String result = "";

        if(menuActions.length <= 0){
            return "No options were found!";
        }

        for(int index = 0; index < menuActions.length; index++){
            MenuAction menuAction = menuActions[index];
            result += String.valueOf(index + 1) + ". " + menuAction.actionName + "\n";
        }
        return result;
    }
}

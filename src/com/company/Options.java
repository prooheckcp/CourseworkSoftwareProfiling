package com.company;

/*
This class prompts an X amount of options
to the given user to select from
*/

public class Options {
    MenuAction[] menuActions;

    public static Integer parseOption(String option){
        try{
            return Integer.parseInt(option);
        }catch (NumberFormatException e){
            return -1;
        }
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

    public void promptOptions(){
        Util.print(getOptionsList());
        Integer userSelectedOption = parseOption(Util.getLine());
        if(!isValidOption(userSelectedOption)){
            Util.print("Error: Selected option is not valid!\n");
            return;
        }
        MenuAction menuAction = menuActions[userSelectedOption - 1];
        while(true){
            if (menuAction.Main())
                break;
        }
    }

    Options(MenuAction[] menuActions){
        this.menuActions = menuActions;
    }


}

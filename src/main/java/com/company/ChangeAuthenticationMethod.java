package com.company;

import java.util.HashMap;
import java.util.Map;

public class ChangeAuthenticationMethod extends MenuAction {
    ChangeAuthenticationMethod(String actionName){
        super(actionName);
    }

    public Boolean Main(){
        String finalMessage = "";
        Integer index = 0;

        //Temporary list for reference
        Map<Integer, AuthenticationMethod> temp = new HashMap<>();

        Util.print("Select authentication method:");
        for(AuthenticationMethod key : Data.authenticationList.keySet()){
            index++;
            finalMessage += String.valueOf(index) + "." + Data.authenticationStrings.get(key) + "\n";
            temp.put(index, key);
        }

        Util.print(finalMessage);

        String userOption = Util.getLine();
        Integer filteredUserOption = Options.parseOption(userOption);

        if(!temp.containsKey(filteredUserOption)){
            Util.print("Error: Selected option is not valid!");
            Main();
            return true;
        }

        AuthenticationMethod selectedMethod = temp.get(filteredUserOption);
        if(selectedMethod == AuthenticationMethod.PASSWORD)
            Profile.currentUser.setAuthenticationMethod(AuthenticationMethod.NONE);
        else
            Profile.currentUser.setAuthenticationMethod(selectedMethod);

        return true;
    };
}

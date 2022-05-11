package com.company.Utiliity;

//Imports
import javax.swing.*;

/*
This class implements some utility methods that
are essentially wrappers to already existing java
methods.

    Static Methods:
        getLine
            Description:
                Pops up a dialog box asking for user input and returns the user input.

            Arguments:
                message : String -> The message that you want to display to the user in the dialog box.

            Returns:
                String -> User input

        warning
            Description:
                Alerts a user with a given message. Similar to Javascript's alert()

            Arguments:
                message : String -> The message to display on the alert

        responseTuple
            Description:
                This behaves as a wrapper for the usual Tuple<Boolean, String>. Since I usually return a tupple with the success status and errorMessage as a way to manage checks this allows us to create responses with a smaller syntax.

            Arguments:
                Boolean -> If the action succeed or not
                String (optional) -> Error message to give context in case it fails

        printInLine
            Description:
                Wrapper function for System.out.print

            Arguments:
                String message

         print
            Description:
                Wrapper function for System.out.println

            Arguments:
                String message
*/

public class Util {

    public static String getLine(String message){
        return JOptionPane.showInputDialog(message);
    }

    public static void warning(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static Tuple<Boolean, String> responseTuple(Boolean first, String second){
        return new Tuple<Boolean, String>(first, second);
    }

    public static Tuple<Boolean, String> responseTuple(Boolean first){
        return responseTuple(first, "");
    }

    public static void printInLine(String message){
        System.out.print(message);
    }

    public static void print(String message){
        System.out.println(message);
    }
}

package com.company.Utiliity;
/*
This class implements some utility methods that
are essentially wrappers to already existing java
methods.

    Static Methods:
        getLine
            Description: Gets the next line of input given by the user.

            Returns:
                String -> Next line of input from the user

        retryPrompt
            Description: Asks if the user wants to retry or go back.
            Pressing 1 will make it return true, everything else will make it false.

            Returns:
                Boolean -> If the user pressed 1 or not

        printInLine
            Description: Wrapper function for System.out.print

            Arguments:
                String message

         print
            Description: Wrapper function for System.out.println

            Arguments:
                String message
*/

import javax.swing.*;

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

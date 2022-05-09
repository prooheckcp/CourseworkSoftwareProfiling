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

import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);

    public static String getLine(){
        if(scanner.hasNextLine())
            return scanner.nextLine();
        return "";
    }

    public static void printInLine(String message){
        System.out.print(message);
    }

    public static void print(String message){
        System.out.println(message);
    }
}

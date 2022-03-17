package com.company;
/*
This class implements some utility methods that
java does not have by default
*/

import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);

    public static String getLine(){
        return scanner.nextLine();
    }

    public static Boolean retryPrompt(){
        Util.print("Press 1 to retry or any other key to go back");
        return (Options.parseOption(Util.getLine()) == 1);
    }

    public static void printDivision(){
        print("||||||||||||||||||||||||");
    }

    public static void printInLine(String message){
        System.out.print(message);
    }

    public static void print(String message){
        System.out.println(message);
    }
}

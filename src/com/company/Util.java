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

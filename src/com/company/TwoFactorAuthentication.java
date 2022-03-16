package com.company;
import java.io.File;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class TwoFactorAuthentication extends Authentication{
    public boolean loginAttempt(User a, String b) {
        Random rand = new Random();

        //Generate number between 0-999
        int generatedCode = rand.nextInt(1000);
        
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Util.print("A code was sent to your mobile device!");

        Util.printInLine("Code: ");
        String insertedCode = Util.getLine();

        return false;
    }
}

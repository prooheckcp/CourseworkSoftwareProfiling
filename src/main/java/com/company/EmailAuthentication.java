package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class EmailAuthentication implements Authentication{
    //Sends the code to a txt file
    private void sendCode(String code){
        try{
            FileWriter myWriter = new FileWriter("EmailCode.txt");
            myWriter.write("Your code: " + code);
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private char randomChar(){
        Random rand = new Random();
        return (char)rand.nextInt(65, 91);
    }

    public boolean loginAttempt(User a, String b) {
        Random rand = new Random();

        //Generate a 3 number sequence
        String generatedCode = "" + randomChar() + randomChar() + randomChar();

        sendCode(generatedCode);

        Util.print("A code was sent to your email!");

        Util.printInLine("Code: ");
        String insertedCode = Util.getLine();


        Boolean correctCode =  insertedCode.strip().equals(generatedCode);

        if(!correctCode)
            Util.print("Inserted code is incorrect!");

        return correctCode;
    }
}

package com.company.Authentication;

import com.company.AccountManagers.User;
import com.company.Utiliity.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
This is one of the multiple authentication methods.
It generates 3 random letters and writes them to a txt file.
Requiring the user to input three letters.

    Public methods:
        loginAttempt
            Description: Attempts to log-in
            Arguments:
                _a : User -> Does not require this argument, can pass null
                _b : String -> Does not require this argument, can pass null

            Returns:
                Boolean -> If the user succeed on passing the login attempt

    Private methods:
        sendCode
            Description: Writes the code into a txt file
            Arguments:
                code : String -> The code that you want to be written in the txt file

        randomChar
            Description: Generates a random letter (A-Z)

            Returns:
                char -> Returns letter (A-Z)
*/

public class EmailAuthentication implements Authentication {
    public boolean loginAttempt(User _a, String _b) {
        //Generate a 3 letter sequence
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
}

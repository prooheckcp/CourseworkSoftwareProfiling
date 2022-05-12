package com.company.Authentication;

//Imports
import com.company.AccountManagers.User;
import com.company.Utility.Util;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
This is one of the multiple authentication methods.
It generates 3 random letters and writes them to a txt file.
Requiring the user to input three letters.

    Public methods:
        loginAttempt
            Description:
                Attempts to log-in

            Arguments:
                _a : User -> Does not require this argument, can pass null
                _b : String -> Does not require this argument, can pass null

            Returns:
                Boolean -> If the user succeed on passing the login attempt

    Private methods:
        sendCode
            Description:
                Writes the code into a txt file

            Arguments:
                code : String -> The code that you want to be written in the txt file

        randomChar
            Description:
                Generates a random letter (A-Z)

            Returns:
                char -> Returns letter (A-Z)
*/

public class EmailAuthentication implements Authentication {
    //Constants
    private final String WARNING_MESSAGE = "A code has been sent to your email! Insert it below";
    private final String FILE_NAME = "EmailCode.txt";
    private final int FIRST_ASCII_VALUE = 65;
    private final int FINAL_ASCII_VALUE = 91;

    //Methods
    public boolean loginAttempt(User _a, String _b) {
        //Generate a 3 letter sequence
        String generatedCode = "" + randomChar() + randomChar() + randomChar();

        sendCode(generatedCode);

        String response = Util.getLine(WARNING_MESSAGE).trim();
        Boolean correctCode =  response.strip().equals(generatedCode);

        return correctCode;
    }

    private void sendCode(String code){
        try{
            FileWriter myWriter = new FileWriter(FILE_NAME);
            myWriter.write("Your code: " + code);
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private char randomChar(){
        Random rand = new Random();
        return (char)rand.nextInt(FIRST_ASCII_VALUE, FINAL_ASCII_VALUE);
    }
}

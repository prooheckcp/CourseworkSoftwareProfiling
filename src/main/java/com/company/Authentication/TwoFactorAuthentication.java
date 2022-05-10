package com.company.Authentication;
import com.company.AccountManagers.User;
import com.company.Utiliity.Util;

import javax.swing.*;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/*
This is one of the multiple authentication methods.
It generates 3 random number and writes them to a txt file.
Requiring the user to input three numbers.

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
                code : Integer -> The code that you want to be written in the txt file
*/

public class TwoFactorAuthentication implements Authentication {
    //Constants
    private String WARNING_MESSAGE = "A code has been sent to your phone! Insert it below";

    //Sends the code to a txt file
    private void sendCode(Integer code){
        try{
            FileWriter myWriter = new FileWriter("MobileDeviceCode.txt");
            myWriter.write("Your code: " + code.toString());
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean loginAttempt(User _a, String _b) {
        Random rand = new Random();

        //Generate number between 0-999
        Integer generatedCode = rand.nextInt(1000);
        String generatedCodeString = generatedCode.toString();
        sendCode(generatedCode);

        String response = Util.getLine(WARNING_MESSAGE).trim();
        Boolean correctCode = response.strip().equals(generatedCodeString);

        return correctCode;
    }
}
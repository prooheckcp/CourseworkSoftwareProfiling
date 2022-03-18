package com.company;
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

public class TwoFactorAuthentication implements Authentication{

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

        Util.print("A code was sent to your mobile device!");

        Util.printInLine("Code: ");
        String insertedCode = Util.getLine();

        Boolean correctCode = insertedCode.strip().equals(generatedCodeString);

        if(!correctCode)
            Util.print("Inserted code is incorrect!");

        return correctCode;
    }
}

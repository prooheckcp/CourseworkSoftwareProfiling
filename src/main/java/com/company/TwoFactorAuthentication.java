package com.company;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

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

    public boolean loginAttempt(User a, String b) {
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

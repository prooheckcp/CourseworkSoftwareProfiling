package com.company;

public class TwoFactorAuthentication extends Authentication{
    static public boolean loginAttempt(User a, String b) {
        Util.print("A code was sent to your mobile device!");
        int GeneratedCode = 1000;
        Util.printInLine("Code: ");
        String insertedCode = Util.getLine();

        return false;
    }
}

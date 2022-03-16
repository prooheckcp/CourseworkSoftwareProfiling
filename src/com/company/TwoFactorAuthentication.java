package com.company;

public class TwoFactorAuthentication implements Authentication{
    static public boolean loginAttempt(User user, String userInput) {
        return user.password.strip().equals(userInput.strip());
    }
}

package com.company;

public class PasswordAuthentication extends Authentication {
    public boolean loginAttempt(User user, String userInput) {
        return user.password.strip().equals(userInput.strip());
    }
}


package com.company;

public class PasswordAuthentication implements Authentication {
    public boolean loginAttempt(User user, String userInput) {
        return user.getPassword().strip().equals(userInput.strip());
    }
}


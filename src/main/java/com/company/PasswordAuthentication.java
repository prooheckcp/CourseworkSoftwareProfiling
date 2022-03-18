package com.company;

/*
This is one of the multiple authentication methods.
It simply compares the given password with the given user password.

    Public methods:
        loginAttempt
            Description: Attempts to log-in
            Arguments:
                user : User -> User that you're attempting to log into
                userInput : String -> User input for logging in into the account

            Returns:
                Boolean -> If the user succeed on passing the login attempt
*/

public class PasswordAuthentication implements Authentication {
    public boolean loginAttempt(User user, String userInput) {
        return user.getPassword().strip().equals(userInput.strip());
    }
}


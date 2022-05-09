package com.company.Authentication;

/*
This is an interface to implement custom authentication methods.
The loginAttempt function gets called a user attempts to log in while having the
authentication class activated.
*/

import com.company.AccountManagers.User;

public interface Authentication {
    boolean loginAttempt(User user, String userInput);
}

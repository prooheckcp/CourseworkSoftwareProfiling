package com.company;

/*
Since we won't be using any sort of databases
or storing files we'll instead use this place
to save data related to the program and other static data
such as option lists

    Static methods:
        getUser
            Description: This method is used to find a user by his username
            and retrieve it.

            Arguments:
                username : String -> The username of the user you want to find

            Returns:
                Tuple<Boolean, User> -> A tuple where the first argument is true if it
                                        found the user and the second argument is the user.

        createUser
            Description: Creates a new user into the pseudo database.

            Arguments:
                username : String -> Username for the new user
                password : String -> The password for the new account

            Returns:
                Tuple<Boolean, String> -> A tuple where the first argument is true if it
                                          created a new user and the second argument a feedback
                                          message for context in case it fails.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Data {

    public static final OperatingSystem currentOperatingSystem = OperatingSystem.WINDOWS; //Hardcoded
    public static final Map<AuthenticationMethod, Authentication> authenticationList = new HashMap<>(){{
        put(AuthenticationMethod.PASSWORD, new PasswordAuthentication());
        put(AuthenticationMethod.TWO_FACTOR, new TwoFactorAuthentication());
        put(AuthenticationMethod.EMAIL, new EmailAuthentication());
    }};
    public static final Map<OperatingSystem, GUI> GUIList = new HashMap<>(){{
        put(OperatingSystem.WINDOWS, new windowsGUI());
        put(OperatingSystem.LINUX, new linuxGUI());
    }};

    public static Map<Privilege, String> privilegeStrings = new HashMap<>(){{
        put(Privilege.GUEST, "Guest");
        put(Privilege.ADMIN, "Admin");
    }};

    public static Map<AuthenticationMethod, String> authenticationStrings = new HashMap<>(){{
        put(AuthenticationMethod.NONE, "None");
        put(AuthenticationMethod.PASSWORD, "Password");
        put(AuthenticationMethod.TWO_FACTOR, "2FA");
        put(AuthenticationMethod.EMAIL, "Email");
    }};

    //Random basic admin account for testing purposes
    private static Vector<User> userList = new Vector<User>(){{
        add(
            new User(
                    "prooheckcp",
                    "password",
                    Privilege.ADMIN,
                    AuthenticationMethod.NONE)
        );

        add(
            new User(
                    "proohec",
                    "password",
                    Privilege.ADMIN,
                    AuthenticationMethod.EMAIL)
        );
    }};

    public static Tuple<Boolean, User> getUser(String username){
        for(int index = 0; index < userList.size(); index++){
            User user = userList.get(index);

            if(user.getUsername().strip().equals(username))
                return new Tuple(true, user);
        }
        return new Tuple(false, null);
    }

    public static Tuple<Boolean, String> createUser(String username, String password){
        username = username.strip();

        for(int index = 0; index < userList.size(); index++){
            if(userList.get(index).getUsername().strip().equals(username)){
                return new Tuple<>(false, "The username: " + username + " is already taken!");
            }
        }

        userList.add(new User(username.strip(), password));

        return new Tuple<>(true, "");
    }
}

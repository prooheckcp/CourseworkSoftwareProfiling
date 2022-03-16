package com.company;

/*
Since we won't be using any sort of databases
or storing files we'll instead use this place
to save data related to the program
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class data {

    public static final String INITIAL_MESSAGE =
            "Welcome to the IT " +
            "services of the University of Bradford!\n" +
            "What do you wish to do?\n\n";

    private static Vector<User> userList = new Vector<User>();

    public static void declareTestUsers(){
        //Random basic admin account for testing purposes
        userList.add(new User("prooheckcp", "password", Privilege.ADMIN));
    }

    public static Tuple<Boolean, User> getUser(String username){
        for(int index = 0; index < userList.size(); index++){
            User user = userList.get(index);

            if(user.username.strip().equals(username))
                return new Tuple(true, user);
        }
        return new Tuple(false, null);
    }

    public static Tuple<Boolean, String> createUser(String username, String password){
        username = username.strip();

        for(int index = 0; index < userList.size(); index++){
            if(userList.get(index).username.strip().equals(username)){
                return new Tuple<>(false, "The username: " + username + " is already taken!");
            }
        }

        userList.add(new User(username.strip(), password));

        return new Tuple<>(true, "");
    }
}

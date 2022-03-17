package com.company;

/*
Since we won't be using any sort of databases
or storing files we'll instead use this place
to save data related to the program and other static data
such as option lists
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Data {
    public static final Map<AuthenticationMethod, Authentication> AuthenticationList = new HashMap<>();

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

    public static Options profileWindowOptions = new Options("Profile options", new MenuAction[]{
            new CheckAccountDetails("Show account details"),
            new ChangeAuthenticationMethod("Change authentication method"),
            new Logout("Log-out")
    });

    public static final String INITIAL_MESSAGE =
            "Welcome to the IT " +
            "services of the University of Bradford!\n" +
            "What do you wish to do?\n";

    public static Options mainWindowOptions = new Options("Main window", new MenuAction[]{
            new RegisterUser("Register"),
            new LoginUser("Log-in")
    });

    private static Vector<User> userList = new Vector<User>();

    public static void populateAuthenticationList(){
        AuthenticationList.put(AuthenticationMethod.PASSWORD, new PasswordAuthentication());
        AuthenticationList.put(AuthenticationMethod.TWO_FACTOR, new TwoFactorAuthentication());
        AuthenticationList.put(AuthenticationMethod.EMAIL, new EmailAuthentication());
    }

    public static void declareTestUsers(){
        //Random basic admin account for testing purposes
        userList.add(new User(
                "prooheckcp",
                "password",
                Privilege.ADMIN,
                AuthenticationMethod.NONE
        ));
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

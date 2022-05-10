package com.company.GUIcontainers;

import com.company.AccountManagers.Profile;
import com.company.AccountManagers.User;
import com.company.GUIs.Linux.LinuxAccountDetails;
import com.company.GUIs.Linux.LinuxLogin;
import com.company.GUIs.Linux.LinuxOptions;
import com.company.GUIs.Linux.LinuxRegister;
import com.company.Utiliity.Data;
import com.company.Utiliity.Event;
import com.company.Utiliity.EventManager;
import com.company.enums.AuthenticationMethod;
import com.company.enums.Privilege;

public class linuxGUI extends GUI {
    @Override
    public void start() {
        //Creates the actions of the GUI
        setupEvents();

        //Creating options panels
        LinuxOptions mainWindow = new LinuxOptions(
                "Main Hub (Linux Version)",
                "Please select what you wish to do.",
                mainWindowActions
        );

        LinuxOptions profileWindow = new LinuxOptions(
                "Profile",
                "",
                profileWindowActions
        );

        LinuxOptions authenticationWindow = new LinuxOptions(
                "Authentication",
                "Please select your desired authentication method",
                authenticationWindowActions
        );

        //Populating the options panels
        setMainPanel(mainWindow.getMainContainer());
        setProfilePanel(profileWindow.getMainContainer());
        setAuthenticationPanel(authenticationWindow.getMainContainer());

        //Create the rest of the panels
        LinuxRegister linuxRegister = new LinuxRegister(this);
        LinuxLogin linuxLogin = new LinuxLogin(this);
        LinuxAccountDetails linuxAccountDetails = new LinuxAccountDetails(this);

        setLoginPanel(linuxLogin.getMainContainer());
        setRegisterPanel(linuxRegister.getMainContainer());
        setAccountDetailsPanel(linuxAccountDetails.getMainContainer());

        //Events
        EventManager.addListener(Data.PROFILE_UPDATE, new Event(){
            @Override
            public void action(){
                User user = Profile.currentUser;

                if(user == null)
                    return;

                String username = (user.getUsername() != null) ? user.getUsername() : "N/A";
                String email = (user.getEmail() != null) ? user.getEmail() : "N/A";
                String phoneNumber = (user.getPhoneNumber() != null) ? user.getPhoneNumber() : "N/A";

                AuthenticationMethod authenticationMethod = user.getAuthenticationMethod();
                Privilege privilege = user.getPrivilege();

                String authenticationMethodString = "N/A";
                String privilegeString = "N/A";

                if(authenticationMethod != null && Data.authenticationStrings.containsKey(authenticationMethod))
                    authenticationMethodString = Data.authenticationStrings.get(authenticationMethod);

                if(privilege != null && Data.privilegeStrings.containsKey(privilege))
                    privilegeString = Data.privilegeStrings.get(privilege);

                linuxAccountDetails.setupUsername(username);
                linuxAccountDetails.setupEmail(email);
                linuxAccountDetails.setupPrivilege(privilegeString);
                linuxAccountDetails.setupPhoneNumber(phoneNumber);
                linuxAccountDetails.setupAuthenticationMethod(authenticationMethodString);
            }
        });

        EventManager.addListener(Data.LOGGED_IN, new Event(){
            @Override
            public void action() {
                profileWindow.setDescription("Welcome back " + Profile.currentUser.getUsername() + "! What are you doing today?");
            }
        });

        super.start();
    }
}

package com.company.GUIcontainers;

import com.company.AccountManagers.Profile;
import com.company.AccountManagers.User;
import com.company.GUIcontainers.GUI;
import com.company.GUIs.Windows.WindowsAccountDetails;
import com.company.GUIs.Windows.WindowsLogin;
import com.company.GUIs.Windows.WindowsOptions;
import com.company.GUIs.Windows.WindowsRegister;
import com.company.Utiliity.Data;
import com.company.Utiliity.Event;
import com.company.Utiliity.EventManager;
import com.company.enums.AuthenticationMethod;
import com.company.enums.Privilege;

public class windowsGUI extends GUI {
    @Override
    public void start() {
        //Creates the actions of the GUI
        setupEvents();

        //Creating options panels
        WindowsOptions mainWindow = new WindowsOptions(
                "Main Hub",
                "Please select what you wish to do.",
                mainWindowActions
        );

        WindowsOptions profileWindow = new WindowsOptions(
                "Profile",
                "Welcome to your account, what do you wish to do?",
                profileWindowActions
        );

        WindowsOptions authenticationWindow = new WindowsOptions(
                "Authentication",
                "Please select your desired authentication method",
                authenticationWindowActions
        );

        //Populating the options panels
        setMainPanel(mainWindow.getMainContainer());
        setProfilePanel(profileWindow.getMainContainer());
        setAuthenticationPanel(authenticationWindow.getMainContainer());

        //Create the rest of the panels
        WindowsRegister windowsRegister = new WindowsRegister(this);
        WindowsLogin windowsLogin = new WindowsLogin(this);
        WindowsAccountDetails windowsAccountDetails = new WindowsAccountDetails(this);

        setLoginPanel(windowsLogin.getMainContainer());
        setRegisterPanel(windowsRegister.getMainContainer());
        setAccountDetailsPanel(windowsAccountDetails.getMainContainer());

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

                windowsAccountDetails.setupUsername(username);
                windowsAccountDetails.setupEmail(email);
                windowsAccountDetails.setupPrivilege(privilegeString);
                windowsAccountDetails.setupPhoneNumber(phoneNumber);
                windowsAccountDetails.setupAuthenticationMethod(authenticationMethodString);
            }
        });

        super.start();
    }
}

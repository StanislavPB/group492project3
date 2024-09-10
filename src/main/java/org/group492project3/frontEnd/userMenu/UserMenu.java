package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.dto.Response;
import org.group492project3.frontEnd.API.Api;
import org.group492project3.frontEnd.services.UserInputService;

public class UserMenu {
    private UserInputService userInput = new UserInputService();
    private Api api = new Api();
    //private MessageService message = new MessageService;

    public UserMenu() {
        startUserInterface();
    }

    private void startUserInterface() {
        switch (userInput.getInt(
                "Enter number of item to continue:\n" +
                        "1.Login.\n" +
                        "2.Registration.\n" +
                        "3.Enter like Admin." +
                        "Enter number:"
        )) {
            case 1: {
                loginMenu();
                break;
            }
            case 2: {
                registrationMenu();
                break;
            }
            case 3: {
                adminMenu();
                break;
            }
            default: {
                //message.showError();
                startUserInterface();
            }
        }
    }

    private void loginMenu() {
        Response<Api.User, String> loginResult = api.authorisation(userInput.getString("Enter login:"), userInput.getString("Enter password:"));
        if (loginResult.getStatusOfOperation()) {
            //TODO: goToMainUserMenu();
        } else {
            //TODO: message.error(loginResult.getDescription());
            startUserInterface();
        }
    }

    private void registrationMenu() {
        Response<Api.NewUser, String> registrationResult = api.registration(
                userInput.getString("Enter login:"),
                userInput.getString("Enter password:"),
                userInput.getString("Enter first name:"),
                userInput.getString("Enter second name:"));
        if (registrationResult.getStatusOfOperation()) {
            //TODO: goToMainUserMenu();
        } else {
            //TODO: message.error(loginResult.getDescription());
            startUserInterface();
        }
    }

    private void adminMenu() {
        Response<Api.User, String> loginResult = api.authorisation(userInput.getString("Enter login:"), userInput.getString("Enter password:"));
        if (loginResult.getStatusOfOperation()) {
            //TODO: goToAdminMenu();
        } else {
            //TODO: message.error(loginResult.getDescription());
            startUserInterface();
        }
    }
}

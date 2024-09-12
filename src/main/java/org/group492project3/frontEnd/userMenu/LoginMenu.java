package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.dto.CurrentUser;
import org.group492project3.backEnd.dto.LoginUserResponse;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;

public class LoginMenu {
    private final Api api = new Api();
    private final UserInputService userInput = new UserInputService();
    private final MessageService message = new MessageService();
    private final DecorationService decor = new DecorationService();
    private final AdminMenu adminMenu = new AdminMenu();
    private final UserMenu userMenu = new UserMenu();

    public void startMenu() {
        decor.printDecorativeLineWithWord("LOGIN MENU");
        Response<LoginUserResponse, String> loginResult = api.authorisation(userInput.getString("Enter login:"), userInput.getString("Enter password:"));
        decor.printDecorativeLine();
        if (loginResult.getStatusOfOperation()) {
            if (loginResult.getElementOfOperation().getRole().equals("admin")) {
                adminMenu.startMenu();
            } else {
                userMenu.start(getCurrentUserInfo(loginResult.getElementOfOperation()));
            }
        } else {
            message.printErrorMessage(loginResult.getDescription());
            tryAgainMenu();
        }
    }

    private void tryAgainMenu() {
        decor.printDecoratedMenu("1.Try again.;0.Go back.", "");
        int userChoice = userInput.getInt();
        switch (userChoice) {
            case 1: {
                startMenu();
            }
            case 0: {
                break;
            }
            default: {
                message.printErrorMessage("Incorrect input. Try again.");
                tryAgainMenu();
            }
        }
    }

    private CurrentUser getCurrentUserInfo(LoginUserResponse responseData) {
        return new CurrentUser(responseData.getUserId(), responseData.getFirstName(), responseData.getSecondName());
    }
}

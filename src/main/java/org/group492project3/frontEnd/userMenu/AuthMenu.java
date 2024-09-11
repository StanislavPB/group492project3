package org.group492project3.frontEnd.userMenu;

import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;

public class AuthMenu {
    private final DecorationService decor = new DecorationService();
    private final UserInputService userInput = new UserInputService();
    private final MessageService message = new MessageService();
    private final LoginMenu login = new LoginMenu();
    private final Registration registration = new Registration();

    public void startAuthMenu() {
        startMenu();
    }

    private void startMenu() {
        decor.printDecoratedMenu("1.Login.;2.Registration.", "AUTHORIZATION MENU");
        int userChoice = userInput.getInt();
        switch (userChoice) {
            case 1: {
                login.startMenu();
                break;
            }
            case 2: {
                registration.startMenu();
                break;
            }
            default: {
                message.printErrorMessage("Incorrect input.Try again.");
                startMenu();
            }
        }
    }
}

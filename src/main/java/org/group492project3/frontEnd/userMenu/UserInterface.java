package org.group492project3.frontEnd.userMenu;

import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;

public class UserInterface {
    private final UserInputService userInput = new UserInputService();
    private final MessageService message = new MessageService();
    private final DecorationService decor = new DecorationService();

    public UserInterface() {
        startUserInterface();
    }

    private void startUserInterface() {

        switch (userInput.getInt(
                decor.getDecorativeLine() +
                        "\nEnter number of item to continue:\n" +
                        decor.getEloyText("1") + ".Login.\n" +
                        decor.getEloyText("2") + ".Registration.\n" +
                        decor.getEloyText("3") + ".Enter like Admin.\n" +
                        decor.getDecorativeLine() + "Enter number:"
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
                loginToAdminMenu();
                break;
            }
            default: {
                message.printErrorMessage("Incorrect input.Try again.");
                startUserInterface();
            }
        }
    }
}

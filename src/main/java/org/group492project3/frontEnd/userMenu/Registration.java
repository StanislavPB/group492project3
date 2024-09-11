package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.dto.LoginUserResponse;
import org.group492project3.backEnd.dto.RegistrationResponce;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;

public class Registration {
    private final DecorationService decor = new DecorationService();
    private final UserInputService userInput = new UserInputService();
    private final MessageService message = new MessageService();
    private final UserMenu userMenu = new UserMenu();
    private final Api api = new Api();

    public void startMenu() {
        decor.printDecorativeLineWithWord("REGISTRATION MENU");
        Response<RegistrationResponce, String> registrationResult = api.registration(userInput.getString("Enter login:"), userInput.getString("Enter password:"), userInput.getString("Enter first name:"), userInput.getString("Enter second name:"));
        decor.printDecorativeLine();
        if (registrationResult.getStatusOfOperation()) {
            LoginUserResponse autoLoginAfterRegistration = new LoginUserResponse(registrationResult.getElementOfOperation().getUserID(), "user", registrationResult.getElementOfOperation().getFirstName(), registrationResult.getElementOfOperation().getSecondName());
            userMenu.startMenu(autoLoginAfterRegistration);
        } else {
            message.printErrorMessage(registrationResult.getDescription());
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
}

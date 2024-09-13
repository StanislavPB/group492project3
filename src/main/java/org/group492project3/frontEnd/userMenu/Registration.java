package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.CurrentUser;
import org.group492project3.backEnd.dto.RegistrationResponce;
import org.group492project3.backEnd.dto.Response;

public class Registration {
    Container cont;
    Api api;
    private final UserMenu userMenu;

    public Registration(Container cont) {
        this.userMenu = new UserMenu(cont);
        this.api = new Api(cont);
        this.cont = cont;
    }

    public void startMenu() {
        cont.decor.printDecorativeLineWithWord("REGISTRATION MENU");
        Response<RegistrationResponce, String> registrationResult = api.registration(cont.userInput.getString("Enter login:"), cont.userInput.getString("Enter password:"), cont.userInput.getString("Enter first name:"), cont.userInput.getString("Enter second name:"));
        cont.decor.printDecorativeLine();
        if (registrationResult.getStatusOfOperation()) {
            userMenu.start(getCurrentUserInfoForAutoLogin(registrationResult.getElementOfOperation()));
        } else {
            cont.message.printErrorMessage(registrationResult.getDescription());
            tryAgainMenu();
        }
    }

    private void tryAgainMenu() {
        cont.decor.printDecoratedMenu("1.Try again.;0.Go back.", "");
        int userChoice = cont.userInput.getInt();
        switch (userChoice) {
            case 1: {
                startMenu();
            }
            case 0: {
                break;
            }
            default: {
                cont.message.printErrorMessage("Incorrect input. Try again.");
                tryAgainMenu();
            }
        }
    }

    private CurrentUser getCurrentUserInfoForAutoLogin(RegistrationResponce responseData) {
        return new CurrentUser(responseData.getUserID(), responseData.getFirstName(), responseData.getSecondName());
    }
}

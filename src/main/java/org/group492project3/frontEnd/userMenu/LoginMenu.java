package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.CurrentUser;
import org.group492project3.backEnd.dto.LoginUserResponse;
import org.group492project3.backEnd.dto.Response;

public class LoginMenu {
    Container cont;
    private final AdminMenu adminMenu;
    private final UserMenu userMenu;

    public LoginMenu(Container cont) {
        adminMenu = new AdminMenu(cont);
        userMenu = new UserMenu(cont);
        this.cont = cont;
    }

    public void startMenu() {
        cont.decor.printDecorativeLineWithWord("LOGIN MENU");
        Response<LoginUserResponse, String> loginResult = cont.api.authorisation(cont.userInput.getString("Enter login:"), cont.userInput.getString("Enter password:"));
        cont.decor.printDecorativeLine();
        if (loginResult.getStatusOfOperation()) {
            if (loginResult.getElementOfOperation().getRole().equals("admin")) {
                adminMenu.startMenu();
            } else {
                userMenu.start(getCurrentUserInfo(loginResult.getElementOfOperation()));
            }
        } else {
            cont.message.printErrorMessage(loginResult.getDescription());
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

    private CurrentUser getCurrentUserInfo(LoginUserResponse responseData) {
        return new CurrentUser(responseData.getUserId(), responseData.getFirstName(), responseData.getSecondName());
    }
}

package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Container;

public class AuthMenu {
    Container cont;
    private final LoginMenu login;
    private final Registration registration;

    public AuthMenu(Container cont) {
        this.cont = cont;
        this.login = new LoginMenu(cont);
        this.registration = new Registration(cont);
    }

    public void startAuthMenu() {
        startMenu();
    }

    private void startMenu() {
        cont.decor.printDecoratedMenu("1.Login.;2.Registration.", "AUTHORIZATION MENU");
        int userChoice = cont.userInput.getInt();

        switch (userChoice) {
            case 1: {
                login.startMenu();
                startMenu();
                break;
            }
            case 2: {
                registration.startMenu();
                startMenu();
                break;
            }
            default: {
                cont.message.printErrorMessage("Incorrect input.Try again.");
                startMenu();
            }
        }
    }
}

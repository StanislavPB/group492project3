package org.group492project3.frontEnd.userMenu;

public class UserInterface {
    private final AuthMenu authMenu = new AuthMenu();

    public UserInterface() {
        startUserInterface();
    }

    private void startUserInterface() {
        authMenu.startAuthMenu();
    }
}

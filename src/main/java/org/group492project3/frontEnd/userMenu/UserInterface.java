package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Container;

public class UserInterface {
    private final AuthMenu authMenu;

    public UserInterface(Container cont) {
        authMenu = new AuthMenu(cont);
        authMenu.startAuthMenu();
    }
}

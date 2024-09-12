package org.group492project3;

import org.group492project3.backEnd.API.Container;
import org.group492project3.frontEnd.userMenu.UserInterface;

public class Main {
    public static void main(String[] args) {
        Container cont = new Container();
        UserInterface userInterface = new UserInterface(cont);
    }
}

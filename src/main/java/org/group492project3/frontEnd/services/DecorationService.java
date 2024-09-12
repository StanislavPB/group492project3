package org.group492project3.frontEnd.services;

public class DecorationService {
    private static final String RED_COLOR_FOR_TEXT = "[0;31m";
    private static final String GREEN_COLOR_FOR_TEXT = "\033[0;32m";
    private static final String STANDARD_COLOR_FOR_TEXT = "\033[0m";
    private static final String YELLOW_COLOR_FOR_TEXT = "\033[0;33m";
    public static final String CYAN_COLOR_FOR_TEXT = "\033[0;36m";

    public void printWelcomeMessage(String firstName, String secondName) {
        System.out.println(getCyanText("***") + getGreenText("Welcome to see you ") + getEloyText(firstName + " " + secondName) + getCyanText("***"));
    }

    public String getDecorativeLine() {
        return "--------------------------------------------------";
    }

    public void printDecorativeLine() {
        System.out.println("--------------------------------------------------");
    }

    public String getDecorativeLineWithWord(String text) {
        int numberOfCustomSymbolsInTheLineInOneSide = (50 - text.length()) / 2;
        String symbolLine = "";
        for (int i = 0; i < numberOfCustomSymbolsInTheLineInOneSide; i++) {
            symbolLine += "-";
        }
        return symbolLine + YELLOW_COLOR_FOR_TEXT + text + STANDARD_COLOR_FOR_TEXT + symbolLine;
    }

    public void printDecorativeLineWithWord(String text) {
        System.out.println(getDecorativeLineWithWord(text));
    }


    public String getDecoratedUserMenu(String menuText, String menuTitle) {
        menuText = menuText.trim();
        String formatedMenu;
        if (menuTitle.isEmpty()) {
            formatedMenu = getDecorativeLine() + "\n" + "Enter number of item to continue\n";
        } else {
            formatedMenu = getDecorativeLineWithWord(menuTitle) + "\n" + "Enter number of item to continue\n";
        }
        String[] itemsOfMenu = menuText.split(";");

        for (String element : itemsOfMenu) {
            element = getRedText(String.valueOf(element.charAt(0))) + element.substring(1) + "\n";
            formatedMenu += element;
        }
        formatedMenu += getDecorativeLine() + "Enter number of item:";
        return formatedMenu;
    }

    public void printDecoratedMenu(String menuText, String menuTitle) {
        System.out.print(getDecoratedUserMenu(menuText, menuTitle));
    }

    public String getRedText(String text) {
        return (RED_COLOR_FOR_TEXT + text + STANDARD_COLOR_FOR_TEXT);
    }

    public String getGreenText(String text) {
        return (GREEN_COLOR_FOR_TEXT + text + STANDARD_COLOR_FOR_TEXT);
    }

    public String getEloyText(String text) {
        return (YELLOW_COLOR_FOR_TEXT + text + STANDARD_COLOR_FOR_TEXT);
    }

    public String getCyanText(String text) {
        return (CYAN_COLOR_FOR_TEXT + text + STANDARD_COLOR_FOR_TEXT);
    }
}

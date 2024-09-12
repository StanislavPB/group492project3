package org.group492project3.frontEnd.services;

public class MessageService {
    private DecorationService decorator = new DecorationService();

    public void printErrorMessage(String text) {
        System.out.println(
                decorator.getRedText(
                        decorator.getDecorativeLine()
                                + "\n" + text + "\n" +
                                decorator.getDecorativeLine())
        );
    }

    public void printSuccessMessage(String text) {
        System.out.println(
                decorator.getGreenText(
                        decorator.getDecorativeLine()
                                + "\n" + text + "\n" +
                                decorator.getDecorativeLine())
        );
    }
}

package org.group492project3.frontEnd.services;

public class DecorationService {
    private static final String RED_COLOR_FOR_TEXT = "[0;31m";
    private static final String GREEN_COLOR_FOR_TEXT = "\033[0;32m";
    private static final String STANDART_COLOR_FOR_TEXT = "\033[0m";

    public String getDecorativeLine() {
        return "--------------------------------------------------";
    }

    public String getDecorativeLineWithWord(String text) {
        int numberOfCustomSymbolsInTheLineInOneSide = (50 - text.length()) / 2;
        String symbolLine = "";
        for (int i = 0; i < numberOfCustomSymbolsInTheLineInOneSide; i++) {
            symbolLine += "-";
        }
        return symbolLine + text + symbolLine;
    }

    public String getRedText(String text) {
        return (RED_COLOR_FOR_TEXT + text + STANDART_COLOR_FOR_TEXT);
    }

    public String getGreenText(String text) {
        return (GREEN_COLOR_FOR_TEXT + text + STANDART_COLOR_FOR_TEXT);
    }
}

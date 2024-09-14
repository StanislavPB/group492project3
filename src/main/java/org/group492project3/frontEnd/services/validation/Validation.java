package org.group492project3.frontEnd.services.validation;

import static java.lang.Character.isDigit;

public class Validation {

    public boolean isNumbers(String str) {
        if(str.isEmpty())return false;

        for (int i = 0; i < str.length(); i++) {
            char tempChar = str.charAt(i);
            if(!isDigit(tempChar)){
                return false;
            }
        }
        return true;
    }
}

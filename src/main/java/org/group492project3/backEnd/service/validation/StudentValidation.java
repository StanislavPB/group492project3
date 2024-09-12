package org.group492project3.backEnd.service.validation;

public class StudentValidation {
    public String validate(String firstName, String lastName, String login, String password) {
        String valResult = "";
        if (firstName == null || lastName == null) {
            valResult = valResult + "name and surname can not be empty ";
        }

        if (password.length() <= 5) {
            valResult = valResult + "passwort can not have less as 6 symbole";
        }
        return valResult;
    }
}

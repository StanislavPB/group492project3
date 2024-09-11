package org.group492project3.backEnd.dto;

public class RegistrationResponce {
    private final int userID;
    private final String firstName;
    private final String secondName;

    public RegistrationResponce(int userID, String firstName, String secondName) {
        this.userID = userID;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}

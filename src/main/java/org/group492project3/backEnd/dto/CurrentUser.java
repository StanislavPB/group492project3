package org.group492project3.backEnd.dto;

public class CurrentUser {
    private final int userId;
    private final String firstName;
    private final String secondName;

    public CurrentUser(int userId, String firstName, String secondName) {
        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}

package org.group492project3.backEnd.dto;

public class LoginUserResponse {
    private final int userId;
    private final String role;
    private final String firstName;
    private final String secondName;

    public LoginUserResponse(int userId, String role, String firstName, String secondName) {
        this.userId = userId;
        this.role = role;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}

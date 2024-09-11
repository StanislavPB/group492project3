package org.group492project3.backEnd.dto;

public class NewUserRequest {
    private String login;
    private String password;
    private String firstName;
    private String secondName;

    public NewUserRequest(String login, String password, String firstName, String secondName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}

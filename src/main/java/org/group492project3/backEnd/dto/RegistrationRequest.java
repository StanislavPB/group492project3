package org.group492project3.backEnd.dto;

public class RegistrationRequest {
    private final String login;
    private final String password;
    private final String firstName;
    private final String secondName;

    public RegistrationRequest(String login, String password, String firstName, String secondName) {
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

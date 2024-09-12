package org.group492project3.backEnd.dto;

public class LoginUserRequest {
    private String login;
    private String password;

    public LoginUserRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}

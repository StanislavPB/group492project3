package org.group492project3.backEnd.dto;

public class LoginUserResponse {
    private int userId;
    //data about user

    public LoginUserResponse(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    //Finish the Login user response
}

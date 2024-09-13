package org.group492project3.backEnd.service;

import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.LoginUserResponse;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Student;

public class AuthorizationService {
    Container cont;

    public AuthorizationService(Container cont) {
        this.cont = cont;
    }

    public Response<LoginUserResponse, String> authorization(String login, String password) {
        if (isAdmin(login, password)) {
            return new Response<>(new LoginUserResponse(00, "admin", "", ""), true, "");
        } else {
            Response<Student, String> foundUser = cont.studentService.findByLogin(login);
            if (foundUser.getStatusOfOperation()) {
                Student user = foundUser.getElementOfOperation();
                return new Response<LoginUserResponse, String>(new LoginUserResponse(user.getId(), user.getRole(), user.getFirstName(), user.getLastName()), true, "");
            }
        }
        return new Response<LoginUserResponse, String>(null, false, "Incorrect login or password.");
    }

    private boolean isAdmin(String login, String password) {
        String adminLogin = "admin";
        String adminPassword = "pass";
        return adminLogin.equals(login) && adminPassword.equals(password);
    }
}

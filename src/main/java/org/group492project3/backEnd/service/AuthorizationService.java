package org.group492project3.backEnd.service;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.LoginUserResponse;
import org.group492project3.backEnd.dto.Response;

public class AuthorizationService {
    Container cont;
    Api api;

    public AuthorizationService(Container cont) {
        this.cont = cont;
        this.api = new Api(cont);
    }

    public Response<LoginUserResponse, String> authorization(String login, String password) {
        if (isAdmin(login, password)) {
            return new Response<LoginUserResponse, String>(new LoginUserResponse(00, "admin", "", ""), true, "");
        } else{
            ///api.getStudentByLogin(login)
        }
        // Response<Student,String> result = studentService.getStudentByLogin(login);
        return null;
    }

    public boolean isAdmin(String login, String password) {
        String adminLogin = "admin";
        String adminPassword = "pass";
        return adminLogin.equals(login) && adminPassword.equals(password);
    }
}

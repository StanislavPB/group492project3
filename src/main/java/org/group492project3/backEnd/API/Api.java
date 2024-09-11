package org.group492project3.backEnd.API;

import org.group492project3.backEnd.dto.LoginUserRequest;
import org.group492project3.backEnd.dto.LoginUserResponse;
import org.group492project3.backEnd.dto.NewUserRequest;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;

import java.util.ArrayList;

public class Api {

    public Response<LoginUserResponse, String> authorisation(String login, String password) {
        //new User(login, password);
        //!forTesting finish it
        if (login.equals("user") && password.equals("pass"))
            return new Response<>(new LoginUserResponse(1), true, ""); //plug
        return new Response<>(null, false, "Pass or login isn't correct."); //plug
    }

    public Response<LoginUserResponse, String> authorisationToAdminMenu(String login, String password) {
        String adminLogin = "admin";
        String passwordData = "pass";
        String role = "admin";
        //new User(login, password);
        //!forTesting finish it
        if (login.equals(adminLogin) && password.equals(passwordData) && role.equals("admin"))
            return new Response<>(null, true, ""); //plug
        return new Response<>(null, false, "Pass or login isn't correct."); //plug
    }

    public Response<NewUserRequest, String> registration(String login, String password, String firstName, String secondName) {
        // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public Response<newCourse, String> createNewCourse(String nameOfCourse) {
        // new NewCourse(nameOfCourse);
        return new Response<>(null, false, null); //plug
    }

    public Response<Course, ArrayList<String>> updateCourse(Course updatedCourse) {
        // new NewCourse(nameOfCourse);
        return new Response<>(null, false, null); //plug
    }

    public Response<String, String> editNameOfCourse() {
        // new NewCourse(nameOfCourse);
        return new Response<>(null, false, null); //plug
    }

    public Response<Course, String> findCourseByName(String nameOfCourse) {
        // new NewCourse(nameOfCourse);
        return new Response<>(null, false, null); //plug
    }

    public static class newCourse {
        private int id;
        private String nameOfCourse;

        public newCourse(String nameOfCourse) {
            this.nameOfCourse = nameOfCourse;
        }

        public String getNameOfCourse() {
            return nameOfCourse;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}

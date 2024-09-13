package org.group492project3.backEnd.API;

import org.group492project3.backEnd.dto.*;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.Student;

import java.util.List;

public class Api {
    Container cont;

    public Api(Container cont) {
        this.cont = cont;
    }

    public Response<LoginUserResponse, String> authorisation(String login, String password) {
        //new User(login, password);
        //!forTesting finish it
        if (login.equals("user") && password.equals("pass"))
            return new Response<>(new LoginUserResponse(1, "user", "Alex", "Firko"), true, ""); //plug
        return new Response<>(null, false, "Pass or login isn't correct."); //plug
    }

    public Response<RegistrationResponce, String> registration(String login, String password, String firstName, String secondName) {
        // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public Response<List<Course>, String> getCoursesList() {
        // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public Response<List<Course>, String> getMyCoursesList(int studentId) {
        // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public Response<List<Course>, String> getMyAnalytic(int studentId) {     //!  change "Course" on "Analytic"
        // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public Response<Course, String> addNewCourse(AddCourseRequest newCourse) {     //!  change "Course" on "Analytic"
        // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public Response<Student, String> getStudentByLogin(String login) {
        return null;//!!!!!
    }


    /*
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


    */
}

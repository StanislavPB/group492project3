package org.group492project3.backEnd.API;

import org.group492project3.backEnd.dto.*;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.Student;
import org.group492project3.backEnd.service.AuthorizationService;
import org.group492project3.backEnd.service.fill.FillCourse;

import java.util.List;

public class Api {
    Container cont;
    AuthorizationService authService;
    FillCourse fillCourse;

    public Api(Container cont) {
        this.cont = cont;
        fillCourse = new FillCourse(cont);
        this.authService = new AuthorizationService(cont);
    }

    public Response<LoginUserResponse, String> authorisation(String login, String password) {
        Response<LoginUserResponse, String> loginResult = authService.authorization(login, password);
        if (loginResult.getStatusOfOperation()) {
            LoginUserResponse user = loginResult.getElementOfOperation();
            if (user.getRole().equals("user")) {
                return new Response<>(user, true, "");
            } else {
                return new Response<>(user, true, "Pass or login isn't correct.");
            }
        }
        return new Response<>(null, false, loginResult.getDescription());
    }

    public Response<RegistrationResponce, String> registration(String login, String password, String firstName, String secondName) {
        // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public Response<List<Course>, String> getCoursesList() {
        Response<List<Course>, String> courseList = cont.courseService.findAllCourses();
        if (courseList.getStatusOfOperation() && courseList.getElementOfOperation() != null) {
            return new Response<>(courseList.getElementOfOperation(), true, null); //plug
        }
        return new Response<>(null, false, "Course repository is empty.");
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
    public void fillDataBaseForTesting(){
        fillCourse.fillCourseJava();
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

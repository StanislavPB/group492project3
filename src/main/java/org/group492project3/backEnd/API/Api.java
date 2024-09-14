package org.group492project3.backEnd.API;

import org.group492project3.backEnd.dto.*;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.EducationalMaterials;
import org.group492project3.backEnd.entity.Student;
import org.group492project3.backEnd.entity.TestQuestions;
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

    public Response<LoginUserResponse, String> authorisation(String login, String password) {   //! need rewrite this method
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

    public Response<List<Course>, String> getCoursesList() {  //! need rewrite this method
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

    public Response<Course, String> addNewCourse(String newCourseName) {     //!  change "Course" on "Analytic"
        return cont.courseService.addNewCourse(newCourseName);
    }

    public Response<List<Course>, String> getCourseByName(String nameOfCourse) {
        return cont.courseService.findByName(nameOfCourse);
    }

    public void deleteStudentFromCourse(Course course, Student student) {
        cont.courseService.removeStudentFromCourse(course, student);
    }

    public Response<List<EducationalMaterials>, String> getCourseMaterials(int id) {
        return cont.courseService.getEducationalMaterialsToCourse(id);
    }

    public Response<List<TestQuestions>, String> getTestQuestionsList(int id) {
        return cont.courseService.getTestQuestionsToCourse(id);
    }


    public void fillDataBaseForTesting() {
        fillCourse.fillCourseJava();
    }

    public Response<String, String> editNameOfCourse(int id, String name) {
        return cont.courseService.renameCourse(id, name);
    }

    public Response<Course, String> deleteCourse(Integer id) {
        return cont.courseService.deleteCourse(id);
    }
}

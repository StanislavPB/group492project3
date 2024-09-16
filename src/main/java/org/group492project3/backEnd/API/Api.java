package org.group492project3.backEnd.API;

import org.group492project3.backEnd.dto.*;
import org.group492project3.backEnd.entity.*;
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
        return authService.authorization(login, password);
    }

    public Response<Student, String> registration(String login, String password, String firstName, String secondName) {
        return cont.studentService.addStudent(firstName, secondName, login, password);
    }

    public Response<List<Course>, String> getCoursesList() {
        return cont.courseService.findAllCourses();
    }

    public Response<List<Course>, String> getMyCoursesList(int studentId) {
        return cont.studentService.getCourseList(studentId);
    }

    public Response<List<Course>, String> getAvailableCourseListForStudent(Student student) {
        return cont.courseService.getCoursesStudentIsNotEnrolled(student);
    }

    public Response<Course, String> addNewCourse(String newCourseName) {
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

    public void enrollInTheCourse(int studentId, int courseId) {
        Response<Course, String> course = cont.courseService.findById(courseId);
        Response<Student, String> student = cont.studentService.findById(studentId);
        cont.courseService.addNewStudentToCourse(course.getElementOfOperation(), student.getElementOfOperation());
        cont.studentService.addCourse(student.getElementOfOperation(), course.getElementOfOperation());
    }

    public Response<Course, String> deleteCourse(Integer id) {
        return cont.courseService.deleteCourse(id);
    }

    public Response<Course, String> getCourseInfo(int id) {
        return cont.courseService.findById(id);
    }

    public Student getStudentById(int id) {
        return cont.studentService.findById(id).getElementOfOperation();
    }

    public Response<List<TestResult>, String> getTestingResultForStudentCourse(int courseId, int studentId) {
        return cont.testResultService.getTestingResultsForStudentCourse(courseId, studentId);
    }

    public Response<TestResult, String> addTestResult(int courseId, int studentId, List<TestQuestions> questionsList, List<Integer> answersList) {
        return cont.testResultService.addTestResult(courseId, studentId, questionsList, answersList);
    }


    public Response<EducationalMaterials, String> addMaterials(int idOfCourse, String materialType, String materialDescription) {
        return cont.educationalMaterialsService.addMaterial(idOfCourse, materialType, materialDescription);
    }

    public void addMaterialsToCourse(Course course ,EducationalMaterials educationalMaterials) {
        cont.courseService.addEducationalMaterialsToCourse(course, educationalMaterials);
    }

    public Response<Double, String> getBestTestResultForStudentInTheCourse(Integer courseId, Integer studentId) {
        return cont.testResultService.getBestTestingResultsForStudentCourse(courseId, studentId);
    }
}

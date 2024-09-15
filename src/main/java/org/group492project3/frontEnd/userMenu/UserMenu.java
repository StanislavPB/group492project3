package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.CurrentUser;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.*;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {
    Container cont;
    Api api;
    private CurrentUser userData = null;

    public UserMenu(Container cont) {
        this.api = new Api(cont);
        this.cont = cont;
    }

    private void rememberUserDataAndWelcome(CurrentUser userData) {
        this.userData = userData;
        cont.decor.printWelcomeMessage(this.userData.getFirstName(), this.userData.getSecondName());
    }

    public void start(CurrentUser userData) {
        rememberUserDataAndWelcome(userData);
        startMenu();
    }

    private void startMenu() {
        cont.decor.printDecoratedMenu("1.Sign up for a course.;2.Get a list of my courses.;0. Log out.", "STUDENT MENU");
        int userChoice = cont.userInput.getInt();
        switch (userChoice) {
            case 1: {
                getCourseList();
                break;
            }
            case 2: {
                getMyCoursesList();
                break;
            }
            case 0: {
                exit(); //! add logic maybe with deleting user data
                break;
            }
            default: {
                cont.message.printErrorMessage("Incorrect input");
                tryAgainMenu();
                break;
            }
        }
    }

    private void getCourseList() {
        Student studentForSearching = api.getStudentById(userData.getUserId());
        boolean tryAgain = true;
        Response<List<Course>, String> response = api.getAvailableCourseListForStudent(studentForSearching);
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < response.getElementOfOperation().size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + "") + "." + response.getElementOfOperation().get(i).getName());
            }
            while (tryAgain) {
                cont.decor.printDecoratedMenu("№.Enter the course number you wish to enroll in.;0.Go to main menu.", "");
                int userChoice = cont.userInput.getInt();
                if (userChoice == 0) {
                    tryAgain = false;
                    startMenu();
                } else if (userChoice - 1 < response.getElementOfOperation().size()) {
                    api.enrollInTheCourse(userData.getUserId(), response.getElementOfOperation().get(userChoice - 1).getId());
                    startMenu();
                }
            }
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
    }

    private void getMyCoursesList() {
        Response<List<Course>, String> response = api.getMyCoursesList(userData.getUserId());
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < response.getElementOfOperation().size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + "") + "." + response.getElementOfOperation().get(i).getName());
            }
            cont.decor.printDecoratedMenu("№.Enter number of course to get information.;O.Go to maim menu.", "");
            int userChoice = cont.userInput.getInt();
            if (userChoice == 0) {
                startMenu();
            } else if (userChoice <= response.getElementOfOperation().size()) {
                Response<Course, String> selectedCourse = api.getCourseInfo(response.getElementOfOperation().get(userChoice - 1).getId());
            } else {
                cont.message.printErrorMessage("Incorrect input.Try again.");
                getMyCoursesList();
            }
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
    }

    private void courseMenu(Course currentCourse) {
        cont.decor.printDecoratedMenu("1.Materials of course.;2.Test result.;3.Start course test.;0.Go to main menu.", "COURSE MENU");
        int userChoice = cont.userInput.getInt();
        if (userChoice == 0) {
            startMenu();
        } else if (userChoice <= 3) {
            switch (userChoice) {
                case 1: {
                    getMaterialsForCurrentCourse(currentCourse);
                    break;
                }
                case 2: {
                    getTestResults(currentCourse);
                    break;
                }
                case 3: {
                    startTestForCurrentCourse(currentCourse);
                    break;
                }
            }
        } else {
            cont.message.printErrorMessage("Incorrect input.Try again.");
        }
        startMenu();
    }

    private void startTestForCurrentCourse(Course course) {
        List<TestQuestions> questionList = course.getTestQuestionsList();
        int courseId = course.getId();
        List<Integer> studentAnswers = new ArrayList<>();
        for (TestQuestions question : questionList) {
            System.out.println(question.getQuestion());
            for (int i = 1; i <= question.getAnswersMap().size(); i++) {
                System.out.println(cont.decor.getRedText(i + ".") + question.getAnswersMap().get(i));
            }
            System.out.println("Enter number of answer: ");
            studentAnswers.add(cont.userInput.getInt());
        }
        Response<TestResult, String> testResponse = api.addTestResult(courseId, userData.getUserId(), questionList, studentAnswers);
        System.out.println("The result of correct answers is " + cont.decor.getGreenText(testResponse.getElementOfOperation().getPercentOfCorrectAnswers() + "") + cont.decor.getRedText("%"));
        getTestResults(course);
    }

    private void getMaterialsForCurrentCourse(Course course) {
        List<EducationalMaterials> materials = course.getEducationalMaterialsList();
        for (EducationalMaterials element : materials) {
            System.out.println(element.getMaterialType());
        }
    }

    private void getTestResults(Course course) {
        int courseId = course.getId();
        Response<List<TestResult>, String> testResults = api.getTestingResultForStudentCourse(courseId, userData.getUserId());
        for (int i = 0; i < testResults.getElementOfOperation().size(); i++) {
            System.out.println("Testing data: " + testResults.getElementOfOperation().get(i).getDateOfTesting() + " Percent of right answers: " + testResults.getElementOfOperation().get(i).getPercentOfCorrectAnswers() + "%");
        }
        cont.decor.printDecoratedMenu("1.Try again.;0.Go to course menu.", "");
        int userChoice = cont.userInput.getInt();
        if (userChoice == 0) {

        }
    }

    private void tryAgainMenu() {
        cont.decor.printDecoratedMenu("1.Try again.;0.Go back.", "");
        int userChoice = cont.userInput.getInt();
        switch (userChoice) {
            case 1: {
                startMenu();
            }
            case 0: {
                break;
            }
            default: {
                cont.message.printErrorMessage("Incorrect input. Try again.");
                tryAgainMenu();
            }
        }
    }

    private void exit() {

    }
}

package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.CurrentUser;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.Student;

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
        startMenu(userData);
    }

    private void startMenu(CurrentUser userData) {

        cont.decor.printDecoratedMenu("1.Sign up for a course.;2.Get a list of my courses.;3.My progress analytic.;0. Log out.", "STUDENT MENU");
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
            case 3: {
                getMyProgressAnalytic();
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
        Response<List<Course>, String> listCoursesResponse = api.getAvailableCourseListForStudent(studentForSearching);
        if (listCoursesResponse.getStatusOfOperation()) {
            for (int i = 0; i < listCoursesResponse.getElementOfOperation().size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + "") + "." + listCoursesResponse.getElementOfOperation().get(i));
            }
        }
    }

    private void getMyCoursesList() {
        Response<List<Course>, String> response = api.getMyCoursesList(userData.getUserId());
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < response.getElementOfOperation().size(); i++) {
                System.out.println(i + 1 + " " + response.getElementOfOperation().get(i));
            }
            cont.decor.printDecoratedMenu("№.Enter number of course to enrol.;O.Go to maim menu.","");
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
    }
    //private void enrolStudentOnCourse.

    private void getMyProgressAnalytic() {
        Response<List<Course>, String> response = api.getMyAnalytic(userData.getUserId());
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < response.getElementOfOperation().size(); i++) {
                System.out.println(i + 1 + " " + response.getElementOfOperation().get(i));
            }
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
    }

    private void tryAgainMenu() {
        cont.decor.printDecoratedMenu("1.Try again.;0.Go back.", "");
        int userChoice = cont.userInput.getInt();
        switch (userChoice) {
            case 1: {
                startMenu(userData);
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

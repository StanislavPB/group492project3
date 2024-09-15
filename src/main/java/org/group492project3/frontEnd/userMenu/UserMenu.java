package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.CurrentUser;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;

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
        boolean tryAgain = true;
        Response<List<Course>, String> response = null;//api.getAvailableCoursListForCurrentStudent();
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < response.getElementOfOperation().size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + "") + "." + response.getElementOfOperation().get(i).getName());
            }
            while (tryAgain) {
                cont.decor.printDecoratedMenu("№.Enter the course number you wish to enroll in.;0.Go to main menu.", "");
                int userChoice = cont.userInput.getInt();
                if (userChoice == 0) {
                    tryAgain = false;
                    startMenu(userData);
                } else if (userChoice - 1 < response.getElementOfOperation().size()) {

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
                System.out.println(i + 1 + " " + response.getElementOfOperation().get(i));
            }
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
    }

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

/*



    private void userMenu() {

    }

    private void registrationMenu() {
        decor.printDecorativeLine();
        Response<NewUserRequest, String> registrationResult = api.registration(
                userInput.getString("Enter login:"),
                userInput.getString("Enter password:"),
                userInput.getString("Enter first name:"),
                userInput.getString("Enter second name:"));
        decor.printDecorativeLine();
        if (registrationResult.getStatusOfOperation()) {
            message.printSuccessMessage("User successfully added.");
            //TODO: goToMainUserMenu();
        } else {
            message.printErrorMessage(registrationResult.getDescription());
            startUserInterface();
        }
    }

    private void loginToAdminMenu() {
        Response<LoginUserResponse, String> loginResult = api.authorisationToAdminMenu(userInput.getString("Enter login:"), userInput.getString("Enter password:"));
        if (loginResult.getStatusOfOperation()) {
            goToAdminMenu();
        } else {
            message.printErrorMessage(loginResult.getDescription());
            startUserInterface();
        }
    }



    private void createNewCourseMenu() {
        Response<Api.newCourse, String> creatingResult = api.createNewCourse(userInput.getString("Enter name of course:"));
        if (creatingResult.getStatusOfOperation()) {
            message.printSuccessMessage("Course was successfully created.");
        } else {
            message.printErrorMessage(creatingResult.getDescription());
            createNewCourseMenu();
        }
    }

    //! Check it later
    private void findCourseByName() {
      /*  Response<Course, String> findingResult = api.findCourseByName(userInput.getString("Enter name of course:"));
        if (findingResult.getStatusOfOperation()) {
            editCourseNameMenu();
        } else {
            message.printErrorMessage(findingResult.getDescription());
            findCourseByName();
        }
    }

    *  Course courseAfterEditing = editCourse(findingResult.getElementOfOperation());
            Response<Course, ArrayList<String>> resultOfUpdating = api.updateCourse(courseAfterEditing);
            if (resultOfUpdating.getStatusOfOperation()) {
                message.printSuccessMessage("Course was successfully updated.");
                goToAdminMenu();
            } else {
                message.printErrorMessage(resultOfUpdating.getDescription().toString());
                findCourseByName();

    //! TODOFinish this metod


    private Course editCourse(Course courseForAdding) {
        Course oldVersionOfCourse = courseForAdding;
        editCourseNameMenu();
        return null;
    }


    private void editCourseNameMenu() {
        switch (userInput.getInt(
                decor.getDecorativeLine() +
                        "Enter number of item to continue:\n" +
                        decor.getEloyText("1") + ".Edit name of course.\n" +
                        decor.getEloyText("0") + ".Exit to Admin menu.\n" +
                        decor.getDecorativeLine() + "Enter number:"
        )) {
            case 1: {

                break;
            }
            case 0: {
                goToAdminMenu();
                break;
            }
            default: {
                message.printErrorMessage("Incorrect input.Try again.");
                goToAdminMenu();
            }
        }
    }

    private void exitFromAccount() {
        userID = 0;
        startUserInterface();
    }

    private Response<String, String> editNameOfCourse() {
    }*/
}

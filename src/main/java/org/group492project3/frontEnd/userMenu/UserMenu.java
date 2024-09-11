package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.dto.LoginUserResponse;
import org.group492project3.backEnd.dto.NewUserRequest;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.API.Api;
import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;

public class UserMenu {
    private final UserInputService userInput = new UserInputService();
    private final Api api = new Api();
    private final MessageService message = new MessageService();
    private final DecorationService decor = new DecorationService();
    private int userID = 0;

    public UserMenu() {

    }





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
        }*/
    }
    /*
    *  Course courseAfterEditing = editCourse(findingResult.getElementOfOperation());
            Response<Course, ArrayList<String>> resultOfUpdating = api.updateCourse(courseAfterEditing);
            if (resultOfUpdating.getStatusOfOperation()) {
                message.printSuccessMessage("Course was successfully updated.");
                goToAdminMenu();
            } else {
                message.printErrorMessage(resultOfUpdating.getDescription().toString());
                findCourseByName();
            }*/
    //! TODOFinish this metod
    /*

    private Course editCourse(Course courseForAdding) {
        Course oldVersionOfCourse = courseForAdding;
        editCourseNameMenu();
        return null;
    }
    */

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
/*
    private Response<String, String> editNameOfCourse() {
    }*/
}

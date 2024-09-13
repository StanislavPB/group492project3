package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.AddCourseRequest;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.service.fill.FillCourse;
import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;

import java.util.List;

public class AdminMenu {
    Api api;
    Container cont;

    public AdminMenu(Container cont) {
        this.cont = cont;
        this.api = new Api(cont);
    }

    public void startMenu() {
        welcome();
        start();
    }

    public void welcome() {
        cont.decor.printWelcomeMessage("ADMIN", "");
    }

    public void start() {
        cont.decor.printDecoratedMenu("1.Courses.;2.Find course by name.;3.Get courses list.;4.Add data for testing.;0.Exit.", "ADMIN");
        int userChoice = cont.userInput.getInt();
        switch (userChoice) {
            case 1: {
                NewCourseMenu();
                break;
            }
            case 2: {
                findCourseByName();
                break;
            }
            case 3: {
                getCoursesList();//! :TODO:
                break;
            }
            case 4: {
                addDataForTesting();//! TODO:
                break;
            }
            case 0: {
                exit();
                break;
            }
            default: {
                cont.message.printErrorMessage("Incorrect input.Try again.");
                start();
            }

        }

    }

    public void NewCourseMenu() {
        Response<Course, String> response = api.addNewCourse(new AddCourseRequest(cont.userInput.getString("Enter name of new course:")));
        if (response.getStatusOfOperation()) {
            cont.message.printSuccessMessage("New course was successfully created.");
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
        cont.decor.printDecoratedMenu("1.Try again.;0.Exit.", "");
        int userChoice = cont.userInput.getInt();
        switch (userChoice) {
            case 1: {
                NewCourseMenu();
                break;
            }
            case 0: {
                start();
                break;
            }
            default: {
                cont.message.printErrorMessage("Incorrect input");
                NewCourseMenu();
                break;
            }
        }
    }

    public void findCourseByName() {

    }

    public void getCoursesList() {
        Response<List<Course>, String> response = api.getCoursesList();
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < response.getElementOfOperation().size(); i++) {
                System.out.println(i + 1 + " " + response.getElementOfOperation().get(i));
            }
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
    }

    public void addDataForTesting() {

        FillCourse fillCourse = new FillCourse(cont);
        fillCourse.fillCourseJava();
    }

    public void exit() {

    }

    /*private void goToAdminMenu() {
        switch (userInput.getInt(
                decor.getDecorativeLineWithWord("ADMIN MENU") +
                        "\nEnter number of item to continue:\n" +
                        decor.getEloyText("1") + ".Courses.\n" +
                        decor.getEloyText("2") + ".Find course by name.\n" +
                        decor.getEloyText("3") + ".Get course list.\n" +
                        decor.getEloyText("4") + ".Add add data for testing.\n" +
                        decor.getEloyText("0") + ".Exit from Admin mode.\n" +
                        decor.getDecorativeLine() + "Enter number:"
        )) {
            case 1: {
                createNewCourseMenu();
                break;
            }
            case 2: {
                findCourseByName();
                break;
            }
            case 3: {
                //! :TODO: getCoursesList();
                break;
            }
            case 4: {
                //! TODO: addDataForTesting();
                break;
            }
            case 0: {
                startUserInterface();
                break;
            }
            default: {
                message.printErrorMessage("Incorrect input.Try again.");
                goToAdminMenu();
            }
        }
    }*/
}

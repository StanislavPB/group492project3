package org.group492project3.frontEnd.userMenu;

public class AdminMenu {
    private void goToAdminMenu() {
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
    }
}

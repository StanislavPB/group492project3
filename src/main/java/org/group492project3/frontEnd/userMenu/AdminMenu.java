package org.group492project3.frontEnd.userMenu;

import org.group492project3.backEnd.API.Api;
import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.EducationalMaterials;
import org.group492project3.backEnd.entity.Student;
import org.group492project3.backEnd.entity.TestQuestions;

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

    private void welcome() {
        cont.decor.printWelcomeMessage("ADMIN", "");
    }

    private void start() {
        cont.decor.printDecoratedMenu("1.Create course.;2.Find course by name.;3.Get courses list.;4.Add data for testing.;0.Exit.", "ADMIN");
        int userChoice = cont.userInput.getInt();
        switch (userChoice) {
            case 1: {
                newCourseMenu();
                break;
            }
            case 2: {
                findCourseByName();
                break;
            }
            case 3: {
                getCoursesList();
                break;
            }
            case 4: {
                addDataForTesting();
                break;
            }
            case 0: {
                goToAdminMenu();
                break;
            }
            default: {
                cont.message.printErrorMessage("Incorrect input.Try again.");
                start();
            }
        }
    }

    private void newCourseMenu() {
        Response<Course, String> response = api.addNewCourse(cont.userInput.getString("Enter name of new course:"));
        if (response.getStatusOfOperation()) {
            cont.message.printSuccessMessage("New course was successfully created.");
        } else {
            cont.message.printErrorMessage(response.getDescription());
            cont.decor.printDecoratedMenu("1.Try again.;0.Exit.", "");
            int userChoice = cont.userInput.getInt();
            switch (userChoice) {
                case 1: {
                    newCourseMenu();
                    break;
                }
                case 0: {
                    goToAdminMenu();
                    break;
                }
                default: {
                    cont.message.printErrorMessage("Incorrect input");
                    newCourseMenu();
                    break;
                }
            }
        }
        goToAdminMenu();
    }

    private void findCourseByName() {
        Response<List<Course>, String> requestResult = api.getCourseByName(cont.userInput.getString("Enter course name:"));
        if (requestResult.getStatusOfOperation()) {
            for (int i = 0; i < requestResult.getElementOfOperation().size(); i++) {
                System.out.println(i + 1 + "." + requestResult.getElementOfOperation().get(i).getName());
            }
        } else {
            cont.message.printErrorMessage(requestResult.getDescription());
            cont.decor.printDecoratedMenu("1.Try again.;0.Go back.", "");
            int userChoice = cont.userInput.getInt();
            if (userChoice == 0) {
                goToAdminMenu();
            } else if (userChoice == 1) {
                findCourseByName();
            } else {
                goToAdminMenu();//!!!!!add
            }
        }
        cont.decor.printDecoratedMenu(" Enter number of course for editing.;0.Go to admin menu.", "");
        int userChoice = cont.userInput.getInt();
        if (userChoice == 0) {
            goToAdminMenu();
        } else if (userChoice - 1 < requestResult.getElementOfOperation().size()) {
            courseMenu(requestResult.getElementOfOperation().get(userChoice - 1));
        } else {
            cont.message.printErrorMessage("Incorrect input.");
        }
        findCourseByName();
    }
    //! change

    private void getCoursesList() {
        Response<List<Course>, String> requestResult = api.getCoursesList();
        if (requestResult.getStatusOfOperation()) {
            for (int i = 0; i < requestResult.getElementOfOperation().size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + "") + "." + requestResult.getElementOfOperation().get(i).getName());
            }
        } else {
            cont.message.printErrorMessage(requestResult.getDescription());
        }
        cont.decor.printDecoratedMenu("№.Enter number of course for editing.;0.Go to admin menu.", "");
        int userChoice = cont.userInput.getInt();
        if (userChoice == 0) {
            goToAdminMenu();
        } else if (userChoice <= requestResult.getElementOfOperation().size()) {
            courseMenu(requestResult.getElementOfOperation().get(userChoice - 1));
        } else {
            cont.message.printErrorMessage("Incorrect input.");
        }
        getCoursesList();
    }

    private void courseMenu(Course course) {
        cont.decor.printDecoratedMenu("1.List of course students.;2.Show course materials.;3.Show test list for course.;4.Edit name of course.;5.Delete this course.;0.Go back.;00.Go to admin menu.", "COURSE MENU");
        String userChoice = cont.userInput.getString();
        switch (userChoice) {
            case "1": {
                courseStudentList(course);
                break;
            }
            case "2": {
                showCourseMaterials(course);
                break;
            }
            case "3": {
                showTestListForCourse(course);
                break;
            }
            case "4": {
                editNameOfTheCourse(course);
                break;
            }
            case "5": {
                deleteThisCourse(course);
                break;
            }
            case "0": {
                goToAdminMenu();
                break;
            }

            default: {
                cont.message.printErrorMessage("Incorrect input");
                newCourseMenu();
                break;
            }
        }
    }

    private void deleteThisCourse(Course course) {
        Response<Course, String> deletingResponse = api.deleteCourse(course.getId());
        if (deletingResponse.getStatusOfOperation()) {
            cont.message.printSuccessMessage("Course was successfully deleted.");
        } else {
            cont.message.printErrorMessage(deletingResponse.getDescription());
        }
        goToAdminMenu();
    }

    private void editNameOfTheCourse(Course course) {
        Response<String, String> responseResult = api.editNameOfCourse(course.getId(), cont.userInput.getString("Enter new name for this course:"));
        if (responseResult.getStatusOfOperation()) {
            cont.message.printSuccessMessage("Name was successfully changed.");
        } else {
            cont.message.printErrorMessage(responseResult.getDescription());
        }
        courseMenu(course);
    }

    private void showTestListForCourse(Course course) {
        Response<List<TestQuestions>, String> response = api.getTestQuestionsList(course.getId());
        List<TestQuestions> testQuestions = response.getElementOfOperation();
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < testQuestions.size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + ".") + testQuestions.get(i));
            }
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
        courseMenu(course);
    }

    private void showCourseMaterials(Course course) {
        Response<List<EducationalMaterials>, String> response = api.getCourseMaterials(course.getId());
        List<EducationalMaterials> educationalMaterials = response.getElementOfOperation();
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < educationalMaterials.size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + ".") + educationalMaterials.get(i));
            }
        } else {
            cont.message.printErrorMessage(response.getDescription());
        }
        courseMenu(course);
    }

    private void courseStudentList(Course course) {
        List<Student> studentsFromCourse = course.getStudentList();
        boolean exit = true;
        if (!studentsFromCourse.isEmpty()) {
            while (exit) {
                for (int i = 0; i < studentsFromCourse.size(); i++) {
                    System.out.println(cont.decor.getRedText(i + 1 + "") + "." + studentsFromCourse.get(i).getFirstName() + " " + studentsFromCourse.get(i).getLastName());
                }
                cont.decor.printDecoratedMenu("№.Enter student number for deleting.;0.Go back", "");
                int userChoice = cont.userInput.getInt();
                if (userChoice == 0) {
                    exit = false;
                    courseMenu(course);
                } else if (userChoice <= studentsFromCourse.size()) {
                    api.deleteStudentFromCourse(course, studentsFromCourse.get(userChoice - 1));
                } else {
                    cont.message.printErrorMessage("Incorrect input.");
                }
            }
        } else {
            cont.message.printErrorMessage("This course has no students.");
        }
        courseMenu(course);
    }

    private void addDataForTesting() {
        api.fillDataBaseForTesting();
        cont.message.printSuccessMessage("Data has been added to the repository successfully.");
        goToAdminMenu();
    }

    private void editCourseMenu(int numberOfCourse) {

    }

    public void goToAdminMenu() {
        start();
    }
}

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
        boolean running = true;
        while (running) {
            cont.decor.printDecoratedMenu("1.Create course.;2.Find course by name.;3.Get courses list.;4.Add data for testing.;0.Exit.", "ADMIN");
            switch (cont.userInput.getInt()) {
                case 1 -> newCourseMenu();
                case 2 -> findCourseByName();
                case 3 -> getCoursesList();
                case 4 -> addDataForTesting();
                case 0 -> running = false;
                default -> error("Incorrect input. Try again.");
            }
        }
    }

    private void newCourseMenu() {
        Response<Course, String> response = api.addNewCourse(cont.userInput.getString("Enter name of new course:"));
        if (response.getStatusOfOperation()) {
            cont.message.printSuccessMessage("New course was successfully created.");
        } else {
            error(response.getDescription());
            cont.decor.printDecoratedMenu("1.Try again.;0.Exit.", "");
            switch (cont.userInput.getInt()) {
                case 1 -> newCourseMenu();
                case 0 -> {
                    break;
                }
                default -> error("Incorrect input");
            }
        }
    }

    private void findCourseByName() {
        boolean tryAgain = true;
        boolean tryAgain1 = true;
        Response<List<Course>, String> requestResult = api.getCourseByName(cont.userInput.getString("Enter course name:"));
        if (requestResult.getStatusOfOperation()) {
            for (int i = 0; i < requestResult.getElementOfOperation().size(); i++) {
                System.out.println(i + 1 + "." + requestResult.getElementOfOperation().get(i).getName());
            }
        } else {
            error(requestResult.getDescription());
            while (tryAgain) {
                cont.decor.printDecoratedMenu("1.Try again.;0.Go back.", "");
                int userChoice = cont.userInput.getInt();
                if (userChoice == 0) {
                    tryAgain = false;
                    tryAgain1 = false;
                } else if (userChoice == 1) {
                    findCourseByName();
                } else {
                    error("Incorrect input.");
                }
            }
            while (tryAgain1) {
                cont.decor.printDecoratedMenu(" Enter number of course for editing.;0.Go to admin menu.", "");
                int userChoice = cont.userInput.getInt();
                if (userChoice == 0) {
                    tryAgain1 = false;
                } else if (userChoice - 1 < requestResult.getElementOfOperation().size()) {
                    tryAgain1 = false;
                    courseMenu(requestResult.getElementOfOperation().get(userChoice - 1));
                } else {
                    error("Incorrect input.");
                }
            }
        }
    }

    private void getCoursesList() {
        Response<List<Course>, String> requestResult = api.getCoursesList();
        if (requestResult.getStatusOfOperation()) {
            for (int i = 0; i < requestResult.getElementOfOperation().size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + "") + "." + requestResult.getElementOfOperation().get(i).getName());
            }
        } else {
            error(requestResult.getDescription());
        }
        boolean tryAgain = true;
        while (tryAgain) {
            cont.decor.printDecoratedMenu("№.Enter number of course for editing.;0.Go to admin menu.", "");
            int userChoice = cont.userInput.getInt();
            if (userChoice == 0) {
                tryAgain = false;
            } else if (userChoice <= requestResult.getElementOfOperation().size()) {
                courseMenu(requestResult.getElementOfOperation().get(userChoice - 1));
                tryAgain = false;
            } else {
                error("Incorrect input.");
            }
        }
    }

    private void courseMenu(Course course) {
        cont.decor.printDecoratedMenu("1.List of course students.;2.Show course materials.;3.Add course materials.;4.Show test list for course.;5.Edit name of course.;6.Delete this course.;0.Go back.", "COURSE MENU");
        switch (cont.userInput.getInt()) {
            case 1 -> courseStudentList(course);
            case 2 -> showCourseMaterials(course);
            case 3 -> addMaterials(course);
            case 4 -> showTestListForCourse(course);
            case 5 -> editNameOfTheCourse(course);
            case 6 -> deleteThisCourse(course);
            case 0 -> {
                break;
            }
            default -> {
                error("Incorrect input. Try again.");
            }
        }
    }

    private void addMaterials(Course course) {
        Response<EducationalMaterials, String> responce = api.addMaterials(course.getId(), cont.userInput.getString("Enter type of materials:"), cont.userInput.getString("Enter materials description:"));
        if (responce.getStatusOfOperation()) {
            cont.message.printSuccessMessage("Materias were successfully added.");
        } else {
            cont.message.printSuccessMessage(responce.getDescription());
        }
        courseMenu(course);
    }

    private void deleteThisCourse(Course course) {
        Response<Course, String> deletingResponse = api.deleteCourse(course.getId());
        if (deletingResponse.getStatusOfOperation()) {
            cont.message.printSuccessMessage("Course was successfully deleted.");
        } else {
            error(deletingResponse.getDescription());
        }
    }

    private void editNameOfTheCourse(Course course) {
        Response<String, String> responseResult = api.editNameOfCourse(course.getId(), cont.userInput.getString("Enter new name for this course:"));
        if (responseResult.getStatusOfOperation()) {
            cont.message.printSuccessMessage("Name was successfully changed.");
        } else {
            error(responseResult.getDescription());
        }
        courseMenu(course);
    }

    private void showTestListForCourse(Course course) {
        Response<List<TestQuestions>, String> response = api.getTestQuestionsList(course.getId());
        List<TestQuestions> testQuestions = response.getElementOfOperation();
        if (response.getStatusOfOperation()) {
            for (int i = 0; i < testQuestions.size(); i++) {
                System.out.println(cont.decor.getRedText(i + 1 + ".") + testQuestions.get(i).getQuestion());
            }
        } else {
            error(response.getDescription());
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
            error(response.getDescription());
        }
        courseMenu(course);
    }

    private void courseStudentList(Course course) {
        List<Student> studentsFromCourse = course.getStudentList();
        boolean exit = true;
        if (!studentsFromCourse.isEmpty()) {
            while (exit) {
                for (int i = 0; i < studentsFromCourse.size(); i++) {
                    Response<Double, String> bestTestResult = api.getBestTestResultForStudentInTheCourse(course.getId(), studentsFromCourse.get(i).getId());
                    if (bestTestResult.getStatusOfOperation()) {
                        System.out.println(cont.decor.getRedText(i + 1 + "") + "." + studentsFromCourse.get(i).getFirstName() + " " + studentsFromCourse.get(i).getLastName() + " " + cont.decor.getGreenText(bestTestResult.getElementOfOperation() + "") + cont.decor.getRedText("%"));
                    } else {
                        System.out.println(cont.decor.getRedText(i + 1 + "") + "." + studentsFromCourse.get(i).getFirstName() + " " + studentsFromCourse.get(i).getLastName() + " " + cont.decor.getRedText(bestTestResult.getDescription()));
                    }

                }
                cont.decor.printDecoratedMenu("№.Enter student number for deleting.;0.Go back", "");
                int userChoice = cont.userInput.getInt();
                if (userChoice == 0) {
                    exit = false;
                } else if (userChoice <= studentsFromCourse.size()) {
                    api.deleteStudentFromCourse(course, studentsFromCourse.get(userChoice - 1));
                } else {
                    error("Incorrect input.");
                }
            }
        } else {
            error("This course has no students.");
        }
        courseMenu(course);
    }

    private void addDataForTesting() {
        api.fillDataBaseForTesting();
        error("Data has been added to the repository successfully.");
    }

    private void error(String errorText) {
        cont.message.printSuccessMessage(errorText);
    }

}

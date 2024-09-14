package org.group492project3.backEnd.repository;

import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.EducationalMaterials;
import org.group492project3.backEnd.entity.Student;
import org.group492project3.backEnd.entity.TestQuestions;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private final List<Course> databaseCourse = new ArrayList<>();

    public Course addCourse(String nameCourse) {
        Course courseForSave = new Course((databaseCourse.size() + 1), nameCourse);
        databaseCourse.add(courseForSave);
        return courseForSave;
    }

    public List<Course> findAllCourses() {
        return databaseCourse;
    }

    public Course findById(Integer id) {

        return databaseCourse.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Course> findByName(String name) {

        return databaseCourse.stream()
                .filter(course -> course.getName().equals(name))
                .toList();
    }

    public Course deleteCourse(Course courseForDelete) {
        databaseCourse.remove(courseForDelete);
        return courseForDelete;
    }

    //Изменяет только поле "name"
    public Course updateCourse(Course courseForUpdate) {
        courseForUpdate.setName(courseForUpdate.getName());
        return courseForUpdate;
    }

    //---------------------------------------   EducationalMaterials ------------------------------------
    //добавление EducationalMaterials к курсу
    public void addEducationalMaterialsToCourse(Course course, EducationalMaterials educationalMaterials) {
        course.addEducationalMaterialsToList(educationalMaterials);
    }

    //удаление EducationalMaterials из курса
    public void removeEducationalMaterialsFromCourse(Course course, EducationalMaterials educationalMaterials) {
        course.removeEducationalMaterialsFromList(educationalMaterials);
    }

    //полное обновление всех EducationalMaterials LIST в курсе
    public void setEducationalMaterialsToCourse(Course course, List<EducationalMaterials> educationalMaterialsList) {
        course.setNewEducationalMaterialsList(educationalMaterialsList);
    }

    //полное удаление EducationalMaterials LIST в курсе
    public void deleteEducationalMaterialsList(Course course) {
        course.deleteEducationalMaterialsList();
    }

    //---------------------------------------   Student ------------------------------------
    //добавление студента к курсу
    public void addNewStudentToCourse(Course course, Student student) {
        course.addStudentToList(student);
    }

    //удаление студента из курса
    public void removeStudentFromCourse(Course course, Student student) {
        course.removeStudentFromList(student);
    }

    //полное обновление всех Student LIST в курсе
    public void setNewStudentList(Course course, List<Student> studentList) {
        course.setNewStudentList(studentList);
    }

    //полное удаление Student LIST в курсе
    public void deleteStudentList(Course course) {
        course.deleteStudentList();
    }

    //---------------------------------------   TestQuestions ------------------------------------
    //добавление TestQuestions к курсу
    public void addTestQuestionsToCourse(Course course, TestQuestions testQuestions) {
        course.addTestQuestionsToList(testQuestions);
    }

    //удаление TestQuestions из курса
    public void removeTestQuestionsFromCourse(Course course, TestQuestions testQuestions) {
        course.removeTestQuestionsFromList(testQuestions);
    }

    //полное обновление всех TestQuestions LIST в курсе
    public void setNewTestQuestionsList(Course course, List<TestQuestions> testQuestionsList) {
        course.setNewTestQuestionsList(testQuestionsList);
    }

    //полное удаление TestQuestions LIST в курсе
    public void deleteTestQuestionsList(Course course) {
        course.deleteTestQuestionsList();
    }

}

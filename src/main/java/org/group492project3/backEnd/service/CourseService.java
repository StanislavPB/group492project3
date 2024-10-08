package org.group492project3.backEnd.service;

import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.EducationalMaterials;
import org.group492project3.backEnd.entity.Student;
import org.group492project3.backEnd.entity.TestQuestions;
import org.group492project3.backEnd.repository.CourseRepository;
import org.group492project3.backEnd.service.validation.CourseValidation;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private CourseRepository repository;
    private CourseValidation validation;

    public CourseService(CourseRepository repository, CourseValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public Response<Course, String> addNewCourse(String courseName) {

        String validationResult = validation.validateCourseName(courseName, repository.findAllCourses());

        if (!validationResult.isEmpty()) {
            return new Response<>(null, false, validationResult);
        }

        Course savedCourse = repository.addCourse(courseName);

        return new Response<>(savedCourse, true, "");
    }


    public Response<Course, String> updateCourse(Integer id, String courseName) {

        Course courseForUpdate = repository.findById(id);

        if (courseForUpdate == null) {
            return new Response<>(null, false, "Course with id = " + id + " not found.");
        }

        Course courseAfterUpdate = repository.updateCourse(courseForUpdate);

        return new Response<>(courseAfterUpdate, true, "");
    }

    public Response<Course, String> deleteCourse(Integer id) {
        Course courseForDelete = repository.findById(id);

        if (courseForDelete == null) {
            return new Response<>(null, false, "Course with id = " + id + " not found. Removal is not possible.");
        }

        courseForDelete = repository.deleteCourse(courseForDelete);

        return new Response<>(courseForDelete, true, "");
    }

    public Response<Course, String> findById(Integer id) {
        Course foundCourse = repository.findById(id);

        if (foundCourse == null) {
            return new Response<>(null, false, "Course with id = " + id + " not found.");
        } else {
            return new Response<>(foundCourse, true, "");
        }
    }

    public Response<List<Course>, String> findByName(String name) {

        List<Course> foundCourses = repository.findByName(name);

        if (foundCourses.isEmpty()) {
            return new Response<>(foundCourses, false, "Courses with name = " + name + " not founded.");
        } else {
            return new Response<>(foundCourses, true, "");
        }
    }

    public Response<List<Course>, String> findAllCourses() {

        List<Course> foundCourses = repository.findAllCourses();
        if (foundCourses.isEmpty()) {
            return new Response<>(foundCourses, false, "Courses not founded. Course Database is empty.");
        } else {
            return new Response<>(foundCourses, true, "");
        }

    }

    public Response<String, String> renameCourse(Integer id, String name) {

        String validationResult = validation.validateCourseName(name, repository.findAllCourses());
        if (!validationResult.isEmpty()) {
            return new Response<>(null, false, validationResult);
        }

        Response<Course, String> foundCourse = findById(id);
       if (foundCourse.getStatusOfOperation()) {
            foundCourse.getElementOfOperation().setName(name);
            return new Response<>(null, true, "");
        }

        return new Response<>(foundCourse.getElementOfOperation().getName(), false, "Course with id=" + id + " didn't find.");
    }

    public Response<List<Course>, String> getCoursesStudentIsNotEnrolled(Student student){
        List<Course> allCourses = repository.findAllCourses();

        if(!allCourses.isEmpty()){
            List<Course> coursesForStudent = new ArrayList<>();
            for (int i = 0; i < allCourses.size(); i++) {

                Course tempCourse = allCourses.get(i);
                boolean isCourse = false;
                List<Student> studentsList = tempCourse.getStudentList();
                if(!studentsList.isEmpty()){
                    for (int j = 0; j < studentsList.size(); j++) {
                        if(studentsList.get(j).equals(student)){
                            isCourse = true;
                        }
                    }
                    if(!isCourse){
                        coursesForStudent.add(tempCourse);
                    }
                }else{
                    coursesForStudent.add(tempCourse);
                }
            }
            if(coursesForStudent.isEmpty()){
                return new Response<>(null, false, "There are no courses at DB that you can enroll in.");
            }
            return new Response<>(coursesForStudent, true, "");
        }else{
            return new Response<>(null, false, "There are no courses at DB that you can enroll in.");
        }




    }

    //---------------------------------------   EducationalMaterials ------------------------------------
    public Response<List<EducationalMaterials>, String> getEducationalMaterialsToCourse(Integer id) {
        List<EducationalMaterials> foundEducationMaterials = findById(id).getElementOfOperation().getEducationalMaterialsList();
        if (foundEducationMaterials.isEmpty()) {
            return new Response<>(null, false, "Materials for this course are empty.");
        }
        return new Response<>(foundEducationMaterials, true, "");
    }

    //добавление EducationalMaterials к курсу
    public void addEducationalMaterialsToCourse(Course course, EducationalMaterials educationalMaterials) {
        repository.addEducationalMaterialsToCourse(course, educationalMaterials);
    }

    //удаление EducationalMaterials из курса
    public void removeEducationalMaterialsFromCourse(Course course, EducationalMaterials educationalMaterials) {
        repository.removeEducationalMaterialsFromCourse(course, educationalMaterials);
    }

    //полное обновление всех EducationalMaterials LIST в курсе
    public void setEducationalMaterialsToCourse(Course course, List<EducationalMaterials> educationalMaterialsList) {
        repository.setEducationalMaterialsToCourse(course, educationalMaterialsList);
    }

    //полное удаление EducationalMaterials LIST в курсе
    public void deleteEducationalMaterialsList(Course course) {
        repository.deleteEducationalMaterialsList(course);
    }

    //---------------------------------------   Student ------------------------------------
    //добавление студента к курсу
    public void addNewStudentToCourse(Course course, Student student) {
        repository.addNewStudentToCourse(course, student);
    }

    //удаление студента из курса
    public void removeStudentFromCourse(Course course, Student student) {
        repository.removeStudentFromCourse(course, student);
    }

    //полное обновление всех Student LIST в курсе
    public void setNewStudentList(Course course, List<Student> studentList) {
        repository.setNewStudentList(course, studentList);
    }

    //полное удаление Student LIST в курсе
    public void deleteStudentList(Course course) {
        repository.deleteStudentList(course);
    }

    //---------------------------------------   TestQuestions ------------------------------------
    public Response<List<TestQuestions>, String> getTestQuestionsToCourse(int id) {//! Firko
        List<TestQuestions> foundTestQuestions = repository.findById(id).getTestQuestionsList();
        if (foundTestQuestions.isEmpty()) {
            return new Response<>(null, false, "Materials for this course are empty.");
        }
        return new Response<>(foundTestQuestions, true, "");
    }

    //добавление TestQuestions к курсу
    public void addTestQuestionsToCourse(Course course, TestQuestions testQuestions) {
        repository.addTestQuestionsToCourse(course, testQuestions);
    }

    //удаление TestQuestions из курса
    public void removeTestQuestionsFromCourse(Course course, TestQuestions testQuestions) {
        repository.removeTestQuestionsFromCourse(course, testQuestions);
    }

    //полное обновление всех TestQuestions LIST в курсе
    public void setNewTestQuestionsList(Course course, List<TestQuestions> testQuestionsList) {
        repository.setNewTestQuestionsList(course, testQuestionsList);
    }

    //полное удаление TestQuestions LIST в курсе
    public void deleteTestQuestionsList(Course course) {
        repository.deleteTestQuestionsList(course);
    }


}

package org.group492project3.backEnd.repository;

import org.group492project3.backEnd.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private List<Course> databaseCourse = new ArrayList<>();
    private Integer idCourse = 0;

    public Course addCourse(String nameCourse) {
        idCourse++;
        Course courseForSave = new Course(idCourse,nameCourse);
        databaseCourse.add(courseForSave);
        return courseForSave;
    }

    public List<Course> findAllCourses() {
        return databaseCourse;
    }

    public Course findById(Integer id) {

        return databaseCourse.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Course> findByName(String name) {

        return databaseCourse.stream()
                .filter(note -> note.getName().equals(name))
                .toList();
    }

    //Изменяет только поле "name"
    public Course updateNote(Course courseForUpdate) {

        courseForUpdate.setName(courseForUpdate.getName());

        return courseForUpdate;
    }

    //добавление EducationalMaterials

    //добавление студента к курсу VOID!!!!
    public void setNewStudent(Course course, Student student){
        course.addStudentList(student);
    }
    public void removeStudentFromCourse(Course course, Student student){
        course.removeStudent(student);
    }

    //добавление TestQuestions






}

package org.group492project3.backEnd.repository;

import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudRepository {

    private List<Student> studentBase = new ArrayList<>();

    public StudRepository() {//! DELETE AFTER TESTING
        studentBase.add(new Student(1, "lalala@mail.com ", " pass11 ", " Mamkin ", " Animeshnik "));
    }

    public Student add(String login, String password, String firstName, String lastName) {
        Student newStudent = new Student((studentBase.size() + 1), login, password, firstName, lastName);
        studentBase.add(newStudent);
        return newStudent;
    }

    public Student update(Student updStudent, String updLogin, String updPassword) {
        updStudent.setLogin(updLogin);
        updStudent.setPassword(updPassword);
        return updStudent;
    }

    public Student deleteStudent(Student stForDelete) {
        studentBase.remove(stForDelete);
        return stForDelete;
    }

    public List<Student> getAllStudent() {
        return studentBase;
    }

    public Student findById(Integer id) {
        for (Student student : studentBase) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }


    public Student findByLogin(String login) {
        return studentBase.stream()
                .filter(course -> course.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    public List<Course> getCourseList(Student student){
        return student.getCourseList();
    }

    public void addCourse(Student student, Course newCourse) {
        student.addCourse(newCourse);
    }

    public void removeCourse(Student student, Course course) {
        student.removeCourse(course);
    }

}







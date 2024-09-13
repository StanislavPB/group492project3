package org.group492project3.backEnd.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private List<Course> courseList;

    public Student(Integer id, String login, String password, String firstName, String lastName) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        role = "user";
        courseList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public String getRole() {
        return role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //---------------------------  Course
    public void addCourse(Course newCourse) {
        courseList.add(newCourse);
    }

    public void removeCourse(Course course) {
        courseList.remove(course);
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }
}


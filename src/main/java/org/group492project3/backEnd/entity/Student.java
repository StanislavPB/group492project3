package org.group492project3.backEnd.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private List<Course> courseList;

    public Student(Integer id, String login, String password, String firstName, String lastName) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


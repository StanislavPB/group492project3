package org.group492project3.backEnd.dto;

public class AddCourseRequest {
    private String courseName;

    public AddCourseRequest(String courseName) {
        this.courseName = courseName;
    }

    public String getCouseName() {
        return courseName;
    }
}

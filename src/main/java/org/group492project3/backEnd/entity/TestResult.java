package org.group492project3.backEnd.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestResult {

    private Integer testResultID;
    private Integer idOfCourse;
    private Integer studentID;
    private Integer dateOfTesting;
    private Integer amountOfQuestions;
    private Integer amountOfRightAnswers;


    public TestResult(Integer studentID, Integer idOfCourse) {
        this.studentID = studentID;
        this.idOfCourse = idOfCourse;
    }


    public Integer getIdOfCourse() {
        return idOfCourse;
    }

    public Integer getAmountOfQuestions() {
        return amountOfQuestions;
    }

    public Integer getAmountOfRightAnswers() {
        return amountOfRightAnswers;
    }

    public Integer getStudentID() {
        return studentID;
    }


    public Integer getTestResultID() {
        return testResultID;
    }


    public void setDateOfTesting(Integer dateOfTesting) {
        this.dateOfTesting = dateOfTesting;
    }

    public Integer getDateOfTesting() {
        return dateOfTesting;
    }


    public void setAmountOfQuestions(Integer amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    public void setTestResultID(Integer testResultID) {
        this.testResultID = testResultID;
    }

    public void setAmountOfRightAnswers(Integer amountOfRightAnswers) {
        this.amountOfRightAnswers = amountOfRightAnswers;
    }

}

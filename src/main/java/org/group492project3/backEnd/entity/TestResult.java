package org.group492project3.backEnd.entity;

import java.time.LocalDate;

public class TestResult {

    private Integer id;
    private Integer idCourse;
    private Integer idStudent;
    private LocalDate dateOfTesting;
    private Integer amountOfQuestions;
    private Integer amountOfRightAnswers;
    private Double percentOfCorrectAnswers;

    public TestResult(Integer id, Integer idCourse, Integer idStudent, Integer amountOfQuestions, Integer amountOfRightAnswers, Double percentOfCorrectAnswers) {
        this.id = id;
        this.idCourse = idCourse;
        this.idStudent = idStudent;
        this.dateOfTesting = LocalDate.now();
        this.amountOfQuestions = amountOfQuestions;
        this.amountOfRightAnswers = amountOfRightAnswers;
        this.percentOfCorrectAnswers = percentOfCorrectAnswers;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public LocalDate getDateOfTesting() {
        return dateOfTesting;
    }

    public Integer getAmountOfQuestions() {
        return amountOfQuestions;
    }

    public Integer getAmountOfRightAnswers() {
        return amountOfRightAnswers;
    }

    public Double getPercentOfCorrectAnswers() {
        return percentOfCorrectAnswers;
    }
}

package org.group492project3.backEnd.entity;

import java.util.Map;

public class TestQuestions {

    private Integer id;
    private Integer idCourse;
    private String question;
    private Map<Integer, String> answersMap;
    private Integer correctAnswer;

    public TestQuestions(Integer id, Integer idCourse, String question, Map<Integer, String> answersMap, Integer correctAnswer) {
        this.id = id;
        this.idCourse = idCourse;
        this.question = question;
        this.answersMap = answersMap;
        this.correctAnswer = correctAnswer;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public String getQuestion() {
        return question;
    }

    public Map<Integer, String> getAnswersMap() {
        return answersMap;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "TestQuestions{" +
                "id=" + id +
                ", idCourse=" + idCourse +
                ", question='" + question + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}

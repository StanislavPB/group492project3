package org.group492project3.backEnd.repository;

import org.group492project3.backEnd.entity.TestQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestQuestionsRepository {
    private final List<TestQuestions> databaseTestQuestions = new ArrayList<>();
    private Integer idTestQuestions = 0;

    public TestQuestions addTestQuestions(Integer idCourse, String question, Map<Integer, String> answersMap, Integer correctAnswer) {
        idTestQuestions = databaseTestQuestions.size() + 1;

        TestQuestions testQuestionsForSave = new TestQuestions(idTestQuestions, idCourse, question, answersMap, correctAnswer);

        databaseTestQuestions.add(testQuestionsForSave);

        return testQuestionsForSave;
    }

    public List<TestQuestions> getTestQuestionsFromCourse(Integer idCourse) {

        return databaseTestQuestions.stream()
                .filter(testQ -> testQ.getIdCourse().equals(idCourse))
                .toList();

    }

    public List<TestQuestions> getAllTestQuestions() {
        return databaseTestQuestions;
    }


}

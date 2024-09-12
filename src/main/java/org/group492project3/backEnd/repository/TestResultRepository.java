package org.group492project3.backEnd.repository;

import org.group492project3.backEnd.entity.TestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultRepository {

    public List <TestResult> databaseTestResults = new ArrayList<>();
    private Integer resultsGetID = 0;


    public TestResult addTestResult(Integer idCourse, Integer idStudent, Integer amountOfQuestions, Integer amountOfRightAnswers){
        resultsGetID = databaseTestResults.size()+1;

        Double percentOfCorrectAnswers = amountOfRightAnswers * 100.0 / amountOfQuestions;

        TestResult testResultForSave = new TestResult(resultsGetID, idCourse, idStudent, amountOfQuestions, amountOfRightAnswers, percentOfCorrectAnswers);
        databaseTestResults.add(testResultForSave);
        return testResultForSave;
    }

    public List<TestResult> getTestingResultsForStudentCourse(Integer idCourse, Integer idStudent){

        return databaseTestResults.stream()
                .filter(testResult -> testResult.getIdCourse().equals(idCourse) && testResult.getIdStudent().equals(idStudent))
                .toList();
    }


}





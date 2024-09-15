package org.group492project3.backEnd.service;

import org.group492project3.backEnd.dto.Response;

import org.group492project3.backEnd.entity.TestQuestions;
import org.group492project3.backEnd.entity.TestResult;
import org.group492project3.backEnd.repository.TestResultRepository;

import java.util.List;
import java.util.Objects;

public class TestResultService {

    private final TestResultRepository testResultRepository;

    public TestResultService(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    public Response<TestResult,String> addTestResult(Integer idCourse, Integer idStudent, Integer amountOfQuestions, Integer amountOfRightAnswers){

        TestResult testResult = testResultRepository.addTestResult(idCourse, idStudent, amountOfQuestions, amountOfRightAnswers);

        if(testResult == null){
            return new Response<>(null, false, "No test results available.");
        }
        return new Response<>(testResult, true,"");
    }

    public Response<TestResult,String> addTestResult(Integer idCourse, Integer idStudent, List<TestQuestions> testQuestionsList, List<Integer> studentAnswers){

        if(testQuestionsList.isEmpty()){
            return new Response<>(null, false, "Test sheet is empty.");
        } else if (studentAnswers.isEmpty()) {
            return new Response<>(null, false, "No student answers to tests.");
        }
        Integer amountOfQuestion = testQuestionsList.size();

        Integer amountOfRightAnswers = 0;
        for (int i = 0; i < testQuestionsList.size(); i++) {
            if(Objects.equals(testQuestionsList.get(i).getCorrectAnswer(), studentAnswers.get(i))){
                amountOfRightAnswers++;
            }
        }
        return addTestResult(idCourse, idStudent, amountOfQuestion, amountOfRightAnswers);
    }


    public Response<List<TestResult>,String> getTestingResultsForStudentCourse(Integer idCourse, Integer idStudent){

        List<TestResult> testResultList = testResultRepository.getTestingResultsForStudentCourse(idCourse, idStudent);

        if(testResultList.isEmpty()){
            return new Response<>(null, false, "No test results available.");
        }
        return new Response<>(testResultList, true,"");
    }


}

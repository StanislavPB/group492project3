package org.group492project3.backEnd.service;

import org.group492project3.backEnd.dto.Response;

import org.group492project3.backEnd.entity.TestResult;
import org.group492project3.backEnd.repository.TestResultRepository;

import java.util.List;

public class TestResultService {

    private TestResultRepository testResultRepository;

    public TestResultService(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    public Response<TestResult,String> addTestResult(Integer idCourse, Integer idStudent, Integer amountOfQuestions, Integer amountOfRightAnswers){

        TestResult testResult = testResultRepository.addTestResult(idCourse, idStudent, amountOfQuestions, amountOfRightAnswers);

        if(testResult == null){
            return new Response<>(null, false, "Результаты теста отсутствуют");
        }
        return new Response<>(testResult, true,"");
    }

    public Response<List<TestResult>,String> getTestingResultsForStudentCourse(Integer idCourse, Integer idStudent){

        List<TestResult> testResultList = testResultRepository.getTestingResultsForStudentCourse(idCourse, idStudent);

        if(testResultList.size() == 0){
            return new Response<>(null, false, "Результаты тестов отсутствуют");
        }
        return new Response<>(testResultList, true,"");
    }


}

package org.group492project3.backEnd.repository;

import org.group492project3.backEnd.entity.TestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultRepository {

    public List <TestResult> testingWithResults = new ArrayList<>();
    private Integer resultsGetID = 0;

    private TestResult addTestingFromStudent (Integer idOfCourse, Integer studentID) {

            resultsGetID = testingWithResults.size()+1;
            TestResult testResultForSave = new TestResult (studentID, idOfCourse);
            testingWithResults.add(testResultForSave);
            return testResultForSave;
        }

}





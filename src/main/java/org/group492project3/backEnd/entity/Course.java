package org.group492project3.backEnd.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private Integer id;
    private String name;
    private List<EducationalMaterials> educationalMaterialsList;
    private List<Student> studentList;
    private List<TestQuestions> testQuestionsList;

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
        educationalMaterialsList = new ArrayList<>();;
        studentList = new ArrayList<>();
        testQuestionsList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EducationalMaterials> getEducationalMaterialsList() {
        return educationalMaterialsList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<TestQuestions> getTestQuestionsList() {
        return testQuestionsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    //------------------- educationalMaterialsList
    public void addEducationalMaterialsToList(EducationalMaterials educationalMaterials) {
        educationalMaterialsList.add(educationalMaterials);
    }

    public void removeEducationalMaterialsFromList(EducationalMaterials educationalMaterials) {
        educationalMaterialsList.remove(educationalMaterials);
    }

    public void setNewEducationalMaterialsList(List<EducationalMaterials> newEducationalMaterialsList) {
        educationalMaterialsList = newEducationalMaterialsList;
    }
    public void deleteEducationalMaterialsList() {
        educationalMaterialsList = new ArrayList<>();
    }

    //------------------- studentList
    public void addStudentToList(Student student) {
        studentList.add(student);
    }

    public void removeStudentFromList(Student student) {
        studentList.remove(student);
    }

    public void setNewStudentList(List<Student> newStudentList) {
        studentList = newStudentList;
    }
    public void deleteStudentList() {
        studentList = new ArrayList<>();
    }

    //------------------- testQuestionsList
    public void addTestQuestionsToList(TestQuestions testQuestions) {
        testQuestionsList.add(testQuestions);
    }

    public void removeTestQuestionsFromList(TestQuestions testQuestions) {
        testQuestionsList.remove(testQuestions);
    }

    public void setNewTestQuestionsList(List<TestQuestions> newTestQuestionsList) {
        testQuestionsList = newTestQuestionsList;
    }
    public void deleteTestQuestionsList() {
        testQuestionsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

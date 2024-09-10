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

    public void addEducationalMaterials(EducationalMaterials educationalMaterials) {
        educationalMaterialsList.add(educationalMaterials);
    }

    public void removeEducationalMaterials(EducationalMaterials educationalMaterials) {
        educationalMaterialsList.remove(educationalMaterials);
    }

    public void addStudentList(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public void addTestQuestions(TestQuestions testQuestions) {
        testQuestionsList.add(testQuestions);
    }

    public void removeTestQuestions(TestQuestions testQuestions) {
        testQuestionsList.remove(testQuestions);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

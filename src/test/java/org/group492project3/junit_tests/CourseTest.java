package org.group492project3.junit_tests;

import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    List <Student> studentList = new ArrayList<>();
    Course course = new Course (0, "Java");

    @BeforeEach
    void setUp () {
        Student student = new Student(2,"new student", "333", "Ivan", "Ivanov");
        Student student2 = new Student( 3, "new student2", "444","Petr", "Petrov");
        studentList.add(student);
        studentList.add(student2);
    }

    @Test
    @DisplayName("Удаление листа со студентами")
    void deleteStudentList () {
            studentList = new ArrayList<>();
       assertNull(studentList);
    }


}
package org.group492project3.junit_tests;

import org.group492project3.backEnd.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

       @BeforeEach
       void setUp () {
           Student student = new Student(3, "new student", "fg3444", "Ivan", "Ivanov");
       }

       @Test
       @DisplayName("Проверка соответствия поля role")
       void RoleTest () {
           assertNotEquals("admin", "user");
       }


}
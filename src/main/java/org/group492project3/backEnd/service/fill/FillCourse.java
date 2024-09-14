package org.group492project3.backEnd.service.fill;

import org.group492project3.backEnd.API.Container;
import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.EducationalMaterials;
import org.group492project3.backEnd.entity.Student;
import org.group492project3.backEnd.entity.TestQuestions;
import org.group492project3.backEnd.repository.TestQuestionsRepository;

import java.util.HashMap;
import java.util.Map;

public class FillCourse {
    Container cont;

    public FillCourse(Container cont) {
        this.cont = cont;
    }

    public void fillCourseJava() {
        Response<Course, String> courseJavaResponse = cont.courseService.addNewCourse("Java Course 49-2");
        if (courseJavaResponse.getStatusOfOperation()) {

            Course courseJava = courseJavaResponse.getElementOfOperation();
            Integer idCourse = courseJava.getId();

            //---------------------------------------  заполнить тесты

            TestQuestionsRepository testQuestionsRepository = new TestQuestionsRepository();
            String question1 = "Укажите какой тип данных, из представленных, занимает наибольшее место памяти.";
            Map<Integer, String> answersMap1 = new HashMap<>();
            answersMap1.put(1, "int");
            answersMap1.put(2, "byte");
            answersMap1.put(3, "double");
            answersMap1.put(4, "float");
            answersMap1.put(5, "никакой, так как все примитивные типы занимают одинаковый объём в памяти");

            TestQuestions testQuestions1 = testQuestionsRepository.addTestQuestions(idCourse, question1, answersMap1, 3);
            courseJava.addTestQuestionsToList(testQuestions1);


            String question2 = "Какое расширение имеют файлы с исходным кодом Java?";
            Map<Integer, String> answersMap2 = new HashMap<>();
            answersMap2.put(1, ".javac");
            answersMap2.put(2, ".java");
            answersMap2.put(3, ".class");
            answersMap2.put(4, ".classpath");

            TestQuestions testQuestions2 = testQuestionsRepository.addTestQuestions(idCourse, question2, answersMap2, 2);
            courseJava.addTestQuestionsToList(testQuestions2);


            String question3 = "Импорт какого пакета в Java происходит автоматически?";
            Map<Integer, String> answersMap3 = new HashMap<>();
            answersMap3.put(1, "Все пакеты нужно явно указывать");
            answersMap3.put(2, "java.util");
            answersMap3.put(3, "java.lang");
            answersMap3.put(4, "java.text");

            TestQuestions testQuestions3 = testQuestionsRepository.addTestQuestions(idCourse, question3, answersMap3, 3);
            courseJava.addTestQuestionsToList(testQuestions3);

            String question4 = "Какой арифметический оператор в Java не существует?";
            Map<Integer, String> answersMap4 = new HashMap<>();
            answersMap4.put(1, "--");
            answersMap4.put(2, "%");
            answersMap4.put(3, "**");
            answersMap4.put(4, "++");

            TestQuestions testQuestions4 = testQuestionsRepository.addTestQuestions(idCourse, question4, answersMap4, 3);
            courseJava.addTestQuestionsToList(testQuestions4);

            String question5 = "Какой тип преобразования не произойдёт автоматически?";
            Map<Integer, String> answersMap5 = new HashMap<>();
            answersMap5.put(1, "byte в short");
            answersMap5.put(2, "int в long");
            answersMap5.put(3, "char в short");
            answersMap5.put(4, "long в float");

            TestQuestions testQuestions5 = testQuestionsRepository.addTestQuestions(idCourse, question5, answersMap5, 3);
            courseJava.addTestQuestionsToList(testQuestions5);

            //---------------------------------------------------------------------------------

            ////заполнить материалы

            String description = "Java – популярный многофункциональный язык программирования, используемый для создания бизнес логики веб-проектов, а также приложений для Android.";
            Response<EducationalMaterials, String> educationalMaterialsResponse = cont.educationalMaterialsService.addMaterial(idCourse, "Java For Dummies", description);
            if (educationalMaterialsResponse.getStatusOfOperation()) {
                courseJava.addEducationalMaterialsToList(educationalMaterialsResponse.getElementOfOperation());
            }

            // добавить студентов

            Response<Student, String> studentResponse1 = cont.studentService.addStudent("Ivan", "Ivanov", "login1", "pass111");
            if (studentResponse1.getStatusOfOperation()) {
                courseJava.addStudentToList(studentResponse1.getElementOfOperation());
            }
            Response<Student, String> studentResponse2 = cont.studentService.addStudent("Petr", "Petrov", "login2", "pass222");
            if (studentResponse2.getStatusOfOperation()) {
                courseJava.addStudentToList(studentResponse2.getElementOfOperation());
            }
            Response<Student, String> studentResponse3 = cont.studentService.addStudent("Sidr", "Sidorov", "login3", "pass333");
            if (studentResponse3.getStatusOfOperation()) {
                courseJava.addStudentToList(studentResponse3.getElementOfOperation());
            }

        }


        //------------------------------------- Java 2

        Response<Course, String> courseJavaResponse2 = cont.courseService.addNewCourse("Java for dummies");
        if (courseJavaResponse2.getStatusOfOperation()) {

            Course courseJava2 = courseJavaResponse2.getElementOfOperation();
            Integer idCourse2 = courseJava2.getId();

            //---------------------------------------  заполнить тесты

            TestQuestionsRepository testQuestionsRepository = new TestQuestionsRepository();
            String question1 = "Укажите какой тип данных, из представленных, занимает наибольшее место памяти.";
            Map<Integer, String> answersMap1 = new HashMap<>();
            answersMap1.put(1, "int");
            answersMap1.put(2, "byte");
            answersMap1.put(3, "double");
            answersMap1.put(4, "float");
            answersMap1.put(5, "никакой, так как все примитивные типы занимают одинаковый объём в памяти");

            TestQuestions testQuestions1 = testQuestionsRepository.addTestQuestions(idCourse2, question1, answersMap1, 3);
            courseJava2.addTestQuestionsToList(testQuestions1);


            String question2 = "Какое расширение имеют файлы с исходным кодом Java?";
            Map<Integer, String> answersMap2 = new HashMap<>();
            answersMap2.put(1, ".javac");
            answersMap2.put(2, ".java");
            answersMap2.put(3, ".class");
            answersMap2.put(4, ".classpath");

            TestQuestions testQuestions2 = testQuestionsRepository.addTestQuestions(idCourse2, question2, answersMap2, 2);
            courseJava2.addTestQuestionsToList(testQuestions2);


            String question3 = "Импорт какого пакета в Java происходит автоматически?";
            Map<Integer, String> answersMap3 = new HashMap<>();
            answersMap3.put(1, "Все пакеты нужно явно указывать");
            answersMap3.put(2, "java.util");
            answersMap3.put(3, "java.lang");
            answersMap3.put(4, "java.text");

            TestQuestions testQuestions3 = testQuestionsRepository.addTestQuestions(idCourse2, question3, answersMap3, 3);
            courseJava2.addTestQuestionsToList(testQuestions3);

            String question4 = "Какой арифметический оператор в Java не существует?";
            Map<Integer, String> answersMap4 = new HashMap<>();
            answersMap4.put(1, "--");
            answersMap4.put(2, "%");
            answersMap4.put(3, "**");
            answersMap4.put(4, "++");

            TestQuestions testQuestions4 = testQuestionsRepository.addTestQuestions(idCourse2, question4, answersMap4, 3);
            courseJava2.addTestQuestionsToList(testQuestions4);

            String question5 = "Какой тип преобразования не произойдёт автоматически?";
            Map<Integer, String> answersMap5 = new HashMap<>();
            answersMap5.put(1, "byte в short");
            answersMap5.put(2, "int в long");
            answersMap5.put(3, "char в short");
            answersMap5.put(4, "long в float");

            TestQuestions testQuestions5 = testQuestionsRepository.addTestQuestions(idCourse2, question5, answersMap5, 3);
            courseJava2.addTestQuestionsToList(testQuestions5);

            //---------------------------------------------------------------------------------

            ////заполнить материалы

            String description = "Java – популярный многофункциональный язык программирования, используемый для создания бизнес логики веб-проектов, а также приложений для Android.";
            Response<EducationalMaterials, String> educationalMaterialsResponse = cont.educationalMaterialsService.addMaterial(idCourse2, "Java For Dummies", description);
            if (educationalMaterialsResponse.getStatusOfOperation()) {
                courseJava2.addEducationalMaterialsToList(educationalMaterialsResponse.getElementOfOperation());
            }

            // добавить студентов

            Response<Student, String> studentResponse4 = cont.studentService.addStudent("Alex", "Alexandrov", "login4", "pass444");
            if (studentResponse4.getStatusOfOperation()) {
                courseJava2.addStudentToList(studentResponse4.getElementOfOperation());
            }
            Response<Student, String> studentResponse5 = cont.studentService.addStudent("Dmitri", "Dmitrov", "login5", "pass555");
            if (studentResponse5.getStatusOfOperation()) {
                courseJava2.addStudentToList(studentResponse5.getElementOfOperation());
            }
            Response<Student, String> studentResponse6 = cont.studentService.addStudent("Valerij", "Leontjev", "login6", "pass666");
            if (studentResponse6.getStatusOfOperation()) {
                courseJava2.addStudentToList(studentResponse6.getElementOfOperation());
            }

        }

    }

}

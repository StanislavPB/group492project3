package org.group492project3.backEnd.service.fill;

import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.TestQuestions;
import org.group492project3.backEnd.repository.CourseRepository;
import org.group492project3.backEnd.repository.TestQuestionsRepository;
import org.group492project3.backEnd.service.CourseService;
import org.group492project3.backEnd.service.validation.CourseValidation;

import java.util.HashMap;
import java.util.Map;

public class FillCourse {

    CourseRepository courseRepository = new CourseRepository();
    CourseValidation courseValidation = new CourseValidation();
    CourseService courseService = new CourseService(courseRepository, courseValidation);

    public void fillCourseJava(){

        Response<Course,String> courseJavaResponse = courseService.addNewCourse("Java");

        if(courseJavaResponse.getStatusOfOperation()){

            Course courseJava = courseJavaResponse.getElementOfOperation();

            Integer idCourse = courseJava.getId();

            //---------------------------------------  заполнить тесты

            TestQuestionsRepository testQuestionsRepository = new TestQuestionsRepository();

            Map<Integer, String> answersMap1 = new HashMap<>();
            answersMap1.put(1,"5");
            answersMap1.put(2,"3");
            answersMap1.put(3,"4");
            answersMap1.put(4,"Задача не решается!");

            TestQuestions testQuestions1 = testQuestionsRepository.addTestQuestions(idCourse, "2 * 2", answersMap1, 3);
            courseJava.addTestQuestionsToList(testQuestions1);


            String question2 = "Какое расширение имеют файлы с исходным кодом Java?";
            Map<Integer, String> answersMap2 = new HashMap<>();
            answersMap2.put(1,".javac");
            answersMap2.put(2,".java");
            answersMap2.put(3,".class");
            answersMap2.put(4,".classpath");

            TestQuestions testQuestions2 = testQuestionsRepository.addTestQuestions(idCourse, question2, answersMap2, 2);
            courseJava.addTestQuestionsToList(testQuestions2);


            String question3 = "Импорт какого пакета в Java происходит автоматически?";
            Map<Integer, String> answersMap3 = new HashMap<>();
            answersMap3.put(1,"Все пакеты нужно явно указывать");
            answersMap3.put(2,"java.util");
            answersMap3.put(3,"java.lang");
            answersMap3.put(4,"java.text");

            TestQuestions testQuestions3 = testQuestionsRepository.addTestQuestions(idCourse, question3, answersMap3, 3);
            courseJava.addTestQuestionsToList(testQuestions3);

            //---------------------------------------------------------------------------------


            ////заполнить материалы


            // добавить созданных ранее студентов

        }
    }

}

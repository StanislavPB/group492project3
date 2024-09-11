package org.group492project3.backEnd.service;

import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.repository.CourseRepository;
import org.group492project3.backEnd.service.validation.CourseValidation;

import java.util.List;

public class CourseService {
    private CourseRepository repository;
    private CourseValidation validation;

    public CourseService(CourseRepository repository, CourseValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public Response<Course,String> addNewCourse(String courseName){

        String validationResult = validation.validateCourseName(courseName);

        if (!validationResult.isEmpty()){
            return new Response<>(null, false, validationResult);
        }

        Course savedCourse = repository.addCourse(courseName);

        return new Response<>(savedCourse, true,"");
    }


    public Response<Course,String>  updateNote(Integer id, String courseName){

        Course courseForUpdate = repository.findById(id);

        if (courseForUpdate == null) {
            return new Response<>(null, false,"Курс с id = " + id + " не найден");
        }

        Course courseAfterUpdate = repository.updateCourse(courseForUpdate);

        return new Response<>(courseAfterUpdate,true,"");
    }

    public Response<Course,String> deleteCourse (Integer id){
        Course courseForDelete = repository.findById(id);

        if (courseForDelete == null) {
            return new Response<>(null,false, "Курс с id = " + id + " не найден. Удаление невозможно.");
        }

        courseForDelete = repository.deleteCourse(courseForDelete);

        return new Response<>(courseForDelete, true, "");
    }

    public Response<Course,String> findById(Integer id) {
        Course foundCourse = repository.findById(id);

        if (foundCourse == null) {
            return new Response<>(null, false, "Курс с id = " + id + " не найден.");
        } else {
            return new Response<>(foundCourse, true, "");
        }
    }

    public Response<List<Course>,String>  findByName(String name) {

        List<Course> foundCourses = repository.findByName(name);

        if (foundCourses.isEmpty()) {
            return new Response<>(foundCourses, false,"Курсы с name = " + name + " не найдены.");
        } else {
            return new Response<>(foundCourses, true, "");
        }
    }

    public Response<List<Course>,String>  findAllCourses() {

        List<Course> foundCourses = repository.findAllCourses();
        if (foundCourses.isEmpty()) {
            return new Response<>(foundCourses, false,"Курсы не найдены. Database курсов пуст.");
        } else {
            return new Response<>(foundCourses, true, "");
        }

    }



}

package org.group492project3.backEnd.service;

import org.group492project3.backEnd.repository.CourseRepository;
import org.group492project3.backEnd.service.validation.CourseValidation;

public class CourseService {
    private CourseRepository repository;
    private CourseValidation validation;

    public CourseService(CourseRepository repository, CourseValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }
}

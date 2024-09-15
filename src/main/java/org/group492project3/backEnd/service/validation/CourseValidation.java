package org.group492project3.backEnd.service.validation;

import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.repository.CourseRepository;

import java.util.List;

import static java.lang.Character.isDigit;

public class CourseValidation {

    public String validateCourseName(String name, List<Course> databaseCourse){
        String validationResult = "";

        if (name == null || name.isEmpty()){
            validationResult = validationResult + "The title cannot be empty \n";
        }

        if (name.length() < 3){
            validationResult = validationResult + "The name length cannot be less than 3 characters \n";
        }

        if (name.length() > 40){
            validationResult = validationResult + "The name length cannot be more than 40 characters \n";
        }
        if(!databaseCourse.isEmpty()){
            for (int i = 0; i < databaseCourse.size(); i++) {
                if(databaseCourse.get(i).getName().equals(name)){
                    validationResult = validationResult + "A course with the same name already exists.. \n";
                }
            }
        }

        return validationResult;
    }

}

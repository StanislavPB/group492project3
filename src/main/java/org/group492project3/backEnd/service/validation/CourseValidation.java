package org.group492project3.backEnd.service.validation;

public class CourseValidation {

    public String validateCourseName(String name){
        String validationResult = "";

        if (name == null || name.isEmpty()){
            validationResult = validationResult + "Название не может быть пустым \n";
        }

        if (name.length() < 3){
            validationResult = validationResult + "Длина названия не может быть менее 3-х символов \n";
        }

        if (name.length() > 15){
            validationResult = validationResult + "Длина названия не может быть более 15-х символов \n";
        }

        return validationResult;
    }
}

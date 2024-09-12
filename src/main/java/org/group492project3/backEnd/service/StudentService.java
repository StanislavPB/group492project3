package org.group492project3.backEnd.service;

import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.Student;
import org.group492project3.backEnd.repository.StudRepository;
import org.group492project3.backEnd.service.validation.StudentValidation;

import java.util.List;

public class StudentService {
    private StudRepository studRepository;
    private StudentValidation validation;

    public StudentService(StudRepository studRepository, StudentValidation validation) {
        this.studRepository = studRepository;
        this.validation = validation;
    }

    public List<Student> getAllStudent() {
        return studRepository.getAllStudent();
    }


    public Response<Student, String> findById(Integer id) {
        Student foundStudent = studRepository.findById(id);
        if (foundStudent == null) {
            return new Response<>(null, false, "Student with id=" + id + "not exists");
        } else {
            return new Response<>(foundStudent, true, "");
        }
    }



    public Response<Student, String> addStudent(Integer id,String firstName, String lastName, String login, String passwort) {
        String valResult = validation.validate(firstName, lastName, login, passwort);
        if (!valResult.isEmpty()) {
            return new Response<>(null, false, valResult);
        }
        Student savedStudent = studRepository.add(id,login,passwort,firstName,lastName );
        return new Response<>(savedStudent,true,"");
    }


public Response<Student,String>deleteStudent(Integer id){
        Student studForDelete=studRepository.findById(id);
        if (studForDelete==null){
            return new Response<>(studForDelete,false,"Student with id=" + id + "not exists and can not be deleted");
        }studForDelete=studRepository.deleteStudent(studForDelete);
        return new Response<>(studForDelete,true,"");
}


public Response<Student,String> updStudent(Student student, String updLogin, String updPassword){
        Student updStudent=studRepository.update(student,updLogin,updPassword);
        if (!(updStudent ==null)) {


            return new Response<>(updStudent, true, "");
        }return new Response<>(updStudent,false,"");
    }
}

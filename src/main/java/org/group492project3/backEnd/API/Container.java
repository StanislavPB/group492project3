package org.group492project3.backEnd.API;

import org.group492project3.backEnd.repository.CourseRepository;
import org.group492project3.backEnd.repository.StudRepository;
import org.group492project3.backEnd.service.CourseService;
import org.group492project3.backEnd.service.StudentService;
import org.group492project3.backEnd.service.validation.CourseValidation;
import org.group492project3.backEnd.service.validation.StudentValidation;
import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;

public class Container {
    StudentService studentService = new StudentService(new StudRepository(), new StudentValidation());
    CourseService courseService = new CourseService(new CourseRepository(),new CourseValidation());
    public DecorationService decor = new DecorationService();
    public MessageService message = new MessageService();
    public UserInputService userInput = new UserInputService();
    public Api api = new Api();
}

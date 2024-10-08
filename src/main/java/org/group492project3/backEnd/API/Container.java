package org.group492project3.backEnd.API;

import org.group492project3.backEnd.repository.CourseRepository;
import org.group492project3.backEnd.repository.EdMatRepository;
import org.group492project3.backEnd.repository.StudRepository;
import org.group492project3.backEnd.repository.TestResultRepository;
import org.group492project3.backEnd.service.CourseService;
import org.group492project3.backEnd.service.EducationalMaterialsService;
import org.group492project3.backEnd.service.StudentService;
import org.group492project3.backEnd.service.TestResultService;
import org.group492project3.backEnd.service.validation.CourseValidation;
import org.group492project3.backEnd.service.validation.StudentValidation;
import org.group492project3.frontEnd.services.DecorationService;
import org.group492project3.frontEnd.services.MessageService;
import org.group492project3.frontEnd.services.UserInputService;
import org.group492project3.frontEnd.services.validation.Validation;

public class Container {
    public StudentService studentService = new StudentService(new StudRepository(), new StudentValidation());
    public CourseService courseService = new CourseService(new CourseRepository(), new CourseValidation());
    public EducationalMaterialsService educationalMaterialsService = new EducationalMaterialsService(new EdMatRepository());
    public TestResultService testResultService = new TestResultService(new TestResultRepository());
    public DecorationService decor = new DecorationService();
    public MessageService message = new MessageService();
    public UserInputService userInput = new UserInputService(decor, message);
}

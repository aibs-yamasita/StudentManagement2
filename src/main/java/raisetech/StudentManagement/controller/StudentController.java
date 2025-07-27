package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/studentList")
  public List<Student> getStudentsInTheir30s() {
    return studentService.searchStudentList();
  }

  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentsCourseList() {
    return studentService.getStudentsCourseList();
  }

  @GetMapping("/javaCourses")
  public List<StudentsCourses> getJavaCourses() {
    return studentService.getJavaCourses();  // ← service → studentService に修正
  }

  // mainメソッドはここには不要。Applicationクラスに入れるべきです。
}

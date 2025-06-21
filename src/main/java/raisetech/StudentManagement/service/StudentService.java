package raisetech.StudentManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    // 年齢が30代の学生のみを抽出
    List<Student> allStudents = repository.search();
    return allStudents.stream()
        .filter(s -> s.getAge() >= 30 && s.getAge() < 40)
        .toList();
  }
    //すべての学生と講座の対応リストを返す
  public List<StudentsCourses> searchStudentsCourseList() {
    return repository.searchStudentsCourses();
  }

  public List<StudentsCourses> getJavaCourses() {
    List<StudentsCourses> allCourses = repository.searchStudentsCourses();
    return allCourses.stream()
        .filter(course -> "Javaプログラミング".equals(course.getCourseName()))
        .toList();
  }
}

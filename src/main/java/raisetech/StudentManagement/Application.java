package raisetech.StudentManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// GETリクエスト: 学生情報を取得
	@GetMapping("/studentList")
	public List<Student> getStudent() {
		return repository.search();
	}


	//GET POST
//GETは取得する。リクエストの結果を受け取る
//POST は情報を与える、渡す

//	@GetMapping("/courses")
//	public List<StudentsCourses> getCourses() {
//		// コースのリストを返すロジック
//		List<StudentsCourses> courses = new ArrayList<>();
//		// サンプルデータを追加
//		StudentsCourses course = new StudentsCourses();
//		course.setCourseId("C001");
//		course.setCourseName("Mathematics");
//		course.setStartDate(LocalDateTime.now());
//		course.setEndDate(LocalDateTime.now().plusMonths(3));
//		course.setStudentIDs(Arrays.asList("S001", "S002", "S003"));
//		courses.add(course);
//		return courses;
//	}

//	@PostMapping("/courses")
//	public StudentsCourses createCourse(@RequestBody StudentsCourses course) {
//		// 新しいコースを作成するロジック
//		course.setStartDate(LocalDateTime.now());
//		course.setEndDate(LocalDateTime.now().plusMonths(3));
//		return course;
//	}

//	@GetMapping
//	public List<StudentsCourses> getAllCourses() {
//		return repository.getAllCourses();
//	}

	@GetMapping("/AllCourses")
	public List<StudentsCourses> findAllCourses() {
		return repository.findAllCourses();
	}

}
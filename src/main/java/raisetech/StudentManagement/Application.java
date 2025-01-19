package raisetech.StudentManagement;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// GETリクエスト: 学生情報を取得
	@GetMapping("/student")
	public String getStudent(@RequestParam String name) {
		Student student = repository.searchByName(name);
		return student.getName() + " " + student.getAge() + "歳";
	}


	@PostMapping("/student")
	public void registerStudent(String name, int age) {
		repository.registerStudent(name, age);

	}

	// POSTリクエスト: 名前のみ更新
	@PatchMapping("/student")
	public void updateStudentName(String name,int age) {
		repository.updateStudent(name,age);
  }
	@DeleteMapping("/student")
	public void deleteStudent(String name){
		repository.deleteStudent(name);
	}
	@GetMapping("/studentList")
	public List<Student> getStudentList() {
		List<Student> student = repository.searchByNameList();
		return student;
	}
}


//GET POST
//GETは取得する。リクエストの結果を受け取る
//POST は情報を与える、渡す


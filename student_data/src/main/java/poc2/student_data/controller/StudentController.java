package poc2.student_data.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poc2.student_data.entity.Student;
import poc2.student_data.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/saveStudent")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT')")
	public ResponseEntity<Student> saveStudent(@RequestBody @Valid Student student) {
		Student studentSave = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentSave);
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('student:read')")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> getlist = studentService.getAlldata();
		return ResponseEntity.status(HttpStatus.OK).body(getlist);

	}

	@GetMapping("/getById/{studentId}")
	@PreAuthorize("hasAuthority('student:read')")
	public ResponseEntity<Student> findById(@PathVariable Long studentId){
		Student student = studentService.searchById(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
}

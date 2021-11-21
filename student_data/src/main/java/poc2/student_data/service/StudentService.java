package poc2.student_data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc2.student_data.entity.Student;
import poc2.student_data.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;

	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	public List<Student> getAlldata() {
		return studentRepo.findAll();
	}

	public Student searchById(Long studentId) {
		return studentRepo.findById(studentId).get();
	}

}

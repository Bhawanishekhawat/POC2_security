package poc2.student_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poc2.student_data.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

}

package poc2.student_data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="student_data")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id")
	private Long studentId;
	@NotNull(message = "{firstName}")
	@Column(name="first_name")
	private String firstName;
	@NotNull(message = "{lastName}")
	@Column(name="last_name")
	private String lastName;
	@NotNull(message = "{mobileNo}")
	@Column(name="mobile_number")
	@Digits(integer = 10, fraction = 0, message = "{MobileNo}")
	@Min(value = 1000000000, message = "{MobileNo}")
	private Long mobileNo;
	@NotNull(message = "{email_id}")
	@Column(name="email_id")
	@Email(message = "{email}")
	private String emailId;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="project_list")
	private List<Project> projectList;

}

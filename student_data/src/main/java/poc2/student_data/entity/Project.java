package poc2.student_data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="project_details")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="projId")
	private Long id;
    @NotNull(message="{projName}")
    @Column(name="project_name")
	private String projectName;
    @NotNull(message="{duration}")
    @Column(name="projduration")
	private Integer projectDurationInMonth;
	
}

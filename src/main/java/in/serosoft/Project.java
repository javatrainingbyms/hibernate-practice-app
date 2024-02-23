package in.serosoft;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
	@Id
	private String code;
	private String title;
	private String subject;
	private Date sdate;
	
	@ManyToOne	//student_id
	private Student student;
}

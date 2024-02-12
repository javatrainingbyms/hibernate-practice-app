package in.serosoft;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name="stud_info")
@Builder
public class Student {
	@Id
	@Column(name="rno")
	private int rno;
	
	@Column(name="name", length = 100, nullable = false)
	private String name;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="sem")
	private int sem=1;
	
	@Column(name="marks")
	private int marks;

}

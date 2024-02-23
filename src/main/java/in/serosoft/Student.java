package in.serosoft;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="lapy")
	private Laptop laptop;//laptop_code
	
	@OneToMany(mappedBy = "student")
	private List<Project> projects;

	public Student(int rno, String name, String branch, int sem, int marks, Laptop laptop) {
		super();
		this.rno = rno;
		this.name = name;
		this.branch = branch;
		this.sem = sem;
		this.marks = marks;
		this.laptop = laptop;
	}
	

}

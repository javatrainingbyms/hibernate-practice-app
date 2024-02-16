package in.serosoft;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
	@Id
	private String code;
	private String brand;
	private int price;
	@OneToOne(fetch = FetchType.LAZY, mappedBy="laptop")
	private Student student;	//student_id
	public Laptop(String code) {
		super();
		this.code = code;
	}
	
	
}

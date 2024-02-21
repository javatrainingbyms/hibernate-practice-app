package in.serosoft;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
	@Id
	private int id;
	private String name;
	private String email;
	private String mobile;
	@OneToOne
	@JoinColumn(name = "bd_id")
	private BankDetail bankDetail;	
}

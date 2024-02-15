package in.serosoft;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	public Laptop(String code) {
		super();
		this.code = code;
	}
	
	
}

package in.serosoft;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AccountType {
	@Id
	private String id;
	private String type;
	private String desc;
}

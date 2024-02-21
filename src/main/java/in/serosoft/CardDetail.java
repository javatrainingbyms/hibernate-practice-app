package in.serosoft;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CardDetail {
	@Id
	private String id;
	private String cardNo;
	private String type;
}

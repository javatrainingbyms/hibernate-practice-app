package in.serosoft;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankDetail {
	@Id
	private int id;
	private String bankName;
	private String accountNo;
	private String branch;
	@OneToOne(mappedBy = "bankDetail")
	private Person person;
	@OneToOne
	@JoinColumn(name="cd_id")
	private CardDetail card;
	public BankDetail(int id) {
		super();
		this.id = id;
	}
	public BankDetail(int id, String bankName, String accountNo, String branch) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.branch = branch;
	}
	
	
}

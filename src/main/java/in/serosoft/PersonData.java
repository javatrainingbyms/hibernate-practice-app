package in.serosoft;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class PersonData {

	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Criteria criteria=session.createCriteria(Person.class);
		List<Person> persons=criteria.list();
		for(Person person:persons) {
			System.out.println(person.getId()+","+person.getName()+","+person.getEmail()+","+person.getMobile());
			BankDetail bd=person.getBankDetail();
			System.out.println(bd.getId()+","+bd.getBankName()+","+bd.getAccountNo()+","+bd.getBranch());
			System.out.println("________________________________________________________________________");
		}
		session.close();
	}

}

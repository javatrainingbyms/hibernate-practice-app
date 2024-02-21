package in.serosoft;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PersonData {

	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Criteria criteria=session.createCriteria(Person.class);
		//criteria.add(Restrictions.like("name", "S%"));
		//criteria.add(Restrictions.ilike("name", "S%",MatchMode.EXACT));
		criteria.createAlias("bankDetail","bankDetail");
		criteria.createAlias("bankDetail.card", "card");
		criteria.add(Restrictions.eq("bankDetail.bankName","sbi"));
		criteria.add(Restrictions.eq("card.type", "gold"));
		List<Person> persons=criteria.list();
		for(Person person:persons) {
			System.out.println(person.getId()+","+person.getName()+","+person.getEmail()+","+person.getMobile());
			BankDetail bd=person.getBankDetail();
			System.out.println(bd.getId()+","+bd.getBankName()+","+bd.getAccountNo()+","+bd.getBranch());
			CardDetail card=bd.getCard();
			System.out.println(card.getId()+","+card.getCardNo()+","+card.getType());
			System.out.println("________________________________________________________________________");
		}
		session.close();
	}
}

package in.serosoft;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BankDetailsData {

	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Criteria criteria=session.createCriteria(BankDetail.class);
		criteria.add(Restrictions.eq("bankName", "sbi"));
		//criteria.add(Restrictions.like("name", "S%"));
		//criteria.add(Restrictions.ilike("name", "S%",MatchMode.EXACT));
		List<BankDetail> bds=criteria.list();
		for(BankDetail bd:bds) {
			Person person=bd.getPerson();
			System.out.println(bd.getId()+","+bd.getBankName()+","+bd.getAccountNo()+","+bd.getBranch());
			System.out.println(person.getId()+","+person.getName()+","+person.getEmail()+","+person.getMobile());
			System.out.println("________________________________________________________________________");
		}
		session.close();
	}

}

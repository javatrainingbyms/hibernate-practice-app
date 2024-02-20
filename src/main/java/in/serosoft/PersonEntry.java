package in.serosoft;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonEntry {

	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure();
		SessionFactory sf=configuration.buildSessionFactory();
		Session session=sf.openSession();
		Person p1=new Person(1,"manoj","manoj@gmail.com","12345",new BankDetail(1001));
		Person p2=new Person(2,"sunil","sunil@gmail.com","23456",new BankDetail(1002));
		Person p3=new Person(3,"keerti","keerti@gmail.com","34567",new BankDetail(1003));
		Transaction tr=session.beginTransaction();
		session.save(p1); 
		session.save(p2);
		session.save(p3);
		tr.commit();
		session.close();
		System.out.println("Data Stored...!");
	}

}

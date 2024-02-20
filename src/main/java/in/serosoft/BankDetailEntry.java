package in.serosoft;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BankDetailEntry {

	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure();
		SessionFactory sf=configuration.buildSessionFactory();
		Session session=sf.openSession();
		BankDetail bd1=new BankDetail(1001,"sbi","1111","indore");
		BankDetail bd2=new BankDetail(1002,"hdfc","2222","indore");
		BankDetail bd3=new BankDetail(1003,"sbi","3333","bhopal");
		Transaction tr=session.beginTransaction();
		session.save(bd1); 
		session.save(bd2);
		session.save(bd3);
		tr.commit();
		session.close();
		System.out.println("Data Stored...!");
	}
}

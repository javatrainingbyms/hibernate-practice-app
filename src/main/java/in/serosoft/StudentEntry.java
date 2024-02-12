package in.serosoft;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentEntry {

	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure();
		SessionFactory sf=configuration.buildSessionFactory();
		Session session=sf.openSession();
		Student s1=new Student(1,"manish","cs",4,50);
		Student s2=new Student(2,"ashish","it",6,70);
		Student s3=new Student(3,"rakesh","cs",2,30);
		Student s4=new Student(4,"chetan","it",6,20);
		Student s5=new Student(5,"smith","civil",4,80);
		
		Transaction tr=session.beginTransaction();
		session.save(s1); session.save(s2); session.save(s3); session.save(s4); session.save(s5);
		tr.commit();
		session.close();
		System.out.println("Data Stored...!");
	}

}

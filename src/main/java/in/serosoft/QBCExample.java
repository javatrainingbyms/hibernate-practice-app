package in.serosoft;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class QBCExample {
	public static void main(String[] args) {
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		//criteria.add(Restrictions.or(Restrictions.ge("marks",60), Restrictions.eq("branch","it")));
		criteria.add(Restrictions.between("marks", 40, 60));
		/*
		//Criterion crt1=Restrictions.eq("branch", "cs");
		Criterion crt1=Restrictions.ge("marks",60);
		Criterion crt2=Restrictions.eq("branch", "it");
		Criterion crt3=Restrictions.or(crt1,crt2);
		
		//criteria.add(crt1);
		//criteria.add(crt2);
		criteria.add(crt3);
		*/
		/*
		Order order1=Order.asc("marks");
		Order order2=Order.asc("name");
		criteria.addOrder(order1);
		criteria.addOrder(order2);
		*/
		
		List<Student> students=criteria.list();
		//students.forEach(System.out::println);
		for(Student student:students) {
			System.out.println(student.getRno()+","+student.getName()+","+student.getBranch()+","+student.getSem()+","+student.getMarks());

		}
		session.close();
	}

}

package in.serosoft;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class ProjectionExampleOne {

	public static void main(String[] args) {
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.setProjection(Projections.property("marks"));
		List<Integer> rnos=criteria.list();
		System.out.println(rnos);
		/*
		Projection proj1=Projections.property("name");
		
		criteria.setProjection(proj1);
		
		List<String> names=criteria.list();
		for(String name:names) {
			System.out.println(name);
			System.out.println("_______________________________");
		}
		*/
		session.close();
	}

}

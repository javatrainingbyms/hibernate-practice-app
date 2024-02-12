package in.serosoft;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class ProjectionExampleThree {

	public static void main(String[] args) {
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		
		Projection proj1=Projections.property("name");
		Projection proj2=Projections.property("marks");
		
		ProjectionList pList=Projections.projectionList();
		pList.add(proj1, "name");
		pList.add(proj2, "marks");
	
		criteria.setProjection(pList);
		
		criteria.setResultTransformer(Transformers.aliasToBean(Student.class));
		
		List<Student> list=criteria.list();
		for(Student info:list) {
			System.out.println(info);
		}
		
		
		session.close();

	}

}

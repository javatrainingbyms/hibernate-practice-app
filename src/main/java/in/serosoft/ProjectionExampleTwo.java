package in.serosoft;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class ProjectionExampleTwo {
	public static void main(String[] args) {
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		
		Projection proj1=Projections.property("name");
		Projection proj2=Projections.property("marks");
		Projection proj3=Projections.property("branch");
		
		ProjectionList pList=Projections.projectionList();
		pList.add(proj1, "name");
		pList.add(proj2, "marks");
		pList.add(proj3, "branch");
		
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map> list=criteria.list();
		
		for(Map map:list) {
			System.out.println(map);
		}
		session.close();
	}

}

package in.serosoft;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class ProjectionExampleFour {

	public static void main(String[] args) {
		
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		//avg, sum, max, min, count
		ProjectionList pList=Projections.projectionList();
		pList.add(Projections.groupProperty("branch"), "branch");
		pList.add(Projections.avg("marks"), "average");
		pList.add(Projections.sum("marks"), "total");
		pList.add(Projections.max("marks"), "maximum");
		pList.add(Projections.min("marks"), "minimum");
		pList.add(Projections.rowCount(), "count");
		
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.aliasToBean(Summary.class));
		List<Summary> list=criteria.list();
		for(Summary summary:list) {
			System.out.println(summary);
		}
		/*
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map> list=criteria.list();
		for(Map map:list) {
			System.out.println(map);
		}
		*/
		session.close();
	}

}

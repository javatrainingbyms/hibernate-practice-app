package in.serosoft;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class ProjectionInAssociation {

	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Criteria criteria=session.createCriteria(Person.class);
		criteria.createAlias("bankDetail", "bankDetail");
		criteria.createAlias("bankDetail.card", "cardDetail");
		Map<String,String> map=DAOUtil.getProjectionInstance();
		map.put("name", "name");
		map.put("email", "email");
		map.put("bankDetail.accountNo","ano");
		map.put("cardDetail.cardNo", "cno");
		DAOUtil.createProjection(criteria, map);
		/*
		Projection proj1=Projections.property("name");
		Projection proj2=Projections.property("email");
		Projection proj3=Projections.property("bankDetail.accountNo");
		Projection proj4=Projections.property("cardDetail.cardNo");
		ProjectionList pList=Projections.projectionList();
		pList.add(proj1, "name");
		pList.add(proj2, "email");
		pList.add(proj3, "ano");
		pList.add(proj4, "cno");
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		*/
		List<Map> list=criteria.list();
		for(Map mp:list) {
			System.out.println(mp);
		}
		
		session.close();
	}

}

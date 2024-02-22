package in.serosoft;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class ProjectionInAssociationWithJoin {
	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Criteria criteria=session.createCriteria(Person.class);
		//criteria.createAlias("bankDetail", "bankDetail");
		//criteria.createAlias("bankDetail", "bankDetail", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("bankDetail", "bankDetail", JoinType.RIGHT_OUTER_JOIN);
		Map<String,String> map=DAOUtil.getProjectionInstance();
		map.put("name", "name");
		map.put("email", "email");
		map.put("bankDetail.accountNo","ano");
		DAOUtil.createProjection(criteria, map);
		//criteria.add(Restrictions.isNull("bankDetail.accountNo"));
		List<Map> list=criteria.list();
		for(Map mp:list) {
			System.out.println(mp);
		}
		
		session.close();
	}

}

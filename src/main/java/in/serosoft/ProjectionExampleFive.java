package in.serosoft;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class ProjectionExampleFive {

	public static void main(String[] args) {
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);

		// Map<String,String> map=new HashMap<>();
		Map<String, String> projections = DAOUtil.getProjectionInstance();
		projections.put("name", "stdname"); // cols to be projected, alias name
		projections.put("marks", "score");
		projections.put("branch", "branch");
		DAOUtil.createProjection(criteria, projections);

		List<Map> list = criteria.list();
		for (Map map : list) {
			System.out.println(map);
		}
		session.close();

	}

}

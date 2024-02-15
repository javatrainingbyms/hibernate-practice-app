package in.serosoft;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class ProjectionExampleSix {
	public static void main(String[] args) {
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		Map<String, String> projections = DAOUtil.getProjectionInstance();
		projections.put("name", "name"); // cols to be projected, alias name
		projections.put("marks", "marks");
		
		DAOUtil.transformResultListToBeanClass(criteria, projections, StudentInfo.class);
		List<StudentInfo> list=criteria.list();
		for(StudentInfo info:list) {
			System.out.println(info);
		}
		
		session.close();

	}
}

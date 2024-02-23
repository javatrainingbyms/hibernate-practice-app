package in.serosoft;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class StudentProjectInfo {

	public static void main(String[] args) {
		Session session = Utility.getSF().openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.createAlias("projects", "project");
		criteria.add(Restrictions.eq("project.subject", "physics"));
		List<Student> students=criteria.list();
		for(Student student:students) {
			System.out.println(student.getName()+","+student.getBranch());
			List<Project> projects=student.getProjects();
			for(Project project:projects) {
				System.out.println(project.getCode()+","+project.getTitle()+","+project.getSubject());
			}
			System.out.println("__________________________________________");
		}
		session.close();
	}

}

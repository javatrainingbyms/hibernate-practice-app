package in.serosoft;

import org.hibernate.Session;

public class QBIExample {

	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Student student=session.get(Student.class, 5);
		System.out.println(student.getRno()+","+student.getName()+","+student.getBranch()+","+student.getSem()+","+student.getMarks());
		session.close();

	}

}

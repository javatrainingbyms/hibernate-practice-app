package in.serosoft;

import org.hibernate.Session;

public class QBIExample {

	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Student student=session.get(Student.class, 3);
		System.out.println(student.getRno()+","+student.getName()+","+student.getBranch()+","+student.getSem()+","+student.getMarks());
		Laptop laptop=student.getLaptop();
		System.out.println(laptop.getCode()+","+laptop.getBrand()+","+laptop.getPrice());
		session.close();

	}

}

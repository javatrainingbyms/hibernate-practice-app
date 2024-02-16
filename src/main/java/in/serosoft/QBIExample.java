package in.serosoft;

import org.hibernate.Session;

public class QBIExample {

	public static void main(String[] args) {
		Session session=Utility.getSF().openSession();
		Laptop laptop=session.get(Laptop.class, "L3");
		System.out.println(laptop.getCode()+","+laptop.getBrand()+","+laptop.getPrice());
		Student student=laptop.getStudent();
		System.out.println(student.getRno()+","+student.getName()+","+student.getBranch()+","+student.getSem()+","+student.getMarks());
		//Student student=laptop.getStudent();
		//System.out.println();
		/*
		Student student=session.get(Student.class, 3);
		System.out.println(student.getRno()+","+student.getName()+","+student.getBranch()+","+student.getSem()+","+student.getMarks());
		Laptop laptop=student.getLaptop();
		System.out.println(laptop.getCode()+","+laptop.getBrand()+","+laptop.getPrice());
		*/
		session.close();
		

	}

}

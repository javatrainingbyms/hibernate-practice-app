package in.serosoft;

import lombok.Data;

@Data
class Emp {
	private int id;
	private String name;
	private Address address;
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}

@Data
class Address {
	private int id;
	private String city;
	private String state;
	private Emp emp;
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", emp=" + emp + "]";
	}
	
}


public class Practice {
	public static void main(String[] args) {
		Emp emp=new Emp();
		emp.setId(111);
		emp.setName("abc");
		Address adr=new Address();
		adr.setId(555); adr.setCity("indore"); adr.setState("mp");
		adr.setEmp(emp);
		emp.setAddress(adr);
		System.out.println(emp);
		
		String result = "Info  : "+emp;
		System.out.println(result);
		
	}
}

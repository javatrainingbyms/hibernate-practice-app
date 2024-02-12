package in.serosoft;

public class Demo {
	public void show() {
		Runnable r1=new Runnable() {
			public void run() {
				Runnable r3=new Runnable() {
					public void run() {}
				};
			}
		};
		Runnable r2=new Runnable() {
			public void run() {}
		};
	}
	
	class Test
	{}
}

package in.serosoft;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
	public static SessionFactory getSF() {
		Configuration configuration=new Configuration().configure();
		SessionFactory sf=configuration.buildSessionFactory();
		return sf;
	}
}

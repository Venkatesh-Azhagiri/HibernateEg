package hibernateMethods;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class HibernateLock {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		Person person  = new Person();
		person.setName("Venkatesh");
		person.setAge("28");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(person);		
		transaction.commit();
		session.close();
		
		
	
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		session.lock("1", person, LockMode.WRITE); // will throw exception since its write and update below
		//session.lock("1", person, LockMode.NONE); // it will work fine
		//person.setName("Venkatesh1");
		Person p1 = (Person)session.get(Person.class, 1);
		System.out.println("p1 "+p1.getName());
		transaction.commit();
		session.close();
	}

}

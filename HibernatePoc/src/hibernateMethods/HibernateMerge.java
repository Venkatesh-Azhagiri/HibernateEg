package hibernateMethods;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class HibernateMerge {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		Person person  = new Person();
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		person = (Person)session.get(Person.class,1);
		transaction.commit();
		session.close();
		System.out.println("name "+person.getName());
		
		person.setName("Venkatesh");
		
		session = factory.openSession();
		transaction = session.beginTransaction();
		Person p1 = (Person)session.get(Person.class, 1);
		session.merge(person);		
		transaction.commit();
		session.close();
		System.out.println("after merge "+person.getName());

	}

}

package hibernateMethods;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class HibernateMethods {

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
		
		//throws persistentobjectException
		person.setName("Venkatesh1");
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.persist(person);
		transaction.commit();
		session.close();
		

	}

}

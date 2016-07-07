package collectionEg1;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class CollectionMainEg1 {

	public static void main(String[] args) {
		
		//Not working yet to hibernate jars for element collection
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setUserName("Venkatesh");
		Address address = new Address();
		address.setCity("Chennai");
		address.setStreetName("Valluvar");
		Address address1 = new Address();
		address1.setCity("Bangalore");
		address1.setStreetName("IT World");
		
		user.getListOfAddress().add(address);
		user.getListOfAddress().add(address1);
		session.save(user);
		transaction.commit();
		session.close();
		
		//Named query example
		/*session = factory.openSession();
		Query query = session.getNamedQuery("UserInfo");
		query.setInteger(0, 1);
		User user1 = (User)query.list();
		System.out.println("User user1 "+user1.getUserName());*/
		
	}

}

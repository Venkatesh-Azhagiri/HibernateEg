package EmbeddedEg1;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainEmbeddedEg {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Address address = new Address();
		address.setCity("Chennai");
		address.setCountry("India");
		AddressType addressType = new AddressType();
		addressType.setLocation("Vinayagar Temple");
		addressType.setStreetName("Valluvar");
		address.setAddressType(addressType);
		session.save(address);
		transaction.commit();
		Query query = session.createQuery("From Address");
		Address add = (Address)query.list().get(0);
		System.out.println("Country "+add.getCountry());
		session.close();

	}

}

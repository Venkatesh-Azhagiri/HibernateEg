package Many.to.Many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainManytoMany {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Event event = new Event();
		Delegate delegate = new Delegate();
		List<Delegate> delegateList =(List<Delegate>) session.createQuery("from Delegate").list();
		for(Delegate delegateItr: delegateList){
			System.out.println("DelegateId "+delegateItr.getDelegateId());
			System.out.println("DelegateName "+delegateItr.getDelegateName());
			System.out.println("Event Id "+delegateItr.getEventList().get(0).getEventId());
			System.out.println("Event Name "+delegateItr.getEventList().get(0).getEventName());
		}
		
		//constructSaveDate(event, delegate);
		//session.save(event);
		//session.save(delegate);
		transaction.commit();
		session.close();

	}

	private static void constructSaveDate(Event event, Delegate delegate) {
		event.setEventName("Java Learning");
		List<Delegate> delegateList = new ArrayList<Delegate>();
		delegate.setDelegateName("Venkatesh");
		delegateList.add(delegate);	
		event.setDelegateList(delegateList);		
	}

}

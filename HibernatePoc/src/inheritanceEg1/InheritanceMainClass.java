package inheritanceEg1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class InheritanceMainClass {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory  factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		/*Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Motor");
		TwoWheeler two =  new TwoWheeler();
		two.setHonda("Unicorn");
		Car car = new Car();
		car.setJaguar("WhiteJaguar");		
		session.save(vehicle);
		session.save(two);
		session.save(car);*/
		
		//Named Query Eg
		/*Query query = session.getNamedQuery("vehicle_info");
		query.setInteger(0, 1);	
		
		List<Vehicle> list = query.list();
		System.out.println(" size "+list.size());	
		
		System.out.println("Vehicle  "+list.get(0).getVehicleName());
		
		//Criteria Eg
		Criteria criteria = session.createCriteria(Vehicle.class);
		criteria.add(Restrictions.eq("vehicleName", "Motor"));
		List<Vehicle> vehicleList = (List<Vehicle>)criteria.list();
		System.out.println("Criteria  "+vehicleList.get(0).getVehicleId());
		
		
		transaction.commit();
		session.close();*/
		
		//Second level Eg
		
		session =factory.openSession();
		transaction = session.beginTransaction();
		Vehicle vehicle1 = (Vehicle)session.get(Vehicle.class, 1);
		
		System.out.println("vehicle1  "+vehicle1.getVehicleId());
		session.saveOrUpdate(vehicle1);
		vehicle1.setVehicleName("Test1");
		transaction.commit();
		//session.close();
		
		//session =factory.openSession();
		transaction = session.beginTransaction();
		//Vehicle vehicle2 = (Vehicle)session.get(Vehicle.class, 1);
		System.out.println("vehicle2  "+vehicle1.getVehicleId());
		vehicle1.setVehicleName("Test2");
		session.saveOrUpdate(vehicle1);
		vehicle1.setVehicleName("Test1");
		transaction.commit();
		//Diff between get and load
		Vehicle veh = (Vehicle)session.load(Vehicle.class, new Integer(1));
		
		System.out.println("Load "+veh.getVehicleId());
		System.out.println("Load "+veh.getVehicleName());
		session.close();

	}

}

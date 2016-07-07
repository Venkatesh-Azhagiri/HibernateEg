import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import one.to.one.mapping.EmployeeDetails;
import one.to.one.mapping.Employees;

public class Mainonetone {

	public static void main(String[] args) {
		/*Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction trs = session.beginTransaction();
		trs.commit();
		session.close();*/
		Employees employee = new Employees();
		employee.setEmployeeName("VENKATESH");
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setAddress("Chennawi");
		empDetails.setDesignation("Software Engineer");
		empDetails.setEmployee(employee);
		//employee.setEmpDetails(empDetails);
		
		Employees employee1 = new Employees();
		employee1.setEmployeeName("VENKATESH1");
		EmployeeDetails empDetails1 = new EmployeeDetails();
		empDetails1.setAddress("Chennai1");
		empDetails1.setDesignation("Software Engineer");
		empDetails1.setEmployee(employee1);
		//employee1.setEmpDetails(empDetails1);
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(empDetails);
		
		/*EmployeeDetails empdet =(EmployeeDetails)session.get(EmployeeDetails.class, 2);
		System.out.println("empdet  "+empdet.getEmployee().getEmployeeId());*/
		//Employees emp = (Employees)session.get(Employees.class, 1);
		//System.out.println("emp "+emp.getEmployeeId());

		//session.save(empDetails1);
		System.out.println("tet");
		transaction.commit();
		
		
		
	}	

}

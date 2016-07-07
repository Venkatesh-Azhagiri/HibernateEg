package one.to.many.mapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainonetoManyClass {

	public static void main(String[] args){
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		
		College college = new College();
		Student student = new Student();
		//constructObjectData(college, student);
		Transaction transaction  = session.beginTransaction();		
		//session.save(student);
		
		
		List<Student> studentList = (List<Student>)session.createQuery("from Student").list();
		for(Student student1: studentList){
			System.out.println("Student Id "+student1.getStudentId());
			//System.out.println("College Id  "+student1.getCollege().getCollegeId());
			
		}
		
		/*
		List<College> collegeList = (List<College>)session.createQuery("from College").list();
		for(College college1: collegeList){
			System.out.println("College Id "+college1.getCollegeId());
			System.out.println("College  Name  "+college1.getCollegeName());
			
			
			Set<Student> studentSet = college1.getStudentSet();
			for(Student detail: studentSet){
				System.out.println("Student City  "+detail.getCity());
			}
		}*/
		transaction.commit();
		session.close();
		
		
		
		

	}

	private static void constructObjectData(College college, Student student) {
		college.setCollegeName("S.A");
		student.setCity("Chennai");
		student.setState("TamilNadu");
		student.setCountry("India");
		student.setCollege(college);
		
	}

}

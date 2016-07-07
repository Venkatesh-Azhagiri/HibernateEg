package one.to.one.mapping.eg2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class WorkerMainClass {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		
		Worker worker = new Worker();
		WorkerDetail workerDetail = new WorkerDetail();
		//constructObjectData(worker, workerDetail);
		Transaction transaction  = session.beginTransaction();		
		//session.save(worker);
		
		
		/*List<WorkerDetail> workerDetailList = (List<WorkerDetail>)session.createQuery("from WorkerDetail").list();
		for(WorkerDetail wrkDetail: workerDetailList){
			System.out.println("Worker Id "+wrkDetail.getWorkerId());
			System.out.println("Worker First Name  "+wrkDetail.getWorker().getFirstName());
			System.out.println("Worker Last Name  "+wrkDetail.getWorker().getLastName());
			System.out.println("Worker City  "+wrkDetail.getCity());
			
		}*/
		
		
		List<Worker> workerlList = (List<Worker>)session.createQuery("from Worker").list();
		for(Worker wrkDetail: workerlList){
			System.out.println("Worker Id "+wrkDetail.getWorkerId());
			System.out.println("Worker First Name  "+wrkDetail.getFirstName());
			System.out.println("Worker Last Name  "+wrkDetail.getLastName());
			System.out.println("Worker City  "+wrkDetail.getWorkerDetail().getCity());
			
		}
		transaction.commit();
		session.close();
		
		
		

	}

	private static void constructObjectData(Worker worker, WorkerDetail workerDetail) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try{
			dt =sdf.parse("2016-04-09");
		}catch(Exception e){
			e.printStackTrace();
		}
		worker.setBirthDate(dt);
		worker.setCellPho("9884558968");
		worker.setFirstName("Venkatesh");
		worker.setLastName("Azhagiri");
		workerDetail.setCity("Chennai");
		workerDetail.setCountry("India");
		workerDetail.setState("TamilNadu");
		workerDetail.setStreet("Valluvar");
		worker.setWorkerDetail(workerDetail);
		workerDetail.setWorker(worker);
		
	}

}

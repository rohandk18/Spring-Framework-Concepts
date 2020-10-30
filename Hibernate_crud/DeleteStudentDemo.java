package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create a session factory
		SessionFactory factory =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		
		try {
			//create session
			Session session = factory.getCurrentSession();
	
			session.beginTransaction(); 
			
			
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			//commit the transaction
			
			session.getTransaction().commit();
	
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
	}

}

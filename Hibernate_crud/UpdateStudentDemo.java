package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			int studentId = 1;
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student");
			
			//update firstName to scooby
			
			myStudent.setFirstName("scooby");
            //commit the transaction
			
			session.getTransaction().commit();
			
		
			System.out.println("Done");
			
			
			//Multi Update ;)
			
			
			 session = factory.getCurrentSession();
			
			session.beginTransaction(); 
			
			
			session.createQuery("update Student set email='luv2code.com'").executeUpdate();
			
			//commit the transaction
			
			session.getTransaction().commit();
	
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
	}

}

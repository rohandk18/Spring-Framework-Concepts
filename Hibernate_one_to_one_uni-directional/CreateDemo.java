package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create a session factory
		SessionFactory factory =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//create the objects
			
			/*
			 * Instructor tempinstructor = new
			 * Instructor("Chad","darby","darby@luv2code.com");
			 * 
			 * InstructorDetail tempinstructordetail = new
			 * InstructorDetail("xyz/youtube","soccer");
			 */
			
			Instructor tempinstructor = new Instructor("Madhu","Patel","darby@luv2code.com");
			
			InstructorDetail tempinstructordetail = new InstructorDetail("abc/youtube","Guitar");
		
			//associate the objects
			
			tempinstructor.setInstructorDetail(tempinstructordetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			
			System.out.println("Saving instructor:"+tempinstructor);
			
			session.save(tempinstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

}

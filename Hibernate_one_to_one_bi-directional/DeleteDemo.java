package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
		
			
			
			//start a transaction
			session.beginTransaction();
			
			
			//get instructor by primary key/id
			
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: "+tempInstructor);
			
			//delete the instructor
			
			if(tempInstructor!=null)
			{
				System.out.println("Deleting: "+tempInstructor);
				
				//Note:will also delete associated "details" object
				
				//because of CascadeType.ALL

				session.delete(tempInstructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

}

package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			
			int theId = 3;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the associated instructor
			
			System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
			
			
			//now let's delete the instructor detail
			
			System.out.println("Deleting tempInstructorDetail: "+tempInstructorDetail);
			
			session.delete(tempInstructorDetail);
			
			
			//remove the associated object reference
			//break bi-directional reference
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

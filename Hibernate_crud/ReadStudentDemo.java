package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create a session factory
		SessionFactory factory =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save Java object
			
			//create a student object
			
			  System.out.println("Creating a new student object"); Student tempStudent =
			  new Student("Daffy","daffy","daffy@luvtocode.com");
			  
			  //start a transaction session.beginTransaction();
			  
			  //save the student object System.out.println("saving the student...");
			  session.save(tempStudent);
			 
			
			//commit transaction
			session.getTransaction().commit();
			
			//find out the student's id:primary key
			
			System.out.println("saved student,Generated id:"+tempStudent.getId());
			
			//now get a new session and start transaction
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrive student based on the id:primary key
			
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			//commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
	}

}

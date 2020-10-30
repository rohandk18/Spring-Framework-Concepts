package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import hibernate.demo.entity.Student;

public class QuerryStudentDemo {

	public static void main(String[] args) {
		
		//create a session factory
		SessionFactory factory =  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//start a transaction
			session.beginTransaction();
			
			// querry students
			
			List<Student> theStudents = session.createQuery("from Student").list();
			
			
			//display the students
			
			displayStudents(theStudents);
			
			System.out.println("----------------------------------");
			
			//querry students:lastName:Daffy
			
			 theStudents = session.createQuery("from Student s where s.lastName='daffy'").list();
			
			//querry students:lastName:Daffy
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.firstName='paul'").list();
			
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent:theStudents)
		{
			System.out.println(tempStudent);
		}
	}

}

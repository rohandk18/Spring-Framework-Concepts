package springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp 
{

	public static void main(String[] args) 
	{
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from the spring container
		
		Coach theCoach = context.getBean("myCoach",Coach.class);  //id=myCoach  interface = Coach
		
		//call methods on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		//close context
		
		context.close();
		

	}

}

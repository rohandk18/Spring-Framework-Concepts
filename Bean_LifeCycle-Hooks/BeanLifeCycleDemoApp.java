package springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp 
{

	public static void main(String[] args) 
	{
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean-LifeCylce-applicationContext.xml");
		
		//retrieve bean from the spring container
		
		Coach theCoach = context.getBean("myCoach",Coach.class);  //id=myCoach  interface = Coach
		
		//call methods on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		//call fortune methods 
		
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		
		context.close();
		

	}

}

package springDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//add the annotation
@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneservice; //  constructor injection
	
	/*
	 * @Autowired public TennisCoach(FortuneService fortuneservice) {
	 * this.fortuneservice = fortuneservice; }
	 */
	
	//setter injection
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneservice) {
	 * System.out.println("Inside setter method"); this.fortuneservice =
	 * fortuneservice; }
	 */
	
	public TennisCoach()
	{
		System.out.println("Inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}
	
	@PostConstruct
	public void doMystartupStuff()
	{
		System.out.println("TennisCoach:inside of doMystartupStuff method");
	}
	
	@PreDestroy
	public void doMycleanupStuff()
	{
		System.out.println("TennisCoach:inside of doMyCleanupStuff method");
	}

}

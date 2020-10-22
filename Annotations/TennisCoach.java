package springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//add the annotation
@Component
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

}

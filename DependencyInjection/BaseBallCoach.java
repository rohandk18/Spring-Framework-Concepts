package springDemo;

public class BaseBallCoach implements Coach
{
	//define the private field for the dependancy
	
	private FortuneService fortuneservice;
	
	public BaseBallCoach(FortuneService fortuneservice)
	{
		this.fortuneservice = fortuneservice;
	}
	
     public String getDailyWorkout()
     {
    	 return "Spend 30 mins on batting practice";
     }

	@Override
	public String getDailyFortune() {
		// use FortuneService to get a fortune
		
		
		return fortuneservice.getFortune();
	}
}

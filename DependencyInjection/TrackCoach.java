package springDemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneservice;
	
	public TrackCoach(FortuneService fortuneservice)
	{
		this.fortuneservice = fortuneservice;
	}
	
	@Override
	public String getDailyWorkout() 
	{
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}

}

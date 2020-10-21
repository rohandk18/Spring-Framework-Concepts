package springDemo;

public class CricketCoach implements Coach
{
	private FortuneService fortuneservice;
	
	private String emailAddress;
	private String team;
	
	//no arg constructor
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach:Setter Method:Email Address");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach:Setter Method:Team");
	}

	public CricketCoach()
	{
		System.out.println("CricketCoach:No arg ctor");
	}
	
	public void setFortuneService(FortuneService fortuneservice)
	{
		this.fortuneservice = fortuneservice;
		System.out.println("CricketCoach:Setter Method");
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 mins a day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}

}

package org.cricket.manager;

public class Match {

	private Team first;
	private Team second;
	
	private Batsman striker = null;
	private Batsman non_striker = null;
	
	private Bowler bowler = null;
	
	
	void startPlay () {
		
		//bowler = second.getNextBowler ();
		
		Batsman test = new Batsman ();
		
		for (int i = 0;i < 6;i++) {
			Shot s = test.bat(null);			
			System.out.printf("It is %s%n", s.result);
		}
	}
}

package org.cricket.manager;

public class Match {

	private Team first;
	private Team second;
	
	private Batsman striker = null;
	private Batsman non_striker = null;
	
	private Bowler bowler = null;
	
	private final int num_of_overs = 20;
	
	private final int TOTAL_WICKETS = 10;
	
	private int current_wickets = 0;
	private int inningsRun = 0;
	
	
	void startPlay () {
		//bowler = second.getNextBowler ();
		striker = new Batsman ();
		
		for (int i = 0;i < 20;i++) {
			System.out.println("Starting over number " + (i+1));
			if (this.startOver() < 0)
				return;
		}
	}
	
	int startOver () {
		for (int i = 0;i < 6;i++) {
			Shot s = striker.bat(null);			
			System.out.printf("It is %s%n", s.result);
			
			// analyze result ....
			analyzeResult(s);
			
			System.out.println("The score is " + 
								this.inningsRun + 
								" for " + 
								this.current_wickets);
			
			if (current_wickets == 10)
				return -1;
		}	
		return 0;
	}

	private void analyzeResult(Shot s) {
		// TODO Auto-generated method stub
		switch (s.result) {
		case OUT:
			this.current_wickets++;
			break;
		case SINGLE:
			this.inningsRun++;
			break;
		case TWO:
			this.inningsRun += 2;
			break;
		case THREE:
			this.inningsRun += 3;
			break;
		case FOUR:
			this.inningsRun += 4;
			break;
		case SIX:
			this.inningsRun += 6;
			break;
		}
	}
}

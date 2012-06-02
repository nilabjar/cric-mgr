package org.cricket.manager;

import org.cricket.manager.entity.Batsman;

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
	
	private int firstTeamRun = 0;
	private int secondTeamRun = 0;
	
	private int currentOver = 0;
	
	private boolean chasing = false;
	
	void startPlay () {
		
		// toss 
		
		// first innings ....
		
		System.out.println ("Starting First Innings");
		startInnings (first);
		
		this.firstTeamRun = this.inningsRun;
		//second innings ... 
		
		System.out.println ("\nInnings Over : Total " + firstTeamRun);
		
		reset ();
		
		System.out.println ("\nStarting Second Innings: Target " + (firstTeamRun + 1));
		Sleep (10000);
		
		chasing = true;
		startInnings (second);

		this.secondTeamRun = this.inningsRun;
		// result ....
		
		System.out.println((firstTeamRun > secondTeamRun) ? "First Team Wins" : "Second Team Wins");
		
		//matchResult ();
		

	}
	
	private void reset() {
		// TODO Auto-generated method stub
		current_wickets = 0;
		inningsRun = 0;
		currentOver = 0;
	}

	private void startInnings(Team team) {
		// TODO Auto-generated method stub
		//bowler = second.getNextBowler ();
		striker = new Batsman ();
		
		for (int i = 0;i < 20;i++) {
			currentOver++;
			print ("\n");
			System.out.println("Starting over number " + (i+1));
			print ("\n");
			if (this.startOver() < 0)
				return;
			
			Sleep (1000);
		}
		
	}
	
	public void Sleep (int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int startOver () {
		for (int i = 0;i < 6;i++) {
			Shot s = striker.bat(null);			
			System.out.println(currentOver + "." + (i+1) + " : " + s.result);
			
			// analyze result ....
			analyzeResult(s);			
			
			if (current_wickets == 10)
				return -1;
			if (chasing) {
				if (this.inningsRun > firstTeamRun)
					return -1;
			}
		}
				
		printScore ();
		return 0;
	}
	
	private void printScore () {
		print ("\n");
		
		System.out.println("The score is " + 
				this.inningsRun + 
				" for " + 
				this.current_wickets +
				" in " + 
				this.currentOver + 
				" overs " + 
				(chasing ? ("Chasing " + this.firstTeamRun) : ""));
		
		print ("\n");
	}
	
	private void print (String s) {
		System.out.println (s);
	}

	private void analyzeResult(Shot s) {
		// TODO Auto-generated method stub
		switch (s.result) {
		case OUT:
			out ();
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

	private void out () {
		this.current_wickets++;
		
		//Sleep (5000);
		
		//print ("\nNew batsman walks in : Play Resumes");
		
		//printScore ();
		//Sleep (10000);
	}
}

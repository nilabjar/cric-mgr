package org.cricket.manager.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.cricket.manager.Delivery;
import org.cricket.manager.Delivery.Length;
import org.cricket.manager.Delivery.Line;

public class Bowler extends Player {

	public Bowler () {
		this.populateProbs();
		this.createArray();
	}
	
	Map<Length , Double> LengthProbs = new HashMap<Length, Double> ();
	Map<Line , Double> LineProbs = new HashMap<Line, Double> ();
	
	public void populateProbs () {
		LengthProbs.put(Length.YORKER, 0.1);
		LengthProbs.put(Length.GOOD_LENGTH , 0.2);
		LengthProbs.put(Length.HALF_VOLLEY, 0.2);
		LengthProbs.put(Length.SHORT_OF_LENGTH, 0.2);
		LengthProbs.put(Length.SHORT, 0.2);
		LengthProbs.put(Length.FULL_TOSS, 0.1);
		
		LineProbs.put(Line.X_OUTSIDE_LEG, 0.05);
		LineProbs.put(Line.OUTSIDE_LEG, 0.05);
		LineProbs.put(Line.WICKET, 0.3);
		LineProbs.put(Line.X_OUTSIDE_OFF, 0.2);
		LineProbs.put(Line.OUTSIDE_OFF, 0.4);
	}
	
	private Length[] lengthData = null;
	private Line[] lineData = null;
	public void createArray () {
		
		// create array for LengthProbs ... 
		lengthData= new Length [100];
		// initialize ...
		int i = 0;
		for (; i < LengthProbs.get(Length.YORKER)*100;i++)
			lengthData[i] = Length.YORKER;
		int temp = i;
		for (; i < temp+LengthProbs.get(Length.HALF_VOLLEY)*100;i++)
			lengthData[i] = Length.HALF_VOLLEY;
		temp = i;
		for (; i < temp+LengthProbs.get(Length.GOOD_LENGTH)*100;i++)
			lengthData[i] = Length.GOOD_LENGTH;
		temp = i;
		for (; i < temp+LengthProbs.get(Length.SHORT_OF_LENGTH)*100;i++)
			lengthData[i] = Length.SHORT_OF_LENGTH;
		temp = i;
		for (; i < temp+LengthProbs.get(Length.SHORT)*100;i++)
			lengthData[i] = Length.SHORT;
		temp = i;
		for (; i < temp+LengthProbs.get(Length.FULL_TOSS)*100;i++)
			lengthData[i] = Length.FULL_TOSS;
		
		// create array for Line ...
		lineData= new Line [100];
		// initialize ...
		i = 0;
		for (; i < LineProbs.get(Line.X_OUTSIDE_OFF)*100;i++)
			lineData[i] = Line.X_OUTSIDE_OFF;
		temp = i;
		for (; i < temp+LineProbs.get(Line.OUTSIDE_OFF)*100;i++)
			lineData[i] = Line.OUTSIDE_OFF;
		temp = i;
		for (; i < temp+LineProbs.get(Line.WICKET)*100;i++)
			lineData[i] = Line.WICKET;
		temp = i;
		for (; i < temp+LineProbs.get(Line.OUTSIDE_LEG)*100;i++)
			lineData[i] = Line.OUTSIDE_LEG;
		temp = i;
		for (; i < temp+LineProbs.get(Line.X_OUTSIDE_LEG)*100;i++)
			lineData[i] = Line.X_OUTSIDE_LEG;
	}
	
	private Length currentBallLength = null;
	private Line currentBallLine = null;
	public Delivery bowl () {
		
		simulate ();
		return new Delivery();
	}
	
	static private Random generator = new Random ();
	
	private void simulate() {
		// TODO Auto-generated method stub
		// get the length ...
		int res = generator.nextInt(100);
		
		Length cur = lengthData[res];
		
		res = generator.nextInt(100);
		
		Line curLine = lineData[res];
		
		System.out.println("The current ball is " + cur + " " + curLine);
	}
}

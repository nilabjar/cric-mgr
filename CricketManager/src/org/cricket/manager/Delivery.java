package org.cricket.manager;



public class Delivery {
	
	public enum Length {
		YORKER,
		HALF_VOLLEY,
		GOOD_LENGTH,
		SHORT_OF_LENGTH,
		SHORT,
		FULL_TOSS
	}
	
	public enum Line {
		X_OUTSIDE_OFF,
		OUTSIDE_OFF,
		WICKET,
		OUTSIDE_LEG,
		X_OUTSIDE_LEG
	}
	
	private Length length;
	private Line line;
	
	
	
	public Delivery (Length length, Line line) {
		this.length=length;
		this.line=line;
	}



	public Length getLength() {
		return length;
	}



	public Line getLine() {
		return line;
	}


}

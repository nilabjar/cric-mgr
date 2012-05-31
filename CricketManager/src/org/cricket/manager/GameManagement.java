package org.cricket.manager;


public class GameManagement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameManagement gameManager = new GameManagement ();
		
		gameManager.showInitOptions();
		
		Game g = gameManager.LoadGame();
		
		g.startMatch();

	}
	
	void showInitOptions () {
		
	}
	
	Game LoadGame () {
		return new Game ();
	}
	
	

}

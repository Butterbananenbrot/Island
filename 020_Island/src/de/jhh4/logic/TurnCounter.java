package de.jhh4.logic;

import de.jhh4.backend.HighscoreCenter;

/**
 * records which turn it is
 */
public class TurnCounter {
	
	/** represents the current turn */
	private static int turn = 1;

	/**
	 * @return the turn
	 */
	public static int getTurn() {
		return turn;
	}

	/**
	 * @param turn the turn to set
	 */
	public static void setTurn(int turn) {
		TurnCounter.turn = turn;
	}


}

package de.jhh4.logic;

/**
 * keeps track of the score attained throughout the game
 * currently stone is treated as gold and used for scoring purposes
 * this can be changed in future versions
 */
public class ScoreCounter {
	
	/**
	 * records the score
	 */
	private static int score = 0;
	
	/**
	 * increases the score by the given number
	 * @param number to be added to the score
	 */
	public static void increaseScore(int number) {
		score = score + number;
//		System.out.println("Debug: increaseScore was called");
	}

	/**
	 * @return the score
	 */
	public static int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public static void setScore(int score) {
		ScoreCounter.score = score;
	}


	

}

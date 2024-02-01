package de.jhh4.logic;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import de.jhh4.backend.HighscoreCenter;
import de.jhh4.gui.IslandView;
import de.jhh4.gui.MainWindow;
import de.jhh4.tiles.Tile;
/**
 * manages the increase in turns and score when pressing the "next turn" button
 */
public class TurnManager {

	/** this array contains the information for map creation */
	private Tile[][] island;
	
	/** this is the visual representation of the Tile array within the GUI */
	private IslandView islandView;
	
	/** reference to the main window JFrame */
	private MainWindow mainWindow;
	
	/** reference to the logic hub */
	private LogicCenter logicCenter;
	
	
	/** the object gets references to all the important objects of the GUI and the array */
	public TurnManager (Tile[][] island, IslandView islandView, MainWindow mainWindow) {
		this.island = island;
		this.islandView = islandView;
		this.mainWindow = mainWindow;
	}
	
	/**
	 * end the current turn and starts the next one
	 * collects ressources through the manager and adds them to storage
	 * at turn 10, saves highscore and displays message - popup window?
	 * 
	 * most of this was written by ChatGPT 4.0 using an earlier version using the prompt:
	 * 		please write me a method or an extra class that brings up a pop-up window in my Swing GUI 
	 * 		which displays the attained score and allows the user to input their name for the highscore list.
	 */
	public void nextTurn() {
		RealEstateManager.collectAllRessources();
		TurnCounter.setTurn(TurnCounter.getTurn()+1);

		if (TurnCounter.getTurn() == 20) {
	        // Calculate and display score
	        int score = ScoreCounter.getScore();
	        String message = "You mined " + Storage.getStoneInStorage() + " gold! Enter your name for the highscore list:";
	        
	        // Show input dialog to get the player's name
	        String playerName = JOptionPane.showInputDialog(null, message, "Highscore Entry", JOptionPane.PLAIN_MESSAGE);
	        
	        // If player doesn't enter a name, use a default name
	        if (playerName == null || playerName.trim().isEmpty()) {
	            playerName = "Unknown Player";
	        }

	        // Save score with the player's name
	        logicCenter.getHighScoreCenter().saveScore(playerName, score);

	        // Display confirmation
	        JOptionPane.showMessageDialog(null, "Your score of " + score + " was saved as " + playerName + ". You may continue playing!", "Score Saved", JOptionPane.INFORMATION_MESSAGE);
	        
	        // Reload the highscore list to be viewed later
	        String newText = logicCenter.getHighScoreCenter().getHighscoresForDisplay();
	        mainWindow.getHighscores().getTextArea().setText(newText);
	    }
	}


	/**
	 * @return the logicCenter
	 */
	public LogicCenter getLogicCenter() {
		return logicCenter;
	}


	/**
	 * @param logicCenter the logicCenter to set
	 */
	public void setLogicCenter(LogicCenter logicCenter) {
		this.logicCenter = logicCenter;
	}
	
}

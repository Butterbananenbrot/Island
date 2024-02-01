package main;

import de.jhh4.gui.IslandView;
import de.jhh4.gui.MainWindow;
import de.jhh4.logic.IslandMaker;
import de.jhh4.logic.LogicCenter;
import de.jhh4.logic.PieceMover;
import de.jhh4.logic.TurnManager;
import de.jhh4.pieces.Worker;
import de.jhh4.tiles.Tile;

/**
 * the main entry point for the program
 * execute this to play the game
 * also used for testing
 */
public class Main {

	/**
	 * the main thread for the program
	 * starts the GUI thread
	 * builds all the major objects for GUI, logic, etc.
	 * @param args not used here
	 */
	public static void main(String[] args) {
		
		// build the GUI
		MainWindow gui = new MainWindow();
		
		// build the logic objects, create a randomized island, create the associated buttons
		IslandMaker islandMaker = new IslandMaker(gui);
		Tile[][] island = islandMaker.createRandomIsland(11, 11);	// these parameters decide the size of the island		
		PieceMover pieceMover = new PieceMover(island, gui);
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[i].length; j++) {
				island[i][j].getButton().setPieceMover(pieceMover);
			}
		}
		TurnManager turnManager = new TurnManager(island, gui.getIslandViewContainer().getIslandView(), gui);
		LogicCenter logicCenter = new LogicCenter(island, islandMaker, pieceMover, turnManager, gui, gui.getHighscores().getHighscoreCenter());
		
		//place a settler on the central tile
		pieceMover.setUpNewGame();
		
		// start the GUI thread
		gui.setVisible(true);
		
	}

}

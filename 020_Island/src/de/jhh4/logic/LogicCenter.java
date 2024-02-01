package de.jhh4.logic;

import de.jhh4.backend.HighscoreCenter;
import de.jhh4.gui.MainWindow;
import de.jhh4.tiles.Tile;

/** provides references to the logic objects which handle the game progress */
public class LogicCenter {

	/** the Tile array which represents the current state of the game as well as the terrain */
	private Tile[][] island;
	
	/** makes the Tile array */
	private IslandMaker islandMaker;
	
	/** creates and moves pieces */
	private PieceMover pieceMover;
	
	/** advances turns */
	private TurnManager turnManager;
	
	/** a Link from this logic hub to the GUI hub */
	private MainWindow mainWindow;
	
	/** a link to the HighScore Center */
	private HighscoreCenter highScoreCenter;

	/**
	 * this hub gets all the references
	 * @param island
	 * @param islandMaker
	 * @param pieceMover
	 * @param turnManager
	 */
	public LogicCenter(Tile[][] island, IslandMaker islandMaker, PieceMover pieceMover, 
			TurnManager turnManager, MainWindow mainWindow, HighscoreCenter highScoreCenter) {
		this.island = island;
		this.islandMaker = islandMaker;
		this.pieceMover = pieceMover;
		this.turnManager = turnManager;
		this.mainWindow = mainWindow;
		this.highScoreCenter = highScoreCenter;
		
		pieceMover.setLogicCenter(this);
		mainWindow.setLogicCenter(this);
		turnManager.setLogicCenter(this);
		
	}

	/**
	 * @return the island
	 */
	public Tile[][] getIsland() {
		return island;
	}

	/**
	 * @return the islandMaker
	 */
	public IslandMaker getIslandMaker() {
		return islandMaker;
	}

	/**
	 * @return the pieceMover
	 */
	public PieceMover getPieceMover() {
		return pieceMover;
	}

	/**
	 * @return the turnManager
	 */
	public TurnManager getTurnManager() {
		return turnManager;
	}

	/**
	 * @param island the island to set
	 */
	public void setIsland(Tile[][] island) {
		this.island = island;
	}

	/**
	 * @param islandMaker the islandMaker to set
	 */
	public void setIslandMaker(IslandMaker islandMaker) {
		this.islandMaker = islandMaker;
	}

	/**
	 * @param pieceMover the pieceMover to set
	 */
	public void setPieceMover(PieceMover pieceMover) {
		this.pieceMover = pieceMover;
	}

	/**
	 * @param turnManager the turnManager to set
	 */
	public void setTurnManager(TurnManager turnManager) {
		this.turnManager = turnManager;
	}

	/**
	 * @return the highScoreCenter
	 */
	public HighscoreCenter getHighScoreCenter() {
		return highScoreCenter;
	}

	/**
	 * @param highScoreCenter the highScoreCenter to set
	 */
	public void setHighScoreCenter(HighscoreCenter highScoreCenter) {
		this.highScoreCenter = highScoreCenter;
	}
	
	
	
	
}

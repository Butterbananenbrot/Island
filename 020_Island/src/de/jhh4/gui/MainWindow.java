package de.jhh4.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import de.jhh4.logic.LogicCenter;
import de.jhh4.pieces.Settler;
import de.jhh4.tiles.Tile;

/**
 * Provides the enclosing structure for the main menu, map and other components.
 */
public class MainWindow extends JFrame {

	/** Links the main menu to the main window as an attribute. */
	private MainMenu mainMenu;
	
	/** Links the map to the main window as an attribute */
	private IslandViewContainer islandViewContainer;
	
	/** Links the logic hub to this GUI hub */
	private LogicCenter logicCenter;
	
	/** Links the highscore display to the main window as an attribute */
	private Highscores highscores;
	
	/** Links the credits display to the main window as an attribute */
	private Credits credits;
	
	/** The program uses CardLayout to switch between menus and the map */
	private CardLayout cardLayout = new CardLayout();
	
	

	/** Constructs the main window including its subordinate containers:
	 * main menu, map, ....
	 * use the gameMap constructor to set the size of the map!
	 * TODO let the user set the size of the map
	 */
	public MainWindow() {
		super("Island");
		this.mainMenu = new MainMenu(this);
		this.islandViewContainer = new IslandViewContainer(this); // sets the size of the map
		this.highscores = new Highscores(this);
		this.credits = new Credits(this);

		setSize(900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//build the structure which includes the GUI Elements
		setLayout(cardLayout);
		
		add(mainMenu); // add to the CardLayout 
		cardLayout.addLayoutComponent(mainMenu, "MainMenu"); // fill a table for the CardLayout to find its contents
		
		add(islandViewContainer);
		cardLayout.addLayoutComponent(islandViewContainer, "GameMap");		
		
		add(highscores);
		cardLayout.addLayoutComponent(highscores, "Highscores");
		
		add(credits);
		cardLayout.addLayoutComponent(credits, "Credits");

	}


	/**
	 * @return the mainMenu
	 */
	public MainMenu getMainMenu() {
		return mainMenu;
	}

	/**
	 * @return the gameMap
	 */
	public IslandViewContainer getIslandViewContainer() {
		return islandViewContainer;
	}

	/**
	 * @return the highscores
	 */
	public Highscores getHighscores() {
		return highscores;
	}

	/**
	 * @return the credits
	 */
	public Credits getCredits() {
		return credits;
	}

	/**
	 * @return the cardLayout
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
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

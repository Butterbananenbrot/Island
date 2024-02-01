package de.jhh4.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import de.jhh4.logic.IslandMaker;
import de.jhh4.tiles.Tile;

/**
 * Adds the main map area, which includes the UI for the game itself and surrounding buttons and displays.
 */
public class IslandViewContainer extends JPanel{
	
	/** contains UI elements */
	private UpperPanel upperPanel;
	
	/** contains game rules */
	private LowerPanel lowerPanel;
	
	/** contains the island */
	private IslandView islandView;
	
	/** provides a reference to the highest container (JFrame) */
	private MainWindow mainWindow;

	/**
	 * constructs a new IslandViewContainer with an upperPanel (UI elements) but without an island display
	 * @param mainWindow the highest level container (JFrame)
	 */
	public IslandViewContainer(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		this.upperPanel = new UpperPanel(this);		
		add(upperPanel, BorderLayout.NORTH);
		this.setLowerPanel(new LowerPanel(this));
		add(getLowerPanel(), BorderLayout.SOUTH);
	}

	/**
	 * @return the mainWindow
	 */
	public MainWindow getMainWindow() {
		return mainWindow;
	}

	/**
	 * @return the upperPanel
	 */
	public UpperPanel getUpperPanel() {
		return upperPanel;
	}

	/**
	 * @return the islandView
	 */
	public IslandView getIslandView() {
		return islandView;
	}

	/**
	 * @param upperPanel the upperPanel to set
	 */
	public void setUpperPanel(UpperPanel upperPanel) {
		this.upperPanel = upperPanel;
	}

	/**
	 * @param islandView the islandView to set
	 */
	public void setIslandView(IslandView islandView) {
		this.islandView = islandView;
	}

	/**
	 * @param mainWindow the mainWindow to set
	 */
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/**
	 * @return the lowerPanel
	 */
	public LowerPanel getLowerPanel() {
		return lowerPanel;
	}

	/**
	 * @param lowerPanel the lowerPanel to set
	 */
	public void setLowerPanel(LowerPanel lowerPanel) {
		this.lowerPanel = lowerPanel;
	}
	
	

}

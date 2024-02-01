package de.jhh4.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.jhh4.pieces.Structure;
import de.jhh4.pieces.Town;
import de.jhh4.pieces.Unit;
import de.jhh4.tiles.Tile;

/**
 * this JPanel contains many JButtons which constitute the visual representation of the island
 */
public class IslandView extends JPanel {
	
	/** the parent container */
	private IslandViewContainer islandViewContainer;
	
	/** this array determines the composition of the map */
	private Tile[][] island;
	
	/** 
	 * constructs a new IslandView
	 * and add the previously built Buttons which are referenced in the Tile array to the IslandView one by one
	 * @param gameMap: parent container as a reference 
	 * @param terrainArray: as a model (different maps are possible)
	 * */
	public IslandView(IslandViewContainer islandViewContainer, Tile[][] island) {
		this.islandViewContainer = islandViewContainer;
		this.island = island;
		setLayout(new GridLayout(island.length,island.length));
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island.length; j++) {
				add(island[i][j].getButton());
			}
		}
	}

	/**
	 * @return the islandViewContainer
	 */
	public IslandViewContainer getIslandViewContainer() {
		return islandViewContainer;
	}

	/**
	 * @return the island
	 */
	public Tile[][] getIsland() {
		return island;
	}
	
	
}

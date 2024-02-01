package de.jhh4.tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

/** Oceans are at the border of the map and limit the game are, providing one food */
public class Ocean extends Tile {

	/**
	 *  constructs an Ocean object with a food output of 1
	 * @param row for location
	 * @param column
	 */
	public Ocean(int row, int column) {
		super(row, column, new ImageIcon("icons/ocean.png"), Color.BLUE);
		accessibleForWorkers = false;
		accessible = false;
//		color = Color.BLUE;
//		icon = new ImageIcon("icons/ocean.png");
		foodOutput = 0;
		woodOutput = 0;
		stoneOutput = 0;
	}
	

}

package de.jhh4.tiles;

import java.awt.Color;

import javax.swing.ImageIcon;
/**
 * Mountain tiles can currently be traversed to allow for worker placement of outposts/mines
 * provides gold/stone when worked
 */
public class Mountain extends Tile {

	/**
	 * constructs a new Mountain tile
	 * @param gridX the location
	 * @param gridY the location
	 */
	public Mountain(int row, int column) {
		super(row, column, new ImageIcon("icons/mountain.png"), Color.GRAY);
		accessibleForWorkers = true;
		accessible = false;
//		color = Color.GRAY;
//		icon = new ImageIcon("icons/mountain.png");
		foodOutput = 0;
		woodOutput = 0;
		stoneOutput = 1;
	}

}

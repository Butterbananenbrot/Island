package de.jhh4.tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

/** plains can be traversed and provide one food */
public class Plains extends Tile {

	/** 
	 * constructs a Plains object with a food output of 1
	 * @param row for location
	 * @param column for location
	 */
	public Plains(int row, int column) {
		super(row, column, new ImageIcon("icons/plains.png"), Color.YELLOW);
		accessibleForWorkers = true;
		accessible = true;
//		color = Color.YELLOW;
//		icon = new ImageIcon("icons/plains.png");
		foodOutput = 1;
		woodOutput = 0;
		stoneOutput = 0;
	}
	
}

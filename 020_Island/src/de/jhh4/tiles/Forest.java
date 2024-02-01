package de.jhh4.tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

/** forests can be traversed and provide one wood */
public class Forest extends Tile {

	/**
	 * constructs a Forest object with a wood output of 1 
	 * @param row for location
	 * @param column for location
	 */
	public Forest(int row, int column) {
		super(row, column, new ImageIcon("icons/forest.png"), Color.GREEN);
		accessibleForWorkers = true;
		accessible = true;
//		color = Color.GREEN;
//		icon = new ImageIcon("icons/forest.png");
		foodOutput = 0;
		woodOutput = 1;
		stoneOutput = 0;
	}

}

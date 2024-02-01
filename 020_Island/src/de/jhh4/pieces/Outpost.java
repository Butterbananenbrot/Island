package de.jhh4.pieces;

import javax.swing.ImageIcon;

import de.jhh4.tiles.Tile;

/**
 * extends the collection area to a specific tile
 * currently used to represent a mine to mine gold from Mountain tiles to increase score 
 */
public class Outpost extends Structure {
	
	/**
	 * constructor with parentTile
	 * @param parentTile on which the piece is located
	 */
	public Outpost (Tile parentTile) {
		this.parentTile = parentTile;
		icon = new ImageIcon("icons/mine.png");
	}
	
}

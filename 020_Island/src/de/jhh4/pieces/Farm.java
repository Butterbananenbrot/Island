package de.jhh4.pieces;

import javax.swing.ImageIcon;

import de.jhh4.tiles.Tile;

/** 
 * the town collects one food from the tile with this structure
 */
public class Farm extends Structure {
	
	/**
	 * constructor with parentTile
	 * @param parentTile on which the piece is located
	 */
	public Farm (Tile parentTile) {
		this.parentTile = parentTile;
		icon = new ImageIcon("icons/farm.png");
	}

}

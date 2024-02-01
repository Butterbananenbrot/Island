package de.jhh4.pieces;

import javax.swing.ImageIcon;

import de.jhh4.tiles.Tile;

/**
 * a town is a hub for resource collectio and unit training
 * it is founded by a settler
 * it collects resources from surrounding tiles
 * image: Flaticon.com
 */
public class Town extends Structure {

	/**
	 * constructor with parentTile
	 * @param parentTile on which the piece is located
	 */
	public Town (Tile parentTile) {
		this.parentTile = parentTile;
		icon = new ImageIcon("icons/town2.png");
	}

}

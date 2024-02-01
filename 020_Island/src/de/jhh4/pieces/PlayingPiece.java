package de.jhh4.pieces;

import javax.swing.ImageIcon;

import de.jhh4.tiles.Tile;

/** this abstract class represents all pieces that can placed on the map including units and structures
 * for example: towns, settlers.
 */
public abstract class PlayingPiece {
	
	/** the tile on which this piece is located */
	protected Tile parentTile;

	/** the icon used to represent the piece on the map */
	protected ImageIcon icon;
	
//not used, instead the parentTile provides info on location	
//	/** this piece's location on the Y axis in the array */
//	protected int gridX;
//	
//	/** this piece's location on the Y axis in the array */
//	protected int gridY;
//	
//	/**
//	 * constructor with parentTile, for subtypes
//	 * @param parentTile on which the piece is located
//	 */
//	public PlayingPiece(Tile parentTile) {
//		super();
//		this.parentTile = parentTile;
//	}

	/**
	 * @return the icon
	 */
	public ImageIcon getIcon() {
		return icon;
	}

//	/**
//	 * @return the gridX
//	 */
//	public int getGridX() {
//		return gridX;
//	}
//
//	/**
//	 * @return the gridY
//	 */
//	public int getGridY() {
//		return gridY;
//	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

//	/**
//	 * @param gridX the gridX to set
//	 */
//	public void setGridX(int gridX) {
//		this.gridX = gridX;
//	}
//
//	/**
//	 * @param gridY the gridY to set
//	 */
//	public void setGridY(int gridY) {
//		this.gridY = gridY;
//	}

}

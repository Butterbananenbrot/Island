package de.jhh4.pieces;

import java.awt.Color;

import javax.swing.ImageIcon;

import de.jhh4.tiles.Tile;

/**
 * a settler can found a town. 
 * this is done by the actionListener of the button of the tile on which the settler stands.
 * a newly founded town must have a distance of at least two tiles to the nearest town.
 * this ensures consistent resource collection by avoiding ownership disputes over tiles.
 */
public class Settler extends Unit {
	
	/**
	 * how many food ressources does the unit cost?
	 */
	public static final int FOODCOST = 20;
	/**
	 * how many wood ressources does the unit cost?
	 */
	public static final int WOODCOST = 10;
	
	/**
	 * constructor with parentTile
	 * @param parentTile on which the piece is located
	 */
	public Settler(Tile parentTile) {
		this.parentTile = parentTile;
		icon = new ImageIcon("icons/settler.png");
//		speed = 1;
//		foodCost = 2;
//		woodCost = 2;
//		stoneCost = 2;
	}

}

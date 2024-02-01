package de.jhh4.pieces;

import java.awt.Color;

import javax.swing.ImageIcon;

import de.jhh4.tiles.Tile;

public class Worker extends Unit {

	/**
	 * how many food ressources does the unit cost?
	 */
	public static final int FOODCOST = 10;
	/**
	 * how many wood ressources does the unit cost?
	 */
	public static final int WOODCOST = 5;
	
	/** creates a worker and sets the cost and icon */
	public Worker(Tile parentTile) {
		this.parentTile = parentTile;
		icon = new ImageIcon("icons/worker.png");
//		speed = 2;
//		foodCost = 10;
//		woodCost = 5;
//		stoneCost = 0;
	}
	
	/**
	 * a worker can build a village to increase the ressource output of a tile
	 */
	public String buildVillage() {
		return "A worker has built a village.";
	}
}

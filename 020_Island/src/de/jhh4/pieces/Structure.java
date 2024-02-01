package de.jhh4.pieces;

import javax.swing.ImageIcon;

/**
 * structures are built by units:
 * a settler can build a town
 * a worker can build a house
 * 
 * therefore structures do not have cost or speed values 
 * however they have a range in which they collect ressources
 * 
 * structures have a X,Y coordinate on the grid corresponding to the map array 
 */
public abstract class Structure extends PlayingPiece{
	
	
//	currently not used 
//	/** the distance in which the structure collects ressources */
//	int collectionRange;

}

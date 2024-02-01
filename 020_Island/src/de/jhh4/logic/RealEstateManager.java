package de.jhh4.logic;

import java.util.ArrayList;
import java.util.List;

import de.jhh4.tiles.Tile;
/**
 * knows where all the towns are and collects resources from them
 */
public class RealEstateManager {
	
	/** contains all towns built in the game */
	private static List<Tile> townTileList = new ArrayList<Tile>();
	/** contains all outposts/mines built in the game */
	private static List<Tile> outpostTileList = new ArrayList<Tile>();	
	
	/** uses a for each loop to get ressources from each town and oupost/mine on either list */
	public static void collectAllRessources() {
		for(Tile townTile : townTileList) {
			ResourceCollector.collectSurroundingResources(townTile);
		}
		for(Tile outpostTile : outpostTileList)
			ResourceCollector.collectGold(outpostTile);
	}
	
	/** 
	 * registers a town on the list for towns for resource collection
	 * @param newTownTile the town to be registered
	 */
	public static void registerTown(Tile newTownTile) {
		townTileList.add(newTownTile);
	}
	
	/** 
	 * registers an outpost on the list for outposts for resource collection
	 * @param newOutpostTile the oupost/mine to ge registered
	 */
	public static void registerOutpost(Tile newOutpostTile) {
		outpostTileList.add(newOutpostTile);
	}

	/**
	 * @return the townTileList
	 */
	public static List<Tile> getTownTileList() {
		return townTileList;
	}

	/**
	 * @return the outpostTileList
	 */
	public static List<Tile> getOutpostTileList() {
		return outpostTileList;
	}

	/**
	 * @param townTileList the townTileList to set
	 */
	public static void setTownTileList(List<Tile> townTileList) {
		RealEstateManager.townTileList = townTileList;
	}

	/**
	 * @param outpostTileList the outpostTileList to set
	 */
	public static void setOutpostTileList(List<Tile> outpostTileList) {
		RealEstateManager.outpostTileList = outpostTileList;
	}	
	

}

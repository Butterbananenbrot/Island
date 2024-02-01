package de.jhh4.logic;

import de.jhh4.gui.MainWindow;
import de.jhh4.pieces.Farm;
import de.jhh4.pieces.Lumbermill;
import de.jhh4.pieces.Outpost;
import de.jhh4.pieces.Settler;
import de.jhh4.pieces.Town;
import de.jhh4.pieces.Unit;
import de.jhh4.pieces.Worker;
import de.jhh4.tiles.Forest;
import de.jhh4.tiles.Mountain;
import de.jhh4.tiles.Plains;
import de.jhh4.tiles.Tile;

/**
 * places and moves pieces across the island.
 * knows the island through its array of tiles.
 */
public class PieceMover {
	
	/** this array contains the information for map creation */
	private Tile[][] island;
	
	/** reference to the main window JFrame */
	private MainWindow mainWindow;
	
	/** the central hub */
	private LogicCenter logicCenter;
	
	/** counts the number of workers, currently there must only be one */
	private int numberOfWorkers;
	
	/** counts the number of settlers, currently there must only be one */
	private int numberOfSettlers;
	
	/**
	 * the object gets references to both the GUI and the Tile array
	 * @param island
	 * @param mainWindow
	 * @param logicCenter
	 */
	public PieceMover(Tile[][] island, MainWindow mainWindow) {
		this.island = island;
		this.mainWindow = mainWindow;
		this.numberOfWorkers = 0;
		this.numberOfSettlers = 0;
	}

	/** 
	 * places a settler on the central tile and refreshes the correspong button to display it.
	 * refresh() must be called after setLocalUnit(...) to update the button and give him the appropriate actionListener
	 */
	public void setUpNewGame() {
		Tile centerTile = island[island.length/2][island.length/2];
		centerTile.setLocalUnit(new Settler(centerTile));
		numberOfSettlers++;
		centerTile.getButton().refresh(); // must be called to update the button and give him the appropriate actionListener
	}
	
	/** 
	 * creates a worker in the first city founded
	 * if there is not already another unit on the board
	 */
	public void createWorker() {
		if (numberOfWorkers < 1 && numberOfSettlers < 1
				&& Storage.getFoodInStorage() >= Worker.FOODCOST
				&& Storage.getWoodInStorage() >= Worker.WOODCOST) {
			Tile town = RealEstateManager.getTownTileList().get(0);
			town.setLocalUnit(new Worker(town)); 	// create new worker
			numberOfWorkers++;
			town.getButton().refresh();			// display new worker
			town.getButton().repaint();
			Storage.setFoodInStorage(Storage.getFoodInStorage() - Worker.FOODCOST);	// pay the cost
			Storage.setWoodInStorage(Storage.getWoodInStorage() - Worker.WOODCOST);
			mainWindow.getIslandViewContainer().getUpperPanel().getFoodLabel().setText("Food: " + Storage.getFoodInStorage()); // display new storage
			mainWindow.getIslandViewContainer().getUpperPanel().getWoodLabel().setText("Wood: " + Storage.getWoodInStorage());
			System.out.println("a worker was built in a town");
		}
	}
	
	/**
	 * creates a settler in the first city founded
	 * if there is not already another unit on the board
	 */
	public void createSettler() {
		if (numberOfWorkers < 1 && numberOfSettlers < 1
				&& Storage.getFoodInStorage() >= Settler.FOODCOST
				&& Storage.getWoodInStorage() >= Settler.WOODCOST) {
			Tile town = RealEstateManager.getTownTileList().get(0);
			town.setLocalUnit(new Settler(town));
			numberOfSettlers++;
			town.getButton().refresh();
			town.getButton().repaint();
			Storage.setFoodInStorage(Storage.getFoodInStorage() - Settler.FOODCOST);
			Storage.setWoodInStorage(Storage.getWoodInStorage() - Worker.WOODCOST);
			mainWindow.getIslandViewContainer().getUpperPanel().getFoodLabel().setText("Food: " + Storage.getFoodInStorage());
			mainWindow.getIslandViewContainer().getUpperPanel().getWoodLabel().setText("Wood: " + Storage.getWoodInStorage());
			System.out.println("a settler was built in a town");
		}
	}
	
	/** 
	 * build a structure if there is a unit and no structure.
	 * move a unit here if there is a unit on a neighbouring tile and the tile accessible for it.
	 * called by the actionListener of any tile
	 * @param tile
	 */
	public void action(Tile tile) {

		//case 1 build a structure 
//				if there is a unit and no structure
		if (tile.getLocalUnit() != null) {
			buildStructure(tile);
		}
		

		//case 2 move a unit here 
//				if there is a unit on a neighboring tile
//		tile.getSurroundingTiles().forEach(neighbourTile -> { // use this for up-down-vertical movement
		tile.getDirectNeighbours().forEach(neighbourTile -> { // use this for only up-down movement
			if (tile.isAccessible()											// if the tile is accessible, any unit can move here
					|| (tile.isAccessibleForWorkers() 						// if not, check if a worker can move there anyway(to build mines)
							&& neighbourTile.getLocalUnit() instanceof Worker) ) { 					
				if (neighbourTile.getLocalUnit() != null) { // check if there is a unit on one of the surrounding tiles
					tile.setLocalUnit(neighbourTile.getLocalUnit()); // reference the unit on the new tile
					neighbourTile.setLocalUnit(null); // dereference the unit on the old tile
					neighbourTile.getButton().refresh();
					neighbourTile.getButton().repaint();
//					System.out.println("unit detected, referenced, deferenced on a neighbouring tile");
				}
			} 
//			else if (tile.isAccessibleForWorkers() &&) {
//				
//			}
		});
	}
	
	/**
	 * a settler builds a town on plains or forest tiles
	 * a worker/miner builds an outpost/mine on a mountain tile
	 * a newly founded town must have a distance of at least two tiles to the nearest town.
	 * this ensures consistent resource collection by avoiding ownership disputes over tiles.
	 * @param tile the location of the new structure
	 */
	private void buildStructure(Tile tile) {
		Unit unitOnTile = tile.getLocalUnit();
		
		// case 1 settler on plains or forest (and with no shared neighbouring tiles with another city)
		// found town and build farms and lumbermills around it
		if (unitOnTile instanceof Settler) {
			if (tile.getLocalStructure() == null 
					&& (tile instanceof Plains || tile instanceof Forest)
					&& (ensureNoOverlap(tile))) {
				tile.setLocalUnit(null);
				numberOfSettlers--;
				tile.setLocalStructure(new Town(tile));
				buildFarms(tile);
				buildLumbermills(tile);
				RealEstateManager.registerTown(tile);
				System.out.println("a town was founded by a settler");
			}
		}
		// case 2 worker on mountain - build outpost
		if (unitOnTile instanceof Worker) {
			if (tile.getLocalStructure() == null
					&& (tile instanceof Mountain)) {
				tile.setLocalUnit(null);
				numberOfWorkers--;
				tile.setLocalStructure(new Outpost(tile));
				RealEstateManager.registerOutpost(tile);
				System.out.println("an outpost was built by a worker");
			}
		}
	}

	/**
	 * ensures that a town founded on this tile does not have overlapping neighbouring tiles with another city
	 * @param tile
	 * @return true if there is no overlap, false if there is overlap
	 */
	private boolean ensureNoOverlap(Tile tile) {
		for(Tile neighbour: tile.getSurroundingTiles() ) {
			for(Tile otherTown: RealEstateManager.getTownTileList()) {
				for(Tile neighbourOfOtherTown: otherTown.getSurroundingTiles()) {
//					if (neighbour.equals(neighbourOfOtherTown)) { // if they were different tiles with the same attributes, not needed here
					if (neighbour == (neighbourOfOtherTown)) { // because they reference the same tile object 
						return false;
					};
				}
			}
		}
		return true;
	}

	
	/** builds a farm on every surrounding Plains tile */
	private void buildFarms(Tile tile) {
		for(Tile outskirt: tile.getSurroundingTiles()) {
			if (outskirt instanceof Plains) {
				outskirt.setLocalStructure(new Farm(outskirt));
				outskirt.getButton().refresh();
				outskirt.getButton().repaint();
			}
		}
	}
	
	/** builds a Lumbermill on every surrounding Lumbermill tile */
	private void buildLumbermills(Tile tile) {
		for(Tile outskirt: tile.getSurroundingTiles()) {
			if (outskirt instanceof Forest) {
				outskirt.setLocalStructure(new Lumbermill(outskirt));
				outskirt.getButton().refresh();
				outskirt.getButton().repaint();
			}
		}
		
	}
	
	/**
	 * @return the logicCenter
	 */
	public LogicCenter getLogicCenter() {
		return logicCenter;
	}

	/**
	 * @param logicCenter the logicCenter to set
	 */
	public void setLogicCenter(LogicCenter logicCenter) {
		this.logicCenter = logicCenter;
	}

	/**
	 * @return the numberOfWorkers
	 */
	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}

	/**
	 * @return the numberOfSettlers
	 */
	public int getNumberOfSettlers() {
		return numberOfSettlers;
	}

	/**
	 * @param numberOfWorkers the numberOfWorkers to set
	 */
	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

	/**
	 * @param numberOfSettlers the numberOfSettlers to set
	 */
	public void setNumberOfSettlers(int numberOfSettlers) {
		this.numberOfSettlers = numberOfSettlers;
	}

	
	
	

}

package de.jhh4.logic;

import de.jhh4.tiles.Tile;

/**
 * collects resources from tiles
 */
public class ResourceCollector {
	
	/**
	 * collects 1 gold (stone) from the tile where a mine (outpost) was built
	 * increases the score counter by 1
	 * increases the stone storage by 1 (currently not used) 
	 * @param mine the tile where the mine is located
	 */
	public static void collectGold(Tile mine) {
//		System.out.println("Debug: collectGold was called");
		Storage.storeStone(1);
		ScoreCounter.increaseScore(1);

	}
	
	/** 
	 * checks all surrounding 8 tiles and the tile of the town for ressources produced and collects them
	 * also increases the score by the amount of gold(stone) collected this turn
	 * @param town location of town
	 */
	public static void collectSurroundingResources(Tile town) {
		
		int foodCollected = collectFood(town);
		int woodCollected = collectWood(town);
//		int stoneCollected = collectStone(town);
		
		Storage.storeFood(foodCollected);
//		System.out.println("Debug: before storing, current wood is " + Storage.getWoodInStorage());
		Storage.storeWood(woodCollected);
//		System.out.println("Debug: after storing, current wood is " + Storage.getWoodInStorage());
//		Storage.storeStone(stoneCollected);
		
//		ScoreCounter.increaseScore(stoneCollected);
//		ScoreCounter.increaseScore(foodCollected + woodCollected + stoneCollected);
		
//		System.out.println("Debug: ressources collected by RessourceCollector");
//		System.out.println("Debug: current food is " + Storage.getFoodInStorage());
//		System.out.println("Debug: current score is " + ScoreCounter.getScore());
	}
	

	/** 
	 * helper method to collect Food from surrounding tiles
	 * @param town location of town
	 */
	private static int collectFood(Tile town) {
//		int food = town.getFoodOutput();
		int food = 0;
		for(Tile tile: town.getSurroundingTiles()) {
			food = food + tile.getFoodOutput();
//			if (tile.getFoodOutput()!=0) {
//				System.out.println(tile.getFoodOutput() + " food was collected from tile: " + tile.getRow() + tile.getColumn());
//			}
		}	
		return food;	
	}
	
	/** 
	 * helper method to collect Food from surrounding tiles 
	 * @param town location of town
	 */
	private static int collectWood(Tile town) {
//		int wood = town.getWoodOutput();
		int wood = 0;
		for(Tile tile: town.getSurroundingTiles()) {
			wood = wood + tile.getWoodOutput();
//			if (tile.getWoodOutput()!=0) {
//				System.out.println(tile.getWoodOutput() + " wood was collected from tile: " + tile.getRow() + tile.getColumn());
//			}
		}
		return wood;
	}
	
	/** 
	 * helper method to collect Food from all 9 tiles 
	 * @param town location of town
	 */
	private static int collectStone(Tile town) {
		int stone = town.getStoneOutput();
		for(Tile tile: town.getSurroundingTiles()) {
			stone = stone + tile.getStoneOutput();
//			if (tile.getStoneOutput()!=0) {
//				System.out.println(tile.getStoneOutput() + " stone was collected from tile: " + tile.getRow() + tile.getColumn());
//			}
		}
		return stone;
	}
	
}

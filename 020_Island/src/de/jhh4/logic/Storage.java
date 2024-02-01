package de.jhh4.logic;

/**
 * TODO update to enum Ressources in version 2
 * stores the collected ressources
 */
public class Storage {
	
	/** the amount of food stored during the game */
	private static int foodInStorage = 0;
	
	/** the amount of wood stored during the game */
	private static int woodInStorage = 0;
	
	/** the amount of stone stored during the game */
	private static int stoneInStorage = 0;
	
	/**
	 * store food after collection
	 * @param amount
	 */
	public static void storeFood(int amount) {
		foodInStorage = foodInStorage + amount;
	}
	
	/**
	 * store wood after collection
	 * @param amount
	 */
	public static void storeWood(int amount) {
		woodInStorage = woodInStorage + amount;
	}
	
	/**
	 * store stone after collection
	 * @param amount
	 */
	public static void storeStone(int amount) {
		stoneInStorage = stoneInStorage + amount;
	}

	/**
	 * @return the foodInStorage
	 */
	public static int getFoodInStorage() {
		return foodInStorage;
	}

	/**
	 * @return the woodInStorage
	 */
	public static int getWoodInStorage() {
		return woodInStorage;
	}

	/**
	 * @return the stoneInStorage
	 */
	public static int getStoneInStorage() {
		return stoneInStorage;
	}

	/**
	 * @param foodInStorage the foodInStorage to set
	 */
	public static void setFoodInStorage(int foodInStorage) {
		Storage.foodInStorage = foodInStorage;
	}

	/**
	 * @param woodInStorage the woodInStorage to set
	 */
	public static void setWoodInStorage(int woodInStorage) {
		Storage.woodInStorage = woodInStorage;
	}

	/**
	 * @param stoneInStorage the stoneInStorage to set
	 */
	public static void setStoneInStorage(int stoneInStorage) {
		Storage.stoneInStorage = stoneInStorage;
	}

}

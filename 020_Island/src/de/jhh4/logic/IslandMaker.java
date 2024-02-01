package de.jhh4.logic;

import java.util.Random;

import de.jhh4.gui.IslandView;
import de.jhh4.gui.MainWindow;
import de.jhh4.pieces.Settler;
import de.jhh4.tiles.Forest;
import de.jhh4.tiles.Mountain;
import de.jhh4.tiles.Ocean;
import de.jhh4.tiles.Plains;
import de.jhh4.tiles.Tile;

/** 
 * this class makes terrain grids as a basis for map creation
 * the first dimension represents the rows
 * the second dimension represents the columns
 * meaning: Tile[y][x]
 */
public class IslandMaker {
	
	/** this array contains the information for map creation */
	private static Tile[][] island;
	
	/** reference to the main window JFrame */
	private MainWindow mainWindow;
	
	/**
	 * the constructor gets a reference to the Main Window so that instances can work with it
	 * @param mainWindow
	 */
	public IslandMaker(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	/**
	 * this method can be called to create a balanced map with the specified dimensions 
	 * works with the attributes mainWindow and island
	 * @param width of the map
	 * @param height of the map
	 * @return the array which defines the terrain of the map
	 */
	public Tile[][] createRandomIsland(int width, int height) {
//		System.out.println("Debug: Creating new tileGrid with width and heigth: " + width + " " + height);	
		
		// creating a randomized Tile array
		island = new Tile[width][height];
		createRandomInternalTiles();
		createOceanBorder();
//		System.out.println("Debug: after Map creation, the internal tile at [2][2] is : " + island[2][2]);
		
		// linking neighbouring tiles
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[i].length; j++) {
				island[i][j].initializeNeighbours();
			}
		}

		// displaying the Tile array as buttons and tying the result into the GUI
		IslandView islandView = new IslandView(mainWindow.getIslandViewContainer(), island);
		mainWindow.getIslandViewContainer().setIslandView(islandView);
		mainWindow.getIslandViewContainer().add(islandView);
		
		return island;
	}

	/** sets all outer tiles of the map as Ocean tiles */
	private void createOceanBorder() {
		for (int i = 0; i < island.length; i++) {
			// set the first row to ocean
			island[0][i] = new Ocean(0,i);
			// set the last row to ocean
			island[island.length-1][i] = new Ocean(island.length-1,i);
			// set the first column to ocean
			island[i][0] = new Ocean(i,0);
			// set the last column to ocean
			island[i][island.length-1] = new Ocean(i,island.length-1);
			
		}
		// round off the edges
		island[1][1] = new Ocean(1,1); // top left corner
		island[1][island.length-2] = new Ocean(1, island.length-2); // top right corner
		island[island.length-2][1] = new Ocean(island.length-2, 1); // bottom left corner
		island[island.length-2][island.length-2] = new Ocean(island.length-2, island.length-2); // bottom right corner
	}
	
	/** 
	 * sets all inner tiles of the map to either Ocean, Mountain, Forest, or Plains tiles.
	 * Plains and Forest are twice as likely to appear to make the terrain more traversable.
	 * the center tile is guaranteed to be a Plains tile to enable settler/city spawning.
	 * */
	private void createRandomInternalTiles() {
		Random die = new Random();
		for (int row = 1; row < island.length-1; row++) {
			for (int column = 1; column < island.length-1; column++) {
				int tileKey = die.nextInt(6);
				switch(tileKey) {
				case 0:
					island[row][column] = new Ocean(row,column);
					break;
				case 1:
					island[row][column] = new Mountain(row,column);
					break;
				case 2:
					island[row][column] = new Forest(row,column);
					break;
				case 3:
					island[row][column] = new Forest(row,column);
					break;
				case 4:
					island[row][column] = new Plains(row,column);
					break;
				case 5:
					island[row][column] = new Plains(row,column);
					break;	
				default:
					System.out.println("Default case reached during map creation - this should not happen");
					break;
				}
			}
		}
		//ensure that the center tile is plains, overwrite the random tile
		island[island.length/2][island.length/2] = new Plains(island.length/2,island.length/2);
		
		Tile centerTile = island[island.length/2][island.length/2];
		centerTile.setLocalUnit(new Settler(centerTile));
		
	} // end of createRandomInternalTiles

	/**
	 * @return the island
	 */
	public static Tile[][] getIsland() {
		return island;
	}
	
}

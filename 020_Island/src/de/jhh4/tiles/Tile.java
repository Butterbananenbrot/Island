package de.jhh4.tiles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.ImageIcon;

import de.jhh4.gui.ButtonForMap;
import de.jhh4.logic.IslandMaker;
import de.jhh4.pieces.Settler;
import de.jhh4.pieces.Structure;
import de.jhh4.pieces.Unit;

/**
 * takes care of logic for tiles/the game
 * 
 * object description: a forest is green, produces wood, and is accessible
 * 
 * abstraction: a tile object has a terrain type a colour, a ressource, an
 * accessible boolean a return method for ressource
 */

public abstract class Tile {
	
	/** contains the specified neighbouring tile */
	protected Tile upperLeftNeighbour;
	/** contains the specified neighbouring tile */
	protected Tile upperNeighbour;
	/** contains the specified neighbouring tile */
	protected Tile upperRightNeighbour;
	/** contains the specified neighbouring tile */
	protected Tile leftNeighbour;
	/** contains the specified neighbouring tile */
	protected Tile rightNeighbour;
	/** contains the specified neighbouring tile */
	protected Tile bottomLeftNeighbour;
	/** contains the specified neighbouring tile */
	protected Tile bottomNeighbour;
	/** contains the specified neighbouring tile */
	protected Tile bottomRightNeighbour;
	
	/** contains all 8 neighbouring tiles */
	protected List<Tile> surroundingTiles;
	/** contains the 4 neighbouring tiles - left, above, right, bottom */
	protected List<Tile> directNeighbours;
	
	/** the island surrounding this Tile */
	protected Tile[][] island;
	
	/** the corresponding Button in view */
	protected ButtonForMap button;
	
	/**
	 * currently not used, could be used to indicate nearby unit
	 */
	protected boolean active;
	
	/** 
	 * this icon represents the type of tile on the map
	 * it is set against a colored background defined below
	 */
	protected ImageIcon icon;
	
	/** this tile's location on the y axis in the array */
	protected int row;
	
	/** this tile's location on the X axis in the array */
	protected int column;

	/** a unit that was built on this tile or moved to this tile */
	private Unit localUnit;
	
	/** a structure that built on this tile */
	private Structure localStructure;
	
	/**
	 * which colour does the tile have?
	 */
	protected Color color;

	/**
	 * can settlers walk on the tile?
	 */
	protected boolean accessible;
	
	/**
	 * can workers walk on the tile?
	 */
	protected boolean accessibleForWorkers;
	
	/**
	 * how much food does the tile produce?
	 */
	protected int foodOutput;
	/**
	 * how much wood does the tile produce?
	 */
	protected int woodOutput;
	/**
	 * how much stone does the tile produce?
	 */
	protected int stoneOutput;
	
	/**
	 * constructor to be used by subclasses, including coordinates of the tile in the grid array
	 * @param row left to right
	 * @param column top to bottom
	 * @param imageIcon 
	 * @param color 
	 */
	public Tile(int row, int column, ImageIcon imageIcon, Color color) {
		this.row = row;
		this.column = column;
		this.icon = imageIcon;
		this.color = color;
		button = new ButtonForMap(this);
		this.island = IslandMaker.getIsland();
//		initializeNeighbours();
	}
	
	/** initialize the references to the surrounding tiles */
	public void initializeNeighbours() {
//		System.out.println("-------------------------------------------");
		if (row > 0 && column > 0) { // up left
			upperLeftNeighbour = island[row-1][column-1];		
		}
		if (column > 0) { // left 
			leftNeighbour = island[row][column-1];
		}		
		if ( (row < island.length-1) && column > 0 ) { // down left
			bottomLeftNeighbour = island[row+1][column-1];
		}
		if (row > 0) { // up
			upperNeighbour = island[row-1][column];
		}
		if (row < island.length-1) { // down
			bottomNeighbour = island[row+1][column];
		}
		if (row > 0 && column < island.length-1) { // up right
			upperRightNeighbour = island[row-1][column+1];
//			System.out.println(this + " mit rechtem oberen Nachbarn " + upperRightNeighbour);
		}
		if (column < island.length-1) { // right
			rightNeighbour = island[row][column+1];
		}
		if ((row < island.length-1) && column < island.length-1) { // down right
			bottomRightNeighbour = island[row+1][column+1];
		}
		
		surroundingTiles = createSurroundingTilesList(this);
		directNeighbours = createDirectNeighbourList(this);
	}

	/** creates a list of the tiles left, above, right, below */
	public ArrayList<Tile> createDirectNeighbourList(Tile tile) {
		ArrayList<Tile> list = new ArrayList<Tile>();
		if (getLeftNeighbour() != null)
			list.add(getLeftNeighbour());	
		if (getUpperNeighbour() != null)
			list.add(getUpperNeighbour());
		if (getBottomNeighbour() != null)
			list.add(getBottomNeighbour());	
		if (getRightNeighbour() != null)
			list.add(getRightNeighbour());
		return list;
	}
	
	/** creats a list of all 8 surrounding tiles */
	public ArrayList<Tile> createSurroundingTilesList(Tile tile) {
		ArrayList<Tile> list = new ArrayList<Tile>();
		if (getUpperLeftNeighbour() != null)
			list.add(getUpperLeftNeighbour());
		if (getLeftNeighbour() != null)
			list.add(getLeftNeighbour());		
		if (getBottomLeftNeighbour() != null)
			list.add(getBottomLeftNeighbour());	
		if (getUpperNeighbour() != null)
			list.add(getUpperNeighbour());		
		if (getBottomNeighbour() != null)
			list.add(getBottomNeighbour());		
		if (getUpperRightNeighbour() != null)
			list.add(getUpperRightNeighbour());
		if (getRightNeighbour() != null)
			list.add(getRightNeighbour());
		if (getBottomRightNeighbour() != null)
			list.add(getBottomRightNeighbour());
		return list;
//		System.out.println("surroundingTiles built");
	}

	// SET
	/** 
	 * to set the value
	 * @param foodOutput
	 */
	public void setFoodOutput(int foodOutput) {
		this.foodOutput = foodOutput;
	}
	/**
	 * to set the value
	 * @param woodOutput
	 */
	public void setWoodOutput(int woodOutput) {
		this.woodOutput = woodOutput;
	}
	/**
	 * to set the value
	 * @param stoneOutput
	 */
	public void setStoneOutput(int stoneOutput) {
		this.stoneOutput = stoneOutput;
	}
	/**
	 * to set the value
	 * @param b
	 */
	public void setAccessible(boolean b) {
		accessible = b;
	}
	/**
	 * to set the value
	 * @param colour
	 */
	public void setColour(Color colour) {
		this.color = colour;
	}

	// GET
	/**
	 * to get the value 
	 * @return how much food is produced
	 */
	public int getFoodOutput() {
		return foodOutput;
	}
	/**
	 * to get the value 
	 * @return how much wood is produced
	 */
	public int getWoodOutput() {
		return woodOutput;
	}
	/**
	 * to get the value 
	 * @return how much stone is produced
	 */
	public int getStoneOutput() {
		return stoneOutput;
	}
	/** 
	 * to get the value
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * to get the value
	 * @return true if accessible
	 */
	public boolean isAccessible() {
		return accessible;
	}

	/**
	 * @return the icon
	 */
	public ImageIcon getIcon() {
		return icon;
	}

	/**
	 * @param icon that is to be set
	 */
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	/**
	 * @return the localUnit on this tile
	 */
	public Unit getLocalUnit() {
		return localUnit;
	}

	/**
	 * @return the localStructure on this tile
	 */
	public Structure tile() {
		return localStructure;
	}

	/**
	 * @param localUnit the localUnit to set
	 */
	public void setLocalUnit(Unit localUnit) {
		this.localUnit = localUnit;
	}

	/**
	 * @param localStructure the localStructure to set
	 */
	public void setLocalStructure(Structure localStructure) {
		this.localStructure = localStructure;
	}

	/**
	 * @return the localStructure
	 */
	public Structure getLocalStructure() {
		return localStructure;
	}

	/**
	 * @return the button
	 */
	public ButtonForMap getButton() {
		return button;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return button.isActive();
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
		button.setActive(active);
	}

	/**
	 * @return the gridX
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return the gridY
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the upperLeftNeighbour
	 */
	public Tile getUpperLeftNeighbour() {
		return upperLeftNeighbour;
	}

	/**
	 * @return the upperNeighbour
	 */
	public Tile getUpperNeighbour() {
		return upperNeighbour;
	}

	/**
	 * @return the upperRightNeighbour
	 */
	public Tile getUpperRightNeighbour() {
		return upperRightNeighbour;
	}

	/**
	 * @return the leftNeighbour
	 */
	public Tile getLeftNeighbour() {
		return leftNeighbour;
	}

	/**
	 * @return the rightNeighbour
	 */
	public Tile getRightNeighbour() {
		return rightNeighbour;
	}

	/**
	 * @return the bottomLeftNeighbour
	 */
	public Tile getBottomLeftNeighbour() {
		return bottomLeftNeighbour;
	}

	/**
	 * @return the bottomNeighbour
	 */
	public Tile getBottomNeighbour() {
		return bottomNeighbour;
	}

	/**
	 * @return the bottomRightNeighbour
	 */
	public Tile getBottomRightNeighbour() {
		return bottomRightNeighbour;
	}

	/**
	 * @param upperLeftNeighbour the upperLeftNeighbour to set
	 */
	public void setUpperLeftNeighbour(Tile upperLeftNeighbour) {
		this.upperLeftNeighbour = upperLeftNeighbour;
	}

	/**
	 * @param upperNeighbour the upperNeighbour to set
	 */
	public void setUpperNeighbour(Tile upperNeighbour) {
		this.upperNeighbour = upperNeighbour;
	}

	/**
	 * @param upperRightNeighbour the upperRightNeighbour to set
	 */
	public void setUpperRightNeighbour(Tile upperRightNeighbour) {
		this.upperRightNeighbour = upperRightNeighbour;
	}

	/**
	 * @param leftNeighbour the leftNeighbour to set
	 */
	public void setLeftNeighbour(Tile leftNeighbour) {
		this.leftNeighbour = leftNeighbour;
	}

	/**
	 * @param rightNeighbour the rightNeighbour to set
	 */
	public void setRightNeighbour(Tile rightNeighbour) {
		this.rightNeighbour = rightNeighbour;
	}

	/**
	 * @param bottomLeftNeighbour the bottomLeftNeighbour to set
	 */
	public void setBottomLeftNeighbour(Tile bottomLeftNeighbour) {
		this.bottomLeftNeighbour = bottomLeftNeighbour;
	}

	/**
	 * @param bottomNeighbour the bottomNeighbour to set
	 */
	public void setBottomNeighbour(Tile bottomNeighbour) {
		this.bottomNeighbour = bottomNeighbour;
	}

	/**
	 * @param bottomRightNeighbour the bottomRightNeighbour to set
	 */
	public void setBottomRightNeighbour(Tile bottomRightNeighbour) {
		this.bottomRightNeighbour = bottomRightNeighbour;
	}

	/**
	 * @return the surroundingTiles
	 */
	public List<Tile> getSurroundingTiles() {
		return surroundingTiles;
	}

	/**
	 * @return the accessibleForWorkers
	 */
	public boolean isAccessibleForWorkers() {
		return accessibleForWorkers;
	}

	/**
	 * @param accessibleForWorkers the accessibleForWorkers to set
	 */
	public void setAccessibleForWorkers(boolean accessibleForWorkers) {
		this.accessibleForWorkers = accessibleForWorkers;
	}

	/**
	 * overrides the Object method toString() for testing
	 */
	@Override
	public String toString() {
		return "Row: "+ row + " Column: " + column;
	}

	/**
	 * @return the directNeighbours
	 */
	public List<Tile> getDirectNeighbours() {
		return directNeighbours;
	}

	/**
	 * @param directNeighbours the directNeighbours to set
	 */
	public void setDirectNeighbours(List<Tile> directNeighbours) {
		this.directNeighbours = directNeighbours;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bottomLeftNeighbour, bottomNeighbour, bottomRightNeighbour, column, row, upperLeftNeighbour,
				upperNeighbour, upperRightNeighbour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Tile)) {
			return false;
		}
		Tile other = (Tile) obj;
		return Objects.equals(bottomLeftNeighbour, other.bottomLeftNeighbour)
				&& Objects.equals(bottomNeighbour, other.bottomNeighbour)
				&& Objects.equals(bottomRightNeighbour, other.bottomRightNeighbour) && column == other.column
				&& row == other.row && Objects.equals(upperLeftNeighbour, other.upperLeftNeighbour)
				&& Objects.equals(upperNeighbour, other.upperNeighbour)
				&& Objects.equals(upperRightNeighbour, other.upperRightNeighbour);
	}

}

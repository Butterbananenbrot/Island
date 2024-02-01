package de.jhh4.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import de.jhh4.logic.PieceMover;
import de.jhh4.pieces.Settler;
import de.jhh4.pieces.Town;
import de.jhh4.tiles.Tile;

/**
 * represents a tile in the GUI and allows the user to interact with the tiles
 */
public class ButtonForMap extends JButton {
	
	/** decides what the button does when clicked */
	private ActionListener klickListener;
	
	/** the image to be displayed */
	private Image image;
	
	/** is this currently clickable (not used) */
	private boolean active;
	
	/** the tile which this button represents */
	private Tile tile;
	
	/** needed to call the action() method on the actionListeners */
	private PieceMover pieceMover;

	/**
	 * constructs a new button which represents a tile
	 * and attaches an action listener which calls the action() method to build/move
	 * @param tile with attached data
	 */
	public ButtonForMap(Tile tile) {
		this.tile = tile;
		klickListener = klick -> {
//			System.out.println("You klicked on tile: " + tile.getRow() + tile.getColumn());
//			System.out.println("This tile has the following neighbours: ");
//			for(Tile element: tile.getSurroundingTiles()) {
//				System.out.println("A tile at: "+ element.getRow() + element.getColumn());
//			}
			pieceMover.action(tile);
			refresh();
		};
		addActionListener(klickListener);
		refresh();
	}

	/** 
	 * updates a button by adding all the relevant icons and background colors.
	 * the method checks if there is a playing piece on the tile and sets the image on the button accordingly.
	 * this must be called when a unit has moved onto a new tile;
	 * */
	public void refresh() {
				// case 1: there is neither a unit nor a structure on the tile: display the tile icon
				if (( tile.getLocalStructure() == null) && (tile.getLocalUnit() == null)) {
					image = tile.getIcon().getImage();
				}
				
				// case 2: there is a structure, but no unit on the tile: display the structure icon
				if ( (tile.getLocalStructure() != null) && (tile.getLocalUnit() == null)) {
					image = tile.getLocalStructure().getIcon().getImage();
				}
				
				// case 3: there is a unit, but no structure on the tile: display the unit icon
				if ( (tile.getLocalStructure() == null) && (tile.getLocalUnit() != null)) {
					image = tile.getLocalUnit().getIcon().getImage();
				}
				
				// case 4: there is both a structure and a unit on the tile: display the unit icon
				if ( (tile.getLocalStructure() != null) && (tile.getLocalUnit() != null)) {
					image = tile.getLocalUnit().getIcon().getImage();
				}
				setBackground(tile.getColor());
	}
	
	/** overrides the paint method to properly display icons */
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		graphics.drawImage(image, getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2, null);
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @return the klickListener
	 */
	public ActionListener getKlickListener() {
		return klickListener;
	}

	/**
	 * @param klickListener the klickListener to set
	 */
	public void setKlickListener(ActionListener klickListener) {
		this.klickListener = klickListener;
	}

	/**
	 * @return the pieceMover
	 */
	public PieceMover getPieceMover() {
		return pieceMover;
	}

	/**
	 * @param pieceMover the pieceMover to set
	 */
	public void setPieceMover(PieceMover pieceMover) {
		this.pieceMover = pieceMover;
	}
	
	
}

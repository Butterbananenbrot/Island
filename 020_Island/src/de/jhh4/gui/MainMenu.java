package de.jhh4.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Defines the layout for the main menu using GridLayout.
 */
public class MainMenu extends JPanel{	
	
	/** a reference to the menu element container in the center */
	private CenterGridMenu centerMenu; 
	
	/** provides a reference to the highest container (JFrame) */
	private MainWindow mainWindow;
	
	public MainMenu(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.centerMenu = new CenterGridMenu(mainWindow);
		setLayout(new BorderLayout(50, 50));
		setBackground(Color.GRAY);
		create();
	}

	/** adds elements to the menu, including an empty border and the central menu
	 * then a colour to make it look nicer */
	private void create() {
		
		add(centerMenu, BorderLayout.CENTER);
		centerMenu.setBackground(Color.GRAY);
		centerMenu.setBorder(new EmptyBorder(100,200,100,200));	
	}
	
	

}

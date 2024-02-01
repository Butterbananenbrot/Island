package de.jhh4.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/** 
 * Shows the previous highscores of this game.
 * Contains a center panel with scores.
 */
public class Credits extends JPanel {
	
	/** serves as a reference to the main JFrame */
	private MainWindow mainWindow;
	
	/** the text area in the center, containing credits */
	private JTextArea creditsText;
	
	/** returns to the main menu */
	private JButton returnButton = new JButton("Return to main menu");
	
	/** Provides spacing for the central table */
	private JPanel topSpacing = new JPanel();
	/** Provides spacing for the central table */
	private JPanel leftSpacing = new JPanel();
	/** Provides spacing for the central table */
	private JPanel rightSpacing = new JPanel();
	
	/**
	 * constructs a new object with a reference to the top GUI layer
	 * @param mainWindow the top GUI layer
	 */
	public Credits(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		setLayout(new BorderLayout(5, 5));
		setBackground(Color.GRAY);
		create();
	}


	/** creates the view. 
	 * Firstly, spacing on the top and sides. 
	 * Secondly, the table in the center.
	 * Thirdly, a return button at the buttom.
	 */
	private void create() {
		
		add(topSpacing, BorderLayout.NORTH);
		topSpacing.setPreferredSize(new Dimension(0,50));
		topSpacing.setBackground(Color.GRAY);
		
		add(leftSpacing, BorderLayout.WEST);
		leftSpacing.setPreferredSize(new Dimension(50,0));
		leftSpacing.setBackground(Color.GRAY);
		
		add(rightSpacing, BorderLayout.EAST);
		rightSpacing.setPreferredSize(new Dimension(50,0));
		rightSpacing.setBackground(Color.GRAY);
		
		creditsText = new JTextArea("Created using Swing in Eclipse. "
				+ "All Icons were downloaded from icons8.com and flaticon.com. \n"
				+ "Mine icon created by Andrejs Kirma. \n"
				+ "Town icon created by Icon home. \n"
				+ "Miner icon created by Ayub Irawan. \n"
				+ "Farm icon created by Jongrak. \n"
				+ "Lumbermill icon created by smashingstocks."); //TODO write and edit a credits text
		add(creditsText, BorderLayout.CENTER);
		creditsText.setBackground(Color.LIGHT_GRAY);
		
		add(returnButton, BorderLayout.SOUTH);
		returnButton.setPreferredSize(new Dimension(0,50));
		returnButton.addActionListener(klick -> displayMainMenu());	
		
	}

	/** returns to the main menu */
	private void displayMainMenu() {
		mainWindow.getCardLayout().show(mainWindow.getContentPane(), "MainMenu");
	}

}
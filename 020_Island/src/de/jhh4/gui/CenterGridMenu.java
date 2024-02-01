package de.jhh4.gui;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * Defines the layout for the center component of the main menu using GridLayout.
 */
public class CenterGridMenu extends JPanel {

	
	/** These Buttons are the main navigaton method to switch to the map, highscores, etc. */
	private JButton newGameButton = new JButton();
	/** These Buttons are the main navigaton method to switch to the map, highscores, etc. */
	private JButton highscoresButton = new JButton();
	/** These Buttons are the main navigaton method to switch to the map, highscores, etc. */
	private JButton creditsButton = new JButton();
	/** These Buttons are the main navigaton method to switch to the map, highscores, etc. */
	private JButton quitButton = new JButton();
	
	/** provides a reference to the highest container (JFrame) */
	private MainWindow mainWindow;
	
	/**
	 * Creates a new menu with four rows and a spacing of 50. 
	 * @param mainWindow
	 */
	public CenterGridMenu(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		
		setLayout(new GridLayout(4,1,50,50));
		create();
	}

	/** Specifies the labels for the buttons in the main menu and adds them to the menu. 
	 * It also adds functionality: change the displayed component or quit the program. */
	private void create() {
		
		newGameButton = new JButton("Play");
		add(newGameButton);
//		newGameButton.setBackground(Color.BLUE);
		newGameButton.addActionListener(klick -> displayGameMap());	
		
		highscoresButton = new JButton("Highscores");
		add(highscoresButton);
		highscoresButton.addActionListener(klick -> displayHighscores());		

		creditsButton = new JButton("Credits");
		add(creditsButton);
		creditsButton.addActionListener(klick -> displayCredits());	
		
		quitButton = new JButton("Quit");
		add(quitButton);
		quitButton.addActionListener(klick -> System.exit(0));
		
		}



	/** Changes the display of the CardLayout to the game map */
	public void displayGameMap() {
//		mainWindow.getCardLayout().next(mainWindow.getContentPane());
		mainWindow.getCardLayout().show(mainWindow.getContentPane(), "GameMap");
	}
	
	/** Changes the display of the CardLayout to the highscore display */	
	public void displayHighscores() {
		mainWindow.getCardLayout().show(mainWindow.getContentPane(), "Highscores");
	}	
		
	/** Changes the display of the CardLayout to the credits display */		
	public void displayCredits() {
//		System.out.println("test credits");
		mainWindow.getCardLayout().show(mainWindow.getContentPane(), "Credits");
	}

	
	}


package de.jhh4.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.jhh4.backend.HighscoreCenter;

/** 
 * Shows the previous highscores of this game.
 * Contains a center panel with scores.
 * TODO implement a save method for highscores
 */

public class Highscores extends JPanel {
	
	/** to get the highscores from the saved file */
	private HighscoreCenter highscoreCenter;
	
	/** serves as a reference to the main JFrame */
	private MainWindow mainWindow;
	
	/** the table in the center, containing scores */
	private JTextArea textArea;
	
	/** the text to be displayed in the textArea */
	private String scores;
	
	/** returns to the main menu */
	private JButton returnButton = new JButton("Return to main menu");
	
	/** Provides spacing for the central table */
	private JPanel topSpacing = new JPanel();
	/** Provides spacing for the central table */
	private JPanel leftSpacing = new JPanel();
	/** Provides spacing for the central table */
	private JPanel rightSpacing = new JPanel();
	
	/**
	 * constructs a highscore view including a reference back up 
	 * @param mainWindow to allow references
	 */
	public Highscores(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
//		this.scores = new CenterGridScoreTable();
		setLayout(new BorderLayout(50, 50));
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
		
		highscoreCenter = new HighscoreCenter();
		scores = highscoreCenter.getHighscoresForDisplay();
		textArea = new JTextArea(scores);
		add(textArea, BorderLayout.CENTER);
//		textArea.setBackground(Color.GRAY);
		
		add(returnButton, BorderLayout.SOUTH);
		returnButton.setPreferredSize(new Dimension(0,50));
		returnButton.addActionListener(klick -> displayMainMenu());	
		
	}

	/** returns to the main menu */
	private void displayMainMenu() {
		mainWindow.getCardLayout().show(mainWindow.getContentPane(), "MainMenu");
	}

	/**
	 * @return the highscoreCenter
	 */
	public HighscoreCenter getHighscoreCenter() {
		return highscoreCenter;
	}

	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @param textArea the textArea to set
	 */
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

}

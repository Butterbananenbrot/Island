package de.jhh4.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * the panel in the lower half of the map view, containing instructions
 */
public class LowerPanel extends JPanel{

	/** to return to the main menu */
	private JButton returnButton = new JButton("Return to main menu");
	/** contains instructions for player */
	private JTextArea instructionsField;
	
	/** refers to the container in which this the upperPanel is included */
	private IslandViewContainer parentPanel;
	
	/**
	 * builds a panel that contains the instructions for the game
	 * @param parentPanel to refer back to if needed
	 */
	public LowerPanel(IslandViewContainer parentPanel) {
		this.parentPanel = parentPanel;
		
		// klicking the RETURN button will display the main menu
		add(returnButton);
		returnButton.addActionListener(klick -> displayMainMenu());	
		
		instructionsField = new JTextArea("Move your settler, found a town and mine as much gold as possible within twenty turns!\n"
				+ "Plains and forests adjacent to your town provide food and wood.");
		instructionsField.setEditable(false);
		add(instructionsField);
	}

	/** returns to the main menu */
	private void displayMainMenu() {
		parentPanel.getMainWindow().getCardLayout().show(parentPanel.getMainWindow().getContentPane(), "MainMenu");
	}
}

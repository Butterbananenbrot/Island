package de.jhh4.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.jhh4.logic.RealEstateManager;
import de.jhh4.logic.ScoreCounter;
import de.jhh4.logic.Storage;
import de.jhh4.logic.TurnCounter;
import de.jhh4.logic.TurnManager;
import de.jhh4.pieces.Settler;
import de.jhh4.pieces.Worker;

/** a panel for the upper side of a BorderLayout, containing various buttons and other components */
public class UpperPanel extends JPanel {
	
	/** refers to the container in which this the upperPanel is included */
	private IslandViewContainer parentPanel;
	/** the layout of this element */
	private FlowLayout flowLayout = new FlowLayout();
//	/** to return to the main menu */
//	private JButton returnButton = new JButton("Return to main menu");
	/** displays the current turn of the game */
	private JLabel turnLabel = new JLabel("Turn: 1/20"); 
	/** displays the current score */
	private JLabel scoreLabel = new JLabel("Score: 0"); 
	/** displays the current food storage */
	private JLabel foodLabel = new JLabel("Food: 0");
	/** displays the current wood storage */
	private JLabel woodLabel = new JLabel("Wood: 0");
	/** displays the current stone storage */
//	private JLabel stoneLabel = new JLabel("Stone: 0");
	/** builds a settler */
	private JButton buildSettlerButton = new JButton ("Train a settler for " + Settler.FOODCOST + " food and " + Settler.WOODCOST + " wood");
	/** builds a worker*/
	private JButton buildWorkerButton = new JButton ("Train a miner for " + Worker.FOODCOST + " food and " + Worker.WOODCOST + " wood");
	/** starts the next turn */
	private JButton nextTurnButton = new JButton("Next Turn");
	
	
	/** creates a new UpperPanel using the parentPanel */
	public UpperPanel(IslandViewContainer parentPanel) {
		this.parentPanel = parentPanel;
		setLayout(flowLayout);
		create();
	}

	/** 
	 * adds UI elements to the top panel 
	 * adds action listeners using lambda expressions where needed
	 */
	private void create() {
		
		//currently moved to the lower panel
		// klicking the RETURN button will display the main menu
//		add(returnButton);
//		returnButton.addActionListener(klick -> displayMainMenu());	

		add(foodLabel);
		add(woodLabel);
		
//		TODO currently stone is treated as gold and used for scoring, to be added in v2
//		add(stoneLabel); 
		
		add(buildSettlerButton);
		buildSettlerButton.addActionListener(klick -> parentPanel.getMainWindow().getLogicCenter().getPieceMover().createSettler());
		
		// klicking the WORKER button will create a worker on the first town built
		add(buildWorkerButton);
		buildWorkerButton.addActionListener(klick -> parentPanel.getMainWindow().getLogicCenter().getPieceMover().createWorker());
		
		// klicking the NEXT TURN button will collect ressources and advance the turn counter
		add(nextTurnButton); 
		nextTurnButton.addActionListener(klick -> {
			parentPanel.getMainWindow().getLogicCenter().getTurnManager().nextTurn();
//			TurnManager.nextTurn(); leftover from when nextTurn was static
			scoreLabel.setText("Score: " + ScoreCounter.getScore());
			foodLabel.setText("Food: " + Storage.getFoodInStorage());
			woodLabel.setText("Wood: " + Storage.getWoodInStorage());
//			stoneLabel.setText("Stone: " + Storage.getStoneInStorage());
			turnLabel.setText("Turn: " + TurnCounter.getTurn() +"/20");
			
		});
		
		add(turnLabel);
		add(scoreLabel);
		
		
	}

//	/** returns to the main menu */
//	private void displayMainMenu() {
//		parentPanel.getMainWindow().getCardLayout().show(parentPanel.getMainWindow().getContentPane(), "MainMenu");
//	}

	/**
	 * @return the foodLabel
	 */
	public JLabel getFoodLabel() {
		return foodLabel;
	}

	/**
	 * @return the woodLabel
	 */
	public JLabel getWoodLabel() {
		return woodLabel;
	}

	/**
	 * @param foodLabel the foodLabel to set
	 */
	public void setFoodLabel(JLabel foodLabel) {
		this.foodLabel = foodLabel;
	}

	/**
	 * @param woodLabel the woodLabel to set
	 */
	public void setWoodLabel(JLabel woodLabel) {
		this.woodLabel = woodLabel;
	}

}

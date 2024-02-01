package de.jhh4.backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * manages the loading and saving of highscores
 */
public class HighscoreCenter {
	
	/**
	 * the file attribute to refer to the txt file
	 */
	private File highscoreFile;
	
	/**
	 * To refer to the custom reader
	 */
	private HighscoreReader highscoreReader ;

	/**
	 * constructs a new center to manage reading and writing scores
	 * @param highscoreFile where the text is
	 * @param highscoreReader which reads the text
	 * @param textfromFile the scores
	 */
	public HighscoreCenter() {
		this.highscoreFile = new File("highscores/highscores.txt");
		this.highscoreReader = new HighscoreReader();
	}
	
	/**
	 * provides the highscores from an external .txt file 
	 * @return a String that contains the scores
	 */
	public String getHighscoresForDisplay() {
		String textfromFile = highscoreReader.readHighscores(highscoreFile);
		return textfromFile;
	}
	
	/**
	 * this method inserts the new score into the existing list and saves the list to the file
	 * 
	 * most of it was written by ChatGPT 4.0 using the prompt:
	 * 		please write me a method that will read the provided document 
	 * 		and enable me to insert an extra line at the appropriate position based on the score attained. 
	 * 
	 * @param name the player's name
	 * @param score the score attained
	 */
    public void saveScore(String name, int score) {
        // Read the existing scores
        List<String> scores = new ArrayList<>();
        try (Scanner scanner = new Scanner(highscoreFile)) {
            while (scanner.hasNextLine()) {
                scores.add(scanner.nextLine());
            }
        } catch (IOException exception) {
        	exception.printStackTrace();
            return;
        }

        // Find the position where the new score should be inserted
        int position = 0;
        for (String line : scores) {
        	int existingScore = Integer.parseInt(line.split(" - ")[0].replace("points", "").trim());
            if (score <= existingScore) {
                position++;
            } else {
                break;
            }
        }

        // Insert the new score
        scores.add(position, score + " points - " + name);

        // Write the updated list back to the file
        try (FileWriter writer = new FileWriter(highscoreFile)) {
            for (String line : scores) {
                writer.write(line + "\n");
            }
        } catch (IOException exception) {
        	exception.printStackTrace();
        }
    }
	

}

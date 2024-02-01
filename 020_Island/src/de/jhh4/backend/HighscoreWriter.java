package de.jhh4.backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * writes the new Score into the highscore table file and saves it 
 * currently not used
 */
public class HighscoreWriter {

	/** write the new file
	 * 
	 * @param target the list
	 * @param text the content
	 */
	public void writeNewHighscores(File target, String text) {
		try(
				Writer writer = new FileWriter(target, true);
				BufferedWriter bufferedwriter = new BufferedWriter(writer);
		){
			bufferedwriter.newLine();
			bufferedwriter.write(text);
			
		}catch(IOException exception) {
			exception.printStackTrace();
			System.out.println("New Scores could not be saved.");
		}
	}
}

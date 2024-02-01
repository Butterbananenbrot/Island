package de.jhh4.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * reads the highscores from the .txt file
 */
public class HighscoreReader {

	/**
	 * uses BufferedReader, which decorates FileReader 
	 * TODO "list could not be loaded" in highscore list in catch block
	 * @param source
	 * @return
	 */
	public String readHighscores(File source) {
		String returnValue = "";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(source))){
			
			while(true) {
				String readLine = reader.readLine();
				if(readLine == null) {
					break;
				}
				returnValue = returnValue + readLine + "\n"; //reads texts line-by-line
			}
			
		}catch(IOException exception) { 
			exception.printStackTrace();
			return "None have come before you - you are a true pioneer."; // to be displayed if the specified .txt file could not be loaded
		}
		
		return returnValue;
	}
}

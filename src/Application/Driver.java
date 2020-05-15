package Application;

import java.util.ArrayList;

public class Driver 
{

	public static void main(String[] args) 
	{
		// Example Database
		Database database = new Database();
		
		// Filling database from files
		database.allWordsFromFile();
		database.nounsFromFile();
		database.adjectivesFromFile();
		database.verbsFromFile();
		database.glossariesFromFile();
		
		// Displaying the contents
		database.displayNouns(true);
		database.displayAllWords(true);
		database.displayAdjectives(true);
		database.displayVerbs(true);
		database.displayGlossaries();
				
		// Putting the database back into the files
		database.nounsToFile();
		database.adjectivesToFile();
		database.verbsToFile();
		database.glossariesToFile();
		database.allWordsToFile();
	}

}

package Application;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{

	// Creating the database
	static Database database = new Database();
	
	// Scanner for reading user input
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		// Int for holding user's choice
		int choice = 0;
		
		// Starting up the application
		startApplication();
		
		// Looping letting the user make their choices
		while (choice != 5) {
			
			// Getting the user's main menu choice, reprompting if needed
			displayMainMenu();
			choice = Integer.parseInt(userInput.nextLine());
			while (choice <= 0 || choice > 5) {
				System.out.println("INVALID: Please select a choice from the menu!");
				displayMainMenu();
				choice = Integer.parseInt(userInput.nextLine());
			}
			
			// Take appropriate action for user's choice
			switch(choice) {
				case 1:
					enterNewWord();
					break;
				case 2:
					displayWords();
					break;
				case 3:
					translateWord();
					break;
				case 4:
					glossaryHandler();
					break;
				case 5:
					endApplication();
					break;
			}
		}
				
	}
	
	public static void displayMainMenu() {
		System.out.println("\n**************");
		System.out.println("**** MENU ****");
		System.out.println("**************");
		System.out.println("1. Enter a new Word");
		System.out.println("2. Display words");
		System.out.println("3. Translate a word");
		System.out.println("4. Go to Glossaries");
		System.out.println("5. End the program");
		System.out.print("Enter the number of the choice you select: ");
	}
	
	public static void startApplication() {
		
		// Filling database from files
		database.allWordsFromFile();
		database.nounsFromFile();
		database.adjectivesFromFile();
		database.verbsFromFile();
		database.glossariesFromFile();
		
		// Printing welcome message
		System.out.println("#########################################");
		System.out.println("# Welcome to the Translator Application #");
		System.out.println("#########################################\n");
	}
	
	public static void enterNewWord() {
		
		// Hold the user's choice
		int choice = 0;
		
		// Getting the user input
		newWordMenu();
		choice = Integer.parseInt(userInput.nextLine());
		while (choice <= 0 || choice > 4) {
			System.out.println("INVALID: Please select a choice from the menu!");
			newWordMenu();
			choice = Integer.parseInt(userInput.nextLine());
		}
		
		switch (choice) {
			case 1:
				enterNoun();
				break;
			case 2:
				enterVerb();
				break;
			case 3:
				enterAdjective();
				break;
			case 4:
				enterPhrase();
				break;
			
		}
		
		System.out.println("Your word has been added to the database!");
		
	}
	
	
	public static void displayWords() {
		
		// Hold the user's choice
		int choice = 0;
		
		// Getting the user input
		displayWordMenu();
		choice = Integer.parseInt(userInput.nextLine());
		while (choice <= 0 || choice > 4) {
			System.out.println("INVALID: Please select a choice from the menu!");
			displayWordMenu();
			choice = Integer.parseInt(userInput.nextLine());
		}
		
		// Displaying the correct set of words
		switch (choice) {
			case 1:
				database.displayAllWords(true);
				break;
			case 2:
				database.displayNouns(true);
				break;
			case 3:
				database.displayVerbs(true);
				break;
			case 4:
				database.displayAdjectives(true);
				break;
			
		}
	}

	public static void translateWord() {
		// Hold the user's choice
		int choice = 0;
				
		// Getting the user input
		translateMenu();
		choice = Integer.parseInt(userInput.nextLine());
		while (choice <= 0 || choice > 2) {
			System.out.println("INVALID: Please select a choice from the menu!");
			translateMenu();
			choice = Integer.parseInt(userInput.nextLine());
		}
		
		// Get the word to translate
		System.out.print("Enter the word to translate: ");
		String word = userInput.nextLine().toLowerCase();
				
		// Translating the correct direction
		switch (choice) {
			case 1:
				word = database.translateFromSpanish(word);
				break;
			case 2:
				word = database.translateFromEnglish(word);
				break;
		}
		System.out.println("Searching ...");
		System.out.println(word + "\n");
		
	}
	
	
	public static void glossaryHandler() {
		
		// Hold the user's choice
		int choice = 0;
						
		// Getting the user input
		glossaryMenu();
		choice = Integer.parseInt(userInput.nextLine());
		while (choice <= 0 || choice > 4) {
			System.out.println("INVALID: Please select a choice from the menu!");
			glossaryMenu();
			choice = Integer.parseInt(userInput.nextLine());
		}
		
		switch (choice) {
			case 1:
				database.displayGlossaries();
				break;
			case 2:
				displayGlossaryList().display();
				break;
			case 3:
				createGlossary();
				break;
			case 4:
				Glossary g = displayGlossaryList();
				addWordToGlossary(g);
				break;
		}
		
	}
	
	private static void createGlossary() {
		
		// Get the title for the glossary
		System.out.print("Enter the title: ");
		String title = userInput.nextLine().toLowerCase();
		
		// Add to the list of glosarries
		database.addGlossary(new Glossary(title));
	}
	public static void endApplication() {
		
		// Putting the database back into the files
		database.nounsToFile();
		database.adjectivesToFile();
		database.verbsToFile();
		database.glossariesToFile();
		database.allWordsToFile();
		
		// Printing closing message
		System.out.println("\n#############");
		System.out.println("# THANK YOU #");
		System.out.println("#############\n");
		
	}
	
	private static void addWordToGlossary(Glossary g) {
		// Variables for a adjective
		String english;
		String spanish;
				
		// Getting the input from the user
		System.out.print("Enter the word in english: ");
		english = userInput.nextLine().toLowerCase();
		System.out.print("Enter the word in spanish: ");
		spanish = userInput.nextLine().toLowerCase();
		
		g.addWord(new Word(english, spanish));
		database.addWord(new Word(english, spanish));
	}
	
	private static void glossaryMenu() {
		
		// Getting action to take for glossaries
		System.out.println("\nWhat action would you like to take?");
		System.out.println("1. Display all glossaries");
		System.out.println("2. Display a single glossary");
		System.out.println("3. Create a new glossary");
		System.out.println("4. Add a word to a glossary");
		System.out.print("Enter the number of the choice you select: ");
	}
	
	private static void enterNoun() {
		
		// Variables for a noun
		String english;
		String spanish;
		String gender;
		
		// Getting the input from the user
		System.out.print("Enter the word in english: ");
		english = userInput.nextLine().toLowerCase();
		System.out.print("Enter the word in spanish: ");
		spanish = userInput.nextLine().toLowerCase();
		System.out.print("Is the word masculine (M) or Feminine (F) or anything else for both: ");
		gender = userInput.nextLine().toUpperCase();
		
		// Adding the noun to the database
		if (gender.equals("M")) {
			database.addNoun(new Noun(english, spanish, Gender.MASCULINE));
		}
		else if (gender.equals("F")) {
			database.addNoun(new Noun(english, spanish, Gender.FEMININE));
		}
		else {
			database.addNoun(new Noun(english, spanish, Gender.BOTH));
		}
		
		// Adding it to the list of words
		database.addWord(new Word(english, spanish));
	}
	
	private static void enterAdjective() {
		
		// Variables for a adjective
		String english;
		String spanish;
		
		// Getting the input from the user
		System.out.print("Enter the word in english: ");
		english = userInput.nextLine().toLowerCase();
		System.out.print("Enter the word in spanish: ");
		spanish = userInput.nextLine().toLowerCase();
		
		// Adding the adjective to the database
		database.addAdjective(new Adjective(english, spanish));
		
		// Adding it to the list of words
		database.addWord(new Word(english, spanish));
	}
	
	private static void enterPhrase() {
		
		// Variables for a adjective
		String english;
		String spanish;
		
		// Getting the input from the user
		System.out.print("Enter the word in english: ");
		english = userInput.nextLine().toLowerCase();
		System.out.print("Enter the word in spanish: ");
		spanish = userInput.nextLine().toLowerCase();
		
		// Adding it to the list of words
		database.addWord(new Word(english, spanish));
	}
	
	private static void enterVerb() {
		
		// Variables for a noun
		String english;
		String spanish;
		ArrayList<String> present = new ArrayList<String>();
		ArrayList<String> preterit = new ArrayList<String>();
		ArrayList<String> imperfect = new ArrayList<String>();
		ArrayList<String> future = new ArrayList<String>();
		String temp;
		
		// Getting the verb and its translation
		System.out.print("Enter the word in english: ");
		english = userInput.nextLine().toLowerCase();
		System.out.print("Enter the word in spanish: ");
		spanish = userInput.nextLine().toLowerCase();

		// Get the present tense
		System.out.println("\nENTER THE PRESENT TENSE:");
		System.out.print("Yo: ");
		temp = userInput.nextLine().toLowerCase();
		present.add(temp);
		System.out.print("Tú: ");
		temp = userInput.nextLine().toLowerCase();
		present.add(temp);
		System.out.print("Él/Ella/Usted: ");
		temp = userInput.nextLine().toLowerCase();
		present.add(temp);
		System.out.print("Nosotros: ");
		temp = userInput.nextLine().toLowerCase();
		present.add(temp);
		System.out.print("Ellos/Ellas/Ustedes: ");
		temp = userInput.nextLine().toLowerCase();
		present.add(temp);
		
		// Get the preterit tense
		System.out.println("\nENTER THE PRETERIT TENSE:");
		System.out.print("Yo: ");
		temp = userInput.nextLine().toLowerCase();
		preterit.add(temp);
		System.out.print("Tú: ");
		temp = userInput.nextLine().toLowerCase();
		preterit.add(temp);
		System.out.print("Él/Ella/Usted: ");
		temp = userInput.nextLine().toLowerCase();
		preterit.add(temp);
		System.out.print("Nosotros: ");
		temp = userInput.nextLine().toLowerCase();
		preterit.add(temp);
		System.out.print("Ellos/Ellas/Ustedes: ");
		temp = userInput.nextLine().toLowerCase();
		preterit.add(temp);
		
		// Get the imperfect tense
		System.out.println("\nENTER THE IMPERFECT TENSE:");
		System.out.print("Yo: ");
		temp = userInput.nextLine().toLowerCase();
		imperfect.add(temp);
		System.out.print("Tú: ");
		temp = userInput.nextLine().toLowerCase();
		imperfect.add(temp);
		System.out.print("Él/Ella/Usted: ");
		temp = userInput.nextLine().toLowerCase();
		imperfect.add(temp);
		System.out.print("Nosotros: ");
		temp = userInput.nextLine().toLowerCase();
		imperfect.add(temp);
		System.out.print("Ellos/Ellas/Ustedes: ");
		temp = userInput.nextLine().toLowerCase();
		imperfect.add(temp);
		
		// Get the future tense
		System.out.println("\nENTER THE FUTURE TENSE:");
		System.out.print("Yo: ");
		temp = userInput.nextLine().toLowerCase();
		future.add(temp);
		System.out.print("Tú: ");
		temp = userInput.nextLine().toLowerCase();
		future.add(temp);
		System.out.print("Él/Ella/Usted: ");
		temp = userInput.nextLine().toLowerCase();
		future.add(temp);
		System.out.print("Nosotros: ");
		temp = userInput.nextLine().toLowerCase();
		future.add(temp);
		System.out.print("Ellos/Ellas/Ustedes: ");
		temp = userInput.nextLine().toLowerCase();
		future.add(temp);
		
		//  Add the verb to the list of verbs
		database.addVerb(new Verb(english, spanish, present, preterit, imperfect, future));
			
		// Adding it to the list of words
		database.addWord(new Word(english, spanish));
	}
	
	private static void newWordMenu() {	
		// Getting type of word from the user
		System.out.println("\nWhat type of word would you like to enter?");
		System.out.println("1. Enter a new Noun");
		System.out.println("2. Enter a new Verb");
		System.out.println("3. Enter a new Adjective");
		System.out.println("4. Enter a new Phrase");
		System.out.print("Enter the number of the choice you select: ");
	}
	
	private static void displayWordMenu() {	
		// Getting type of word from the user
		System.out.println("\nWhat do you want to display?");
		System.out.println("1. All words");
		System.out.println("2. All nouns");
		System.out.println("3. All verbs");
		System.out.println("4. All Adjectives");
		System.out.print("Enter the number of the choice you select: ");
	}
	
	
	private static void translateMenu() {	
		// Getting type of word from the user
		System.out.println("\nWhich direction would you like to translate?");
		System.out.println("1. To English");
		System.out.println("2. To Spanish");
		System.out.print("Enter the number of the choice you select: ");
	}
	
	public static Glossary displayGlossaryList() {
		
		
		// The choice  of the user
		int choice = 0;
		
		// The header
		System.out.println("LIST OF GLOSSARIES");
		
		// Display the list and get the glossary object
		for (int i = 0; i < database.getGlossaries().size(); i++) {
			System.out.println((i+1) + ". " + database.getGlossaries().get(i).getTitle());
		}
		System.out.print("Enter the number of the choice you select: ");
		choice = Integer.parseInt(userInput.nextLine());
		while (choice <= 0 || choice > database.getGlossaries().size()) {
			System.out.println("INVALID: Please select a choice from the menu!");
			// The header
			System.out.println("LIST OF GLOSSARIES");
			
			// Display the list and get the glossary object
			for (int i = 0; i < database.getGlossaries().size(); i++) {
				System.out.println((i+1) + ". " + database.getGlossaries().get(i).getTitle());
			}
			System.out.print("Enter the number of the choice you select: ");
			choice = Integer.parseInt(userInput.nextLine());
		}
		
		
		return database.getGlossaries().get(choice - 1);
		
		
	}

}

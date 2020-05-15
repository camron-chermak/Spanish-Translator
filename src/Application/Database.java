package Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Database 
{
	
	private ArrayList<Word> allWords;
	private ArrayList<Verb> verbs;
	private ArrayList<Noun> nouns;
	private ArrayList<Adjective> adjectives;
	private ArrayList<Glossary> glossaries;
	
	public Database() 
	{
		this.allWords = new ArrayList<Word>();
		this.verbs = new ArrayList<Verb>();
		this.nouns = new ArrayList<Noun>();
		this.adjectives = new ArrayList<Adjective>();
		this.glossaries = new ArrayList<Glossary>();
	}
	
	public void nounsToFile() 
	{
		
		File file = new File("Nouns.txt");
		Noun current;
		
		// Updating file
        try (PrintWriter output = new PrintWriter(file)) 
        {
            for (int i = 0; i < nouns.size() - 1; i++) {
            	current = nouns.get(i);
            	output.print(current.getEnglish() + " ");
            	output.print(current.getSpanish() + " ");
            	output.println(current.getGender());
            }
            // Print the last one separate so no newline
            current = nouns.get(nouns.size() - 1);
        	output.print(current.getEnglish() + " ");
        	output.print(current.getSpanish() + " ");
        	output.print(current.getGender());
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Problem outputting to the file");
        }
	}
	
	public void adjectivesToFile() 
	{

		File file = new File("Adjectives.txt");
		Adjective current;
		
		// Updating file
        try (PrintWriter output = new PrintWriter(file)) 
        {
            for (int i = 0; i < adjectives.size() - 1; i++) {
            	current = adjectives.get(i);
            	output.print(current.getEnglish() + " ");
            	output.println(current.getSpanish());
            }
            // Print the last one separate so no newline
            current = adjectives.get(adjectives.size() - 1);
        	output.print(current.getEnglish() + " ");
        	output.print(current.getSpanish());
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Problem outputting to the file");
        }
	}
	
	public void allWordsToFile() 
	{
		File file = new File("AllWords.txt");
		Word current;
		
		// Updating file
        try (PrintWriter output = new PrintWriter(file)) 
        {
            for (int i = 0; i < allWords.size() - 1; i++) {
            	current = allWords.get(i);
            	output.println(current.getEnglish());
            	output.println(current.getSpanish());
            }
            // Print the last one separate so no newline
            current = allWords.get(allWords.size() - 1);
        	output.println(current.getEnglish());
        	output.print(current.getSpanish());
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Problem outputting to the file");
        }
		
	}
	
	public void verbsToFile() 
	{

		File file = new File("Verbs.txt");
		Verb current;
		
		// Updating the file
        try (PrintWriter output = new PrintWriter(file)) 
        {
            for (int i = 0; i < verbs.size() - 1; i++) {
            	current = verbs.get(i);
            	output.print(current.getEnglish() + "\n");
            	output.print(current.getSpanish() + "\n");
            	for (int j = 0; j < current.getPresent().size() - 1; j++) {
            		output.print(current.getPresent().get(j) + " ");
            	}
            	output.println(current.getPresent().get(current.getPresent().size() - 1));
            	for (int j = 0; j < current.getPreterit().size() - 1; j++) {
            		output.print(current.getPreterit().get(j) + " ");
            	}
            	output.println(current.getPreterit().get(current.getPreterit().size() - 1));
            	for (int j = 0; j < current.getImperfect().size() - 1; j++) {
            		output.print(current.getImperfect().get(j) + " ");
            	}
            	output.println(current.getImperfect().get(current.getImperfect().size() - 1));
            	for (int j = 0; j < current.getFuture().size() - 1; j++) {
            		output.print(current.getFuture().get(j) + " ");
            	}
            	output.println(current.getFuture().get(current.getFuture().size() - 1));	
            }
            current = verbs.get(verbs.size() - 1);
        	output.print(current.getEnglish() + "\n");
        	output.print(current.getSpanish() + "\n");
        	for (int j = 0; j < current.getPresent().size() - 1; j++) {
        		output.print(current.getPresent().get(j) + " ");
        	}
        	output.println(current.getPresent().get(current.getPresent().size() - 1));
        	for (int j = 0; j < current.getPreterit().size() - 1; j++) {
        		output.print(current.getPreterit().get(j) + " ");
        	}
        	output.println(current.getPreterit().get(current.getPreterit().size() - 1));
        	for (int j = 0; j < current.getImperfect().size() - 1; j++) {
        		output.print(current.getImperfect().get(j) + " ");
        	}
        	output.println(current.getImperfect().get(current.getImperfect().size() - 1));
        	for (int j = 0; j < current.getFuture().size() - 1; j++) {
        		output.print(current.getFuture().get(j) + " ");
        	}
        	output.print(current.getFuture().get(current.getFuture().size() - 1));	
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Problem outputting to the file");
        }
	}
	
	public void glossariesToFile() 
	{

		File file = new File("Glossaries.txt");
		Glossary current;
		ArrayList<Word> words;
		Word currWord;
		
		// Updating file
        try (PrintWriter output = new PrintWriter(file)) 
        {
            for (int i = 0; i < glossaries.size() - 1; i++) 
            {
            	current = glossaries.get(i);
            	output.println("Glossary");
            	output.println(current.getTitle());
            	words = current.getWords();
            	for (int j = 0; j < words.size(); j++) 
            	{
            		currWord = words.get(j);
            		output.println(currWord.getEnglish());
                	output.println(currWord.getSpanish());
            	}
            	
            }
            // Print the last one separate so no newline
            current = glossaries.get(glossaries.size() - 1);
        	output.println("Glossary");
        	output.println(current.getTitle());
        	words = current.getWords();
        	for (int j = 0; j < words.size() - 1; j++) 
        	{
        		currWord = words.get(j);
        		output.println(currWord.getEnglish());
            	output.println(currWord.getSpanish());
        	}
        	currWord = words.get(words.size() - 1);
    		output.println(currWord.getEnglish());
        	output.print(currWord.getSpanish());
        	
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Problem outputting to the file");
        }
	}
	
	
	
	public void verbsFromWords() {
		for (int i = 0; i < allWords.size(); i++) 
		{
			if (allWords.get(i) instanceof Verb) 
			{
				verbs.add(((Verb)allWords.get(i)));
			}
		}
	}
	
	public void nounsFromWords() 
	{
		for (int i = 0; i < allWords.size(); i++) 
		{
			if (allWords.get(i) instanceof Noun) 
			{
				nouns.add(((Noun)allWords.get(i)));
			}
		}
	}
	
	public void adjectivesFromWords() 
	{
		for (int i = 0; i < allWords.size(); i++) 
		{
			if (allWords.get(i) instanceof Adjective) 
			{
				adjectives.add(((Adjective)allWords.get(i)));
			}
		}
	}
	
	public void addWord(Word w) 
	{
		this.allWords.add(w);
	}
	
	public void addVerb(Verb v) 
	{
		this.verbs.add(v);
	}
	
	public void addNoun(Noun n) 
	{
		this.nouns.add(n);
	}
	
	public void addAdjective(Adjective a) 
	{
		this.adjectives.add(a);
	}
	
	public void addGlossary(Glossary g) 
	{
		this.glossaries.add(g);
	}
	
	public ArrayList<Word> getAllWords() 
	{
		return this.allWords;
	}
	
	public ArrayList<Verb> getVerbs() 
	{
		return this.verbs;
	}
	
	public ArrayList<Noun> getNouns() 
	{
		return this.nouns;
	}
	
	public ArrayList<Adjective> getAdjectives() 
	{
		return this.adjectives;
	}
	
	public ArrayList<Glossary> getGlossaries() 
	{
		return this.glossaries;
	}
	
	public void displayAllWords(boolean sorted) 
	{
		// Header
		System.out.println();
		System.out.println("#################");
		System.out.println("#   All Words   #");
		System.out.println("#################");
		
		if (sorted) 
		{
			Collections.sort(this.allWords);     
			System.out.println(this.allWords);
		}
		else 
		{
			System.out.println(this.allWords);
		}
	}
	
	public void displayVerbs(boolean sorted) 
	{
		// Header
		System.out.println();
		System.out.println("#################");
		System.out.println("#     Verbs     #");
		System.out.println("#################");
		
		if (sorted) 
		{
			Collections.sort(this.verbs);     
			System.out.println(this.verbs);
		}
		else 
		{
			System.out.println(this.verbs);
		}
	}
	
	public void displayNouns(boolean sorted) 
	{
		// Header
		System.out.println();
		System.out.println("#################");
		System.out.println("#     Nouns     #");
		System.out.println("#################");
		
		
		if (sorted) 
		{
			Collections.sort(this.nouns);     
			System.out.println(this.nouns);
		}
		else 
		{
			System.out.println(this.nouns);
		}
	}
	
	public void displayAdjectives(boolean sorted) 
	{
		// Header
		System.out.println();
		System.out.println("#################");
		System.out.println("#   Adjectives  #");
		System.out.println("#################");
		
		if (sorted) 
		{
			Collections.sort(this.adjectives);     
			System.out.println(this.adjectives);
		}
		else 
		{
			System.out.println(this.adjectives);
		}
	}
	
	public void displayGlossaries() 
	{
		// Header
		System.out.println();
		System.out.println("#################");
		System.out.println("#   Glossaries  #");
		System.out.println("#################");
	
		System.out.println(this.glossaries);
	}

}

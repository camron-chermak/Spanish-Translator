package Application;

import java.util.ArrayList;
import java.util.Collections;

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

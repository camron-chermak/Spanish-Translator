package Application;

import java.util.ArrayList;

public class Glossary 
{

	private String title;
	private ArrayList<Word> words;
	
	public Glossary(String title) 
	{
		this.title =  title;
		this.words = new ArrayList<Word>();
	}
	
	public String getTitle() 
	{
		return this.title;
	}
	
	public ArrayList<Word> getWords() 
	{
		return this.words;
	}
	
	public void addWord(Word word) 
	{
		this.words.add(word);
	}
	
	@Override
	public String toString() 
	{
		return "\nGlossary: " + this.title + "\n" + this.words.toString();
	}
}

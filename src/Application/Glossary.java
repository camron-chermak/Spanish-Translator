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
	
	public Glossary(String title, ArrayList<Word> words) 
	{
		this.title =  title;
		this.words = words;
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
	
	public void display()
	{
		System.out.println("Glossary: " + this.title);
		for (int i = 0; i < words.size(); i++) {
			words.get(i).display();
		}
	}
	
	@Override
	public String toString() 
	{
		return "\nGlossary: " + this.title + "\n" + this.words.toString();
	}
}

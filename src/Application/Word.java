package Application;

public class Word  implements Comparable<Word>
{
	
	private String spanish;
	private String english;
	
	public Word(String english, String spanish) 
	{
		this.english = english;
		this.spanish = spanish;
	}
	
	public String getEnglish() 
	{
		return this.english;
	}
	
	public String getSpanish()  
	{
		return this.spanish;
	}
	
	public void display() 
	{
		System.out.println(this.spanish + " --> " + this.english);
	}
	
	@Override
	public int compareTo(Word word) 
	{
		return this.spanish.compareTo(word.getSpanish());
	}

}

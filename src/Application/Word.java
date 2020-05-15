package Application;

public class Word 
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

}

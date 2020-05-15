package Application;

import java.util.ArrayList;

public class Verb extends Word 
{
	private ArrayList<String> present;
	private ArrayList<String> preterit;
	private ArrayList<String> imperfect;
	private ArrayList<String> future;
	
	public Verb(String english, String spanish) 
	{
		super(english, spanish);
		this.present = new ArrayList<String>();
		this.preterit = new ArrayList<String>();
		this.imperfect = new ArrayList<String>();
		this.future = new ArrayList<String>();
	}
	
	public Verb(String english, String spanish, ArrayList<String> present, 
			ArrayList<String> preterit, ArrayList<String> imperfect,
			ArrayList<String> future) 
	{
		super(english, spanish);
		this.present = present;
		this.preterit = preterit;
		this.imperfect = imperfect;
		this.future = future;
	}
	
	public void setPresent(ArrayList<String> present) 
	{
		this.present = present;
	}
	
	public void setPreterit(ArrayList<String> preterit) 
	{
		this.preterit = preterit;
	}
	
	public void setImperfect(ArrayList<String> imperfect) 
	{
		this.imperfect = imperfect;
	}
	
	public void setFuture(ArrayList<String> future) 
	{
		this.future = future;
	}
	
	public ArrayList<String> getPresent() 
	{
		return this.present;
	}
	
	public ArrayList<String> getPreterit() 
	{
		return this.preterit;
	}
	
	public ArrayList<String> getImperfect() 
	{
		return this.imperfect;
	}
	
	public ArrayList<String> getFuture() 
	{
		return this.future;
	}
	
	@Override
	public String toString() 
	{
		String retString = "\nVerb:\n" + this.getSpanish() + " --> " + this.getEnglish(); 
		retString += "\nPresent --> " + this.present.toString();
		retString += "\nPreterit --> " + this.preterit.toString();
		retString += "\nImperfect --> " + this.imperfect.toString();
		retString += "\nFuture --> " + this.future.toString() + "\n"; 
		return retString;	
	}
	
}

package Application;

public class Adjective extends Word 
{
	
	public Adjective(String english, String spanish) 
	{
		super(english, spanish);
	}
	
	@Override
	public String toString() 
	{
		return "\nAdjective:\n" + this.getSpanish() + " --> " + this.getEnglish() + "\n";
	}

}

package Application;

public class Noun extends Word
{

	private Gender gender;
	
	public Noun(String english, String spanish, Gender gender) 
	{
		super(english, spanish);
		this.gender = gender;
	}
	
	public Gender getGender() 
	{
		return this.gender;
	}
	
	@Override
	public String toString() 
	{
		return "Noun{" + this.getSpanish() + " --> " + this.getEnglish() 
					+ ", " + this.gender + "}"; 
	}
}

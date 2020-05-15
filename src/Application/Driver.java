package Application;

import java.util.ArrayList;

public class Driver 
{

	public static void main(String[] args) 
	{
		// Example Noun
		Word noun = new Noun("dog", "perro", Gender.MASCULINE);
		System.out.println(noun);
		
		// Example Verb
		Word word = new Verb("to dance", "bailar");
		Verb verb = (Verb)word;
		ArrayList<String> present = new ArrayList<String>();
		present.add("bailo");
		present.add("bailas");
		present.add("baila");
		present.add("bailamos");
		present.add("bailan");
		verb.setPresent(present);
		ArrayList<String> preterit = new ArrayList<String>();
		preterit.add("bailé");
		preterit.add("bailaste");
		preterit.add("bailó");
		preterit.add("bailamos");
		preterit.add("bailaron");
		verb.setPreterit(preterit);
		ArrayList<String> imperfect = new ArrayList<String>();
		imperfect.add("bailaba");
		imperfect.add("bailabas");
		imperfect.add("bailaba");
		imperfect.add("bailábamos");
		imperfect.add("bailaban");
		verb.setImperfect(imperfect);
		ArrayList<String> future = new ArrayList<String>();
		future.add("bailaré");
		future.add("bailarás");
		future.add("bailará");
		future.add("bailaremos");
		future.add("bailarán");
		verb.setFuture(future);
		System.out.println(verb);
		
		// Example adjective
		Word adjective = new Adjective("pretty", "bonita");
		System.out.println(adjective);
		
		// Example glossary
		Glossary glossary = new Glossary("Teresa");
		glossary.addWord(noun);
		glossary.addWord(word);
		glossary.addWord(adjective);
		System.out.println(glossary);
	}

}

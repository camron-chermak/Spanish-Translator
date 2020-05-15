package Application;

import java.util.ArrayList;

public class Driver 
{

	public static void main(String[] args) 
	{
		// Example Noun
		Word noun = new Noun("dog", "perro", Gender.MASCULINE);
		noun.display();
		
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
		((Word)verb).display();
		
		// Example adjective
		Word adjective = new Adjective("pretty", "bonita");
		adjective.display();
		
		// Example glossary
		Glossary glossary = new Glossary("Teresa");
		glossary.addWord(noun);
		glossary.addWord(word);
		glossary.addWord(adjective);
		System.out.println(glossary);
		
		// Example Database
		Database database = new Database();
		database.addWord(noun);
		database.addWord(word);
		database.addWord(adjective);
		database.addVerb(verb);
		database.addGlossary(glossary);
		database.nounsFromWords();
		database.adjectivesFromWords();
		database.displayAllWords(true);
		database.displayNouns(true);
		database.displayVerbs(true);
		database.displayAdjectives(true);
		database.displayGlossaries();
	}

}

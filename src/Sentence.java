import java.util.ArrayList;
import java.util.Arrays;


public class Sentence {
	
	
	private ArrayList<Word> input;
	private ArrayList<ArrayList<Word>> nouns; // SHE gives THE DOG A BONE - includes pronouns for now
	private ArrayList<Word> verbs; //I DANCE, I LEARN to dance, I CAN learn to dance
	//private ArrayList<Word> infinitives;// I learn TO DANCE, I can learn TO DANCE
	//private ArrayList<Word> gerunds; //I go DANCING, I love LEARNING to dance, I was DANCING, 
	private ArrayList<ArrayList<Word>> adjectives; // the PRETTY GIRL likes the NICE DOG -- includes prettier, prettiest etc             
	//private ArrayList<ArrayList<Word>> adverbs; // she went QUICKLY, (more QUICKLY, most QUICKLY?)
	//private ArrayList<ArrayList<Word>> prepPhrases; // at 2pm, in the garden, with a shovel, like a boss, in order to live, because she could,  etc
	//private ArrayList<ArrayList<Word>> pronouns; // she, he, Edinburgh  - probably too complicated
	
	private Word questionWord;
	private Word punct;
	
	private boolean isQuestion;
	private boolean containsApostrophe = false;
	private String contractedWord;
	private String uncontractedWord;
	private int n;
	public int sentenceSize;
	
	
	public Sentence(ArrayList<Word> input, boolean isQuestion) {
		this.input = input;
		this.isQuestion = isQuestion;
		n = input.size();
		Word word;
		Word last = new Word();
		Word next = new Word();
		
		sentenceSize = input.size(); //to determine the sentence size i.e if the input is one word.
		
		ArrayList<Word> noun = new ArrayList<Word>();
		ArrayList<Word> adjPhrase = new ArrayList<Word>();
		
		verbs = new ArrayList<Word>();
		nouns = new ArrayList<ArrayList<Word>>();
	//	infinitives = new ArrayList<Word>();
		//gerunds = new ArrayList<Word>();
		adjectives = new ArrayList<ArrayList<Word>>();
		
		for (int i=0; i<n; i++) { // CONSTRUCTOR: goes through each word in sentence and if correct type, initializes instance variables
			word = input.get(i);
			 
			if (i>0) last = input.get(i-1);
			if (i<(n-1)) next = input.get(i+1);
			
						
			if (word.isContraction()){
				containsApostrophe = true;
				contractedWord = word.toString();
				uncontractedWord = word.unContract(next);
			}
			
			
			if (word.isDet()) {
				
				noun.add(word);
				
				}
			
			if (word.isNoun()) {
				noun.add(word);
				
				// create new list same as noun, add this to nouns, 
				 nouns.add(new ArrayList<Word>(noun));
			 
				noun.clear();				
			}
			
			if (word.isVerb()) {
				verbs.add(word);
			}
			
			if (word.isModal()) {
				verbs.add(word);
			}
			
		
			
			if (word.isAdjective()) {
				adjPhrase.add(word);
				if (next.isNoun()) {   //  includes described noun in adjectival phrase
					adjPhrase.add(next);
				}
					adjectives.add(new ArrayList<Word>(adjPhrase));
					
					//adjectives.add(new ArrayList<Word>(Arrays.asList(next)));
					adjPhrase.clear();
					
			//	if (last.isToBe() & ) {              finds described nouns when ordering is more complex
							
				}
			
			 
			
			if (word.isWH() && (questionWord == (null))) {
				questionWord = word;
			}	
			
			if (word.toString().equals(input.get(n-1).toString()) && (!noun.isEmpty())) {
				nouns.add(new ArrayList<Word>(noun));
			}
			
		}
		
		//Code used for testing purposes - prints all verbs in the sentence
		// for (Word j : verbs)
		//	System.out.println(j.getWord());
		 
		/* for (ArrayList<Word> j: nouns) 
			 for (int i = 0; i<j.size(); i++)
				 System.out.println(j.get(i).getWord() + i); */
		 
			 
		
	}		
			
	
	public ArrayList<ArrayList<Word>> getNouns() {
		return nouns;
	}


	public ArrayList<Word> getVerbs() {
		return verbs;
	}


	//public ArrayList<Word> getInfinitives() {
	//	return infinitives;
	//}


	//public ArrayList<Word> getGerunds() {
	//	return gerunds;
	//}


	public ArrayList<ArrayList<Word>> getAdjectives() {
		return adjectives;
	}


	public Word getPunct() {
		return punct;
	}


	public int getN() {
		return n;
	}


	public Word getQuestionWord() {
		return questionWord;
	}
	
	public ArrayList<Word> getUserInput() {
		return input;
	}
	
	public ArrayList<String> getUntaggedInput() {
		ArrayList<String> untagged = new ArrayList<String>();
		for (Word word : input) {
			untagged.add(word.toString());
		}
		return untagged;
	}
	
	
	
	
			
	/*public boolean isValidPunct() {
		if (punct.equals.null) return false;
		else return true;
	}
	*/
	
	// UPDATED 20TH
	public boolean isQuestion() {
			return isQuestion;
		}
				
	
	
	public boolean isWHQuestion() {
		if (questionWord != (null))    
			return true;
		else 
			return false;
	}
	
	public boolean isVerbQuestion() {
	
		if (verbs.isEmpty()) return false;
		Word verb1 = verbs.get(0);
		
		//ArrayList<ArrayList<Word>> nouns1 = getNouns();
		//System.out.println(nouns1);
		//ArrayList<Word> nounphrase1 = ((nouns1.get(0)));
		//System.out.println(nounphrase1);
		//Word noun1 = nounphrase1.get(0);
		Word noun1 = getNouns().get(0).get(0);
		
		int verbIndex = input.indexOf(verb1);
		int nounIndex = input.indexOf(noun1);
		
		if (verbIndex < nounIndex) return true; // if first verb comes before first noun, it is a verbQuestion
		else return false;
		}


	public boolean isConfirmationQuestion() {   // ending in "isn't she?, does it?" etc
		Word lastWord = input.get(n-1);
		if (lastWord.isNoun()) return true;
		else return false;
	}
		
	public boolean asksForDefinition() {
		for (int i = 0; i < input.size()-1; i++) {
			if (input.get(i).toString().equals("what") || input.get(i).toString().equals("who"))
				if (input.get(i+1).toString().equals("is") || input.get(i+1).toString().equals("are")|| input.get(i+1).toString().equals("were"))
					return true;
		}
		return false;
	}
	
	public String[] getDefinitionQuery() {
		String s = "";
		ArrayList<Word> in = new ArrayList<Word>();
		for (int i = 0; i < input.size()-1; i++) {
			if (input.get(i).toString().equals("what") || input.get(i).toString().equals("who"));
				if (input.get(i+1).toString().equals("is") || input.get(i+1).toString().equals("are") || input.get(i+1).toString().equals("were")){
					for (int j = 2; j < input.size(); j++)
						in.add(input.get(j));
					for (int j = 0; j < in.size(); j++)
						s += in.get(j).toString() + " ";
				}
		}
		s = s.substring(0, s.length() -1);
		if (s.substring(0,4).equals("the "))
				return new String[]{"the", s.substring(4)};
		else if (s.substring(0,2).equals("a "))
				return new String[] {"a", s.substring(2)};
		else if (s.substring(0,3).equals("an "))
					return new String[] {s.substring(3)};
		
		return new String[] {"", s};
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < input.size(); i++) {
			s += input.get(i).toString();
		}
		
		return s;
	}
	
	public boolean containsApostrophe(){
		return containsApostrophe;
	}
	
	
	public String removeApostrophe(String input){
		String newInput = input.replaceFirst(contractedWord, uncontractedWord);
		return newInput;
		
		
		
	}
	
	
	/*
	public boolean is NegQuestion
}		

	*/
	
}




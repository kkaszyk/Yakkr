
public class Word {
	
	private String text;
	private String tag;
	
	public Word (String te, String ta) {
		text = te;
		tag = ta;
	}
	
	public Word() {   // I added a constructor with no arguments, hope this isn't a bad idea?
		text = "";
		tag = "";
	}
	public String toString() {
		return text;
	}
	
	public String getTag() {
		return tag;
	}
	
	
	
	public boolean is(String s) {  //quick way to check if the text is equal to a string "s"
		if (text.equals(s)) return true;
		else return false;
	}
	
	public boolean isWH() {  //checks if it is a Wh- question word, including how. 
		
		if (text == "THAT") return false; // exception to having WDT tag
		else if (tag.equals("WP") || tag.equals("WRB") || tag.equals("WP$") || tag.equals("WDT")) 
			return true;
		
		else return false;
	}
	
	public boolean isModal () {
		
		if (tag.equals("MD")) return true;
		else return false;
		
	}
	
	public boolean isTrivial() { // tests for prepositions, conjunctions and other trivial words like um, er etc 
		
		if (tag.equals("CC") || tag.equals("UH") || tag.equals("IN") || tag.equals("RP")) return true;
		else return false;
		
	}
	
	public boolean isDet() { // any type of determiner or word that comes before a noun
		if (tag.equals("CD") || tag.equals("DT") || tag.equals("PDT") || tag.equals("PP$") || tag.equals("LS") || tag.equals("WH") || tag.equals("PRP$")) // (PP$ (one's) a determiner? and, what exactly is LS List item marker)
			return true;
		else return false;
	}
	
	
	public boolean isToBe(){// NEW METHOD 19TH MARCH, for use in extracting adjectives
		if (text.equals("be") || text.equals("is") || text.equals("are") || text.equals("am") || text.equals("were") || text.equals("was") || text.equals("been")) 
			return true;
		else return false;
	}

	public boolean isToDo(){
		if (text.equals("do") || text.equals("did") || text.equals("does") || text.equals("done"))
			return true;
		else return false;
	}
	
	public boolean isCreator(){
		if (text.equals("creator") || text.equals("maker") || text.equals("designer") || 
				text.equals("programmer") || text.equals("god") || text.equals("idol") || 
				text.equals("creators") || text.equals("makers") || text.equals("designers")
				|| text.equals("programmers") || text.equals("gods")  || text.equals("idols") || 
				text.equals("created") || text.equals("programmed") || text.equals("made") || text.equals("designed")) 
			return true;
		else return false;
	}
	 

	public boolean isNoun() { // any type of noun including proper, pronoun etc
		if (tag.equals("NN") || tag.equals("NNS") || tag.equals("NNP") || tag.equals("NNPS") || tag.equals("PP") || tag.equals("LS") || tag.equals("PRP"))// (PP$ (one's) a determiner? and, what exactly is LS List item marker)
			return true;
		else return false;
		
	}
	
	public boolean isVerb() { // any type of verb, including infinitive and gerund, INCLUDES LIKE) 
		if (tag.equals("VB") || tag.equals("VBD") || tag.equals("VBN") || tag.equals("VBP") || tag.equals("VBZ") || tag.equals("VB") || tag.equals("VBG") || text.equals("like")) {
			return true;
		}
		else return false;
	}
	
	public boolean isPast() { // simple past (did) and past participle (done)
		if (tag.equals("VBD") || tag.equals("VBN")) 	return true;
		
		else return false;
	}
	
	public boolean isIng() {
		if (text.endsWith("ing")) {
			return true;
		}
		else return false;
	}
	
	public Word capitalise() {
		String fst = text.substring(0,1);
		String capFst = fst.toUpperCase();
		text.replace(fst, capFst);
		return this;
		
	}
	
	
	/*public boolean isInfinitive() {
		if (tag.equals("VB")) return true;
		else return false;
		} */
	
//NEW CODE UPDATED TUES 13TH MARCH
	
	/*public boolean isGerund() {
		if (tag.equals("VBG")) return true;
		else return false;
		}
	*/
	
	
	public boolean isAdjective() {
		if (tag.startsWith("J")) return true; // includes comparative (bigger) and superlative (biggest) 
		else return false;
		}
	
	
	
	

	
	public boolean isContraction() {
		if (text.contains("'")) return true; // *** Must not pick up possessive cases eg Mary's pen should not be interpreted as Mary is pen. ?? 
												//possible method: if following word is NOUN (or NOTHING) and current word ISNT a question (what), then it is probably a possessive. otherwise, will be a contraction
		else return false;
	} 
	
	
	
	 
	
	




	/* 
	 	 
	 	CONVERTS A CONTRACTED WORD (eg they're) INTO TWO STRINGS AND RETURNS THEM AS AN ARRAY. THEY SHOULD THEN BE ADDED TO THE UNTAGGED SENTENCE, FOR RETAGGING. 
		This is because assigning the new tags 'manually' would require a lot of code.
		The "next" parameter is the VERB following the contraction, needed to differentiate between e.g. I'd = I would (do) or I had (done).
	*/
	
		public String unContract(Word next) {
		String fst, snd;
		
		String[] split = text.split("\'");  // assigns first word as everything before apostrophe.
		fst = split[0];
		snd = null;
		
		if (fst.endsWith("n")) { // exception: don't include the n for n't cases
			fst = fst.substring(0, fst.length()-1);  
		}
		if (fst.equals("wo")) fst = "will"; // exception: won't
		
		
		String suffix = split[1]; 
		
		if (suffix.equals("ll")) { // assigns second word depending on the suffix after the apostrophe.
			snd = "will";
			}
			
		if (suffix.equals("t")) {
			snd = "not";
		}
		
		if (suffix.equals("re")) {
			snd = "are";
		}
		
		if (suffix.equals("ve")) {
			snd = "have";
		}
		
		if (suffix.equals("m")) {
			snd = "am";
		}
		
		if (suffix.equals("d")) {
			if ((next.getTag()).equals("VBN")){
				snd = "had";
			}
			else if (fst.equals("where") || fst.equals("how") || fst.equals("when") || fst.equals("what")) {
				snd = "did"; // not very reliable but should be correct in most cases.
			}
			else {snd = "would";}
	}
		
	if (suffix.equals("s")) {
			if (fst.equals("let")) {snd = "us";} // exception: let's = let us
			if ((next.getTag()).equals("VBN")){
				snd = "has";
			}
			else {snd = "is";}
		}
	
	String output = fst +" "+ snd;
	return output;
	
}
	
	
	
	/*
	
	public boolean isPresentTense() {
		
	}*/
	
	public boolean isPastTense() {
		if(tag.contains("VBD")||tag.contains("VBN"))
			return true;
		else return false;		
	}
	
	/*ublic boolean isFutureTense() {
		
	}*/
	
}


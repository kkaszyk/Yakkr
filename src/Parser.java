import java.util.ArrayList;
import java.util.List;
import com.knowledgebooks.nlp.fasttag.FastTag;

public class Parser {
/* Receives user input from YakkrRunner, converts all to lower case 
 * Tags words in user input
 * Decides if the input is a question or statement
 * Decides what type of answer will be appropriate: independent statement, question, or response to question
 */
	
	public ArrayList<Word> tag(String s) {
		FastTag tagger = new FastTag();
		//A new FastTag object is created in order to gain access to the the library and tag the words
		
		String[] w = stringToList(s);
		List<String> w1 = new ArrayList<String>();
		
		for (int i = 0; i < w.length; i++)
			w1.add(w[i]);
		/*List<String> w - First we have to create a new Array, which will take the user input, and convert the String into 
		 * an ArrayList. It will take the sentence apart using a loop and store each word as a separate string in the 
		 * ArrayList. Use stringToList method below. 
		 */
		
		List<String> tags = new ArrayList<String>();
		tags = tagger.tag(w1);
		//List<String> tags - This is the list of tags that will be generated using FastTag
		 
		
		List<Word> words = new ArrayList<Word>();
		for(int i = 0; i < w.length; i++)
			words.add(new Word(w[i], tags.get(i)));
		
		for(int i = 0; i < w.length; i++)
			if (words.get(i).toString().equals("like") || words.get(i).toString().equals("love"))
				words.set(i, new Word(words.get(i).toString(), "VB"));
				
		/*List<Word> words - This is the list of words that will be created from the words(List<String> w) and 
		 * tags(List<String> tags)
		 */
			
		return (ArrayList<Word>) words;
	}
	
	public boolean isQuestion(String s) {
		char punctuation = s.charAt(s.length()-1);
		return punctuation == '?';
	}
	
	public String[] stringToList(String str) {
		String resultString = str.replaceAll("([a-z]+)[?:!.,;]*", "$1");//Removes punctuation
		String[] test = resultString.split(" ");
		return test;
	}
}

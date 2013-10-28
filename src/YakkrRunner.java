import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* I'm still thinking whether or not Question and Statement should be created as objects. Everything that is needed can be written without using
 * objects, right now the intent of having separate classes is just to split up the program for in order to keep it organised. We may also choose to make
 * Parser an actual object. As of now, the methods are all static, which means they can be accessed via Parser.methodName(), but I'm not sure this
 * is the best way to do it yet. 
 */

public class YakkrRunner {
	public static void main(String [] args) throws Exception {
		
		System.out.println("Hello!");
		
		//Create Objects that will be used to generate responses
		Parser parse = new Parser();
		ResponseGenerator gen = new ResponseGenerator();
		
		while (true) {
			System.out.print(">");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String sInput = in.readLine();
			
			sInput = sInput.toLowerCase();
			
			if (sInput.equals("goodbye") || sInput.equals("bye"))
				break;	
			
			ArrayList<Word> pSentence = parse.tag(sInput);
			
			
			
			
			
			
			boolean question = parse.isQuestion(sInput);
			//System.out.println("Is this a question? " + question);
			Sentence parsedSentence = new Sentence(pSentence, question);
			// if contains apostrophe, create a new parsed sentence with an adapted input string.
			if (parsedSentence.containsApostrophe()) {
				String newInput = parsedSentence.removeApostrophe(sInput);
				pSentence = parse.tag(newInput);
				parsedSentence = new Sentence(pSentence, question);
				
			}
				
			//prints tags for testing - should not be displayed in final gui form.
			for(int i = 0; i < pSentence.size(); i++)
			{
				System.out.println(pSentence.get(i).toString() + pSentence.get(i).getTag());
			}
				
			
			
			
			Reaction response = gen.createReaction(parsedSentence);
			
			System.out.println(response.getResponse());
			
		}
		
		System.out.println("Goodbye");
		/* Okay...The Runner receives input, uses Parser to convert the string into an ArrayList. Next it uses Question or Statement, depending on
		 * if its generating a question, or a statement. If its generating a statement, it will have a choice of generating a response to a question, 
		 * or a random sentence. This will all then be returned to the YakkrRunner and printed to the terminal, and later, when we have a GUI, to 
		 * the main frame of the program. 
		 */
		
		/* The YakkrRunner will really only take the user input and send it to the other classes. 
		 * We might need to distinguish between statements and questions here, but this may also be done in other classes. 
		 * The output will then be received and printed. 
		 * All GUI code will be written here. 
		 */
			
	}
}

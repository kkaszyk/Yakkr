import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Engine {
	private Parser parse;
	private yakkrgui gui;
	private ResponseGenerator gen;

	public Engine() {
		parse = new Parser();
		gen = new ResponseGenerator();
	}

	public void setGUI(yakkrgui userInterface) {
		gui = userInterface;
		gui.setResizable(false);
		gui.setTitle("YAKKR");
		gui.setAlwaysOnTop(true);
		gui.pack();
		gui.show();
		printStart();
	}

	public void printStart() {
		gui.println("YAKKR: " + "Hello!");
	}

	public void getResponses(String input) throws IOException {
		//gui.println(input);
		input = input.toLowerCase();
		
		ArrayList<Word> pSentence = parse.tag(input);

		for(int i = 0; i < pSentence.size(); i++)
		{
			System.out.println(pSentence.get(i).toString() + pSentence.get(i).getTag());
		}

		boolean question = parse.isQuestion(input);

		Sentence parsedSentence = new Sentence(pSentence, question);
		
		if (parsedSentence.containsApostrophe()) {
			String newInput = parsedSentence.removeApostrophe(input);
			pSentence = parse.tag(newInput);
			parsedSentence = new Sentence(pSentence, question);
		}
		
		Reaction response = gen.createReaction(parsedSentence);

		gui.println("YAKKR: " + response.getResponse());

		gui.displayEmotion(response.getEmotion());
	}
	
}

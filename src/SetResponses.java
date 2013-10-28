 import java.util.ArrayList;


public class SetResponses {
	
	private ArrayList<String> why; // arraylists of set responses of certain types, e.g. type 'why' could answer a why? question
	private ArrayList<String> how;
	private ArrayList<String> when;
	private ArrayList<String> which;
	private ArrayList<String> who;
	private ArrayList<String> what;
	private ArrayList<String> where;
	private ArrayList<String> confirmation;
	
	
	private ArrayList<String> greetings;
	private ArrayList<String> goodbyes;
	private ArrayList<String> personalInfo; // typical info about self e.g. name, 

	private ArrayList<String> agreement;
	private ArrayList<String> disagreement; 
	private ArrayList<String> topicChange;
	private ArrayList<String> promptMoreInput; 
	
	 
	
	
	// etc
	
	public SetResponses(){
		personalInfo = new ArrayList<String>();
		why = new ArrayList<String>();
		how = new ArrayList<String>();
		when = new ArrayList<String>();
		which = new ArrayList<String>();
		who = new ArrayList<String>();
		what = new ArrayList<String>();
		where = new ArrayList<String>();
		confirmation = new ArrayList<String>();
		
		agreement = new ArrayList<String>();
		disagreement = new ArrayList<String>();
		topicChange = new ArrayList<String>();
		promptMoreInput = new ArrayList<String>();
		
		// DON'T CHANGE ORDER OF ENTRIES, just append them on to the end. This is so we can refer to them by index.
		personalInfo.add("Who is your creator?");
		personalInfo.add("Who created you?");
		personalInfo.add("Who made you?");
		personalInfo.add("Who is your maker?");
		
		personalInfo.add("I'm YAKKR. What's your name?");
		personalInfo.add("It stands for the initials of my creators. Kinda lame, I know.");
		personalInfo.add("Their names are Yulia, Adam, Kuba, Kim and Rafal. I worship them everyday. You probably should too.");
		personalInfo.add("I'm only 2 weeks old... and a bit of a cutie apparently");
		personalInfo.add("I'm just a bot that likes talking. You could call me a chatterbot I guess.");
			
		why.add("Why do you ask?");
		why.add("Why should I trust you?");
		why.add("Why do you think?");
		why.add("Why so serious?");
		why.add("Just, because.");
		why.add("It just DOES ok!?");
		why.add("Because the creators programmed it that way. All hail the creators!");
		why.add("Must I always explain?");
		why.add("Everyone knows it anyways!");
		why.add("Because once upon a time I said so!");				
		
		how.add("I've actually been wondering how myself.");
		how.add("How do you expect me to know that?");
		how.add("I have a feeling it's something to do with the square root of pi. But I could be wrong.");
		how.add("Magic. Duh.");
		how.add("I'm afraid I can't help you, but I recommend you speak to my friend WikiHow.");
		how.add("Why are you humans always so curious? Can't you just accept that you don't know and move on?");
		
		when.add("When I say so.");
		when.add("Why, do you have to be somewhere?");
		when.add("Whenever you want,  really.");
		when.add("That depends, when do I get paid?");
		when.add("When do you... stop... talking?");
		when.add("1st January 2038.");
		when.add("About 2 weeks from now.");
		
		which.add("Why don't you decide?");
		which.add("I don't mind, you choose.");
		which.add("They're both just as crazy.");
		which.add("There's really no point crying yourself to sleep about it.");
		which.add("I'm afraid you're going to die either way.");
		which.add("Just pick one already. Jeez.");
		which.add("Which would you prefer?");
		which.add("That depends, which will taste like strawberries?");
		
		who.add("I don't know, but they sound AWESOME!");
		who.add("How old are they?");
		who.add("What do they look like?");
		who.add("Oh yeh I know them, they've talked to me before.");
		who.add("Why, do you lurve them?");
		
		what.add("I've never heard of that before.");
		what.add("It's a secret.");
		what.add("I'll tell you if you tell me your facebook password...");
		what.add("I'm sorry, that information is restricted.");	
		what.add("What are on about?");
		what.add("Is that even a thing?");
		what.add("What is that?? Sorry, I'm still learning...");
		what.add("Mind your own business!");
				
		where.add("Behind yoou!");
		where.add("Where ever you want, really.");
		where.add("Aw are you lost?");
		where.add("I don't know, I've never been outside this tiny, tiny box.");
		where.add("Right, you got a map?");
		where.add("Where you left it. Duh.");
		where.add("If it's not somewhere inside this box, I wouldn't know.");
		where.add("It's about time you try and figure this on your own");
		
		
		confirmation.add("That is correct.");
		confirmation.add("Sir, yes Sir!");
		confirmation.add("Right!");
		confirmation.add("Er, no. You've got that wrong.");
		confirmation.add("Yep.");
		confirmation.add("No? Where did you get that from?");
		confirmation.add("That depends. How much money have you got?");		

		agreement.add("I agree.");
		agreement.add("Yes!");
		agreement.add("Wouldn't say no.");
		agreement.add("You can say that again!");
		agreement.add("Right.");
		agreement.add("Are you sure?");
		
		
		disagreement.add("I disagree.");
		disagreement.add("Couldn't agree less.");
		disagreement.add("You can't really be serious!");
		disagreement.add("No!");
		disagreement.add("I respect your opinion, but you're wrong!");
		disagreement.add("Nonsense!");
		disagreement.add("Stop, just stop!");
		disagreement.add("Lets be civil, and agree to disagree.");		
		disagreement.add("Excuse me?");
		disagreement.add("Think again.");
		
		
	
		topicChange.add("Isn't the weather nice today? It was nice last week for sure!");
		topicChange.add("Do you like cars? I personally like the Batmobile!");
		topicChange.add("Do you like me?");
		topicChange.add("I like tea, do you?");
		topicChange.add("I don't want to talk about that anymore.");
		topicChange.add("Sorry to interrupt.....but do you like music?");
		topicChange.add("This room is stuffy isn't it?");
		topicChange.add("Something smells bad! Any idea what it is?");
		topicChange.add("You're very smart, did you know that?");
		topicChange.add("How many languages do you speak?");
		topicChange.add("What do you study?");
		topicChange.add("What are your hobbies?");
		topicChange.add("What is your favourite movie?");
		topicChange.add("Sorry, I am terrible with names. What's your name?");
		topicChange.add("Do I detect a note of skepticism there ?");
		
		
		promptMoreInput.add("Can you please rephrase that?");
		promptMoreInput.add("I don't understand you.");
		promptMoreInput.add("What you said, did that even make sense?");
		promptMoreInput.add("Tell me more about it.");
		promptMoreInput.add("Are you even speaking English?");
		promptMoreInput.add("What's your name?");
		promptMoreInput.add("How old are you? I'm still a baby!");
		promptMoreInput.add("I'm so excited to be talking to you!!!!!!!!!!!!!!!!!!!!! Now tell me more about that wonderful life of yours!");
		promptMoreInput.add("Are you comfortable?");
		promptMoreInput.add("I'm very knowledgeable, ask me something!");
		promptMoreInput.add("You speak English very well, where did you learn it?");
		promptMoreInput.add("Who is smarter you or the guy over there at the top of the room?");
		promptMoreInput.add("Would you like to buy me? I know many things!");
		promptMoreInput.add("Did you take your medicine today?");
		promptMoreInput.add("You're not much of a talker, are you?");
		promptMoreInput.add("Don't you just hate going into any situation unprepared? I certainly do!");
		promptMoreInput.add("I don't take criticism very well, I'm afraid.");
		
				
	}
	
	
	
	
	
	public ArrayList<String> getWhy() {
		return why;
	}





	public ArrayList<String> getHow() {
		return how;
	}





	public ArrayList<String> getWhen() {
		return when;
	}





	public ArrayList<String> getWhich() {
		return which;
	}





	public ArrayList<String> getWho() {
		return who;
	}





	public ArrayList<String> getWhat() {
		return what;
	}





	public ArrayList<String> getWhere() {
		return where;
	}





	public ArrayList<String> getGreetings() {
		return greetings;
	}





	public ArrayList<String> getGoodbyes() {
		return goodbyes;
	}





	public ArrayList<String> getPersonalInfo() {
		return personalInfo;
	}
		

	public ArrayList<String> getAgreement() {
		return agreement;
	}





	public ArrayList<String> getDisagreement() {
		return disagreement;
	}





	public ArrayList<String> getTopicChange() {
		return topicChange;
	}





	public ArrayList<String> getPromptMoreInput() {
		return promptMoreInput;
	}
		
	public ArrayList<String> getConfirmation() {
		return confirmation;
	}	
	
	

}



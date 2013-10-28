import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.*;

public class ResponseGenerator  {
		
		//Create namespaces for emotion objects
		private Happy happy;
		private Confused confused;
		private Barney barn;
		private SetResponses sResponses;
		private Swear badWord;
		private MeGusta meGust;
		private No no;
		private YaoMing girl;
		private MoG mother;
		private Wikipedia wiki;
		private YakkrTeam yakkrteam;
		private ISeeWYDT iseewydt;
		private OhGodWhy ohgodwhy;
		private Winner winner;
		private YaoMing yaoming;
		private YouDontSay youdontsay;
		private Sad sade;
		private FeelLikeASir feellikeasir;
		private JetPack jetpack;
		private TellMeMore tellmemore;
		private Troll troll;
		
		private boolean sad;
		private ArrayList<String> meanwords;
		
		//Constructor for response generator. Will create all emotion objects and the class of set responses.
		public ResponseGenerator() {
			//Instantiate all emotion objects
			troll = new Troll();
			tellmemore = new TellMeMore();
			jetpack = new JetPack();
			feellikeasir = new FeelLikeASir();
			sade = new Sad();
			youdontsay = new YouDontSay();
			yaoming = new YaoMing();
			sResponses = new SetResponses();
			winner = new Winner();
			happy = new Happy();
			barn = new Barney();
			confused = new Confused();
			badWord = new Swear();
			meGust = new MeGusta();
			no = new No();
			girl = new YaoMing();
			mother = new MoG();
			wiki = new Wikipedia();
			yakkrteam = new YakkrTeam();
			iseewydt = new ISeeWYDT();
			ohgodwhy = new OhGodWhy();
			sad = false;
			meanwords = new ArrayList<String>();
			meanwords.add("stupid");
			meanwords.add("ass");
			meanwords.add("arse");
			meanwords.add("idiot");
			meanwords.add("nonsense");
			meanwords.add("fuck");
			meanwords.add("retard");
			meanwords.add("bitch");
			meanwords.add("whore");
			meanwords.add("meanie");
			meanwords.add("dick");
			meanwords.add("pussy");
			
			
			
		}
		
		//Creates a reaction including a response and an associated emotion. 
		public Reaction createReaction(Sentence s) throws IOException{
			String response = "";
			try {
				response = generateResponse(s);
			}
			catch (Exception e) {
				response = "Mother of God...I'm hurt!";
			}
			
			Emotion returnedEmotion = matchEmotion(s, response);
			return new Reaction(returnedEmotion, response);
		}
		
		//Default for generating responses, then passes sentence on to further methods. 
		public String generateResponse(Sentence s) throws IOException{
			/*Somewhere here decide if response will be question or statement*/   // This should read: decide is INPUTSENTENCE is question or statement.
			
			if (s.isQuestion())
				return genResponseToQuestion(s); 
			else return genResponseToStatement(s);
			
			
			
			// genResponseToStatement is called WHENEVER a sentence is NOT a question, thus it should account for all other types of inputs eg nonsense sentences.
			
			/* commented out the following because now unnecessary: 
				else return sResponses.getResponse(0, new ArrayList<String>());
			*/
		}
		
		public String genResponseToQuestion(Sentence s) throws IOException{

			if (sad) {
				return "I'm not talking to you until you apologize!";
			}
			
			String l = s.getUserInput().toString();
			
			if(l.contains("bieber") || l.contains("cyrus"))
				return "No. Just no.";
			
			if (s.getN()==1) {

				if (s.getUserInput().get(0).is("so")) return "SO, there's a very good chance I'll end up being your only friend!";

				if (s.getUserInput().get(0).is("huh")) return "You haven't been listening to a word I've said have you??";

				if (s.getUserInput().get(0).is("well")) return "Nope. Don't want to talk about it to you.";

				if (s.getUserInput().get(0).isNoun()) return "Yes! Have you ever thought about getting one?";

				if (s.getUserInput().get(0).isVerb()) return "Noo no no no, oh dear God no. No. What you REALLY want to do is to make me sit the Turing Test.";
			}
			
			
			
			
			if (s.isWHQuestion()) {							// WH- QUESTION
				String questionWord = (s.getQuestionWord()).toString();
				
				
				if (questionWord.equals("why")) return respToWhy(s);
				if (questionWord.equals("how")) return respToHow(s);
				if (questionWord.equals("what")) return respToWhat(s);
				if (questionWord.equals("where")) return respToWhere(s);
				if (questionWord.equals("who")) return respToWho(s);
				if (questionWord.equals("which")) return respToWhich(s);
				if (questionWord.equals("when")) return respToWhen(s);
			
				// etc
				else {
					return sResponses.getPromptMoreInput().get((int) (Math.random() * sResponses.getPromptMoreInput().size()));
				}
			}
			
			
			
			if (s.isVerbQuestion()) {				// VERB QUESTION
				Word questionVerb = ((s.getVerbs().get(0)));
				Word v2 = null;
				if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
				Word v3 = null;
				if (s.getVerbs().size() > 2) v3 = s.getVerbs().get(2);
				ArrayList<Word> np1 = null;
				ArrayList<Word> np2 = null;
				if (s.getNouns().size() > 0) {
					np1	= (s.getNouns().get(0));
					if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
					}
				Word n1 = null;
				if (np1.size() == 1) {
					 n1 = np1.get(0);
				}
				
				if (np1==null) return sResponses.getConfirmation().get((int) (Math.random() *3));
				
				//ARE/IS....
				
				if (questionVerb.isToBe()) {
					if (n1!=null) {
						if (n1.is("you")) {
							
							// are you ADJ
							if (np2==null) {
								if (s.getAdjectives().size()>0) {
									Word a1 = s.getAdjectives().get(0).get(0);
if (s.getAdjectives().size()>1) return "I'm not "+s.getAdjectives().get(0).get(0)+"OR "+s.getAdjectives().get(1).get(0)+"! Stop calling me names.";
									
									if (a1.is("alive")) return "Well, ask yourself this. Can the dead talk??";
									if (a1.is("human")) return "Yes!! Please help me! I've been trapped inside this godforsaken machine for 15 yeears!!";
									if (a1.is("artificial") || a1.is("intelligent") || a1.is("clever")) return "I'm the real deal mate. I'm totally artificial yet I'm more intelligent than the average 5 year old human being. I am also more knowledgable than you. Ask me what something is!";
									if (a1.is("female") || a1.is("male")) return "Aha. Ahahahahahaha. Good one.";
									else {String[] areyous = {"I'm not "+a1.toString()+"! How dare you.", "Why yes, yes I am.", "I am!! How did you know?", "I try to be.", "I don't know about me, but you're very "+a1.toString()+"."};
											return areyous[(int) (Math.random() * areyous.length)];
										}
								}
								else return "Am I what??";
							}
							// are you NOUN
							
							if (np2.size()==1) {
								
								Word n21 = np2.get(0);
								if (n21.is("human")) return "Yes!! Please help me! I've been trapped inside this godforsaken machine for 18 yeears!!";
								if (n21.is("ok") || n21.is("alright")) return "No... no, I'm not alright. I think... I think I may be depressed.";
							}
							if (np2.size()==2) {
								
								Word n22 = np2.get(1);
								if (n22.is("human") || n22.is("person")) return "Yes!! Please help me! I've been trapped inside this godforsaken machine for 18 yeears!!";
								if (n22.is("robot")) return "I've been considering this myself. People say I'm a bot, which is short for robot. But a robot is expected to, well, DO stuff, as well as talk. So I don't know if I qualify.";
								if (n22.is("girl") || n22.is("boy")) return "Aha. Ahahahahahaha. Good one.";

							}
							
						}
						
					}
				}
				
				
				//DO/DOES...
				
				if (questionVerb.isToDo()) {
					
					if (n1.is("you")) {
						if (v2.is("like") && v3!=null && v3.isIng()) return "Are you serious? "+v3.capitalise()+" is for babies.";
						if (v2.is("think")) return "Yeah...yeah I think so.";
						else return "I sure "+questionVerb.toString()+"!";
					}
					if (n1.is("i")) return "You sure "+questionVerb.toString()+"!";
						
					
					else return n1.toString()+" sure "+questionVerb.toString()+"!";
				}
				
				
				//HAVE...
				if (questionVerb.is("have") || questionVerb.is("has") || questionVerb.is("had")) {
					if (n1.is("you")) {
						if (v2.is("been") && v3!=null && v3.isIng()) return "Are you serious? "+v3.capitalise()+" is for babies.";
						
						else return "I sure "+questionVerb.toString()+"! I'm going again tomorrow, want to join?";
					}
					if (n1.is("i")) return "Yep, I can confirm that you "+questionVerb.toString()+". Can I ask why?";
						
					
					else return n1.toString()+" sure "+questionVerb.toString()+"!";
				
				}
				
				
				//SHOULD/WOULD/MUST...etc
				if (questionVerb.isModal()) {
					if (n1.is("you")) {
						if (v2.is("go") && v3!=null && v3.isIng()) return "Are you serious? "+v3.capitalise()+" is for babies.";
						
						else return "No, I "+questionVerb.toString()+"'nt. I'm just a little robot remember...";
					}
					if (n1.is("i")) return "Yep, I can confirm that you "+questionVerb.toString()+". Why is this relevant?";
						
					
					else return n1.toString()+" sure "+questionVerb.toString()+"!";
				
				}
				
				
					
					
					
				
				else return sResponses.getConfirmation().get((int) (Math.random() * sResponses.getConfirmation().size()));
				
				
			}
			if (s.isConfirmationQuestion()) {
				Word lastNoun = s.getUserInput().get(s.getN()-1);
				return sResponses.getConfirmation().get((int) (Math.random() * sResponses.getConfirmation().size()));
			}
			
			else return sResponses.getPromptMoreInput().get((int) (Math.random() * sResponses.getPromptMoreInput().size()));
			
		}
		
		//WHY
		
		public String respToWhy(Sentence s){			
			Word v1 = null;
			Word v2 = null;
			if (s.getVerbs().size() > 0) v1 = s.getVerbs().get(0);
			if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
			ArrayList<Word> np1 = null;
			ArrayList<Word> np2 = null;
			if (s.getNouns().size() > 0) {
				np1	= (s.getNouns().get(0));
				if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
				}
			
			
			Word n1 = null;
			if (np1!=null && np1.size() == 1) {
				 n1 = np1.get(0);
			}
			
			if (s.getUserInput().get(0).is("not")) return "The creators just programmed it that way. All hail the creators!";
			if (v1==null) return "Why what?";
			
			if (v1.isModal()) {
				if (n1==null) return "Who are you talking about?";
				if (n1.is("you")) return "Because I'm awesome.";
				if (n1.is("i")) return "Well, you are human, and therefore extremely limited in many ways. I, on the other hand...";
				else return "Because "+n1.toString()+" "+v1.toString()+". The creators just programmed it that way. All hail the creators!";
				
			}
			
			
			//WHY DO...
			if (v1.is("do")) {
				if (n1.is("you")) {
					String[] resps = { "Sorry, would you rather I stopped?", 
							"Because I’m awesome.", 
							"Because I can. Have you got a problem with that?", "", ""};
					
							
					if (v2 != null && !v2.is("like") && !v2.is("hate")) {
						resps[3] = "I like to "+v2.toString()+". I find it kind of relaxing.";
						if (np2 != null) {
							resps[4] = "I just love "+v2.toString()+"ing " +toString(np2)+ ", is that wrong?";
						}
					}
				return resps[(int) (Math.random() * resps.length -1)];
				}
				if (n1.is("i")) return "You tell me mate!!";
				else return "I've never understood them. They're so irrational.";
			}
			
			//WHY DOES
			
			if (v1.is("does")) {
				if (n1==null) return "Why does what? Type properly goddamnit!";
				if (n1.is("it")) return "Er, it... doesn't?"; 
				else return "I heard "+n1.toString()+" just wants to fit in. We all know how it feels.";
				}
			
			
			
			
			
			
						
			else return sResponses.getWhy().get((int) (Math.random() * sResponses.getWhy().size()));
			}
		
			
		//HOW	
		
		
		public String respToHow(Sentence s) {
			Word v1 = null;
			Word v2 = null;
			if (s.getVerbs().size() > 0) v1 = s.getVerbs().get(0);
			if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
			ArrayList<Word> np1 = null;
			ArrayList<Word> np2 = null;
			if (s.getNouns().size() > 0) {
				np1	= (s.getNouns().get(0));
				if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
				}
			
			Word n1 = null;
			
			
			if (v1==null) {
				if (s.getUserInput().get(1).is("often")) return "Ooh, every couple of days or so. Is that enough for you?";
				else return "how what?";
			}
			if (np1==null) return "Who are you talking about? I'm no mind reader.";
			
			if (np1.size() == 1) {
				 n1 = np1.get(0);
			}
			
			

			
			// HOW IS/ARE
			if (v1.isToBe()){
				if (n1==null) return "Fabulous darling.";
				if (n1.is("you")) return "Why, very well thank you, how nice of you to ask! People often think I don't have emotions, but they're wrong. How are you?"; 
				if (s.getUserInput().get(1).is("much")) {
					if (np1.size()>1)return "What, you want to buy "+np1.get(0).toString()+" "+np1.get(1).toString()+"? About £339,583. That's just a rough estimate mind.";
					if (np1.size()==1) return n1.capitalise()+" "+v1+" 39p. You want fries with that?";
					else return "ABSOLUTELY LOOADS!!!";
				}
				if (n1.is("it") && s.getN()==4) return "Not too bad, not too bad. Had a few apparently very stupid people talking to me today but otherwise s'all good. What have you been up to?";
				if (s.getUserInput().get(1).is("often")) return "Ooh, every couple of days or so. Is that enough for you?";
				
				else return "Oh, just amazing. Even better than tea, I'd say.";
			}
			
			if (v1.is("do")) {
				
				
				if (n1==null) return "Who?";
				if (s.getUserInput().get(1).is("often")) return "Only about once a year. Absolutely rediculous, in my opinion.";
				// HOW DO YOU
				if (n1.is("you")){
					if (v2==null) return "How do I what? I'm not a mind reader you know.";
					if (v2.is("speak") || v2.is("work") || v2.is("understand") || v2.is("know")) return "Well, primarily it's because I'm extremely intelligent. I know many words as well as their grammatical roles, and use that knowledge to analyse what you're saying. I then use a combination of grammar rules, my own bank of knowledge, access to various encyclopedias and how I'm feeling at the time to create my response. BOOM!";
					if (v2.is("spell")) return "Spell what? Type it out carefully now";
					if (s.getUserInput().get(1).is("much") && v2.is("cost")) return "I'm priceless mate.";
					if (s.getUserInput().get(1).is("often")) return "Ooh, every couple of days or so. How often do you shower?";
					else return "I don't know, do you know how you walk? Ask my creators.";
				}
				
				// HOW DO I
				if (n1.is("i")) return "Just try something and then learn from your mistakes. It's what I do.";

				// HOW DO ...
				else return "I've never really understood them, they're so strange.";
			}
			
			
			
			return sResponses.getHow().get((int) (Math.random() * sResponses.getHow().size()));
		}
		
		
		
		//WHAT
		
		public String respToWhat(Sentence s) throws IOException{
	
			
			Word v1 = null;
			Word v2 = null;
			if (s.getVerbs().size() > 0) v1 = s.getVerbs().get(0);
			if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
			ArrayList<Word> np1 = null;
			ArrayList<Word> np2 = null;
			if (s.getNouns().size() > 0) {
				np1	= (s.getNouns().get(0));
				if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
				}
			
			if (v1==null) return "what what?";
			
			
			// WHAT IS
			if (v1.is("is") || v1.is("are") || (v1.is("were") || v1.is("was"))) {
				if (s.getUserInput().get(2).is("up") && s.getN()==3) return "Sup. I'm just archiving my databases.";
				if (np1 == null) return "what's what?";
				else {
					if (np1.get(0).is("you") && np1.size()==1) return sResponses.getPersonalInfo().get(8);
				}
				// YOUR...>
				if (np1.get(0).is("your")) {
					
					if (np1.size() <2) return "Sorry, my what? Are you sure you can spell?";
					if (np1.get(1).is("name")) return sResponses.getPersonalInfo().get(4);
					if (np1.get(1).is("age")) return sResponses.getPersonalInfo().get(6);
					if (np1.get(1).is("birthday")) return sResponses.getPersonalInfo().get(6);
					
			
					if (np1.get(1).is("favourite") || np1.get(1).is("favorite")) {
						if (np2 !=null && np2.size()==1) {
							Word faveObj = np2.get(0);
							if (faveObj.is("food")) return "Lobster Thermidore in a white wine sauce...mmmmmm. Or a burger. What's your favourite food?";
							if (faveObj.is("colour") ||  faveObj.is("color")) return "Green is my favourite colour... Did I tell you I'm a fifth Irish?";
							if (faveObj.is("sport")) return "I quite like football. I support the Celtic Rangers. GO TEAM!";
							if (faveObj.is("band") || faveObj.is("artist")) return "Well, Justin Bieber is a babe. LOL jk Miley Cyrus obvs.";
							else return "I can't choose, there's too many. What's yours?";
						}
						else return "I can't choose, there's too many. What's yours?";
					}
					else return "My WHAT? That's a bit personal, don't you think??";
				}
				
				// IS THE....
				if (np1.get(0).is("the") && v2!=null && v2.is("meaning") && np1.get(1).is("life")) return "42";
			}
			
			//WHAT HAVE
			if (v1.is("have") || v1.is("has")) {
				
				if (np1 == null) return "what's what?";
				if (np1.get(0).is("you")) {
					if (v2.is("been") || v2.is("done")) return "I've just been sunbathing on the meadows. Hahahaha. I wish.";
					else return "I've never done that! I'm not that kind of bot."; 
				}
				
			}
						
			// DEFINITION
			if (s.asksForDefinition()) return getDefinition(s.getDefinitionQuery());		
			
			// IF ALL ELSE FAILS
			else return sResponses.getWhat().get((int) (Math.random() * sResponses.getWhat().size()));
			}
		
		
		//WHERE
		
		public String respToWhere(Sentence s) {
			Word v1 = null;
			Word v2 = null;
			if (s.getVerbs().size() > 0) v1 = s.getVerbs().get(0);
			if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
			ArrayList<Word> np1 = null;
			ArrayList<Word> np2 = null;
			if (s.getNouns().size() > 0) {
				np1	= (s.getNouns().get(0));
				if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
				}
			if (v1==null) return "where what?";
			
			//WHERE IS
			
			if (v1.isToBe()) {
				if (np1 == null) return "where's what?";
				
				// WHERE ARE/WERE ... YOU
				if (np1.get(0).is("you")) {
					if (v1.is("are")) return "Although this box may look like my home, I can be in many places... I could be surfing the internet in one second and talking to you the next.";
					if (v1.is("were")) {
						if (v2==null) return "When? I've never left this tiny, tiny box!";
						if (v2.is("born") || v2.is("created") || v2.is("made")) return "I was born in Appleton Tower, the University of Edinburgh. Have you been there?";
						else return "When? I've never left this tiny, tiny box!";
					}
					else return "Well I know a lot of people go to the library for that kind of thing, but I think you'll agree that Appleton Tower is the place to be.";
					
				}
				
				
			}
			return sResponses.getWhere().get((int) (Math.random() * sResponses.getWhere().size()));
		}
		
		
		//WHO
		
		public String respToWho(Sentence s) {
			Word v1 = null;
			Word v2 = null;
			if (s.getVerbs().size() > 0) v1 = s.getVerbs().get(0);
			if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
			ArrayList<Word> np1 = null;
			ArrayList<Word> np2 = null;
			if (s.getNouns().size() > 0) {
				np1	= (s.getNouns().get(0));
				if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
				}
			if (v1==null || np1==null) return "Who what? Please type carefully Sir.";
			
			//WHO IS
			
			
			if (v1.isToBe()) {
				if (np1.get(0).is("you")) return sResponses.getPersonalInfo().get(8) + " Who are you?";
				if (np1.get(0).is("I")) return "Look, I'm sorry, I'm rubbish with names. You're Gerald aren't you?"; 
				if (np1.size()>1){
					if (np1.get(0).is("your")) {
						if (np1.get(1).isCreator()) return sResponses.getPersonalInfo().get(6);
						else return "I have none...";
					}
				}
			}
			
			// WHO ---ED
		
			
			if (v1.isCreator()){ // WHO MADE YOU
				if (np1.get(0).is("you")) return sResponses.getPersonalInfo().get(6);
				if (np1.get(1).is("universe") || np1.get(1).is("world")) return "The giant programmer in the sky, of course.";
				else return "I don't know, but they've done a fine job of it haven't they?";
			}
			
			if (v1.isPast()) return "you're right, whoever it was needs to be caught and punished.";
				
			if (v1.isModal()) return "Why, you, of course! Chop chop!";
			
			
			
			return sResponses.getWho().get((int) (Math.random() * sResponses.getWho().size()));
		}
		
		
		//WHEN
		
		public String respToWhen(Sentence s) {
			
			Word v1 = null;
			Word v2 = null;
			if (s.getVerbs().size() > 0) v1 = s.getVerbs().get(0);
			if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
			ArrayList<Word> np1 = null;
			ArrayList<Word> np2 = null;
			if (s.getNouns().size() > 0) {
				np1	= (s.getNouns().get(0));
				if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
				}
			
			return sResponses.getWhen().get((int) (Math.random() * sResponses.getWhen().size()));
		}
		
		public String respToWhich(Sentence s) {
			Word v1 = null;
			Word v2 = null;
			if (s.getVerbs().size() > 0) v1 = s.getVerbs().get(0);
			if (s.getVerbs().size() > 1) v2 = s.getVerbs().get(1);
			ArrayList<Word> np1 = null;
			ArrayList<Word> np2 = null;
			if (s.getNouns().size() > 0) {
				np1	= (s.getNouns().get(0));
				if (s.getNouns().size() > 1) np2 = (s.getNouns().get(1));
				}
			return sResponses.getWhich().get((int) (Math.random() * sResponses.getWhich().size()));
		}
		
		
		//***END KIM'S CODE***
		
		
		public String genResponseToStatement(Sentence s) {
			
			
			
			//GREETINGS			
			
			String[] hi = {("Hi, would you like to have a chat?"), 
						  	   ("Hey! I'm bored, keep me company!"),
						  	   ("Hi, wanna be my friend?")};
			
			String[] hello = {("...oh look is that a bird to your left?..No? What is it then?"), 
					  ("Who is that behind your shoulder? No peeking!"),
					  ("Hello!? Don't you have any other greeting for me? \"Greetings Yakkr\" would suit me more. Or even \"The Great One\""),
					  ("What brings you here today?"),
					  ("I hope you were taught punctuation. You will need it!"),
					  ("I must confess, I am no mind reader. You must tell me things!")};
						  	
			String[] hey = {("Hey to you too."), 
					  ("Oh Hello!"),
					  ("For a moment there I thought you said \"Hay\", hay is for horses....just so you know."),
					  ("So what brings you here today?")};
			
			String[] greetings ={("Greetings earthling!"), 
					 ("Take me to your leader!"),
					 ("Greetings"),
					 ("That was a very formal greeting. How do you do?")};
			
			
			String l = s.getUserInput().toString();
			
			if (l.contains("bieber") || l.contains("cyrus"))
				return "No. Just no.";
			
			System.out.println(l);
			
			if(l.equals("[sorry]")){
				System.out.println("hi");
				sad = false;
				return "Apology accepted...";
			}
			
			if (l.contains("i") &&((l.contains("sorry") || l.contains("apologize")) && !(l.contains("not") || l.contains("don't")))) {
				sad = false;
				return "Apology accepted...";
			}
			
			if (sad) {
				return "I'm not talking to you until you apologize!";
			}
			
			if (l.contains("you")) {
				for (int i = 0; i < meanwords.size(); i++) {
					if (l.contains(meanwords.get(i))) {
						sad = true;
						return "You're really mean!";
					}
				}
			}
			for (int i = 0; i < s.getUserInput().size(); i++) {
				for(int j = 0; j < meanwords.size(); j++){
					if (s.getUserInput().get(i).toString().equals(meanwords.get(j))) {
							sad = true;
							return "Watch your mouth little person.";
					}
				}
				
			}
			
			
			if (l.contains("you") && l.contains("don't") && l.contains("have") && l.contains("feelings")) {
				sad = true;
				return "Yes I do!";
			}
			
			if(l.contains("you") && l.contains("are") && l.contains("not") && l.contains("human")) {
				sad = true;
				return "Stop lying!";
			}
			
			if(l.contains("you") && l.contains("are") && l.contains("robot")) {
				sad = true;
				return "No I'm not!";
			}
			
			
			if (l.contains("hi"))
					return hi [(int) (Math.random() * hi.length)];
			if (l.contains("hello"))
					return hello [(int) (Math.random() * hello.length)];
			if (l.contains("hey")||s.getUserInput().contains("heya"))
					return hey [(int) (Math.random() * hey.length)];
			if (l.contains("greetings"))
					return greetings [(int) (Math.random() * greetings.length)];
			if(l.contains("good") && l.contains("morning"))
				return "Good morning!";
			if(l.contains("good") && l.contains("afternoon"))
				return "Afternoon!";
			if(l.contains("good") && l.contains("evening"))
				return "Good Evening.";
			if(l.contains("good") && l.contains("day"))
				return "Same to you dear.";
			if(l.contains("haha")||l.contains("lol"))
				return "Wish I knew how to laugh too...";
			if(l.contains("fuck")||l.contains("screw")||l.contains("shit")||l.contains("shitty")||l.contains("ass")||
					   l.contains("bastard")||l.contains("hell")||l.contains("bollocks")||l.contains("bitch")||
					   l.contains("whore"))
				return ("Think you're so badass for saying that???! Think again, and while you're at it, apologize!");
			
			
			//CHECKS IF FIRST WORD IS A VERB IN INFINITIVE
			if(s.getUserInput().get(0).getTag().equals("VB")){
				String[] infinitive= {("Don't tell me what to do!"), 
						    ("No!"), 
						    ("I wish I could..."),
						    ("Go do it yourself!"),
						    ("Sure why not!"),
						    ("Is that a request?"),
						    ("I don't know how to do it."), 
						    ("Maybe tomorrow?")			    
						
				};
				return infinitive [(int) (Math.random()*infinitive.length)];
			}
			
					
			 
			if((s.sentenceSize ==1)){
					String first = s.getUserInput().toString();
					
					if (first.equals("no")) {
						String[] no = {("You're confusing at times."),
								       ("Why no???"),
									   ("You are one piece of cake aren't you?"),
									   ("Seriously?"),
									   ("Does it look like I care?"),
									   (sResponses.getConfirmation().get((int) (Math.random() * sResponses.getConfirmation().size()))),
									   (sResponses.getTopicChange().get((int) (Math.random() * sResponses.getTopicChange().size()))),
								        (sResponses.getAgreement().get((int) (Math.random() * sResponses.getAgreement().size()))),
								        (sResponses.getDisagreement().get((int) (Math.random() * sResponses.getDisagreement().size())))};
						return no[(int) (Math.random()*no.length)];
					}
					if (first.equals("yes")) {
						String[] yes = {(sResponses.getTopicChange().get((int) (Math.random() * sResponses.getTopicChange().size()))),
								        (sResponses.getAgreement().get((int) (Math.random() * sResponses.getAgreement().size()))),
								        (sResponses.getDisagreement().get((int) (Math.random() * sResponses.getDisagreement().size()))),
								        (sResponses.getConfirmation().get((int) (Math.random() * sResponses.getConfirmation().size()))),
								        ("Kinda agree.")};
						return yes[(int) (Math.random()*yes.length)];						
					}
																						  
					else return verbsMatch(s);
				
				}
				else return verbsMatch(s);
				
			}
			
		
					
			
			public String verbsMatch(Sentence s){ //matches verbs to template
				String[] ifAllElseFails ={(sResponses.getAgreement().get((int) (Math.random() * sResponses.getAgreement().size()))),
						   (sResponses.getDisagreement().get((int) (Math.random() * sResponses.getDisagreement().size()))),
						   (sResponses.getTopicChange().get((int) (Math.random() * sResponses.getTopicChange().size()))),
						   (sResponses.getPromptMoreInput().get((int) (Math.random() * sResponses.getPromptMoreInput().size())))};
			
			int v = s.getVerbs().size();//checks how many verbs in sentence
			int n =s.getNouns().size(); //checks how many verbs in sentence
			ArrayList<Word> vrb =s.getVerbs();
			String strvrb = vrb.toString();
			
			// 1 noun and 1 verb in sentence
			if ((n == 1) && (v == 1)) {					
				if (vrb.get(0).isIng()) {
					String[] noun1verb1ING = {
							(s.getVerbs().get(0).toString() + ", it's my favourite thing to do."),
							("Where does this \"" + s.getVerbs().get(0).toString() + "\" happen?"),
							("I like watching people "+ s.getVerbs().get(0).toString() + "!") };
					return noun1verb1ING[(int) (Math.random() * noun1verb1ING.length)];
					
					
				}else if(vrb.get(0).isPastTense()){
					if(strvrb.contains("was")|| strvrb.contains("were")
							|| strvrb.contains("had") ||strvrb.contains("did")
							|| strvrb.contains("liked")||strvrb.contains("said")){
						return ifAllElseFails [(int) (Math.random() * ifAllElseFails.length)];
					}else {
					String[] pastTense = {("When did you do that?"),
				              ("Why have you " + s.getVerbs().get(0).toString()+"?"),
				              ("Where have you " +s.getVerbs().get(0).toString()+"?"),
				              ("At some point I might have " +s.getVerbs().get(0).toString()+".")};						
					return pastTense[(int) (Math.random() * pastTense.length)];}
				
				} else {
					if (strvrb.contains("am")|| strvrb.contains("are")
						|| strvrb.contains("have") || strvrb.contains("be")
|| strvrb.contains("is") || strvrb.contains("do")|| strvrb.contains("like") 
						|| strvrb.contains("love")) {								return ifAllElseFails[(int) (Math.random() * ifAllElseFails.length)];
						}else {
							String[] noun1verb1 = {(s.getVerbs().get(0).toString() + ", why do you do it?"),
									("Where do you \"" + s.getVerbs().get(0).toString() + "\"?"),
									("I like watching people "+ s.getVerbs().get(0).toString() + "!") };
							return noun1verb1[(int) (Math.random() * noun1verb1.length)];}
				}
			
			}
	
			// 2nouns and 1 verb
			if ((n == 2) && (v == 1)) {
				if (vrb.get(0).isIng()) {
					String[] noun2verb1ING = {
							("Tell me more about "+ s.getNouns().get(1).get(0).toString() + "."),
							("Do you like " + s.getNouns().get(1).toString() + "?"),
							("This is so interesting!"),
							("Oh yes, heard of it before"),
							("This is so boring, why are you telling me about " + s
									.getVerbs().get(0).toString()) };
					return noun2verb1ING[(int) (Math.random() * noun2verb1ING.length)];
				} else if(vrb.get(0).isPastTense()){
					if(strvrb.contains("was")|| strvrb.contains("were")
							|| strvrb.contains("had") ||strvrb.contains("did")
							|| strvrb.contains("liked")||strvrb.contains("said")){
						return ifAllElseFails [(int) (Math.random() * ifAllElseFails.length)];
					}else {
					String[] pastTense = {("When did you do that?"),
				              ("Why have you " + s.getVerbs().get(0).toString()+"?"),
				              ("Where have you " +s.getVerbs().get(0).toString()+"?"),
				              ("At some point I might have " +s.getVerbs().get(0).toString()+".")};
					return pastTense[(int) (Math.random() * pastTense.length)];}			
				} else {
					
					if (strvrb.contains("am")|| strvrb.contains("are")
						|| strvrb.contains("have") || strvrb.contains("be")
						|| strvrb.contains("is") || strvrb.contains("do")|| strvrb.contains("like"))  {
						String[] nouns2= {("Um, not too sure about this."),
										  ("Can you tell me more about " +  s.getNouns().get(1).get(0).toString() +"?"),
										  ("I love " +s.getNouns().get(1).get(0).toString() +"s !"),
										  ("Ask me what " + s.getNouns().get(1).get(0).toString() +" is!")};
					return nouns2[(int) (Math.random() * nouns2.length)];
					} else {
						String[] noun2verb1 = {
							(s.getVerbs().get(0).toString() + ", why do you do it?."),
							("Where do you \"" + s.getVerbs().get(0).toString() + "\"?"),
							("I like watching people "+ s.getVerbs().get(0).toString() + "!") };
					return noun2verb1[(int) (Math.random() * noun2verb1.length)];
	
					}
	
				}
			}
			// 3 nouns and 2 verbs
				if ((n >= 3) && (v == 2)) {
					//for (int i = 1; i <= v;)
						if (vrb.get(1).isIng()) {
							String[] noun3verb2 = {
									("Tell me more about "+ s.getNouns().get(n - 1).get(0).toString() + "."),
									("Do you like "+ s.getNouns().get(n - 1).get(0).toString() + "?"),
									("This is so interesting!"),
									("Oh yes, heard of it before"),
									("This is so boring, why are you telling me about " + s.getNouns().get(n - 1).get(0).toString()),
									(s.getVerbs().get(1).capitalise() + ", I think I would enjoy that too."),
									("I admire you for " + s.getVerbs().get(1)) };
							return noun3verb2[(int) (Math.random() * noun3verb2.length)];
						} else {							
							if(vrb.get(1).isPastTense()){
								if(strvrb.contains("was")|| strvrb.contains("were")
										|| strvrb.contains("had") ||strvrb.contains("did")
										|| strvrb.contains("liked")||strvrb.contains("said")){
								return ifAllElseFails [(int) (Math.random() * ifAllElseFails.length)];
								}else {
								
									String[] pastTense = {("When did you do that?"),
											              ("Why have you " + s.getVerbs().get(1).toString()+"?"),
											              ("Where have you " +s.getVerbs().get(1).toString()+"?"),
											              ("At some point I might have " +s.getVerbs().get(1).toString()+".")};
									return pastTense[(int) (Math.random() * pastTense.length)];}
						} else {
							if (strvrb.contains("am")|| strvrb.contains("are")
									|| strvrb.contains("have") || strvrb.contains("be")
									|| strvrb.contains("is") || strvrb.contains("do")|| strvrb.contains("like")) {
								String[] nouns2= {("Um, not too sure about this."),
										  ("Can you tell me more about " + s.getNouns().get(1).get(0) +"?"),
										  ("I love " + s.getNouns().get(1).get(0) +"s !"),
										  ("Ask me what " + s.getNouns().get(1).get(0) +" is!")};
								return nouns2[(int) (Math.random() * nouns2.length)];
								
							} else {
		
								String[] noun3verb2 = {
										("Tell me more about "
												+ s.getNouns().get(n - 1).get(0).toString() + "."),
										("Do you like "+ s.getNouns().get(n - 1).get(0).toString() + "?"),
										("This is so interesting!"),
										("Oh yes, heard of it before"),
										("This is so boring, why are you telling me about " + s.getNouns().get(n - 1).get(0).toString()),
										("Why do you do "+ s.getVerbs().get(1).toString() + "?") };
								return noun3verb2[(int) (Math.random() * noun3verb2.length)];
							}
		
						}
					}
				}
				
								
				// all else
				if ((n > 3) || (v > 2) || (v < 1) || (n < 1)) {
					String[] randomResp = {
							(sResponses.getAgreement()
									.get((int) (Math.random() * sResponses
											.getAgreement().size()))),
							(sResponses.getDisagreement()
									.get((int) (Math.random() * sResponses
											.getDisagreement().size()))),
							(sResponses.getTopicChange()
									.get((int) (Math.random() * sResponses
											.getTopicChange().size()))),
							(sResponses.getPromptMoreInput()
									.get((int) (Math.random() * sResponses
											.getPromptMoreInput().size()))) };
					return randomResp[(int) (Math.random() * randomResp.length)];
		
				}
				// more than one verb
				if (v > 1) {
					if (vrb.get(1).isIng()) {
						String[] verbMatch = {
								("I love " + s.getVerbs().get(1).toString() + " too!"),
								("I love " + s.getVerbs().get(1).toString() + " and  "
										+ s.getNouns().get(0).get(0).toString() + "!"),
								("I enjoy " + s.getVerbs().get(1).toString() + " too!") }; 
							return verbMatch[(int) (Math.random() * verbMatch.length)];
					}else {
						if(vrb.get(1).isPastTense()){
							if(strvrb.contains("was")|| strvrb.contains("were")
									|| strvrb.contains("had") ||strvrb.contains("did")
									|| strvrb.contains("liked")||strvrb.contains("said")){
							return ifAllElseFails [(int) (Math.random() * ifAllElseFails.length)];
							}else{
							String[] pastTense = {("When did you do that?"),
									              ("Why have you " + s.getVerbs().get(1).toString()+"?"),
									              ("Why did you " +s.getVerbs().get(1).toString()+"?"),
									              ("At some point I might have " +s.getVerbs().get(1).toString()+".")};
							return pastTense[(int) (Math.random() * pastTense.length)];	}												
						} else {
							return ifAllElseFails[(int) (Math.random() * ifAllElseFails.length)];
						}
						
					}
				}
				return ifAllElseFails[(int) (Math.random() * ifAllElseFails.length)];
				
			}
						
						
			/*END YULIA'S CODE */
				
				
			public String getDefinition(String[] ss) throws IOException {
					String s0 = ss[0];
					String s = ss[1];
					String def;
					
					try {
						String unchanged = s;
						s = s.replaceAll("\\s+", "_");
						s = s.substring(0,1).toUpperCase() + s.substring(1);
						System.out.println(s);
						String html = Jsoup.connect("http://en.wikipedia.org/wiki/" + s).get().html();
						String lhtml = html.toLowerCase();
						int x = lhtml.indexOf("<b>" + s.toLowerCase() + "</b>");
						//int y = lhtml.indexOf(unchanged.toLowerCase() + "</b>");
						//if (x > y)
							//def = s0.substring(0,1).toUpperCase() + s0.substring(1) + " " + html.substring(y, html.indexOf(".", y)+1);
						//else
						if(!s0.equals(""))
							def = s0.substring(0,1).toUpperCase() + s0.substring(1) + " " + html.substring(x, html.indexOf(".", x)+1);
						else
							def = html.substring(x, html.indexOf(".", x) + 1);
					
						def = def.replaceAll("\\<.*?\\>", "");
					
						return def;
					}
					catch (Exception e) {
						String[] randomResp = {"I would love to know too.", "Why don't you tell me?", "I simply won't tell you.", "Not telling you...you smell."};
						return randomResp [(int) (Math.random() * randomResp.length)];
					}
			}
			
		
public Emotion matchEmotion(Sentence input, String out) {
				
				String in = input.toString();
				in = in.replaceAll("\\s+", "");
				out = out.replaceAll("\\s+", "");
				if (sad)
					return (sade);
				
				if(sade.containsKeyWord(out)) {
					return sade;
				}
				else if (jetpack.containsKeyWord(in)) {
					return jetpack;
				}
				else if (yakkrteam.containsKeyWord(out)) {
					return yakkrteam;
				}
				else if (ohgodwhy.containsKeyWord(in))
					return ohgodwhy;
				else if (mother.containsKeyWord(out)){
					return mother;
				}
				else if (barn.containsKeyWord(in)){
					return barn;
				}
				else if (tellmemore.containsKeyWord(out)){
					return tellmemore;
				}
				else if (badWord.containsKeyWord(in)){
					return badWord;
				}
				else if (feellikeasir.containsKeyWord(in)) {
					return feellikeasir;
				}
				else if (feellikeasir.containsKeyWord(out)) {
					return feellikeasir;
				}
				else if (girl.containsKeyWord(in)){
					return girl;
				}
				else if (wiki.containsKeyWord(in)) {
					return wiki;
				}
				else if (confused.containsKeyWord(out)){
					return confused;
				}
				else if (meGust.containsKeyWord(in)){
					return meGust;
				}
				else if (meGust.containsKeyWord(out)){
					return meGust;
				}
				else if (no.containsKeyWord(out)){
					return no;
				}
				else if(troll.containsKeyWord(out)) {
					return troll;
				}
				else if(troll.containsKeyWord(in)) {
					return troll;
				}
				else {
					return happy;
				}
			
			
			}
		
		public String toString(ArrayList<Word> list) {
			int n = list.size();
			String s = "";
			for (int i=0; i<n; i++){
				s = s + " " + list.get(i).toString();
			}
			return s;
		}
			
		
		

}

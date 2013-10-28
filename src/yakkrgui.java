	import java.awt.*;
	import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

	//@SuppressWarnings("serial")
	public class yakkrgui extends JFrame{
		private JTextArea textOut;
		private JScrollPane sp_textOut;
		private JTextField textIn;
		private JScrollPane sp_textIn;
		private JButton sendButton;
		private JLabel textHere;
		private JLabel label;
		private JPanel panelImage;
		private JPanel jPanel1;
		private String line;
		private int exit = 0;
		
		//Emotions:
		
		private ImageIcon emotion;
		
		private Happy happy; 
		private ImageIcon happyImage;
		
		private Sad sad;
		private ImageIcon sadImage;
		
		private Confused confused;
		private ImageIcon confusedImage;
		
		private Wikipedia wikipedia;
		private ImageIcon wikipediaImage;
		
		private Barney barney;
		private ImageIcon barneyImage;
		
		private ISeeWYDT iseewydt;
		private ImageIcon iseewydtImage;
		
		private MeGusta megusta;
		private ImageIcon megustaImage;
		
		private No no;
		private ImageIcon noImage;
		
		private OhGodWhy ohgodwhy;
		private ImageIcon ohgodwhyImage;
		
		private Swear swear;
		private ImageIcon swearImage;
		
		private Winner winner;
		private ImageIcon winnerImage;
		
		private YaoMing yaoming;
		private ImageIcon yaomingImage;
		
		private YakkrTeam yakkrteam;
		private ImageIcon yakkrteamImage;
		
		private FeelLikeASir feellikeasir;
		private ImageIcon feellikeasirImage;
		
		private JetPack jetpack;
		private ImageIcon jetpackImage;
		
		private TellMeMore tellmemore;
		private ImageIcon tellmemoreImage;
		
		private Engine engine;

		// ActionListener listener;

		// JPanel panelImage2;


		public yakkrgui(Engine e){
			engine = e;
			
			tellmemore = new TellMeMore();
			jetpack = new JetPack();
			happy = new Happy();
			sad = new Sad();
			confused = new Confused();
			wikipedia = new Wikipedia();
			barney = new Barney();
			iseewydt = new ISeeWYDT();
			megusta = new MeGusta();
			no = new No();
			ohgodwhy = new OhGodWhy();
			swear = new Swear();
			winner = new Winner();
			yaoming = new YaoMing();
			yakkrteam = new YakkrTeam();
			feellikeasir = new FeelLikeASir();
			
			jetpackImage = new ImageIcon("Memes/unified/goodbye_nothing_to_do_here.jpg");
			happyImage = new ImageIcon("Memes/unified/derp_herp.jpg");
			sadImage = new ImageIcon("Memes/unified/you_are_stupid_okay.jpg");
			confusedImage = new ImageIcon("Memes/unified/Confusion_dont_understand_jackie_chan.jpg");
			wikipediaImage = new ImageIcon("Memes/unified/wikipedia_challenge_accepted.jpg");
			barneyImage = new ImageIcon("Memes/unified/I_agree_true_story.jpg");
			iseewydtImage = new ImageIcon ("Memes/unified/i_see_what_you_did_there.jpg");
			megustaImage = new ImageIcon ("Memes/unified/I_like__me_gusta.jpg");
			noImage = new ImageIcon ("Memes/unified/do_something_for_me_no.jpg");
			ohgodwhyImage = new ImageIcon ("Memes/unified/oh_god_why.jpg");
			swearImage = new ImageIcon ("Memes/unified/swear_words_watch_out.jpg");
			winnerImage = new ImageIcon ("Memes/unified/mercury.jpg");
			yaomingImage = new ImageIcon ("Memes/unified/Are_you_a_girl_yao.jpg");
			yakkrteamImage = new ImageIcon ("Memes/unified/yakkr_team.jpg");
			feellikeasirImage = new ImageIcon("Memes/unified/feel-like-a-sir-tea.jpg");
			tellmemoreImage = new ImageIcon("Memes/unified/tell_me_more_cereal_guy.jpg");

			yakkrguiLayout customLayout = new yakkrguiLayout();

			getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 8));
			getContentPane().setLayout(customLayout);
			getContentPane().setBackground(new Color(229, 235, 255));
			
			//ImageIcon icon = new ImageIcon("background.jpg");
	        //Image backImage = icon.getImage();
	        //gui.setBackgroundImage(backImage);
						

			textOut = new JTextArea();
			textOut.setEditable(false);
			textOut.setLineWrap(true);
			textOut.setAutoscrolls(true);
			DefaultCaret caret = (DefaultCaret)textOut.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			
			
			
			sp_textOut = new JScrollPane(textOut,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			getContentPane().add(sp_textOut);

			textIn = new JTextField("");
			sp_textIn = new JScrollPane(textIn);
			textIn.getText();
			getContentPane().add(sp_textIn);
			textIn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e){
						try {
							engine.getResponses(line);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}			
			});

			sendButton = new JButton("Send");
			getContentPane().add(sendButton);

			panelImage = new JPanel();
			//panelImage.setSize(305, 305);
			//panelImage.setBorder(BorderFactory.createLineBorder(Color.black));
			
			emotion = new ImageIcon("Memes/unified/default_derp.jpg");
			label = new JLabel();
			label.setIcon(emotion);
			label.setVisible(true);
			panelImage.add(label);
			getContentPane().add(panelImage);
			


			textIn.addActionListener(listener);  
			sendButton.addActionListener(listener); 
			
			textHere = new JLabel("Input:");
			getContentPane().add(textHere);

			setSize(getPreferredSize());

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
						if (exit == 0){
							label.setIcon(jetpackImage);
							exit++;
							//System.out.println("exiting");
						}
						else if (exit == 1) {
							//System.out.println("exit for real");
							System.exit(0);
						}
				}
				});
		}
			
		private ActionListener listener = new ActionListener() 
		{  
		public void actionPerformed(ActionEvent evt) {  
			line = textIn.getText().trim();  
			textIn.setText("");  
			if (line.length()>0){  
				textOut.append("Me: " + line + "\n");  
				textIn.requestFocusInWindow();  
			}  
		}
		};  

		public void println(String commandline) {
			textOut.append(commandline + '\n');
		}

	
		public void displayEmotion(Emotion e) 
		{
		
			if (e.getId().equals(happy.getId())){
				label.setIcon(happyImage);
				}
			else if (e.getId().equals(sad.getId()))
				{ 
				label.setIcon(sadImage);
				}
			else if (e.getId().equals(confused.getId()))
				{ 
				label.setIcon(confusedImage);
				}
			else if (e.getId().equals(wikipedia.getId()))
				{ 
				label.setIcon(wikipediaImage);
				}
			else if (e.getId().equals(barney.getId()))
				{ 
				label.setIcon(barneyImage);
				}
			else if (e.getId().equals(iseewydt.getId()))
				{ 
				label.setIcon(iseewydtImage);
				}
			else if (e.getId().equals(megusta.getId()))
				{ 
				label.setIcon(megustaImage);
				}
			else if (e.getId().equals(no.getId()))
				{ 
				label.setIcon(noImage);
				}
			else if (e.getId().equals(ohgodwhy.getId()))
				{ 
				label.setIcon(ohgodwhyImage);
				}
			else if (e.getId().equals(swear.getId()))
				{ 
				label.setIcon(swearImage);
				}
			else if (e.getId().equals(winner.getId()))
				{ 
				label.setIcon(winnerImage);
				}
			else if (e.getId().equals(yaoming.getId()))
				{ 
				label.setIcon(yaomingImage);
				}
			else if (e.getId().equals(yakkrteam.getId()))
				{ 
				label.setIcon(yakkrteamImage);
				}
			else if (e.getId().equals(jetpack.getId())) {
				label.setIcon(jetpackImage);
			}
			else if(e.getId().equals(feellikeasir.getId()))
				label.setIcon(feellikeasirImage);
			else if(e.getId().equals(tellmemore.getId()))
				label.setIcon(tellmemoreImage);
			else
				label.setIcon(emotion);
		
		}

}

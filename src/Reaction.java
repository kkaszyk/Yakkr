import java.util.ArrayList;


public class Reaction {
	private Emotion returned_Emotion;
	private String response;
	
	public Reaction(Emotion e, String res) {
		returned_Emotion = e;
		response = res;
	}
	
	public Reaction(String res) {
		response = res;
	}
	
	public Emotion getEmotion() {
		return returned_Emotion;
	}
	
	public String getResponse() {
		return response;
	}
}

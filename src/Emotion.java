


public abstract class Emotion {
	
	private String[] keywords;
	private String id;

	//private imageobject
	
	public Emotion (String[] keywordList, String id) {
		keywords = keywordList;
		this.id = id; 
		
	}
	

	public String[] getKeywords() {
		return keywords;
	}
	
	public boolean containsKeyWord(String s){
		s = s.toLowerCase();
		for (int i = 0; i < keywords.length; i++){
			if (s.contains(keywords[i])){
				return true;
			}
			
		}
		return false;
	}
	
	public String getId() {
		return id;
	}

}

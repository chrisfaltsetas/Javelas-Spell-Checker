import java.util.ArrayList;

public class Suggestions {
	
	private String word;
	private ArrayList<String> suggestedWords;
	
	public Suggestions(String word){
		this.setWord(word);	
	}
		
	public void run() {
		firstSuggestions();
	}
	
	public void firstSuggestions() {
				
		word = word.substring(0, 1).toLowerCase() + word.substring(1).toLowerCase();
		
		boolean wordExists = false;
		if (Mapping.map.containsKey(Mapping.jHashCode(word))) {
			for (String wordInList: Mapping.map.get(Mapping.jHashCode(word))) {
				if (wordInList.equals(word))
					wordExists = true;
			}
		}
		
		if (wordExists)
			suggestedWords.add(word);
		
		
		
		word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
		
		wordExists = false;
		if (Mapping.map.containsKey(Mapping.jHashCode(word))) {
			for (String wordInList: Mapping.map.get(Mapping.jHashCode(word))) {
				if (wordInList.equals(word))
					wordExists = true;
			}
		}
		
		if (wordExists)
			suggestedWords.add(word);
		
	}


	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}	
	
}

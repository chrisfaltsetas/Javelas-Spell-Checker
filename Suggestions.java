public class Suggestions {
	
	private String word;
	
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
			System.out.println("Suggestion: " + word);
		
		
		
		word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
		
		wordExists = false;
		if (Mapping.map.containsKey(Mapping.jHashCode(word))) {
			for (String wordInList: Mapping.map.get(Mapping.jHashCode(word))) {
				if (wordInList.equals(word))
					wordExists = true;
			}
		}
		
		if (wordExists)
			System.out.println("Suggestion: " + word);
		
	}


	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}	
	
}

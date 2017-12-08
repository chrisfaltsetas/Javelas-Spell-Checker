import java.util.ArrayList;

public class Suggestions extends WordEdit {
	
	private String word;
	private ArrayList<String> suggestedWords;
	
	public Suggestions(String word){
		this.word = word;
		this.suggestedWords = new ArrayList<String>();
	}
		
	public void getSuggestions() {
		firstSuggestions();
	}
	
	public void firstSuggestions() {
				
		word = word.substring(0, 1).toLowerCase() + word.substring(1).toLowerCase();
		
		boolean wordExists = false;
		if (grDic.getDic().containsKey(jHashCode(word))) {
			for (String wordInList: grDic.getDic().get(jHashCode(word))) {
				if (wordInList.equals(word))
					wordExists = true;
			}
		}
		
		if (wordExists)
			suggestedWords.add(word);
		
		
		
		word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
		
		wordExists = false;
		if (Dictionary.dic.containsKey(jHashCode(word))) {
			for (String wordInList: Dictionary.dic.get(jHashCode(word))) {
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
	
	public void secondSuggestions() {
		ArrayList<String> sug = new ArrayList<String>();
        int x = Dictionary.jHashCode(this.word) - 23;
        int size;
        for (int counter = 0; counter < 48;counter++) {
            sug = Dictionary.map.get(x);
            size = sug.size();
            if (size > 0) {
                for (int i = 0;i < size;i++) {
                    if(WordDistance.getMinimumDistance(getWord(), sug.get(i)) == 1) {
                        suggestedWords.add(sug.get(i));
                    }
                }
            }
            x++;
        }
    }
	
}

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
		secondSuggestions();
		System.out.println(suggestedWords);
	}
	
	public void firstSuggestions() {
		if (word.length() >= 2) {
			String wordL = word.substring(0, 1).toLowerCase() + word.substring(1).toLowerCase();
			String wordU = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
			for (Dictionary dictionary: Dictionary.dictionaries) {
				if (dictionary.wordExists(wordL))
					suggestedWords.add(wordL);
				if (dictionary.wordExists(wordU))
					suggestedWords.add(wordU);
			}
		}
	}
	
	public void secondSuggestions() {
		final int MAX_DISTANCE = 1;
		for (Dictionary dictionary: Dictionary.dictionaries) {
			int minHash = jHashCode(word) - ((dictionary.getRange() + 974) * MAX_DISTANCE);
			int maxHash = jHashCode(word) + ((dictionary.getRange() + 974) * MAX_DISTANCE);
		
			for (int i = minHash; i <= maxHash; i++) {
				if (dictionary.getDic().containsKey(i)) {
					for (String wordInList: dictionary.getDic().get(i)) {
						if (getLevenshteinDistance(wordInList) <= MAX_DISTANCE) {
							suggestedWords.add(wordInList);
		                }
		            }
				}
	        }
		}
    }	

	public int getLevenshteinDistance(String word2) {
		
		int length1 = word.length();
		int length2 = word2.length();
		
		int[][] distanceMap = new int[length2 + 1][length1 + 1];
		
		for (int i = 0; i <= length2; i++) {
			distanceMap[i][0] = i;
		}
		
		for (int i = 0; i <= length1; i++) {
			distanceMap[0][i] = i;
		}
		
		for (int i = 0; i < length2; i++) {
			char char2 = word2.charAt(i);
			for (int j = 0; j < length1; j++) {
				char char1 = word.charAt(j);
				
				int topleft = distanceMap[i][j];
				int top = distanceMap[i][j + 1];
				int left = distanceMap[i + 1][j];
				
				distanceMap[i + 1][j + 1] = Math.min(topleft, Math.min(top, left));

				if (char1 != char2)
					distanceMap[i + 1][j + 1] ++;
			}//end for
		}//end for
				
		return distanceMap[length2][length1];
		
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<String> getSuggestedWords() {
		return suggestedWords;
	}
	
}

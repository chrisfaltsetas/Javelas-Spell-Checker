package spellchecker;
import java.util.ArrayList;

public class Suggestions {
	
	private Word word;
	private ArrayList<Word> suggestedWords;
	
	public Suggestions(Word word){
		this.word = word;
		this.suggestedWords = new ArrayList<Word>();
		firstSuggestions();
		secondSuggestions();
	}		
	
	public void firstSuggestions() {
		if (word.getWordStr().length() >= 2) {
			Word wordL = new Word(word.getWordStr().toLowerCase());
			Word wordU = new Word(word.getWordStr().substring(0, 1).toUpperCase() + word.getWordStr().substring(1).toLowerCase());
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
			int minHash = word.hashCode() - ((dictionary.getRange() + dictionary.getAddRemoveLetter()) * MAX_DISTANCE);
			int maxHash = word.hashCode() + ((dictionary.getRange() + dictionary.getAddRemoveLetter()) * MAX_DISTANCE);
			
			for (int i = minHash; i <= maxHash; i++) {
				if (dictionary.getDic().containsKey(i)) {
					for (Word wordInList: dictionary.getDic().get(i)) {
						if (getLevenshteinDistance(wordInList) <= MAX_DISTANCE) {
							suggestedWords.add(wordInList);
		                }
		            }
				}
	        }
		}
    }	

	public int getLevenshteinDistance(Word wordX) {
		
		String word1 = word.getWordStr();
		String word2 = wordX.getWordStr();
		int length1 = word1.length();
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
				char char1 = word1.charAt(j);
				
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
	
	public String toString() {

		String sug = "\n\t\t";
		int counter = 0;
		for (Word word: suggestedWords) {
			if (counter < 10) {
				counter++;
				sug += String.valueOf(counter) + ") " + word.getWordStr() + "\n\t\t";
			}
		}
		if (counter == 0)
			return "\tThere are no suggestions for the word \"" + word + "\"\n";
		else
			return "\tSuggestions for \"" + word + "\": " + sug;
	}


	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public ArrayList<Word> getSuggestedWords() {
		return suggestedWords;
	}
	
}

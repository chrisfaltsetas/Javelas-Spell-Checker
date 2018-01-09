package spellchecker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Dictionary {

	private LinkedHashMap<Integer, ArrayList<Word>> dic;
	private String lang;
	private int range;
	private int addRemoveLetter;
	
	public static ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
	private static boolean customExists = false;

	public Dictionary(String lang, int range, int addRemoveLetter) throws IOException {
		this.lang = lang;
		this.dic = new LinkedHashMap<Integer, ArrayList<Word>>();
		setDic();
		this.setRange(range);
		this.addRemoveLetter = addRemoveLetter;
		dictionaries.add(this);
	}

	public Dictionary() throws IOException {
		if (!customExists) {
			this.lang = "custom";
			this.dic = new LinkedHashMap<Integer, ArrayList<Word>>();
			setDic();
			dictionaries.add(this);
			customExists = true;
		}
	}

	// Import the dictionary in a LinkedHashMap
	private void setDic() throws IOException {

		BufferedReader rdr = new BufferedReader(
				new InputStreamReader(new FileInputStream("dictionaries\\" + lang + ".txt"), "UTF8"));
		String nextWord = rdr.readLine();
		if (nextWord != null && nextWord.length() >= 2 && nextWord.substring(0, 1).equals("\ufeff"))
			nextWord = nextWord.substring(1);

		while (nextWord != null) {
			addWord(new Word(nextWord));
			nextWord = rdr.readLine();
		}
		rdr.close();
	}

	public void addWord(Word word) {
		int wordHash = word.hashCode();
		if (this.dic.containsKey(wordHash)) {
			(dic.get(wordHash)).add(word);
		} else {
			ArrayList<Word> list = new ArrayList<Word>();
			list.add(word);
			dic.put(wordHash, list);
		}
	}
	
	public void addWordPermanently(Word word) {
		addWord(word);
		if (this.getDicName().equals("custom")) {
			try {				
				BufferedWriter wtr = 
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dictionaries\\custom.txt", true), "UTF8"));
				wtr.write(word.getWordStr());
				wtr.newLine();
				wtr.close();
			} catch (IOException iOException) {
				System.err.println("Could not find custom dictionary: " + iOException);
			}
		}
		
	}

	// Check if a word exists in the dictionary
	public boolean wordExists(Word word) {
		boolean exists = false;
		int wordHash = word.hashCode();
		if (dic.containsKey(wordHash)) {
			for (Word wordInList : dic.get(wordHash)) {
				if (wordInList.getWordStr().equals(word.getWordStr())) {
					exists = true;
					break;
				}
			}
		}
		return exists;
	}
	
	public String toString() {
		return lang + " dictionary";
	}

	public LinkedHashMap<Integer, ArrayList<Word>> getDic() {
		return dic;
	}

	public String getDicName() {
		return lang;
	}

	public void setDicName(String dicName) {
		this.lang = dicName;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getAddRemoveLetter() {
		return addRemoveLetter;
	}

}

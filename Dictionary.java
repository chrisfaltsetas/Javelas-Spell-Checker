import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Dictionary extends WordEdit {
	
	private LinkedHashMap<Integer, ArrayList<String>> dic;
	private String lang;
	private int range;
	static ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
	private static boolean customExists = false;
	
	public Dictionary(String lang, int range) throws IOException {
		this.lang = lang;
		this.dic = new LinkedHashMap<Integer, ArrayList<String>>();
		setDic();		
		this.setRange(range);
		dictionaries.add(this);
	}
	
	public Dictionary() throws IOException {
		if (!customExists) {
			this.lang = "custom";
			this.dic = new LinkedHashMap<Integer, ArrayList<String>>();
			setDic();
			dictionaries.add(this);
			customExists = true;
		}
	}
	
	//Import the dictionary in a LinkedHashMap
	private void setDic() throws IOException {
				
		BufferedReader rdr = new BufferedReader(new InputStreamReader(new FileInputStream("dictionaries\\" + lang + ".txt"), "UTF8"));
		String nextWord = rdr.readLine();
		
		while (nextWord != null) {
			addWord(nextWord);
			nextWord = rdr.readLine();
		}
		rdr.close();
	}
	
	public void addWord(String word) {
		int wordHash = jHashCode(word);
		if (this.dic.containsKey(wordHash)) {
			(dic.get(wordHash)).add(word);
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(word);
			dic.put(wordHash, list);
		}
	}

    //Check if a word exists in the dictionary
	public boolean wordExists(String word) {
		word = specialCharacters(word);
		boolean exists = false;
		if (dic.containsKey(jHashCode(word))) {
			for (String wordInList: dic.get(jHashCode(word))) {
				if (wordInList.equals(word)) {
					exists = true;
					break;
				}
			}
		}
		return exists;
	}

	public LinkedHashMap<Integer, ArrayList<String>> getDic() {
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

}

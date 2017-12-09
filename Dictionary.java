import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Dictionary extends WordEdit {
	
	private LinkedHashMap<Integer, ArrayList<String>> dic;
	private String lang;
	static ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
	private static boolean customExists = false;
	
	public Dictionary(String lang) throws IOException {
		this.dic = new LinkedHashMap<Integer, ArrayList<String>>();
		setDic(lang);
		this.lang = lang;
		dictionaries.add(this);
	}
	
	public Dictionary() {
		if (!customExists) {
			this.dic = new LinkedHashMap<Integer, ArrayList<String>>();
			this.lang = "custom";
			dictionaries.add(this);
			customExists = true;
		}
	}
	
	//Import the dictionary in a LinkedHashMap
	private void setDic(String lang) throws IOException {
				
		BufferedReader rdr = new BufferedReader(new InputStreamReader(new FileInputStream("dictionaries\\" + lang + ".txt"), "UTF8"));
		String nextWord = rdr.readLine();
		int nextWordHash = 0;
		nextWordHash = jHashCode(nextWord);
		while (nextWord != null) {
			if (this.dic.containsKey(nextWordHash)) {
				(dic.get(nextWordHash)).add(nextWord);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(nextWord);
				dic.put(nextWordHash, list);
			}
			nextWord = rdr.readLine();
			nextWordHash = jHashCode(nextWord);
		}
		rdr.close();
	}

    //Check if a word exists in the dictionary
	public boolean wordExists(String word) {
		word = specialCharacters(word);
		boolean exists = false;
		if (dic.containsKey(jHashCode(word))) {
			for (String wordInList: dic.get(jHashCode(word))) {
				if (wordInList.equals(word)) {
					exists = true;
				}
			}
		}
		return exists;
	}

	//Ignore the special characters
	public String specialCharacters(String word) {
		if (word.length() >= 2)
			word = word.substring(0, word.length() - 1) + word.substring(word.length() - 1).replaceAll("[^a-zA-Z&&[\\P{In" + lang + "}a-zA-Z]]", "");
		//System.out.println(word);//testing
		return word;
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

}

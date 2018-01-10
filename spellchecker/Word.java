package spellchecker;
import java.util.ArrayList;
import java.util.HashMap;


public class Word {

	public static HashMap<String, ArrayList<String>> punMap = new HashMap<String, ArrayList<String>>();
	
	private String wordStr;
	
	public Word(String word) {
		this.wordStr = word;
	}
	
	public static void createPunMap() {
		
		ArrayList<String> start = new ArrayList<String>();
		ArrayList<String> end = new ArrayList<String>();
		
		start.add("\"");
		start.add("'");
		start.add("(");
		start.add("#");
		start.add("$");
		start.add("[");
		start.add("{");
		start.add("@");
		start.add("-");
		start.add("<");
		start.add("~");
		start.add("�");
		start.add("�");
		start.add("�");
		start.add("�");
		
		end.add("�");
		end.add("!");
		end.add("$");
		end.add("%");
		end.add("'");
		end.add("\"");
		end.add(",");
		end.add(".");
		end.add(")");
		end.add("]");
		end.add("}");
		end.add(">");
		end.add(":");
		end.add(";");
		end.add("?");
		end.add("�");
		end.add("�");
		end.add("�");
		end.add("�");
		
		punMap.put("start", start);
		punMap.put("end", end);
	}
	
	public void specialCharacters() {		
		
		if (wordStr.length() >= 2 && punMap.get("start").contains(wordStr.substring(0, 1))) {
			wordStr = wordStr.substring(1);
		}
		if (wordStr.length() >= 4 && wordStr.substring(wordStr.length() - 3).equals("...")) {
			wordStr = wordStr.substring(0, wordStr.length() - 3);
		}
		if (wordStr.length() >= 2 && punMap.get("end").contains(wordStr.substring(wordStr.length() - 1))) {
			wordStr = wordStr.substring(0, wordStr.length() - 1);
		}
	}
	
	@Override
	public int hashCode() {
		int jhash = 0;
		if (wordStr != null) {
			if (wordStr.length() > 0) {
				for (int i = 0; i < wordStr.length(); i++) {
					jhash += wordStr.substring(i, i+1).hashCode();
				}
			}
		}
		return jhash;
	}
	
	public String toString() {
		return getWordStr();
	}
	
	public String getWordStr() {
		return wordStr;
	}

	public void setWordStr(String wordStr) {
		this.wordStr = wordStr;
		specialCharacters();
	}
	
}

import java.util.ArrayList;
import java.util.HashMap;

public abstract class WordEdit {

	private static HashMap<String,ArrayList<String>> punMap = new HashMap<String, ArrayList<String>>();
	
	public static int jHashCode(String word) {
		int jhash = 0;
		if (word != null) {
			if (word.length() > 0) {
				for (int i = 0; i < word.length(); i++) {
					jhash += word.substring(i, i+1).hashCode();
				}
			}
		}
		return jhash;
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
		start.add("«");
		start.add("£");
		start.add("¥");
		start.add("€");
		
		end.add("»");
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
		end.add("»");
		end.add("€");
		end.add("£");
		end.add("¥");
		
		punMap.put("start", start);
		punMap.put("end", end);
	}
	
	public static String specialCharacters(String word) {
		
		
		if (word.length() >= 2 && punMap.get("start").contains(word.substring(0, 1))) {
			word = word.substring(1);
		}
		if (word.substring(word.length() - 3).equals("...")) {
			word = word.substring(0, word.length() - 3);
		}
		if (punMap.get("end").contains(word.substring(word.length() - 1))) {
			word = word.substring(0, word.length() - 1);
		}
		
		return word;
	}
	
}

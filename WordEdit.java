import java.util.ArrayList;
import java.util.HashMap;

public abstract class WordEdit {

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
	
	public static HashMap<String, ArrayList<String>> punctuationMap() {
		
		HashMap<String,ArrayList<String>> punMap = new HashMap<String, ArrayList<String>>();
		
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
		
		return punMap;
		
		
	}
	
}

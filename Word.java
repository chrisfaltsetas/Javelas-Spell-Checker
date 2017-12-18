import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
	
	public void printMistakeMenu() {
		System.out.print("The word \"" + this + "\" doesn't exist.\n"
				+ "\t1) Get suggestions\n"
				+ "\t2) Skip\n"
				+ "\t3) Skip all\n"
				+ "\t4) Add to dictionary\n"
				+ "\tChoice: ");
	}
	
	public void handleMistake(int choice) {
				
		while (choice < 1 || choice > 4) {
			System.out.println("Invalid choice. Please try again.\nChoice: ");
			choice = new Scanner(System.in).nextInt();
		}
		
		if (choice == 1) {
			System.out.println(new Suggestions(this));
		} else if (choice == 3) {
			Dictionary.dictionaries.get(0).addWord(this);
		} else if (choice == 4) {
			Dictionary.dictionaries.get(0).addWord(this);
			try {				
				BufferedWriter wtr = 
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dictionaries\\custom.txt", true), "UTF8"));
				wtr.write(getWordStr());
				wtr.newLine();
				wtr.close();
			} catch (IOException iOException) {
				System.err.println("Could not find custom dictionary: " + iOException);
			}				
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Mapping {
	
	private static Scanner input;
	private static BufferedReader reader;
	static LinkedHashMap<Integer, ArrayList<String>> map = new LinkedHashMap<Integer, ArrayList<String>>();	

	//Run the programm
	public static void run() throws IOException {
				
		loadDic();
		//System.out.println(map.size());//testing
		System.out.print("Γράψε ένα κείμενο φίλε μου: ");
	 	input = new Scanner(System.in);
		String text = input.nextLine();
		searchDic(text);
	}

	//Import the dictionary in a LinkedHashMap
	public static void loadDic() throws IOException {
				
		reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/CHRIS/Desktop/LAB/Java/Javelas/src/Greek.txt"), "UTF8"));
		String nextWord = reader.readLine();
		nextWord = reader.readLine();//Throw first line away, firstline = 575133 (not a word)
		int nextWordHash = 0;
		nextWordHash = jHashCode(nextWord);
		//int counter = 0;
		while (nextWord != null /*&& counter < 1000*/) {
			if (map.containsKey(nextWordHash)) {
				(map.get(nextWordHash)).add(nextWord);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(nextWord);
				map.put(nextWordHash, list);
			}
			//System.out.println(nextWord);//testing
			nextWord = reader.readLine();
			nextWordHash = jHashCode(nextWord);
			//counter++;
		}
		//System.out.println(map.size());//testing DO NOT TRY TO PRINT MAP (takes time ~3min, resource heavy)
	}

    //Check if a word exists in the dictionary
	public static void searchDic(String text) {
		for (String word: text.split(" ")) {
			word = specialCharacters(word);
			//word = word.substring(0, 1) + word.substring(1).toLowerCase();
	
			boolean wordExists = false;
			if (map.containsKey(jHashCode(word))) {
				for (String wordInList: map.get(jHashCode(word))) {
					if (wordInList.equals(word))
						wordExists = true;
				}
			}
			
			if (!wordExists) {
				System.out.println(word + " doesn't exist");
				word.firstSuggestions();
			}			
			else 
				System.out.println(word + " exists");						
		}
	}

	//Ignore the special characters
	public static String specialCharacters(String words) {
		words = words.replaceAll("[\\P{InGreek}a-zA-Z]", "");
		System.out.println(words);//testing
		return words;
	}
	
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
}

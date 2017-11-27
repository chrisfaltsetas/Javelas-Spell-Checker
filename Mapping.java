import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class Mapping {
	
	private static Scanner input;
	private static BufferedReader reader;

	//Run the programm
	public static void run(String path, String encoding) throws IOException {
			
		System.out.print("Γράψε ένα κείμενο φίλε μου: ");
		LinkedHashMap<Integer, ArrayList<String>> map = putWordsInHashMap(path, encoding);
	 	input = new Scanner(System.in);
		String text = input.nextLine();
		//searchDic(map,text);
	}

	//Put the words into the HashMap
	public static LinkedHashMap<Integer, ArrayList<String>> putWordsInHashMap(String path, String encoding) throws IOException {
			
		LinkedHashMap<Integer, ArrayList<String>> map = new LinkedHashMap<Integer, ArrayList<String>>();
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
		String nextWord = "";
		while (nextWord != null) {
			nextWord = reader.readLine();
			if (map.containsKey(jHashCode(nextWord))) {
				(map.get(jHashCode(nextWord))).add(nextWord);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(nextWord);
				map.put(jHashCode(nextWord), list);
			}
		}			
		return map;
	}

    //Check if a word exists in the dictionary.Every single word or character at the text should have space.
	public static void searchDic(HashMap<String,Integer> map, String text) {
		for(String retval: text.split(" ")) {
			String copy_value = specialCharacters(retval).toLowerCase();
			//testing
			if (!map.containsKey(copy_value))
				System.out.println(retval + " doesn't exist");
			else
				System.out.println(retval + " exists");
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
		if (word.length() > 0) {
			for (int i = 0; i < word.length(); i++) {
				jhash += word.substring(i, i+1).hashCode();
			}
		}
		return jhash;
	}
}

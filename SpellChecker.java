import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class SpellChecker {
	
	//Run the programm
	public static void run(String path, String encoding) throws IOException {
			
		System.out.print("Γραψε κειμενο: ");
		HashMap<String,Integer> map = putWordsInHashMap(path, encoding);
	 	Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		searchDic(map,text);
		input.close();

	}

	//Put the words into the HashMap
	public static HashMap<String,Integer> putWordsInHashMap(String path, String encoding) throws IOException {
			
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),encoding));
		String line = "";
		int i = 0;
		while (line != null) {
			line = reader.readLine();
			map.put(line,i);
			i++;
		}
		
		reader.close();
		return map;
	}

     //Check if a word exists in the dictionary.Every single word or character at the text should have space.
     public static void searchDic(HashMap<String,Integer> map, String text) { //Constructor-Class Name ???
    	 Scanner input = new Scanner(System.in);
    	 for(String retval: text.split(" ")) {
    		 String copy_value = SpecialCharacters(retval).toLowerCase();
    		 //testing
    		 if ( !map.containsKey(copy_value))
    			 System.out.println(retval + " doesn't exist");
    		 else
    			 System.out.println(retval + " exists");
    	 }
    	 input.close();
     }

     //An effort to ignore the special characters like , . @ and numbers. IT SHOULD BE FIXED IMMEDIATELY!
     public static String SpecialCharacters(String words) {
    	 if(words.contains(",")) {
    		 words.replace("," ," ");
    	 }
    	 
    	 return words;
     }

}


import java.io.*;
import java.util.*;
import java.lang.*;




public class SpellChecker {

	//Run the programm
	public static void main(String[] args) throws IOException {

	 	HashMap<String,Integer> map = putWords();
	 	Scanner input=new Scanner(System.in);
		String text=input.nextLine();
		SearchDic(map,text);


	}

	//Put the words into the HashMap
     public static HashMap<String,Integer> putWords()throws IOException  {

    	 HashMap<String,Integer> map = new HashMap<String,Integer>();
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/MariosD/Downloads/Greek.txt"),"UTF8"));
    	 String line="";
    	 int i = 0;
    	 while (line != null) {
    		 line = reader.readLine();
    		 map.put(line,i);
    		 i++;
    	 }

    	 return map;
     }

	//Check if a word exists in the dictionary.Every single word or character at the text should have space.
     public static void SearchDic(HashMap<String,Integer> map, String text)  {
    	 Scanner input=new Scanner(System.in);
    	 for(String retval: text.split(" ")) {
    		 String copy_value = SpecialCharacters(retval).toLowerCase();
    		 if ( !map.containsKey(copy_value)) {
    			 System.out.println(retval + " Don't Exists");
    		 }
    	 }
     }

		//An effort to ignore the special characters like , . @ and number . IT SHOULD BE FIXED IMMEDIATELLY!
     public static String SpecialCharacters(String words) {
    	 if(words.contains(",")) {
    		 words.replace("," ," ");
    	 }
    	 
    	 return words;
     }

}

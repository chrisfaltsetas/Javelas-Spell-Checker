
public class Suggestions {
	public void suggestions(String word) {
		String path = "C:\\Users\\spyro\\Desktop\\WORD\\Greek.txt";
		String encoding = "UTF8";
		LinkedHashMap<Integer,ArrayList<String>>  search = putWordsInHashMap( path,  encoding);
		//HashMap<Integer,String>  dic = SpellChecker.run(path, encoding);
		 int code = jHashCode(word);
		 ArrayList<String> array ;
		 array = search.get(code);
		 String[] suggestions ;
		 int i = 0;
		 while ((array.hasNext())|| (i<10)) {
			 suggestions[i]=array.get(i).toString();// 
			 
		 }

	}

}

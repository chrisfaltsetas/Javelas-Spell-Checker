import java.util.HashMap;

public class HashMapsBaseThings {
	public static void main(String args[]) {
		/* declare Hashmap object*/
		HashMap<Integer,String> hashmap = new HashMap<Integer,String>();
		/* add elements  hashmap.put(Integer,String) (integer=key and String=value)*/
		hashmap.put(1,"spyros lavranos");
		hashmap.put(2,"lion");
		hashmap.put(5,"ARGHH ..PIRATE");
		hashmap.put(54,"frogen says aloha");
		hashmap.put(12,"Agar.io");
		//i just added 5 elements
		//how get values  based on the key ;
		//use hashmap.get(key)
		String valueOfMap =hashmap.get(54);
		System.out.println(valueOfMap);
		//remove values based on key
		//use hashmap.remove(key);
		hashmap.remove(1);
	}
}



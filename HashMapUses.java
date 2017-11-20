import java.util.HashMap;

public class HashMapUses {

	public static void HashMapsTest() {
		
		//declare Hashmap object
		HashMap<Integer,String> hashmap = new HashMap<Integer,String>();
		
		//add elements -> hashmap.put(Integer,String) (integer=key and String=value)
		hashmap.put(1, "spyros lavranos");
		hashmap.put(2, "lion");
		hashmap.put(5, "ARGHH ..PIRATE");
		hashmap.put(54, "froggen says aloha");
		hashmap.put(12, "Agar.io");
		
		
		//get values based on key -> hashmap.get(key)
		String valueOfMap = hashmap.get(54);
		System.out.println(valueOfMap);//prints: froggen says aloha
		
		
		//remove values based on key -> hashmap.remove(key)
		hashmap.remove(1);
		System.out.println(hashmap.get(1));//prints: null
		
		
		//get size of map -> hashmap.size()
		int size = hashmap.size();
		System.out.printf("Size of map is %d \n", size);//prints: Size of map is 4
		
		
		//display hashmap elements -> hashmap
		System.out.println("HashMap elements\n" + hashmap);//prints: HashMap elements {2=lion, 5=ARGHH ..PIRATE, 54=froggen says aloha, 12=Agar.io}
		
		
		//remove all mapping -> hashmap.clear()
		hashmap.clear();
		System.out.println("HashMap elements\n" + hashmap);//prints: HashMap elements {}
	}
}

import java.util.HashMap;

public class HashMapUses {

	public static void main(String args[]){
		HashMap<Integer,String> hashmap =new HashMap<Integer,String>();
		hashmap.put(1,"spyros lavranos");
		hashmap.put(2,"lion");
		hashmap.put(5,"ARGHH ..PIRATE");
		hashmap.put(54,"frogen says aloha");
		hashmap.put(12,"Agar.io");
		//how to get size of map  hashmap.size();
		int size = hashmap.size();
		System.out.printf("size of map is %d \n", size);
		//display hashmap elements hmap
		System.out.println("HashMaps element\n" + hashmap);
		//how to remove all mapping;
		//hmap.clear()
		hashmap.clear();
		System.out.println("HashMaps element\n" + hashmap);
	 }
 }

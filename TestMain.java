import java.io.IOException;

public class TestMain {

	public static void main(String[] args) {

		printDistanceMap("cayry", "caral");
		printDistanceMap("sitting", "kitten");
		
		HashMapUses.HashMapsTest();
				
		String path = "C:/Users/CHRIS/Desktop/LAB/Java/Javelas/src/Greek.txt";//Needs to be changed
		String encoding = "UTF8";
		checkSpellingTest(path, encoding);
		
	
	}
	
	
	public static void printDistanceMap(String string1, String string2) {
		//System.out.println("Distance is: " + WordDistance.distanceOptimal(string1, string2));
		//System.out.println();
		//System.out.println();
		System.out.println("Distance is: " + WordDistance.getMinimumDistance(string1, string2));
		System.out.println();
		System.out.println();
	}
	
	public static void checkSpellingTest(String path, String encoding) {
		while(true) {
			try {
				SpellChecker.run(path, encoding);
			} catch (IOException ioException) {
				System.out.println (ioException.toString());
				System.out.println("Could not find file: " + path);
				break;
			}
		}
	}

}

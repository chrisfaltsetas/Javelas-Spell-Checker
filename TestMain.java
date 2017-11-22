import java.io.IOException;

public class TestMain {

	public static void main(String[] args) {

		printDistanceMap("cayry", "caral");
		printDistanceMap("sitting", "kitten");
		
		//HashMapUses.HashMapsTest();
				
		String path = "C:/Users/CHRIS/Desktop/LAB/Java/Javelas/src/Greek.txt";//Needs to be changed
		String encoding = "UTF8";
		//checkSpellingTest(path, encoding);
		
		hashcodeTest();
		
		lowerUpperTest("Α");
		lowerUpperTest("Ά");
		lowerUpperTest("α");
		lowerUpperTest("ά");
		
		
		
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
	
	public static void hashcodeTest() {
		
		//902-974
		char c = "!".charAt(0);
		String s = String.valueOf(c);
		int x = s.hashCode();
		int counter = 0;
		while (x >= 0 && counter < 1000) {			
			System.out.println(c + " = " + s.hashCode());
			c++;
			s = String.valueOf(c);
			x = s.hashCode();
			counter++;
			
		}
	}
	
	public static void lowerUpperTest(String string1) {
				
		System.out.println("Original string = " + string1);
		System.out.println("Lower case = " + string1.toLowerCase());
		System.out.println("Upper case = " + string1.toUpperCase());
		
		if (string1.equals(string1.toLowerCase()))
			System.out.println("O->L: " + string1 + " = " + string1.toLowerCase());
		else
			System.out.println("O->L: " + string1 + " # " + string1.toLowerCase());
		
		if (string1.equals(string1.toUpperCase()))
			System.out.println("O->U: " + string1 + " = " + string1.toUpperCase());
		else
			System.out.println("O->U: " + string1 + " # " + string1.toUpperCase());
	}

}

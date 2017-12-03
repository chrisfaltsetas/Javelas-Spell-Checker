import java.io.IOException;
import java.util.Scanner;

public class TestMain {

	private static Scanner input;

	public static void main(String[] args) {

		//printDistanceMap("cayry", "caral");
		//printDistanceMap("sitting", "kitten");
		
		//HashMapUses.HashMapsTest();
				
		String path = "C:/Users/CHRIS/Desktop/LAB/Java/Javelas/src/Greek.txt";//Needs to be changed
		String encoding = "UTF8";
		checkSpellingTest(path, encoding);
		
		//hashcodeTest();
		
		/*
		String x = "αβγο";
		System.out.println("jHash of " + x + ": " + jHashCode(x));
		String y = "αβογ";
		System.out.println("jHash of " + y + ": " + jHashCode(y));		
		System.out.println("Difference is: " + (Math.abs(jHashCode(x)-jHashCode(y))));
		*/
		
		System.out.println("-> End of TestMain.");
		
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
		String nextWord = "Ν";
		while (nextWord.equals("Ν")) {
			try {
				Mapping.run();
				input = new Scanner(System.in);
				System.out.print("Θελεις να δοκιμασεις κι αλλη προταση φιλε μου; \nΓραψε Ν για ναι ή Ο για οχι: ");
				nextWord = input.nextLine();
				System.out.println(nextWord);
				while (!nextWord.equals("Ν") && !nextWord.equals("Ο")) {
					System.out.print("Θελεις να δοκιμασεις κι αλλη προταση φιλε μου; \nΓραψε Ν για ναι ή Ο για οχι: ");
					nextWord = input.nextLine();
				}				
			} catch (IOException ioException) {
				System.out.println (ioException);
				System.out.println("Could not find the dictionary file.");
				break;
			}
		}
	}
	
	public static void hashcodeTest() {
		
		//902-974
		char c = "Ά".charAt(0);
		String s = String.valueOf(c);
		int x = s.hashCode();
		int counter = 0;
		while (x >= 0 && counter < 73) {			
			System.out.println(c + " = " + s.hashCode());
			c++;
			s = String.valueOf(c);
			x = s.hashCode();
			counter++;
			
		}
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

import java.io.IOException;
import java.util.Scanner;

public class TestMain {

	private static Scanner input;

	public static void main(String[] args) {

		printDistanceMap("cayry", "caral");
		printDistanceMap("sitting", "kitten");
		
		//HashMapUses.HashMapsTest();
				
		String path = "C:/Users/CHRIS/Desktop/LAB/Java/Javelas/src/Greek.txt";//Needs to be changed
		String encoding = "UTF8";
		checkSpellingTest(path, encoding);
		
		hashcodeTest();
		
		lowerUpperTest("ά");
		lowerUpperTest("α");
		lowerUpperTest("Α");
		lowerUpperTest("Ά");
		
		
		String x = "α";
		System.out.println(x.hashCode());
		String y = "ω";
		System.out.println(y.hashCode());
		System.out.println("Difference is: " + (Math.abs(y.hashCode()-x.hashCode())));
		
		
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
				SpellChecker.run(path, encoding);
				input = new Scanner(System.in);
				System.out.print("Θελεις να δοκιμασεις κι αλλη προταση φιλε μου; \nΓραψε Ν για ναι ή Ο για οχι: ");
				nextWord = input.nextLine();
				System.out.println(nextWord);
				while (!nextWord.equals("Ν") && !nextWord.equals("Ο")) {
					System.out.print("Θελεις να δοκιμασεις κι αλλη προταση φιλε μου; \nΓραψε Ν για ναι ή Ο για οχι: ");
					nextWord = input.nextLine();
				}				
			} catch (IOException ioException) {
				System.out.println (ioException.toString());
				System.out.println("Could not find file: " + path);
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
		while (x >= 0 && counter < 74) {			
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpellingTest {

	public static void main(String[] args) throws IOException {
		
		menu();
		String text = null;
		Scanner input = new Scanner(System.in, "UTF8");
		
		int choice = input.nextInt();
		
		if (choice == 1) {
			Scanner input1 = new Scanner(System.in, "UTF8");
			System.out.print("Write a text: ");
			text = input1.nextLine();
		} else if (choice == 2) {
			BufferedReader rdr = new BufferedReader(new InputStreamReader(new FileInputStream("Test.txt"), "UTF8"));
			String nextWord = rdr.readLine();
		} 
		
		checkSpellingTest(text);
		
	}
	
	public static void checkSpellingTest(String text) throws IOException {
		
		Dictionary grDic = new Dictionary("Greek");
		for (String word: text.split(" ")) {
			
			if (!grDic.wordExists(word)) {
				System.out.println(word + " doesn't exist");
			}
		}
		//System.out.print("Want to try another text? (Y/N): ");		
		
	}
	
	public static void menu() {
		System.out.print("What do you want to do:\n"
				+ "1) Write text\n"
				+ "2) Import .txt file\n"
				+ "3) Import .doc file\n"
				+ "4) Give URL\n"
				+ "Choice: ");
		
	}

}

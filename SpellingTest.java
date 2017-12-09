import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpellingTest {

	public static void main(String[] args) throws IOException {
		

		Dictionary grDic = new Dictionary("Greek");
		
		menu();
		String text = null;
		Scanner input = new Scanner(System.in, "UTF8");
		
		int choice = input.nextInt();
		
		if (choice == 1) {
			Scanner input1 = new Scanner(System.in, "UTF8");
			System.out.print("Write a text: ");
			text = input1.nextLine();
			input1.close();
		} else if (choice == 2) {
			BufferedReader rdr = new BufferedReader(new InputStreamReader(new FileInputStream("testTxt.txt"), "UTF8"));
			//Scanner in = new Scanner(rdr);
			String line = rdr.readLine();
			if (line != null) {
				text = line + " ";
				line = rdr.readLine();
				while (line != null) {
					text += line + " ";
					line = rdr.readLine();					
				}
			}
			//System.out.println(text);
			rdr.close();
		} else {
			System.out.println("Not a valid choice, the program will now exit.");
		}
		checkSpellingTest(text);
		input.close();
		
	}
	
	public static void checkSpellingTest(String text) throws IOException {
		
		for (String word: text.split(" ")) {
			for (Dictionary dictionary: Dictionary.dictionaries) {
				if (!dictionary.wordExists(word)) {
					System.out.println(dictionary.specialCharacters(word) + " doesn't exist");
					Suggestions sugg = new Suggestions(word);
					sugg.getSuggestions();
				}
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
				+ "0) Exit program\n"
				+ "Choice: ");
		
	}

}

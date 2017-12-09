import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpellingTest {

	public static void main(String[] args) throws IOException {
		
		Dictionary customDic = new Dictionary();
		Dictionary grDic = new Dictionary("Greek", 73);
		Dictionary enDic = new Dictionary("English", 58);
						
		String text = null;
		Scanner input = new Scanner(System.in, "UTF8");
		
		menu();		
		int choice = Integer.parseInt(input.nextLine());
		
		if (choice == 0) {
			System.out.println("The program will now exit.");
		} else if (choice == 1) {			
			System.out.print("Write a text: ");
			text = input.nextLine();
			//System.out.println(text);
			checkSpellingTest(text);
		} else if (choice == 2) {
			System.out.print("Name of the txt file to be read: ");
			BufferedReader rdr = new BufferedReader(new InputStreamReader(new FileInputStream(input.nextLine() + ".txt"), "UTF8"));
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
			checkSpellingTest(text);
		} else {
			System.out.println("Not a valid choice, the program will now exit.");
		}
		input.close();
		System.out.println("Thank you for using JavelasSpelling.");		
	}
	
	public static void checkSpellingTest(String text) throws IOException {
		
		for (String word: text.split(" ")) {
			boolean exists = false;
			word = word.substring(0, word.length() - 1) + word.substring(word.length() - 1).replaceAll("[^a-zA-Z&&[\\P{InGreek}a-zA-Z]]", "");
			for (Dictionary dictionary: Dictionary.dictionaries) {
				if (dictionary.wordExists(word)) {
					exists = true;
					//System.out.println(word + " exists");
				}
			}
			if (!exists) {
				System.out.print(word + " doesn't exist.\nSuggestions: ");
				new Suggestions(word).getSuggestions();
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

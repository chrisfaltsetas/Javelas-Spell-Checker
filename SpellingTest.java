import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpellingTest {

	public static void main(String[] args) {
						
		String text = null;
		Scanner input = new Scanner(System.in, "UTF8");
		
		menu();		
		int choice = Integer.parseInt(input.nextLine());
		
		try {
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
				if (text != null)
					checkSpellingTest(text);
				else
					System.out.println("The file given was empty.");
			} else {
				System.out.println("Not a valid choice, the program will now exit.");
			}
		} catch (IOException iOException) {
			System.err.println("Could not find any input: " + iOException);
		}
		input.close();
		System.out.println("Thank you for using JavelasSpelling.");		
	}
	
	public static void checkSpellingTest(String text) throws IOException {
		
		Dictionary customDic = new Dictionary();
		Dictionary grDic = new Dictionary("Greek", 73);
		Dictionary enDic = new Dictionary("English", 58);
		
		WordEdit.createPunMap();
		
		for (String word: text.split(" ")) {
			boolean exists = false;
			word = WordEdit.specialCharacters(word);
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

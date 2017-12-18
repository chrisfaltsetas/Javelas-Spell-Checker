import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SpellingTest {

	public static void main(String[] args) {
						
		String text = null;
		Scanner input = new Scanner(System.in, "UTF8");
		try {
			System.setOut(new PrintStream(System.out, true, "UTF8"));			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encoding is not supported. " + e);
		}
		
		printTextMenu();		
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
				if (line != null && line.length() >= 2 && line.substring(0, 1).equals("\ufeff"))
					line = line.substring(1);
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
			System.err.println("Could not get any text to check: " + iOException);
		}
		input.close();
		System.out.println("Thank you for using JavelasSpelling.");		
	}
	
	public static void checkSpellingTest(String text) {
		
		try {
			Dictionary customDic = new Dictionary();
			Dictionary grDic = new Dictionary("Greek", 73);
			Dictionary enDic = new Dictionary("English", 58);
		} catch (IOException iOException) { 
			System.err.println("Could not find the dictionary .txt files in your computer: " + iOException);
		}
		
		Word.createPunMap();		
		Word word = new Word(null);
		Scanner input = new Scanner(System.in);
		
		for (String wordStr: text.split(" ")) {
			boolean exists = false;
			word.setWordStr(wordStr);
			for (Dictionary dictionary: Dictionary.dictionaries) {
				if (dictionary.wordExists(word)) {
					exists = true;
				}
				
				if (word.getWordStr().length() >= 2 && dictionary.wordExists(new Word(word.getWordStr().substring(0, 1).toLowerCase() + word.getWordStr().substring(1)))) {
					exists = true;
				}
			}
			if (!exists) {
				word.printMistakeMenu();				
				int choice = input.nextInt();				
				while (choice < 1 || choice > 4) {
					System.out.print("Invalid choice. Please try again.\nChoice: ");
					choice = new Scanner(System.in).nextInt();
				}
				word.handleMistake(choice);				
			}		
		}
		input.close();
	}
	
	public static void printTextMenu() {
		System.out.print("What do you want to do:\n"
				+ "1) Write text\n"
				+ "2) Import .txt file\n"
				+ "3) Import .doc file\n"
				+ "4) Give URL\n"
				+ "0) Exit program\n"
				+ "Choice: ");
	}
	
	
}

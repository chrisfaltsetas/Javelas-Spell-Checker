import java.io.IOException;
import java.util.Scanner;

public class SpellingTest {

	public static void main(String[] args) throws IOException {
		//menu();
		checkSpellingTest();
	}
	
	public static void checkSpellingTest() throws IOException {
		
		Dictionary grDic = new Dictionary("Greek");
		System.out.print("Write a text: ");
	 	Scanner input = new Scanner(System.in, "UTF8");
		String word = input.next();
		grDic.wordExists(word);
		System.out.print("Want to try another text? (Y/N): ");		
		input.close();
		
	}
	
	public static void menu() {
		System.out.println("What do you want to do:\n"
				+ "1) Write text\n"
				+ "2) Import .txt file\n"
				+ "3) Import .doc file\n"
				+ "4) Give URL\n");
		
	}

}

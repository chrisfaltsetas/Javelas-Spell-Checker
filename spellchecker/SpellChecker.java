package spellchecker;

import fxmlGUI.JavelasApp;

public class SpellChecker {
	
	private JavelasApp javelasApp;
	
	public SpellChecker(JavelasApp javelasApp) {
		this.javelasApp = javelasApp;
	}
	
	public void acheckSpelling(String text) {
	
		Word.createPunMap();
		Word word = new Word(null);
		//Scanner input = new Scanner(System.in);
		
		//javelasApp.showMistakeMenu();
		
		for (String wordStr: text.split(" ")) {		
			boolean exists = false;
			word.setWordStr(wordStr);
			for (Dictionary dictionary: Dictionary.dictionaries) {
				if (word.getWordStr().matches("-?\\d+(\\.\\d+)+(\\,\\d+)?") || word.getWordStr().matches("-?\\d+(\\,\\d+)+(\\.\\d+)?")) {
					exists = true;
				} else {
					if (dictionary.wordExists(word)) {
						exists = true;
					}
					
					if (word.getWordStr().length() >= 2 && dictionary.wordExists(new Word(word.getWordStr().substring(0, 1).toLowerCase() + word.getWordStr().substring(1)))) {
						exists = true;
					}
				}
			}
			if (!exists) {
				
				
				//javelasApp.showEmptyScene();
				
				//synchronized(javelasApp.getPrimaryStage().getScene()) {
					//javelasApp.getPrimaryStage().getScene().wait();
				//}
				
				System.out.println("Etsi vlepw ti kanei");
				//word.handleMistake(choice);				
			}		
		}
		//javelasApp.showMainMenu();
		//input.close();
	}
	
	public boolean wordIsValid(String wordStr) {
		boolean exists = false;
		Word word = new Word(wordStr);
		for (Dictionary dictionary: Dictionary.dictionaries) {
			if (word.getWordStr().matches("-?\\d+(\\.\\d+)+(\\,\\d+)?") || word.getWordStr().matches("-?\\d+(\\,\\d+)+(\\.\\d+)?")) {
				exists = true;
			} else {
				if (dictionary.wordExists(word)) {
					exists = true;
				}
				
				if (word.getWordStr().length() >= 2 && dictionary.wordExists(new Word(word.getWordStr().substring(0, 1).toLowerCase() + word.getWordStr().substring(1)))) {
					exists = true;
				}
			}
		}
		return exists;
	}
}

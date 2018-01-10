package fxmlGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import spellchecker.Dictionary;
import spellchecker.Suggestions;
import spellchecker.Word;

public class MistakeMenuController {

	@FXML
	private Text wrongWordPanel;
	@FXML
	private Button getSuggestionsButton;
	@FXML
	private Text suggestions;
	@FXML
	private Button skipThis;
	@FXML
	private Button skipSame;
	@FXML
	private Button addToDictionary;
	
	private JavelasApp javelasApp;
	private Word word;
	
	public MistakeMenuController() {
	}
	
	@FXML
	public void getSuggestions(ActionEvent event) {
		if (word != null)
			suggestions.setText(new Suggestions(word).toString());
		else
			javelasApp.showThankYou();
	}
	
	@FXML
	public void clickSkipThis(ActionEvent event) {
		wrongWordPanel.setText(null);
		suggestions.setText(null);
		if (javelasApp.counter < javelasApp.wrongWords.size() - 1) {
			javelasApp.raiseCounter();
			javelasApp.handleMistake(this, javelasApp.counter);
		} else {
			javelasApp.showThankYou();
		}
		
	}

	@FXML
	public void clickSkipSame(ActionEvent event) {
		Dictionary.dictionaries.get(0).addWord(word);
		wrongWordPanel.setText(null);
		suggestions.setText(null);
		if (javelasApp.counter < javelasApp.wrongWords.size()) {
			javelasApp.handleMistake(this, javelasApp.counter++);
		} else {
			javelasApp.showThankYou();
		}
	}
	
	@FXML
	public void clickAddToDictionary(ActionEvent event) {
		Dictionary.dictionaries.get(0).addWordPermanently(word);
		wrongWordPanel.setText(null);
		suggestions.setText(null);
		if (javelasApp.counter < javelasApp.wrongWords.size()) {
			javelasApp.handleMistake(this, javelasApp.counter++);
		} else {
			javelasApp.showThankYou();
		}
	}
	
	public void setJavelasApp(JavelasApp javelasApp) {
		this.javelasApp = javelasApp;
	}
	
	public void setWrongWordPanel() {
		wrongWordPanel.setText("The word \"" + word.getWordStr() + "\" doesn't exist");
	}

	public void setSuggestions() {
		suggestions.setText(new Suggestions(word).toString());
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}
}

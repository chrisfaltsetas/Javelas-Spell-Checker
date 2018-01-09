package fxmlGUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import spellchecker.SpellChecker;
import spellchecker.URLtextReader;

public class MainMenuController {
	
	@FXML
	private TextField writtenText;
	@FXML
	private Button importedText;
	@FXML
	private TextField URLText;

	private JavelasApp javelasApp;
	
	public MainMenuController() {
	}
	
	
	@FXML
    private void checkWrittenText(ActionEvent event) {
		try {
	    	String text = writtenText.getText();
	    	if (text != null && !text.isEmpty())
				new SpellChecker(javelasApp).checkSpelling(text);
	    	//javelasApp.showMainMenu();
		} catch (Exception e) {
	    	//javelasApp.showMainMenu();
		}
    }
	
	@FXML
	private void checkImportedText(ActionEvent event) throws InterruptedException {
		FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(javelasApp.getPrimaryStage());

        if (file != null) {
        	String text = null;
        	BufferedReader rdr;
		
			try {
				rdr = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
				
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
				if (text != null && !text.isEmpty())
					new SpellChecker(javelasApp).checkSpelling(text);
				else
					System.out.println("The file given was empty.");
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(javelasApp.getPrimaryStage());
		        alert.setTitle("Error");
		        alert.setHeaderText("Error while reading the file");
		        alert.setContentText("The program was not able to read the txt file given.");
		        alert.showAndWait();
			}
        }
        javelasApp.showMainMenu();
	}
	
	@FXML
	private void checkURLText(ActionEvent event) throws InterruptedException {
		String text = new URLtextReader().removeHTMLTags(URLText.getText());
		if (text != null && !text.isEmpty())
			new SpellChecker(javelasApp).checkSpelling(text);
		javelasApp.showMainMenu();
	}

	public void setJavelasApp(JavelasApp javelasApp) {
		this.javelasApp = javelasApp;
	}
}

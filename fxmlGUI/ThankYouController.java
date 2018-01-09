package fxmlGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ThankYouController {

	@FXML
	private Button checkAgain;
	
	private JavelasApp javelasApp;
	
	@FXML
	public void clickCheckAgain(ActionEvent event) {
		javelasApp.showMainMenu();
	}

	public void setJavelasApp(JavelasApp javelasApp) {
		this.javelasApp = javelasApp;
	}
}

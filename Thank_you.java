import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Thank_you extends Application{
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Text text = new Text(20, 20, "Thank you for using JavelasSpelling.");
		pane.getChildren().addAll(text);

		Scene scene = new Scene(pane, 300, 100);
		primaryStage.setTitle("");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

}


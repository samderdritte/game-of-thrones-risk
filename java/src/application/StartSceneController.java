package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartSceneController extends Controller {

	public Button startButton;
	
	// Button for the first Scene
	public void startGame(ActionEvent event) throws IOException {
		System.out.println("Game started.");
		
		Parent parent = FXMLLoader.load(getClass().getResource("SelectPlayerScene.fxml"));
		Scene selectPlayer = new Scene(parent, 400, 200);
		selectPlayer.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(selectPlayer);
		window.show();
	}
}

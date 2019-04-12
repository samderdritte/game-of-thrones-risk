package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
	
	// Instance Variables for Buttons
	public Button startButton;
	public Button playerSelectButton;
	public Button wolfswood;
	public Button stoneyshore;
	public Button button;
	
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
	

	// Button for the Player select Scene
	public void selectPlayer(ActionEvent event) throws IOException {
		System.out.println("Number of Players: ");
		
		Parent parent = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene mainScene = new Scene(parent, 1200, 900);
		
		mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainScene);
		window.centerOnScreen();
		window.show();
	}
	
	public void printUnits(ActionEvent event) throws IOException {
		Button x = (Button) event.getSource();
		if (x == wolfswood) {
			System.out.println(event.getSource());
		} else if (x == stoneyshore) {
			System.out.println(event.getSource());
		}
			

	}
	public void printUnits2(ActionEvent event) throws IOException {
		System.out.println(button.getText());
	}
	
	
}

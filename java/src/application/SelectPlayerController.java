package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SelectPlayerController extends Controller {
	
	public TextField numPlayers;
	public Label numPlayersValidationMessage;
	public Button playerSelectButton;
	
	// Button for the Player select Scene
	public void selectPlayer(ActionEvent event) throws IOException {
		
		if(!isValidPlayerNumber(numPlayers, numPlayers.getText())) {
			numPlayersValidationMessage.setText("Pleaser enter a number between 2-6");
		} else {
			System.out.println("Number of Players: "+ numPlayers.getText());
			numPlayersEntered = Integer.parseInt(numPlayers.getText());
			playersList = new ArrayList<String>(numPlayersEntered);

			Parent parent = FXMLLoader.load(getClass().getResource("PlayerNameScene.fxml"));
			Scene selectPlayer = new Scene(parent, 400, 200);
			selectPlayer.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(selectPlayer);
			window.show();
		}				
	}
	
	// validation for number of players between 2 and 6
	private boolean isValidPlayerNumber(TextField input, String message) {
		try {
			int value = Integer.parseInt(input.getText());
			if(value > 1 && value < 7) {
				return true;
			} else {
				System.out.println("Error: " + message + " is not between 2-6.");
				return false;
			}
			
		} catch(NumberFormatException e) {
			System.out.println("Error: " + message + " is not an integer");
			return false;
		}
	}
}

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerNameController extends Controller {
	
	public TextField playerName;
	public Label playerNameNumber;
	public Label namePlayersValidationMessage;
	public Button playerNameButton;
	static Text player1NameLabel, player2NameLabel, player3NameLabel, 
				player4NameLabel, player5NameLabel, player6NameLabel;
	
	//Button for Player Name Scene
	public void namePlayer(ActionEvent event) throws IOException {
		
		// add the current player to the ArrayList of players
		if(!playerName.getText().equals("")) {
			playersList.add(playerName.getText());
		}
		// reject empty name-strings
		if (playerName.getText().equals("")) {
			namePlayersValidationMessage.setText("Name cannot be empty");
		
		// change the input selection for the other player numbers
		} else if (playersList.size() < numPlayersEntered) {
			System.out.println("Player " + playerNameNumber.getText() + ": " + playerName.getText());
			int playerNum = Integer.parseInt(playerNameNumber.getText());
			playerNum++;
			playerNameNumber.setText(Integer.toString(playerNum));
			playerName.setText("");
			playerName.requestFocus();
		
		// once all player names are given, load the main scene
		} else {
			System.out.println("Player " + playerNameNumber.getText() + ": " + playerName.getText());
			System.out.println("Load main scene.");
			System.out.println("The players are: "+playersList);
			
			// load the main scene
			Parent parent = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			
			Scene mainScene = new Scene(parent, 1200, 900);		
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();		
			window.setScene(mainScene);
			window.centerOnScreen();
			window.setMaximized(true);
			window.centerOnScreen();			
			window.show();
			

			
			// Set the names of the Players in the left box
			playerStatsBox = (VBox) mainScene.lookup("#playerStatsBox");
			for (int i=0;i<numPlayersEntered;i++) {
				Text currentLabel = (Text) playerStatsBox.getChildren().get(i*3);
				currentLabel.setText(playersList.get(i));
			}
			for (int i=playerStatsBox.getChildren().size()-2; i > numPlayersEntered*3-1; i--) {
				playerStatsBox.getChildren().remove(i);
			}
			
			// Set the number of starting units per player
			int numStartingUnits = 0;			
			switch (numPlayersEntered) {
				case 2:	numStartingUnits = 40;
				break;
				case 3:	numStartingUnits = 35;
				break;
				case 4:	numStartingUnits = 30;
				break;
				case 5:	numStartingUnits = 25;
				break;
				case 6:	numStartingUnits = 20;
				break;
			}
			
			for (int i=0;i<numPlayersEntered;i++) {
				System.out.println("okokok");
				BorderPane currentPane = (BorderPane) playerStatsBox.getChildren().get(i*3+2);
				Text currentUnitsText = (Text) currentPane.getRight();
				currentUnitsText.setText(Integer.toString(numStartingUnits));
			}
			
			// the following code is not final, but used for debugging and testing			
			System.out.println("---");
			
			
			/*
			Text player1NameLabel = (Text) mainScene.lookup("#player1NameLabel");
			player1NameLabel.setText(playersList.get(0));
			Text player2NameLabel = (Text) mainScene.lookup("#player2NameLabel");
			player2NameLabel.setText(playersList.get(1));
			Text player3NameLabel = (Text) mainScene.lookup("#player3NameLabel");
			player2NameLabel.setText(playersList.get(2));
			Text player4NameLabel = (Text) mainScene.lookup("#player4NameLabel");
			player2NameLabel.setText(playersList.get(3));
			Text player5NameLabel = (Text) mainScene.lookup("#player5NameLabel");
			player2NameLabel.setText(playersList.get(4));
			Text player6NameLabel = (Text) mainScene.lookup("#player6NameLabel");
			player2NameLabel.setText(playersList.get(5));
			
			
			Text player1Numunits = (Text) mainScene.lookup("#player1-numunits");
			Text player2Numunits = (Text) mainScene.lookup("#player2-numunits");
			Text player3Numunits = (Text) mainScene.lookup("#player3-numunits");
			Text player4Numunits = (Text) mainScene.lookup("#player4-numunits");
			Text player5Numunits = (Text) mainScene.lookup("#player5-numunits");
			Text player6Numunits = (Text) mainScene.lookup("#player6-numunits");
			Text player1Numterritories = (Text) mainScene.lookup("#player1-numterritories");
			Text player2Numterritories = (Text) mainScene.lookup("#player2-numterritories");
			Text player3Numterritories = (Text) mainScene.lookup("#player3-numterritories");
			Text player4Numterritories = (Text) mainScene.lookup("#player4-numterritories");
			Text player5Numterritories = (Text) mainScene.lookup("#player5-numterritories");
			Text player6Numterritories = (Text) mainScene.lookup("#player6-numterritories");
			//test for printing out some values
			System.out.println(player1Numunits.getText());
			System.out.println(player6Numterritories.getText());
			player1Numunits.setText("45");
			*/
			
			//change css class for units label
			Label wolfswoodUnits = (Label) mainScene.lookup("#wolfswoodUnits");
			System.out.println(wolfswoodUnits.getStyleClass());
			wolfswoodUnits.getStyleClass().add("territory-units-label-player1");
						
		}		
	}
}

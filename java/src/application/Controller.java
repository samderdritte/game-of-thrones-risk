package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
	
	double x, y;
	// Instance Variables for Buttons
	public Button startButton;
	public Button playerSelectButton;
	public Button playerNameButton;

	public Button button, button1, button2, button3;
	
	public TextField numPlayers;
	public TextField playerName;
	public Label playerNameNumber;
	static int numPlayersEntered;
	static ArrayList<String> playersList;
	public Label numPlayersValidationMessage;
	public Label namePlayersValidationMessage;
	
	public Node whichClicked;
	public Label mountainsofthemoon_units;
	public ImageView closeButton;
	
	static Text player1NameLabel, player2NameLabel, player3NameLabel, 
				player4NameLabel, player5NameLabel, player6NameLabel;
	
	@FXML
	public VBox playerStatsBox;
	
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
	
	//Button for Player Name Scene
		public void namePlayer(ActionEvent event) throws IOException {
			if(!playerName.getText().equals("")) {
				playersList.add(playerName.getText());
			}		
			
			if (playerName.getText().equals("")) {
				namePlayersValidationMessage.setText("Name cannot be empty");
			} else if (playersList.size() < numPlayersEntered) {
				System.out.println("Player " + playerNameNumber.getText() + ": " + playerName.getText());
				int playerNum = Integer.parseInt(playerNameNumber.getText());
				playerNum++;
				playerNameNumber.setText(Integer.toString(playerNum));
				playerName.setText("");
				playerName.requestFocus();
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
				
							
				System.out.println("---");
				
				// Set the names of the Players in the left box
				playerStatsBox = (VBox) mainScene.lookup("#playerStatsBox");
				for (int i=0;i<numPlayersEntered;i++) {
					Text currentLabel = (Text) playerStatsBox.getChildren().get(i*3);
					currentLabel.setText(playersList.get(i));
				}
				for (int i=playerStatsBox.getChildren().size()-2; i > numPlayersEntered*3-1; i--) {
					playerStatsBox.getChildren().remove(i);
				}
				
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
	
	
	public void printUnits(ActionEvent e) {
		Button btn = (Button) e.getSource();
		System.out.println(btn.getText());
		Label units = (Label) btn.getParent().getChildrenUnmodifiable().get(1);
		int numUnits = Integer.parseInt(units.getText());
		numUnits++;
		units.setText(Integer.toString(numUnits));
        }
	
	@FXML
	void dragged(MouseEvent event) {
		
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setX(event.getScreenX() - x);
		stage.setY(event.getScreenY() - y);
	}
	
	@FXML
	void pressed(MouseEvent event) {
		x = event.getSceneX();
		y = event.getSceneY();
	}
	
	@FXML
	private void min(MouseEvent event) {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setIconified(true);
	}
	
	@FXML
	private void max(MouseEvent event) {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.setFullScreenExitHint(" ");
		stage.setFullScreen(true);
	}
	
	@FXML
	private void close(MouseEvent event) {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
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

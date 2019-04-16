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
	
	
	

	public Button button, button1, button2, button3;
	
	

	static int numPlayersEntered;
	
	static ArrayList<String> playersList;


	
	public Node whichClicked;

	public ImageView closeButton;
	

	//public Label mountainsofthemoon_units;
	
	
	@FXML
	public VBox playerStatsBox;
	
	
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
	
}

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Image backgroundImage;
	Stage window;
	Scene startScene;
	Scene scene2;
	Scene mainScene;
		
	@Override public void init() {
		backgroundImage = new Image("file:Westeros_Map.jpg");
	}
	@Override
	public void start(Stage window) throws Exception {
		
		// Set start Scene
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,20));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label startMessage = new Label("Welcome to Game of Thrones - Risk");
		GridPane.setConstraints(startMessage, 0,0);
		
		Button startButton = new Button("Start Game");	
		GridPane.setConstraints(startButton, 0, 3);
		
		grid.setAlignment(Pos.CENTER);
		
		startButton.setOnAction(e -> window.setScene(scene2));
		
		// Layout for start scene
		grid.getChildren().addAll(startMessage, startButton);
		startScene = new Scene(grid, 400, 200);
		
		
		// Set second Scene
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10,10,10,20));
		grid2.setVgap(8);
		grid2.setHgap(10);
		
		Label numPlayers = new Label("Enter the number of players");
		GridPane.setConstraints(numPlayers, 0,0);
		
		TextField numPlayerInput = new TextField();
		GridPane.setConstraints(numPlayerInput, 0,2);
		
		Button numPlayersButton = new Button("Confirm");	
		GridPane.setConstraints(numPlayersButton, 0, 5);
		
		grid2.setAlignment(Pos.CENTER);
		
		grid2.getChildren().addAll(numPlayers, numPlayerInput, numPlayersButton);
		scene2 = new Scene(grid2, 400, 200);
		
		// handle click on start button
		// set mainScene
		numPlayersButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {	
				// construct the scene contents over a stacked background
				StackPane layout = new StackPane();
				layout.getChildren().setAll(new ImageView(backgroundImage), createKillButton());
				
				// wrap the scene contents in a pannable scroll pane
				ScrollPane scroll = createScrollPane(layout);
				
				//show the scene
				Scene mainScene = new Scene(scroll, 1200, 900);

				
				// bind the preferred size of the scroll area to the size of the scene
				scroll.prefWidthProperty().bind(mainScene.widthProperty());
				scroll.prefHeightProperty().bind(mainScene.widthProperty());
				
				// center the scroll contents.
			    scroll.setHvalue(scroll.getHmin() + (scroll.getHmax() - scroll.getHmin()) / 2);
			    scroll.setVvalue(scroll.getVmin() + (scroll.getVmax() - scroll.getVmin()) / 2);	
			    window.setScene(mainScene);
				window.centerOnScreen();
			}
		});
		
		// Set the scene
		startScene.getStylesheets().add("Stylesheet.css");
		scene2.getStylesheets().add("Stylesheet.css");
		window.setScene(startScene);
		window.setTitle("Game of Thrones - Risk");
		window.show();
	}
	
	/** @return a control to place on the scene. */
	  private Button createKillButton() {
	    final Button killButton = new Button("Skagos");
	    killButton.setStyle("-fx-base: firebrick;");
	    killButton.setTranslateX(250);
	    killButton.setTranslateY(-650);
	    killButton.setOnAction(new EventHandler<ActionEvent>() {
	      @Override public void handle(ActionEvent t) {
	        killButton.setStyle("-fx-base: forestgreen;");
	        killButton.setText("Conquered");
	        if(t.getSource() == killButton) {
				System.out.println("Button clicked.");
			}
	      }
	    });
	    return killButton;
	  }
	  
	  /** @return a ScrollPane which scrolls the layout. */
	  private ScrollPane createScrollPane(Pane layout) {
	    ScrollPane scroll = new ScrollPane();
	    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    scroll.setPannable(true);
	    scroll.setPrefSize(1200, 900);
	    scroll.setContent(layout);
	    return scroll;
	  }
	  
	public static void main(String[] args) {
		launch(args);
	}
}

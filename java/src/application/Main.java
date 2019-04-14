package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	
	@Override
	public void start(Stage window) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
			Scene scene = new Scene(root,400,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setTitle("Game of Thrones - Risk");
			
			window.setScene(scene);
			window.initStyle(StageStyle.TRANSPARENT);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}



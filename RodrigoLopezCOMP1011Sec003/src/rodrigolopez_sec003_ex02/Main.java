package rodrigolopez_sec003_ex02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
            // Load the FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("exercise02.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 710, 510);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Exercise 02 Regex");
	        primaryStage.show();
	        
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	}

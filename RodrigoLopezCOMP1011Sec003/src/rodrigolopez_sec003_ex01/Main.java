package rodrigolopez_sec003_ex01;
	
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("exercise01.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 670, 330);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Exercise 01 - Multi Threads");
	        primaryStage.show();
	        
	        
        } catch(Exception e) {
            e.printStackTrace();
        }
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

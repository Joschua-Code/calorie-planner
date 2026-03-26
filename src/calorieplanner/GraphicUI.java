package calorieplanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;


public class GraphicUI extends Application{

	@Override
	public void start(Stage stage) {
		TextField insert = new TextField();
		insert.setPromptText("Hallo, wie heißt du?");
		
		Button button = new Button("Enter");
		
		VBox root = new VBox(10, button, insert);
		root.setPadding(new Insets(30));
		
		Scene scene = new Scene(root, 700, 700);
		stage.setTitle("Kalorienplaner");
		stage.setScene(scene);
		stage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}
		
		
		
	

}

package calorieplanner;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;


public class GraphicUI extends Application{

	@Override
	public void start(Stage stage) {
		TextField insertName = new TextField();
		insertName.setPromptText("Hallo, wie heißt du?");
		
		Button enterName = new Button("Enter");
		
		Label outputName = new Label();
		
		Label placeHolder = new Label();
		
		enterName.setOnAction(e -> {
			String text1 = insertName.getText();
			outputName.setText("Hallo " + text1 + ".");
			insertName.clear();
		}); 
		
		insertName.setOnAction(e -> enterName.fire());
		
		HBox rootName = new HBox(1, insertName, enterName);
		rootName.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(10,outputName, rootName, placeHolder);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 300, 200);
		stage.setTitle("Kalorienplaner");
		stage.setScene(scene);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
		
		stage.show();

		
		Platform.runLater(() -> root.requestFocus());
	}
		
	public static void main(String[] args) {
		launch(args);
	}
		
		

	

}

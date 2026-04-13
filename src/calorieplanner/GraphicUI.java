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
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;

import javafx.geometry.Insets;
import javafx.geometry.Pos;



public class GraphicUI extends Application{

private int inputCounter = 0;
private String name;
private int weightcurrent;
private int weightgoal;
private int days;
private int calorieExpenditure;
private int dailyCal;
	
	@Override
	public void start(Stage stage) {
		TextField insertInformation = new TextField();
		insertInformation.setPromptText("Hallo, wie heißt du?");
		
		Button enterName = new Button("Enter");
		
		Label outputName = new Label();
		
		Label placeHolder = new Label();
		Label placeHolder2= new Label();
		
		Hyperlink calorieCalculationLink = new Hyperlink("");
		calorieCalculationLink.setOnAction(_ -> {
			getHostServices().showDocument("https://www.tk.de/service/app/2004134/kalorienrechner/kalorienrechner.app");	
		});
		

		HBox rootName = new HBox(1, insertInformation, enterName);
		rootName.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(10,placeHolder2, outputName, rootName, placeHolder,calorieCalculationLink);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 333, 200);
		stage.setTitle("Kalorienplaner");
		stage.setScene(scene);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
		
		enterName.setOnAction(_ -> {
			if (inputCounter == 0) {
				
				name = insertInformation.getText();
				
				outputName.setText("Was ist dein aktuelles Gewicht?");
				
				insertInformation.clear();
				insertInformation.setPromptText("");
				inputCounter ++;
			}
			
			else if (inputCounter == 1) {

				weightcurrent = Integer.parseInt(insertInformation.getText());

				outputName.setText("Was ist dein Wunschgewicht?");

				insertInformation.clear();
				inputCounter ++;
			}

			else if (inputCounter == 2) {

				weightgoal = Integer.parseInt(insertInformation.getText());

				outputName.setText("In wie viel Tagen willst du dieses erreicht haben?");

				insertInformation.clear();
				inputCounter ++;
			}
			
			else if (inputCounter == 3) {

				days = Integer.parseInt(insertInformation.getText());
				
				

				outputName.setText("Was ist dein täglicher Kalorienverbrauch?");
				calorieCalculationLink.setText("Berechne ihn hier!");

				insertInformation.clear();
				inputCounter ++;
			}
			
			else if (inputCounter == 4) {

				calorieExpenditure = Integer.parseInt(insertInformation.getText());
				
				
				dailyCal = calorieExpenditure - ((weightcurrent - weightgoal) * 7000 / days);
				calorieCalculationLink.setText("");
				outputName.setText(name + " dein Ziel sind " + dailyCal + " Kalorien am Tag.");
				
				rootName.getChildren().clear();
				root.getChildren().remove(calorieCalculationLink);
				root.getChildren().remove(placeHolder2);
				insertInformation.clear();
				inputCounter ++;
			}
		}); 
		

		
		insertInformation.setOnAction(_ -> enterName.fire());
		

		
		stage.show();

		
		Platform.runLater(() -> root.requestFocus());
	}
	
	

	
	
	
	
	
	
		
	public static void main(String[] args) {
		launch(args);
	}
		
		

	

}

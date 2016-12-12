package authoring.editorview.gamesettings.subviews.editorfields;

import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameOrderLevels {
	
	private GridPane root;
	
	public GameOrderLevels(){
		Stage stage = new Stage();
		stage.setTitle("Order levels");
		root = new GridPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		addLevelsToList();
		makeSetButton();
		
		stage.show();
		
	}
	
	private void makeSetButton(){
		Button setButton = ButtonFactory.makeButton("Set Order", null);
		root.getChildren().add(setButton);
	}
	
	private void addLevelsToList(){
		
	}

}

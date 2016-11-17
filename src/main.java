import gameplayer.controller.HomeSelection;
import gameplayer.view.GameGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

	public static final String TITLE = "VOOGASquad";
	private Stage stage;
	

	
	public Stage getStage(){
		return stage;
	}

	@Override
	public void start(Stage s){
		this.stage = s;
		//file chooser for xml
		HomeSelection select = new HomeSelection(s);
		select.initHomeScreen();
		/*
		//This is just for testing, should be switched to creating the authoring environment first
		Stage ns = new Stage();
		GameGUI game = new GameGUI(); 
		Scene scene = game.init();
		ns.setTitle(TITLE);
		ns.setScene(scene);
		ns.show();
		*/

	}

	public static void main(String[] args) {
		launch(args);
	}

}

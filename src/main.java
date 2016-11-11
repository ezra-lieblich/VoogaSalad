import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GameGUI;

public class main extends Application {

	public static final String TITLE = "VOOGASquad";
	private Stage stage;

	
	public Stage getStage(){
		return stage;
	}

	@Override
	public void start(Stage s){
		this.stage = s;
		GameGUI game = new GameGUI();
		Scene scene = game.init();
		s.setScene(scene);
		s.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

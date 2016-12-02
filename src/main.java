import gameplayer.controller.HomeSelection;
import gameplayer.view.GameGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import splashscreen.SplashScreen;

public class main extends Application {

	public static final String TITLE = "VOOGASquad";
	private Stage stage;
	

	
	public Stage getStage(){
		return stage;
	}

	@Override
	public void start(Stage s){
		this.stage = s;
		SplashScreen splash = new SplashScreen(s);
		splash.init();
		this.stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

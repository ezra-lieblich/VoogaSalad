package splashscreen;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SplashScreen {
	
	private Stage stage;
	private Scene scene;
	
	public SplashScreen(Stage s){
		this.stage = s; 
		
	}
	
	public void init(){
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("http://people.duke.edu/~lz107/voogaTemplates/splashscreen.html");
		this.scene = new Scene(browser);
		this.stage.setScene(this.scene);
	}
	
}

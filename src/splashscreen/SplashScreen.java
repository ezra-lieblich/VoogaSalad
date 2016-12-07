package splashscreen;

import java.io.IOException;

import authoring.main.AuthoringController;
import gameplayer.controller.GamePlayerController;
import gameplayer.controller.HomeSelection;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import statswrapper.Wrapper;

public class SplashScreen {
	private GraphicsLibrary graphics = new GraphicsLibrary();
	public static final String TITLE = "VOOGASquad";
	private static final int SIZE = 700;
	private Stage stage;
	private Scene scene;
	private GridPane mainScreen;

	public SplashScreen(Stage s) {
		this.stage = s;
		this.mainScreen = new GridPane();

	}

	public void init() {
		/*
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("http://voogasquad.herokuapp.com/");
		*/
		this.mainScreen.setMinWidth(SIZE);
		this.mainScreen.setMinHeight(SIZE);
		this.scene = new Scene(this.mainScreen);
		this.stage.setScene(this.scene);
		addSignInOption();
	}

	private void addSignInOption() {
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		mainScreen.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		mainScreen.add(userName, 0, 1);

		TextField userTextField = new TextField();
		mainScreen.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		mainScreen.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		mainScreen.add(pwBox, 1, 2);

		//System.out.println("textfield input: "+userTextField.getText()+","+ pwBox.getText());
		addLoginButtons(userTextField, pwBox);
		addCreateAccountButtons(userTextField, pwBox);
	}

	private void addLoginButtons(TextField userfield, TextField passField) {
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		mainScreen.add(hbBtn, 1, 4);
		final Text actiontarget = new Text();
		mainScreen.add(actiontarget, 1, 6);

		btn.setOnAction(e -> {
			actiontarget.setText("Sign in button pressed");
			try {
				Wrapper.getInstance().login(userfield.getText(), passField.getText());
				
				//testing
				//Wrapper.getInstance().updateGameScores("gold", "0", "777");
				createPlayGameOrMakeGameOptions();
				
				//TESTING
				//Wrapper.getInstance().recordGameScores("50", "3", "0");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				createPlayGameOrMakeGameOptions();
				e1.printStackTrace();
			}
		});
	}
	
	private void createPlayGameOrMakeGameOptions(){
		Button btn1 = graphics.createButton("Make a game", e ->{
			startAuthoringEnv();
		});
		Button btn2 = graphics.createButton("Play a game", e -> {
			startGame();
		});
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().addAll(btn1, btn2);
		mainScreen.add(hbBtn, 1, 5);
	}

	private void addCreateAccountButtons(TextField userfield, TextField passField) {
		Button btn = new Button("Create account");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		mainScreen.add(hbBtn, 2, 4);
		final Text actiontarget = new Text();
		mainScreen.add(actiontarget, 2, 6);

		btn.setOnAction(e -> {
			actiontarget.setText("Now login");
			try {
				Wrapper.getInstance().createAccount(userfield.getText(), passField.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	private void startAuthoringEnv() {
		Stage s = new Stage();
		AuthoringController generalController = new AuthoringController(SIZE);

		Scene scene = generalController.getScene();
		s.setTitle(TITLE);
		s.setScene(scene);
		s.setResizable(true);
		s.setHeight(SIZE);
		s.setWidth(SIZE + 145);
		s.show();

	}
	
	private void startGame(){
		Stage s = new Stage();
		
		HomeSelection file = new HomeSelection(s);
		file.initHomeScreen();
		
		/*
		GamePlayerController playerController = new GamePlayerController();
		playerController.init();
		s.setTitle(TITLE);
		s.setScene(playerController.getMainScene());
		s.show();
		*/
	}

}

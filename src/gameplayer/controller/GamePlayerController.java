package gameplayer.controller;

import gameplayer.loader.GamePlayerFactory;
import gameplayer.loader.XMLParser;
import gameplayer.model.GamePlayModel;
import gameplayer.view.GameGUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Observable;
import java.util.Observer;

public class GamePlayerController implements Observer{

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	private GamePlayerFactory loader; 
	private GameGUI view;
	private XMLParser parser;
	
	public GamePlayerController(){
		//use xml parser to create classes. 
		initGUI();
		parser = new XMLParser("player.samplexml/test.xml"); //hardcoded
		loader = new GamePlayerFactory(parser); 
		//System.out.println(authoringFileReader.getVariableValues("height"));
	}
	
	private void initGUI() {
		/*
		int rows = parser.getRows();
		int cols = parser.getCols();
		view = new GameGUI(rows, cols);
		*/
		view = new GameGUI(5,5); //just for testing, should be replaced by block above, 5 rows, 5 columns
	}
	
	public GameGUI getView() {
		return view;
	}

	@Override
	public void update(Observable o, Object arg) {
		GamePlayModel model = (GamePlayModel) o;
		if (model.getLife() == 0) {
			updateLevel();
		}
		
	}
	
	private void updateLevel() {
		//TODO: use Parser's method to get path and update the view's grid with that path
	}
	
	
	
	/*
	private void setUpTimeLine() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> GamePlayModel.update(SECOND_DELAY));
		Timeline animation = new Timeline();
		application.setTimeline(animation);
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	*/
	
	

}

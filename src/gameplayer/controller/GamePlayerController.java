package gameplayer.controller;

import gameplayer.loader.XMLParser;
import gameplayer.view.GameGUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePlayerController {

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private GameGUI view;
	
	public GamePlayerController(GameGUI gui){
		//use xml parser to create classes. 
		view = gui; 
		XMLParser authoringFileReader = new XMLParser("../../player.samplexml/test.xml");
	
	}
	
	
	//needs to be hooked to backend
	private void setUpTimeLine() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> BACKEND?????.update(SECOND_DELAY));
		Timeline animation = new Timeline();
		application.setTimeline(animation);
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	

}

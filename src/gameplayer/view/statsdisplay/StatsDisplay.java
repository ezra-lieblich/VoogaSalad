package gameplayer.view.statsdisplay;

import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Framework for heads up/stats display. Information should be updated
 * automatically, displayed in a variety of formats, and automatically
 * positioned within a HUD that is separate from the game screen
 * 
 * @author lucyzhang
 *
 */
public class StatsDisplay {
	
	private HBox scorePane;
	private GraphicsLibrary graphics;
	private Group goldScore;
	private Group liveScore;
	private Group levelScore;
	private double initGold;
	private double initLives;
	private double initLevel;
	
	
	public StatsDisplay(double gold, double lives, double level){
		this.scorePane = new HBox();
		this.graphics = new GraphicsLibrary();
		/*
		this.goldScore = new Text();
		this.liveScore = new Text();
		this.levelScore = new Text();
		*/
		this.initGold = gold;
		this.initLives = lives;
		this.initLevel = level;
	}
	
	
	public HBox getScorePane(){
		return this.scorePane;
	}
	
	public void init(){
		System.out.println("Gold: "+initGold);
		System.out.println("Lives: "+initLives);
		System.out.println("Level: "+initLevel);
		createTextScore("Amount of gold: ", Double.toString(this.initGold), this.goldScore);
		createTextScore("Lives left: ", Double.toString(this.initLives), this.liveScore);
		createTextScore("Level: ", Double.toString(this.initLevel), this.levelScore);	
	}
	
	private void createTextScore(String title, String score, Group scoreType){
		Group root = new Group();
		this.scorePane.getChildren().add(root);
		//Label label = new Label(title);
		//this.scorePane.getChildren().add(label);
		Text label = graphics.createText(root, title);
		label.getStyleClass().add("scoreLabel");
		scoreType = new Group();
		this.scorePane.getChildren().add(scoreType);
		graphics.createText(scoreType,score).getStyleClass().add("scoreLabel");	
	}
	
	private void updateScore(double score, Group root){
		root.getChildren().clear();
		Text label = graphics.createText(root, Double.toString(score));	
		label.getStyleClass().add("scoreLabel");
	}
	
	public void updateGold(double gold){
		updateScore(gold, this.goldScore);
	}
	
	public void updateLives(double lives){
		updateScore(lives, this.liveScore);
	}
	
	public void updateLevel(double level){
		updateScore(level, this.levelScore);
	}

}

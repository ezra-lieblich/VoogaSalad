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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import engine.TowerType;

public class GamePlayerController implements Observer{

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	private GamePlayerFactory loader; 
	private GameGUI view;
	private XMLParser parser;
	private Scene mainScene;
	private GamePlayModel model;
	
	private Timeline animation;
	
	public GamePlayerController(){
		//use xml parser to create classes. 
		this.parser = new XMLParser("player.samplexml/test.xml"); //hardcoded
		this.loader = new GamePlayerFactory(parser);
		this.model = new GamePlayModel(this.loader);
		this.model.addObserver(this);
	}
	
	public void init(){
		this.model.initializeLevelInfo();
		HashMap<String,Double> settings = this.loader.getGameSetting();
		System.out.println("Settings: "+ settings);
		initGUI();
		createTimeline();
	}
	
	private void initGUI() {
		int[] dimensions = model.getDimension();
		int rows = dimensions[0];
		int cols = dimensions[1];
		this.view = new GameGUI(rows,cols); //just for testing, should be replaced by block above, 5 rows, 5 columns
		this.mainScene = view.init(this.model.getGold(), this.model.getLife(), this.model.getCurrentLevel(),getTowerImages());
		this.view.getGrid().populatePath(model.getGrid().getStartPoint()); //TODO: need to get grid from model to get starting cell
	}
	
	private ArrayList<String> getTowerImages(){
		ArrayList<String> towerImages= new ArrayList<String>();
		HashMap<Integer, TowerType> towers = this.loader.getTowers();
		for (TowerType tower: towers.values()){
			towerImages.add(tower.getImageLocation());
		}
		return towerImages;
	}
	public Scene getMainScene(){
		return this.mainScene;
	}
	
	public GameGUI getView() {
		return view;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof GamePlayModel){
			//update level in display
			this.view.updateStatsDisplay(((GamePlayModel) o).getGold(), ((GamePlayModel) o).getLife(), ((GamePlayModel) o).getCurrentLevel());
			this.view.updateCurrentLevelStats(((GamePlayModel) o).getCurrentLevel());
		}
		/*
		GamePlayModel model = (GamePlayModel) o;
		if (model.getLife() == 0) {
			updateLevel();
		}
		*/
		
	}

	/*
	private void updateLevel() {
		//TODO: use Parser's method to get path and update the view's grid with that path
	}
	*/
	

	private void createTimeline() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
			this.model.updateInLevel();
		});
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		//animation.play();
		this.animation = animation;
	}
	
	public Timeline getTimeline(){
		return this.animation;
	}

	

}

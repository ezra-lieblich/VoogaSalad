package gameplayer.controller;

import gameplayer.loader.GamePlayerFactory;
import gameplayer.loader.XMLParser;
import gameplayer.main.main;
import gameplayer.model.Enemy;
import gameplayer.model.EnemyManager;
import gameplayer.model.GamePlayModel;
import gameplayer.view.GameGUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import engine.TowerType;

public class GamePlayerController implements Observer {

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 50;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	private GamePlayerFactory loader;
	private GameGUI view;
	private Scene mainScene;
	private GamePlayModel model;

	private Timeline animation;
	private EnemyController enemyController;
	private DragDropController dropController;
	
	private EnemyManager enemyManager;

	private double oldLevel;


	private Queue<Enemy> currentWave;

	public GamePlayerController() {
		// use xml parser to create classes.
		this.loader = new GamePlayerFactory(new XMLParser("player.samplexml/test.xml"));// hardcoded

		checkIfValid();
		this.model = new GamePlayModel(this.loader);
		this.enemyManager = new EnemyManager(this.model);
		this.model.addObserver(this);
		this.oldLevel = 0;
	}

	/**
	 * Checks to see if XML is valid If not, it will not create a game and it
	 * will throw an error
	 */
	public void checkIfValid() {
		if (!loader.xmlIsValid()) {
			System.out.println("XML is invalid, game cannot be created");
			// TODO: actually throw an error
		}
	}

	public void init() {
		this.model.initializeLevelInfo();
		HashMap<String, Double> settings = this.loader.getGameSetting();
		System.out.println("Settings: " + settings);
		initGUI();
		this.enemyController = new EnemyController(this.enemyManager, this.view.getGrid());
	}

	private void initGUI() {
		int[] dimensions = model.getDimension();
		int rows = dimensions[0];
		int cols = dimensions[1];
		this.view = new GameGUI(rows, cols); // just for testing, should be
												// replaced by block above, 5
												// rows, 5 columns
		this.view.bindAnimationStart(e -> {
			// TODO: initialize animation
			this.startAnimation();
		});
		System.out.println("Tower images: " + getTowerImages());
		this.mainScene = view.init(this.model.getGold(), this.model.getLife(), this.model.getCurrentLevel(),
				getTowerImages());
		this.view.getGrid().populatePath(model.getGrid().getStartPoint()); 
		this.dropController = new DragDropController(this.view, this.model);
	}
	
	private ArrayList<String> getTowerImages() {
		ArrayList<String> towerImages = new ArrayList<String>();
		HashMap<Integer, TowerType> towers = this.loader.getTowers();
		for (TowerType tower : towers.values()) {
			towerImages.add(tower.getImageLocation());
		}
		return towerImages;
	}

	public Scene getMainScene() {
		return this.mainScene;
	}

	public GameGUI getView() {
		return view;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof GamePlayModel) {
			double newLevel = ((GamePlayModel) o).getCurrentLevel();
			// update level in display
			this.view.updateStatsDisplay(((GamePlayModel) o).getGold(), ((GamePlayModel) o).getLife(),
					((GamePlayModel) o).getCurrentLevel());
			this.view.updateCurrentLevelStats(((GamePlayModel) o).getCurrentLevel());
			if (this.oldLevel != newLevel){
				//test level
				this.oldLevel = newLevel;
				this.view.newLevelPopUp(e->{
					System.out.println("New level");
					this.view.getGrid().getGrid().getChildren().clear();
					//do something to trigger new level here!
				});
			}
		}
		/*
		 * GamePlayModel model = (GamePlayModel) o; if (model.getLife() == 0) {
		 * updateLevel(); }
		 */

	}

	/*
	 * private void updateLevel() { //TODO: use Parser's method to get path and
	 * update the view's grid with that path }
	 */

	private void startAnimation() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
			((Pane) this.view.getGrid().getGrid()).getChildren().clear(); //clear everything
			this.currentWave = this.model.getPackOfEnemyComing();
			
			if(currentWave.size()!=0){
				Enemy test = currentWave.poll();
				test.setCurrentCell(this.model.getGrid().getCell(0, 0));
				this.enemyManager.spawnEnemy(test);
			}
			this.enemyManager.update(); 

//			this.view.getGrid().populatePath(model.getGrid().getStartPoint()); //THIS LINE CAUSES SLOW DOWN
			List<Enemy>enemyRedraw = enemyManager.getEnemyOnGrid(); 
			
			this.view.reRender(enemyManager.getEnemyOnGrid());
		});
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		this.animation = animation;
		animation.play();
	}

	public Timeline getTimeline() {
		return this.animation;
	}


}

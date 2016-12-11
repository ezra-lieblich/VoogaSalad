package gameplayer.controller;

import gameplayer.loader.GamePlayerFactory;
import gameplayer.loader.XMLParser;
import gameplayer.main.main;
import gameplayer.model.Cell;
import gameplayer.model.GamePlayData;
import gameplayer.model.GamePlayModel;
import gameplayer.model.IDrawable;
import gameplayer.model.enemy.Enemy;
import gameplayer.model.enemy.EnemyManager;
import gameplayer.model.tower.Tower;
import gameplayer.model.weapon.Weapon;
import gameplayer.view.GameGUI;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.GraphicsLibrary;
import gameplayer.view.helper.dragdrop.DragDropView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import statswrapper.Wrapper;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;


public class GamePlayerController implements Observer {

	public static final int Y_OFFSET = 54;
	public static final int ENTITY_SIZE = 70;
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 50;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

	private GamePlayerFactory loader;
	private GameGUI view;
	private Scene mainScene;
	private GamePlayModel model;

	private Timeline animation;
	private EnemyController enemyController;
	private TowerController towerController;
	private WeaponController weaponController;
	private CollisionController collisionController;

	private DragDropController dropController;

	private EnemyManager enemyManager;

	private double oldLevel;
	private int timer = 1;

	private GraphicsLibrary graphics;

	private Queue<Enemy> currentWave;

	private HashMap<String, Integer> towerToId;

	
	private double enemyFrequency;
	
	
	private double startTime = System.currentTimeMillis();
	private double elapsedTime = 0;
	
	private KeyFrame enemyKeyFrame;
	

	// Might need to be refactored into a different class
	private HashMap<Integer, ImageView> weaponsOnScreen;

	public GamePlayerController(String xmlFilePath) {
		// use xml parser to create classes.
		this.loader = new GamePlayerFactory(new XMLParser("player.samplexml/newWaveTester.xml"));// hardcoded
		// does not work because of the image path
		checkIfValid();
		this.model = new GamePlayModel(this.loader);
		this.enemyController = new EnemyController(this.model.getEnemyManager(), null);
		this.weaponController = new WeaponController(this.model.getWeaponManager());
		this.collisionController = new CollisionController(this.model.getCollisionManager());
		this.model.getData().addObserver(this);
		this.oldLevel = 0;
		this.towerToId = new HashMap<String, Integer>();
		this.weaponsOnScreen = new HashMap<Integer, ImageView>();
		this.animation = new Timeline();
		this.graphics = new GraphicsLibrary();
		this.enemyManager = this.enemyController.getEnemyModel();
	}

	private void populateTowerToId() {
		HashMap<Integer, engine.tower.Tower> mapping = this.model.getTowerManager().getAvailableTower();
		for (int key : mapping.keySet()) {
			this.towerToId.put(mapping.get(key).getImagePath(), key);
		}
	}

	public HashMap<String, Integer> getTowerImageMap() {
		return this.towerToId;
	}

	/**
	 * Checks to see if XML is valid If not, it will not create a game and it
	 * will throw an error
	 */
	public void checkIfValid() {
		if (!loader.xmlIsValid()) {
			//// System.out.println("XML is invalid, game cannot be created");
			// TODO: actually throw an error
		}
	}

	public void init() {
		HashMap<String, Double> settings = this.loader.getGameSetting();
		this.enemyManager.setCurrentCell(this.model.getData().getGrid().getStartPoint());
		populateTowerToId();
		initGUI();

		try {
			Wrapper.getInstance().recordGameScores("" + this.model.getData().getGold(),
					"" + this.model.getData().getLife(), "" + this.model.getData().getCurrentLevel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.towerController = new TowerController(this.model.getTowerManager(), this.view);

	}

	private void initGUI() {
		int rows = model.getData().getRow();
		int cols = model.getData().getColumns();
		this.view = new GameGUI(rows, cols); // just for testing, should be
		// replaced by block above, 5
		// rows, 5 columns
		this.view.bindAnimationStart(e -> {
			this.startAnimation();
		});

		this.view.bindAnimationStop(e -> {
			this.animation.pause();
		});
		this.mainScene = view.init(this.model.getData().getGold(), this.model.getData().getLife(),
				this.model.getData().getCurrentLevel(), this.model.getData().getScore(), getTowerImages());
		this.view.getGrid().getGrid().setOnMouseClicked(e -> handleMouseClicked(e.getX(), e.getY()));

		this.view.getGrid().populatePath(model.getData().getGrid().getStartPoint());
		this.dropController = new DragDropController(this.view, this.model, this.getTowerImageMap());

	}

	private void handleMouseClicked(double x, double y) {
		Map<Integer, Tower> towersOnGrid = this.model.getTowerOnGrid();
		for (int i : towersOnGrid.keySet()) {
			Tower t = towersOnGrid.get(i);
			double newX = this.view.gridToPixelCoordWidth(t.getX());
			double newY = this.view.gridToPixelCoordHeight(t.getY());
			if ((newX <= x && newX + ENTITY_SIZE >= x && newY <= y && newY + ENTITY_SIZE >= y)) {
				t.toggleInfoVisibility();
				addButtons(t);
			}
		}

		HashMap<Integer, Enemy> enemiesOnGrid = this.enemyManager.getEnemyOnGrid();
		for (int i : enemiesOnGrid.keySet()) {
			Enemy e = enemiesOnGrid.get(i);
			if (e.getX() <= x && e.getX() + ENTITY_SIZE >= x && e.getY() <= y && e.getY() + ENTITY_SIZE >= y) {
				e.toggleInfoVisibility();
			}
		}

	}

	public void addButtons(Tower t) {
		t.getSellButton().setOnAction(e -> this.towerController.handleSellTowerClick());
		t.getUpgradeButton().setOnAction(e -> this.towerController.upgrade(t.getUniqueID()));
	}

	//probably should move to frontend
	private ArrayList<String> getTowerImages() {
		ArrayList<String> towerImages = new ArrayList<String>();
		HashMap<Integer, engine.tower.Tower> towers = this.loader.getTowers(); 
		for (engine.tower.Tower tower : towers.values()) { 
			towerImages.add(tower.getImagePath());
		}
		return towerImages;
	}

	public Scene getMainScene() {
		return this.mainScene;
	}

	public GameGUI getView() {
		return view;
	}

	private void gameOver() {
		this.view.getMainScreen().getChildren().clear();
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("http://people.duke.edu/~lz107/voogaTemplates/gameover.html");
		this.view.getMainScreen().setCenter(browser);

	}

	private void checkCreateNewLevel() {
		// new level condition
		double newLevel = this.model.getData().getCurrentLevel();
		if (this.oldLevel != newLevel) {

			this.oldLevel = newLevel;
			this.view.newLevelPopUp(e -> {
				//// System.out.println("New level");
				this.view.getGrid().getGrid().getChildren().clear();
				// do something to trigger new level here!
				this.model.initializeLevelInfo();
			});

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof GamePlayData) {
			// update level in display
			this.view.updateStatsDisplay(((GamePlayData) o).getGold(), ((GamePlayData) o).getLife(),
					((GamePlayData) o).getCurrentLevel(),((GamePlayData)o).getScore());
			this.view.updateCurrentLevelStats(((GamePlayData) o).getCurrentLevel());


			// check for game over condition
			if (((GamePlayData) o).getLife() < 0) {
				gameOver();
			}


			checkCreateNewLevel();
			
		}
	

	}



	/*
	 * private void updateLevel() { //TODO: use Parser's method to get path and
	 * update the view's grid with that path }
	 */

	private void startAnimation() {
		this.model.getData().getGrid().printGrid();

		// call this once per wave, gets the new wave, new enemy frequency, etc.
		getNewWaveOnInterval();

		KeyFrame frame = new KeyFrame(Duration.millis(/*this.enemyFrequency*/ MILLISECOND_DELAY), e -> {
			((Pane) this.view.getGrid().getGrid()).getChildren().clear(); 
			this.weaponsOnScreen = new HashMap<>(); 

			// trying to get this to work but null pointer
			if (currentWave.size() != 0) {
				if (timer % 15 == 0) {
					Enemy enemy = currentWave.poll();
					this.enemyManager.spawnEnemy(enemy);
					timer = 1;
				} else {
					timer++;
				}
			}
			this.model.updateInLevel();
			this.enemyManager.update();

			redrawEverything();
		});

		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().addAll(frame, this.enemyKeyFrame);
		animation.play();
	}
	
	private void createEnemyKeyFrame(){
		this.enemyKeyFrame = new KeyFrame(Duration.millis(this.enemyFrequency), e -> {
			redrawEnemy();
		});
	}
	


	private void getNewWaveOnInterval() {
		double nextWaveStartTime = this.enemyController.getEnemyModel().getTimeOfNextWave(); //uncomment later
		System.out.println("Time of next wave: "+nextWaveStartTime);
		//double nextWaveStartTime = 0; //comment out later
		while (elapsedTime < nextWaveStartTime) {
			elapsedTime = (new Date()).getTime() - startTime;
		}

		if (elapsedTime >= nextWaveStartTime) {
			// get new wave, enemy frequency, and
			this.enemyFrequency =this.enemyController.getEnemyModel().getFrequencyOfNextWave();
			this.currentWave = this.enemyController.getEnemyModel().getPackOfEnemyComing();
			createEnemyKeyFrame(); //with the enemy frequency
			// get the new start time for a new wave of enemies
			getNewWaveOnInterval();

		}

	}


	private void redrawEverything() {
		// redraw path
		// this.view.getGrid().populatePath(this.model.getGrid().getStartPoint());
		this.view.getGrid().getGrid().getChildren().addAll(this.view.getGrid().getPathImages());

		//HashMap<Integer, Enemy> enemyRedraw = this.enemyManager.getEnemyOnGrid();
		Map<Integer, Tower> towerRedraw = this.model.getTowerOnGrid();
		HashMap<Integer, Weapon> bulletRedraw = this.model.getWeaponManager().getWeaponOnGrid();

		for (int i : bulletRedraw.keySet()) {

			if (!weaponsOnScreen.containsKey(bulletRedraw.get(i).getUniqueID())) {
				ImageView image = new ImageView(bulletRedraw.get(i).getImage());
				image.setCache(true);
				image.setCacheHint(CacheHint.SPEED);
				image.setX(bulletRedraw.get(i).getX());
				image.setY(bulletRedraw.get(i).getY());
				graphics.setImageViewParams(image, DragDropView.DEFENSIVEWIDTH * 0.5,
						DragDropView.DEFENSIVEHEIGHT * 0.5);
				weaponsOnScreen.put(bulletRedraw.get(i).getUniqueID(), image);
			} else {
				weaponsOnScreen.get(bulletRedraw.get(i).getUniqueID()).setX(bulletRedraw.get(i).getX());
				weaponsOnScreen.get(bulletRedraw.get(i).getUniqueID()).setY(bulletRedraw.get(i).getY());
			}

		}

		//List<IDrawable> reEnemyDraw = convertEnemyDrawable(enemyRedraw);
		List<IDrawable> reTowerDraw = convertTowerDrawable(towerRedraw);

		//this.view.reRender(reEnemyDraw);
		this.view.reRenderWeapon(weaponsOnScreen);
		this.view.reRenderTower(reTowerDraw);
	}

	private void redrawEnemy() {
		HashMap<Integer, Enemy> enemyRedraw = this.enemyManager.getEnemyOnGrid();
		List<IDrawable> reEnemyDraw = convertEnemyDrawable(enemyRedraw);
		this.view.reRender(reEnemyDraw);
		
	}

	public Timeline getTimeline() {
		return this.animation;
	}

	private List<IDrawable> convertEnemyDrawable(HashMap<Integer, Enemy> enemies) {
		ArrayList<IDrawable> ret = new ArrayList<>();
		for (int e : enemies.keySet()) {
			ret.add(enemies.get(e));
		}
		return ret;
	}

	private List<IDrawable> convertTowerDrawable(Map<Integer, Tower> towers) {
		ArrayList<IDrawable> ret = new ArrayList<>();
		for (int i : towers.keySet()) {
			ret.add(towers.get(i));
		}
		return ret;
	}

}
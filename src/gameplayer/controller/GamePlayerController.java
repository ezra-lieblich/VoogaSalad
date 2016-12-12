package gameplayer.controller;

import gameplayer.loader.GamePlayerFactory;
import gameplayer.loader.GameSavingController;
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
import javafx.scene.image.Image;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
	private GameSavingController gameSavingController;

	private DragDropController dropController;

	private EnemyManager enemyManager;

	private double oldLevel;
	private int timer = 1;

	private GraphicsLibrary graphics;

	private Queue<Enemy> currentWave;

	private HashMap<String, Integer> towerToId;

	private double enemyFrequency;

	private double startTime;
	private double intervalBetweenWaves;

	private KeyFrame enemyKeyFrame;

	private Thread timeCounterThread;

	// Might need to be refactored into a different class
	private HashMap<Integer, ImageView> weaponsOnScreen;
	private HashMap<Integer, ImageView> enemiesOnScreen;

	private HashMap<String, Image> imageBank;

	public GamePlayerController(String xmlFilePath) {
		// use xml parser to create classes.
		this.loader = new GamePlayerFactory(new XMLParser("player.samplexml/WinEffect_FreePath_PitcforksTest.xml"));// hardcoded
		// does not work because of the image path
		checkIfValid();
		this.currentWave = new LinkedList<>(); 
		this.enemiesOnScreen = new HashMap<Integer, ImageView>();
		this.weaponsOnScreen = new HashMap<Integer, ImageView>();
		this.model = new GamePlayModel(this.loader, enemiesOnScreen);
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
		this.imageBank = new HashMap<String, Image>();
		createImageBank();
		this.gameSavingController = new GameSavingController(this.model);
		// this.gameSavingController.saveGame();
	}

	// TODO: create another constructor that takes in a ManagerMediator and
	// LevelNumber
	// it should use the XMLParser(ManagerMediator) constructor to create an
	// XMLParser (aka this.loader)


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
			//// //System.out.println("XML is invalid, game cannot be created");
			// TODO: actually throw an error
		}
	}

	public void init(boolean newLevel) {
		// HashMap<String, Double> settings = this.loader.getGameSetting();
		// this.enemyManager.setCurrentCell(this.model.getData().getGrid().getStartPoint());
		populateTowerToId();
		initGUI(newLevel);

		try {
			Wrapper.getInstance().recordGameScores("" + this.model.getData().getGold(),
					"" + this.model.getData().getLife(), "" + this.model.getData().getCurrentLevel());
		} catch (IOException e) {
		}
		this.towerController = new TowerController(this.model.getTowerManager(), this.view);
		initSaveGameButton();

	}

	/**
	 * FILL THIS METHOD WITH XML SAVING CRAP
	 */
	private void initSaveGameButton() {
		this.view.saveButton(e -> {

		});
	}

	public void setDataStoreOnClose(Stage s) {
		s.setOnCloseRequest(e -> {
			try {
				Wrapper.getInstance().logEndScore("" + this.model.getData().getGold(),
						"" + this.model.getData().getLife(), "" + this.model.getData().getCurrentLevel());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Log end score went wrong");
				e1.printStackTrace();
			}
		});
	}

	private void initGUI(boolean newlevel) {
		System.out.println("initing gui");
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

		if (newlevel) {
			this.mainScene = view.init(this.model.getData().getGold(), this.model.getData().getLife(),
					this.model.getData().getCurrentLevel(), this.model.getData().getScore(), getTowerImages(),
					this.mainScene);
		} else {
			this.mainScene = view.init(this.model.getData().getGold(), this.model.getData().getLife(),
					this.model.getData().getCurrentLevel(), this.model.getData().getScore(), getTowerImages());
		}
		this.view.getGrid().getGrid().setOnMouseClicked(e -> handleMouseClicked(e.getX(), e.getY()));

		// System.out.println("line 172, gameplay controller: Is the grid
		// null?");
		// System.out.println(model.getData().getGrid());
		if (!this.model.getData().getGrid().isNoPathType()) {
			this.view.getGrid().populatePath(model.getData().getGrid().getAllPaths());
		}
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

	// probably should move to frontend
	private ArrayList<String> getTowerImages() {
		ArrayList<String> towerImages = new ArrayList<String>();
		Map<Integer, engine.tower.Tower> towers = this.loader.getTowers();
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

		// System.out.println("Game Over called");
		// log end score
		try {
			Wrapper.getInstance().logEndScore("" + this.model.getData().getGold(), "" + this.model.getData().getLife(),
					"" + this.model.getData().getCurrentLevel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Log end score went wrong");
			e.printStackTrace();
		}
		this.view.getMainScreen().getChildren().clear();
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("http://people.duke.edu/~lz107/voogaTemplates/gameover.html");
		this.view.getMainScreen().setCenter(browser);

	}

	private void checkCreateNewLevel() {
		// new level condition
		double newLevel = this.model.getData().getCurrentLevel();
		if (this.oldLevel < newLevel) {
			// this.timeCounterThread.
			this.startTime = System.currentTimeMillis();
			this.intervalBetweenWaves = this.model.getEnemyManager().getTimeOfNextWave();
			this.oldLevel = newLevel;
			this.view.newLevelPopUp(e -> {
				//// //System.out.println("New level");
				// this.view.getMainScreen().getChildren().clear();
				this.view.getGrid().getGrid().getChildren().clear();
				init(true);
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
					((GamePlayData) o).getCurrentLevel(), ((GamePlayData) o).getScore());
			this.view.updateCurrentLevelStats(((GamePlayData) o).getCurrentLevel());

			// check for game over condition
			if (((GamePlayData) o).getLife() <= 0) {
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
		// getNewWaveOnInterval();
		// countTime();

		this.startTime = System.currentTimeMillis();
		this.intervalBetweenWaves = this.model.getEnemyManager().getTimeOfNextWave();
		spawnEnemyOnInterval(this.enemyManager,
				this.enemyController/* , this.currentWave */);

		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
			((Pane) this.view.getGrid().getGrid()).getChildren().clear();
			System.out.println("intervalbetween: "+intervalBetweenWaves);
			System.out.println("elapse: "+(System.currentTimeMillis()-this.startTime));
			// trying to get this to work but null pointer
			if(System.currentTimeMillis()-this.startTime>intervalBetweenWaves&&intervalBetweenWaves>=0){
				System.out.println("**********************");
				
				this.currentWave = this.model.getEnemyManager().getPackOfEnemyComing();
				
				this.intervalBetweenWaves=this.model.getEnemyManager().getTimeOfNextWave();
			}
			
			this.model.updateInLevel(weaponsOnScreen);
			this.enemyManager.update();
			this.model.getCollisionManager().handleCollisions();

			redrawEverything();
		});

		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		// animation.getKeyFrames().addAll(frame, this.enemyKeyFrame);//TODO
		animation.play();
	}

	private void spawnEnemyOnInterval(EnemyManager enemyManager,
			EnemyController control/* ,Queue<Enemy> currentWave */) {

		System.out.println("ENEMY THREAD");
		Thread enemyThread = new Thread() {
			public void run() {
				long intervalBetween = (long) control.getEnemyModel().getFrequencyOfNextWave();
				while (intervalBetween!=0) {
					if(currentWave.size()!=0){
						System.out.println("currentWave: "+currentWave.size());
						Enemy enemy = currentWave.poll();
						enemyManager.spawnEnemy(enemy);
					}
					else{	
						
					}
											
					try {
						Thread.sleep(intervalBetween);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		enemyThread.start();

	}

	private void redrawEverything() {
		// redraw path
		// this.view.getGrid().populatePath(this.model.getGrid().getStartPoint());
		this.view.getGrid().getGrid().getChildren().addAll(this.view.getGrid().getPathImages());

		HashMap<Integer, Enemy> enemyRedraw = this.enemyManager.getEnemyOnGrid();
		Map<Integer, Tower> towerRedraw = this.model.getTowerOnGrid();
		HashMap<Integer, Weapon> bulletRedraw = this.model.getWeaponManager().getWeaponOnGrid();

		updateBulletOnScreen(bulletRedraw);
		updateEnemiesOnScreen(enemyRedraw);

		this.view.reRenderEnemy(enemiesOnScreen);
		this.view.reRenderWeapon(weaponsOnScreen);
		this.view.reRenderTower(towerRedraw);
	}

	public Timeline getTimeline() {
		return this.animation;
	}

	private void updateBulletOnScreen(HashMap<Integer, Weapon> bulletRedraw) {
		Iterator<Integer> it = weaponsOnScreen.keySet().iterator();
		while (it.hasNext()) {
			int value = it.next();
			if (!bulletRedraw.containsKey(value)) {
				it.remove();
			}
		}

		for (int i : bulletRedraw.keySet()) {
			if (!weaponsOnScreen.containsKey(bulletRedraw.get(i).getUniqueID())) {
				Image ii = imageBank.get("Weapon " + bulletRedraw.get(i).getWeaponTypeID());
				ImageView image = new ImageView(ii);
				graphics.setImageViewParams(image, DragDropView.DEFENSIVEWIDTH * 0.5,
						DragDropView.DEFENSIVEHEIGHT * 0.5);
				image.setCache(true);
				image.setCacheHint(CacheHint.SPEED);
				image.setX(bulletRedraw.get(i).getX());
				image.setY(bulletRedraw.get(i).getY());
				weaponsOnScreen.put(bulletRedraw.get(i).getUniqueID(), image);

				// this.view.getGrid().getGrid().getChildren().add(weaponsOnScreen.get(i));
			} else {
				weaponsOnScreen.get(bulletRedraw.get(i).getUniqueID()).setX(bulletRedraw.get(i).getX());
				weaponsOnScreen.get(bulletRedraw.get(i).getUniqueID()).setY(bulletRedraw.get(i).getY());
			}
		}
	}

	private void updateEnemiesOnScreen(HashMap<Integer, Enemy> enemyRedraw) {
		for (int i : enemyRedraw.keySet()) {
			if (!enemiesOnScreen.containsKey(enemyRedraw.get(i).getUniqueID())) {
				ImageView image = new ImageView(graphics.createImage(enemyRedraw.get(i).getImage()));
				graphics.setImageViewParams(image, DragDropView.DEFENSIVEWIDTH * 0.9,
						DragDropView.DEFENSIVEHEIGHT * 0.9);
				image.setCache(true);
				image.setCacheHint(CacheHint.SPEED);
				image.setX(enemyRedraw.get(i).getX());
				image.setY(enemyRedraw.get(i).getY());
				enemiesOnScreen.put(enemyRedraw.get(i).getUniqueID(), image);
			} else {
				enemiesOnScreen.get(enemyRedraw.get(i).getUniqueID()).setX(enemyRedraw.get(i).getX());
				enemiesOnScreen.get(enemyRedraw.get(i).getUniqueID()).setY(enemyRedraw.get(i).getY());
			}
		}
	}

	public HashMap<String, Image> createImageBank() {
		Map<Integer, engine.tower.Tower> towers = this.loader.getTowers();

		for (int i : towers.keySet()) {
			Image image = graphics.createImage(towers.get(i).getImagePath());
			imageBank.put("Tower " + i, image);
		}
		Map<Integer, engine.weapon.Weapon> weapons = this.loader.getWeaponBank();
		for (int i : weapons.keySet()) {
			Image image = graphics.createImage(weapons.get(i).getImagePath());
			imageBank.put("Weapon " + i, image);
		}
		return imageBank;
	}

}
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

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

	// Might need to be refactored into a different class
	private HashMap<Integer, ImageView> weaponsOnScreen;

	public GamePlayerController(String xmlFilePath) {
		// use xml parser to create classes.
		this.loader = new GamePlayerFactory(new XMLParser(xmlFilePath));// hardcoded
		// "player.samplexml/game2.xml"
		// does not work because of the image path

		checkIfValid();
		this.model = new GamePlayModel(this.loader);
		this.enemyController = new EnemyController(this.model.getEnemyManager(), null);// Second
																						// arg
																						// should
																						// be
																						// gridGUI
		
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

	public void init(){
		HashMap<String, Double> settings = this.loader.getGameSetting();
		this.enemyManager.setCurrentCell(this.model.getData().getGrid().getStartPoint());
		populateTowerToId();
		initGUI();
		
		try {
			Wrapper.getInstance().recordGameScores(""+this.model.getData().getGold(), ""+this.model.getData().getLife(), ""+this.model.getData().getCurrentLevel());
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
				this.model.getData().getCurrentLevel(), getTowerImages());
		this.view.getGrid().getGrid().setOnMouseClicked(e -> handleMouseClicked(e.getX(), e.getY()));
		
		this.view.getGrid().populatePath(model.getData().getGrid().getStartPoint());
		this.dropController = new DragDropController(this.view, this.model, this.getTowerImageMap());

		// testing stuff
		// this.model.createDummyEnemies();
	}
	

	private void handleMouseClicked(double x, double y) {
		
		Map<Integer, Tower> towersOnGrid = this.model.getTowerOnGrid();
		for (int i : towersOnGrid.keySet()) {
			Tower t = towersOnGrid.get(i);
			double newX = this.view.gridToPixelCoordWidth(t.getX());
			double newY=this.view.gridToPixelCoordHeight(t.getY());
			//System.out.println("Tower x y: "+newX+", "+newY);
			//System.out.println("Clicked: "+x+","+y);
			if ((newX<= x && newX + ENTITY_SIZE >= x && newY <= y
					&& newY+ ENTITY_SIZE >= y)) {
				//System.out.println("shown");
				t.toggleInfoVisibility();
				createBox(x, y, t);
			}
		}

		HashMap<Integer, Enemy> enemiesOnGrid = this.enemyManager.getEnemyOnGrid();
		for (int i : enemiesOnGrid.keySet()) {
			Enemy e = enemiesOnGrid.get(i);
			if (e.getX() <= x && e.getX() + ENTITY_SIZE >= x && e.getY() <= y
					&& e.getY() + ENTITY_SIZE >= y) {
				e.toggleInfoVisibility();
			}
		}
		

	}

	public void createBox(double x, double y, Tower t) {
		VBox box = t.getInfoBox();
		t.getSellButton().setOnAction(e -> this.towerController.handleSellTowerClick());
	}
	


	private ArrayList<String> getTowerImages() {
		ArrayList<String> towerImages = new ArrayList<String>();

		HashMap<Integer, engine.tower.Tower> towers = this.loader.getTowers(); // fix
																				// naming
		for (engine.tower.Tower tower : towers.values()) { // fix naming

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

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof GamePlayData) {
			double newLevel = ((GamePlayData) o).getCurrentLevel();
			// update level in display
			this.view.updateStatsDisplay(((GamePlayData) o).getGold(), ((GamePlayData) o).getLife(),
					((GamePlayData) o).getCurrentLevel());
			this.view.updateCurrentLevelStats(((GamePlayData) o).getCurrentLevel());
			
			/*
			try {
				this.updateWebAppStats(newLevel, ((GamePlayData) o));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				System.out.println("----------FAILED TO UPDATE WEB APP STATS---------");
				e2.printStackTrace();
			}
			*/

			// check for game over condition
			if (((GamePlayData) o).getLife() < 0) { // TODO: change 5 to 0
				gameOver();
			}

			// new level condition
			if (this.oldLevel != newLevel) {
				// record the data to log to web app
				/*
				try {
					Wrapper.getInstance().recordGameScores("" + ((GamePlayData) o).getGold(),
							"" + ((GamePlayData) o).getLife(), "" + ((GamePlayData) o).getCurrentLevel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				this.oldLevel = newLevel;
				this.view.newLevelPopUp(e -> {
					//// System.out.println("New level");
					this.view.getGrid().getGrid().getChildren().clear();
					// do something to trigger new level here!
					this.model.initializeLevelInfo();
				});

			}
		}
		/*
		 * GamePlayModel model = (GamePlayModel) o; if (model.getLife() == 0) {
		 * updateLevel(); }
		 */

	}

	private void updateWebAppStats(double newLevel, GamePlayData gdata) throws IOException {
		/*
		System.out.println("~~~~~trying to update web app stats~~~~~");
		System.out.println("Gold: "+this.model.getData().getGold());
		System.out.println("Gold from observable: "+gdata.getGold());
		*/
		Wrapper.getInstance().updateGameScores("lives", Integer.toString((int)newLevel), Double.toString(gdata.getLife()));
		Wrapper.getInstance().updateGameScores("gold", Integer.toString((int)newLevel), Double.toString(gdata.getGold()));
		Wrapper.getInstance().updateGameScores("level", Integer.toString((int)newLevel),
				Double.toString(gdata.getCurrentLevel()));

	}

	/*
	 * private void updateLevel() { //TODO: use Parser's method to get path and
	 * update the view's grid with that path }
	 */

	private void startAnimation() {
		this.model.getData().getGrid().printGrid();
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
			((Pane) this.view.getGrid().getGrid()).getChildren().clear(); // clear
																			// everything
			this.currentWave = this.enemyController.getEnemyModel().getPackOfEnemyComing();
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
		animation.getKeyFrames().add(frame);
		animation.play();
	}

	private void redrawEverything() {
		// redraw path
		// this.view.getGrid().populatePath(this.model.getGrid().getStartPoint());
		this.view.getGrid().getGrid().getChildren().addAll(this.view.getGrid().getPathImages());

		HashMap<Integer, Enemy> enemyRedraw = this.enemyManager.getEnemyOnGrid();
		Map<Integer, Tower> towerRedraw = this.model.getTowerOnGrid();
		HashMap<Integer, Weapon> bulletRedraw = this.model.getWeaponManager().getWeaponOnGrid();
		/*
		for (int i : bulletRedraw.keySet()) {
			System.out.println("bulletRedraw");
			
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
		*/

		List<IDrawable> reEnemyDraw = convertEnemyDrawable(enemyRedraw);// probably
																		// need
																		// to
																		// add
																		// bullets
																		// here
																		// too
		List<IDrawable> reTowerDraw = convertTowerDrawable(towerRedraw);
		// List<IDrawable> reBulletDraw = convertWeaponDrawable(bulletRedraw);
		// convertWeaponImageView(bulletRedraw);

		this.view.reRender(reEnemyDraw);
		this.view.reRenderWeapon(weaponsOnScreen);
		this.view.reRenderTower(reTowerDraw);
	}

	public Timeline getTimeline() {
		return this.animation;
	}

	@Deprecated
	private List<IDrawable> convertToDrawable(List<Enemy> enemies, List<Tower> towers) {
		ArrayList<IDrawable> ret = new ArrayList<>();
		for (Enemy e : enemies) {
			ret.add(e);
		}
		for (Tower t : towers) {
			ret.add(t);
		}
		return ret;
	}

	@Deprecated
	private List<IDrawable> convertWeaponDrawable(List<Weapon> weapons) {
		ArrayList<IDrawable> ret = new ArrayList<>();
		for (Weapon w : weapons) {
			ret.add(w);
		}
		return ret;
	}

	@Deprecated
	private List<ImageView> convertWeaponImageView(List<Weapon> weapons) {
		ArrayList<ImageView> ret = new ArrayList<>();
		for (Weapon w : weapons) {
			ImageView weaponImage = graphics.createImageView(graphics.createImage(w.getImage()));
			graphics.setImageViewParams(weaponImage, 0.5 * DragDropView.DEFENSIVEWIDTH,
					0.5 * DragDropView.DEFENSIVEHEIGHT);
			weaponImage.setX(w.getX() * GridGUI.GRID_WIDTH / this.model.getData().getRow());
			weaponImage.setY(w.getY() * GridGUI.GRID_HEIGHT / this.model.getData().getColumns());
			ret.add(graphics.createImageView(graphics.createImage(w.getImage())));
			this.view.getGrid().getGrid().getChildren().add(weaponImage);
		}
		return ret;
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
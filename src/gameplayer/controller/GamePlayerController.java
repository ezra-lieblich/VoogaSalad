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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import statswrapper.Wrapper;

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


public class GamePlayerController implements Observer {

	private static final int Y_OFFSET = 54;
	private static final int ENTITY_SIZE = 70;
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

	//Might need to be refactored into a different class
	private HashMap<Integer,ImageView> weaponsOnScreen; 





	public GamePlayerController(String xmlFilePath) {
		// use xml parser to create classes.
		this.loader = new GamePlayerFactory(new XMLParser(xmlFilePath));// hardcoded
		// "player.samplexml/game2.xml"
		// does not work because of the image path
		
		checkIfValid();
		this.model = new GamePlayModel(this.loader);
		this.enemyController = new EnemyController(this.model.getEnemyManager(), null);// Second arg should be gridGUI
		this.towerController = new TowerController(this.model.getTowerManager());
		this.weaponController = new WeaponController(this.model.getWeaponManager());
		this.collisionController = new CollisionController(this.model.getCollisionManager());
		this.model.getData().addObserver(this);
		this.oldLevel = 0;
		this.towerToId = new HashMap<String, Integer>();
		this.weaponsOnScreen = new HashMap<Integer,ImageView>();
		this.animation = new Timeline();
		this.graphics = new GraphicsLibrary();
		this.enemyManager = this.enemyController.getEnemyModel();
	}

	private void populateTowerToId(){
		HashMap<Integer, engine.tower.Tower> mapping = this.model.getTowerManager().getAvailableTower();
		System.out.println("tower mapping:");
		System.out.println(mapping);
		for (int key:mapping.keySet()){
			this.towerToId.put(mapping.get(key).getImagePath(),key);
		}
	}

	public HashMap<String, Integer> getTowerImageMap(){
		return this.towerToId;
	}
	/**
	 * Checks to see if XML is valid If not, it will not create a game and it
	 * will throw an error
	 */
	public void checkIfValid() {
		if (!loader.xmlIsValid()) {
			////System.out.println("XML is invalid, game cannot be created");
			// TODO: actually throw an error
		}
	}

	public void init() {
		//this.model.initializeGameSetting(this.loader);
		HashMap<String, Double> settings = this.loader.getGameSetting();
		//initGUIDummy(settings);
		System.out.println("In init:");
		System.out.println(this.model.getData().getGrid().getStartPoint());
		this.enemyManager.setCurrentCell(this.model.getData().getGrid().getStartPoint());
		System.out.println("In init");
		//this.model.getTowerManager().populateAvailableTower();
		populateTowerToId();
		initGUI();
		//this.enemyController = new EnemyController(this.enemyManager, this.view.getGrid());
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
		this.mainScene = view.init(this.model.getData().getGold(), this.model.getData().getLife(), this.model.getData().getCurrentLevel(),
				getTowerImages());
		this.mainScene.setOnMouseClicked(e -> handleMouseClicked(e.getX(), e.getY()));

		this.view.getGrid().populatePath(model.getData().getGrid().getStartPoint()); 
		this.dropController = new DragDropController(this.view, this.model,this.getTowerImageMap());


		//testing stuff
		//this.model.createDummyEnemies();
	}

	private void handleMouseClicked(double x, double y){
		Map<Integer, Tower> towersOnGrid = this.model.getTowerOnGrid();
		for(int i: towersOnGrid.keySet()){
			Tower t = towersOnGrid.get(i);
			if((t.getX() <= x && t.getX() +ENTITY_SIZE >= x && t.getY() <= y-Y_OFFSET && 
					t.getY() + ENTITY_SIZE >= y -Y_OFFSET)){
				t.toggleInfoVisibility();
			}
		}

		HashMap<Integer, Enemy> enemiesOnGrid = this.enemyManager.getEnemyOnGrid();
		for(int i: enemiesOnGrid.keySet()){
			Enemy e = enemiesOnGrid.get(i);
			if(e.getX() <= x && e.getX() +ENTITY_SIZE >= x && e.getY() <= y-Y_OFFSET &&
					e.getY() + ENTITY_SIZE >=y-Y_OFFSET){
				e.toggleInfoVisibility();
			}
		}
	}

	private ArrayList<String> getTowerImages() {
		ArrayList<String> towerImages = new ArrayList<String>();

		HashMap<Integer, engine.tower.Tower> towers = this.loader.getTowers(); //fix naming
		for (engine.tower.Tower tower : towers.values()) { //fix naming

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

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof GamePlayData) {
			double newLevel = ((GamePlayData)o).getCurrentLevel();
			// update level in display
			this.view.updateStatsDisplay(((GamePlayData)o).getGold(), ((GamePlayData)o).getLife(),
					((GamePlayData)o).getCurrentLevel());
			this.view.updateCurrentLevelStats(((GamePlayData)o).getCurrentLevel());
			if (this.oldLevel != newLevel){
				//record the data to log to web app
				try {
					Wrapper.getInstance().recordGameScores(""+((GamePlayData)o).getGold(), ""+((GamePlayData)o).getLife(), ""+((GamePlayData)o).getCurrentLevel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.oldLevel = newLevel;
				this.view.newLevelPopUp(e->{
					////System.out.println("New level");
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
		this.model.getData().getGrid().printGrid();
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
					((Pane) this.view.getGrid().getGrid()).getChildren().clear(); //clear everything
			this.currentWave = this.enemyController.getEnemyModel().getPackOfEnemyComing();
			//trying to get this to work but null pointer
			if(currentWave.size()!=0){
				if(timer%15==0){
					Enemy enemy = currentWave.poll();
					this.enemyManager.spawnEnemy(enemy);
					timer = 1; 
				}
				else{
					timer++;
				}
			}
			this.model.updateInLevel();
			this.enemyManager.update(); 


			redrawEverything();
		});

		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		this.animation = animation;
		animation.play();
	}

	private void redrawEverything(){
		//redraw path
		//this.view.getGrid().populatePath(this.model.getGrid().getStartPoint());
		this.view.getGrid().getGrid().getChildren().addAll(this.view.getGrid().getPathImages());

		HashMap<Integer, Enemy>enemyRedraw = this.enemyManager.getEnemyOnGrid(); 
		Map<Integer, Tower>towerRedraw = this.model.getTowerOnGrid();
		HashMap<Integer, Weapon>bulletRedraw = this.model.getWeaponOnGrid();
		for(int i: bulletRedraw.keySet()){
			if(!weaponsOnScreen.containsKey(bulletRedraw.get(i).getUniqueID())){
				ImageView image = new ImageView(bulletRedraw.get(i).getImage());
				image.setCache(true);
				image.setCacheHint(CacheHint.SPEED);
				//System.out.println("weapon coord: x:"+entity.getX()+", y:"+entity.getY());
				image.setX(bulletRedraw.get(i).getX());
				image.setY(bulletRedraw.get(i).getY());
				graphics.setImageViewParams(image, DragDropView.DEFENSIVEWIDTH * 0.5, DragDropView.DEFENSIVEHEIGHT * 0.5);
				weaponsOnScreen.put(bulletRedraw.get(i).getUniqueID(),image);
			}
			else{
				weaponsOnScreen.get(bulletRedraw.get(i).getUniqueID()).setX(bulletRedraw.get(i).getX());
				weaponsOnScreen.get(bulletRedraw.get(i).getUniqueID()).setY(bulletRedraw.get(i).getY());
			}
		}

		List<IDrawable> reEnemyDraw = convertEnemyDrawable(enemyRedraw);//probably need to add bullets here too
		List<IDrawable> reTowerDraw = convertTowerDrawable(towerRedraw);
		//		List<IDrawable> reBulletDraw = convertWeaponDrawable(bulletRedraw);
		//convertWeaponImageView(bulletRedraw);

		this.view.reRender(reEnemyDraw);
		this.view.reRenderWeapon(weaponsOnScreen);
		this.view.reRenderTower(reTowerDraw);
	}

	public Timeline getTimeline() {
		return this.animation;
	}

	private List<IDrawable> convertToDrawable(List<Enemy> enemies, List<Tower>towers){
		ArrayList<IDrawable> ret = new ArrayList<>(); 
		for(Enemy e: enemies){
			ret.add(e);
		}
		for(Tower t: towers){
			ret.add(t);
		}
		return ret; 
	}

	private List<IDrawable>convertWeaponDrawable(List<Weapon>weapons){
		ArrayList<IDrawable> ret = new ArrayList<>(); 
		for(Weapon w: weapons){
			ret.add(w);
		}
		return ret; 
	}

	@Deprecated
	private List<ImageView>convertWeaponImageView(List<Weapon>weapons){
		ArrayList<ImageView> ret = new ArrayList<>(); 
		for(Weapon w: weapons){
			ImageView weaponImage = graphics.createImageView(graphics.createImage(w.getImage()));
			graphics.setImageViewParams(weaponImage, 0.5*DragDropView.DEFENSIVEWIDTH, 0.5*DragDropView.DEFENSIVEHEIGHT);
			weaponImage.setX(w.getX()*GridGUI.GRID_WIDTH/this.model.getData().getRow());
			weaponImage.setY(w.getY()*GridGUI.GRID_HEIGHT/this.model.getData().getColumns());
			ret.add(graphics.createImageView(graphics.createImage(w.getImage())));
			this.view.getGrid().getGrid().getChildren().add(weaponImage);
		}
		return ret; 
	}

	private List<IDrawable> convertEnemyDrawable(HashMap<Integer, Enemy> enemies){
		ArrayList<IDrawable> ret = new ArrayList<>(); 
		for(int e: enemies.keySet()){
			ret.add(enemies.get(e));
		}
		return ret; 
	}

	private List<IDrawable> convertTowerDrawable(Map<Integer, Tower>towers){
		ArrayList<IDrawable> ret = new ArrayList<>(); 
		for(int i: towers.keySet()){
			ret.add(towers.get(i));
		}
		return ret; 
	}


}
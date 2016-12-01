package gameplayer.controller;

import gameplayer.loader.GamePlayerFactory;
import gameplayer.loader.XMLParser;
import gameplayer.main.main;
import gameplayer.model.Cell;
import gameplayer.model.Enemy;
import gameplayer.model.EnemyManager;
import gameplayer.model.GamePlayModel;
import gameplayer.model.IDrawable;
import gameplayer.model.Tower;
import gameplayer.model.Weapon;
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
import java.util.Random;


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
	private int timer = 1;
	


	private Queue<Enemy> currentWave;
	
	private HashMap<String, Integer> towerToId;
	
	



	public GamePlayerController() {
		// use xml parser to create classes.
		this.loader = new GamePlayerFactory(new XMLParser("player.samplexml/test.xml"));// hardcoded

		checkIfValid();
		this.model = new GamePlayModel(this.loader);
		this.enemyManager = new EnemyManager(this.model);
		this.model.addObserver(this);
		this.oldLevel = 1;
		this.towerToId = new HashMap<String, Integer>();
		populateTowerToId();
	}

	private void populateTowerToId(){
		HashMap<Integer, engine.tower.Tower> mapping = this.model.getAllTowerTypes();
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
			//System.out.println("XML is invalid, game cannot be created");
			// TODO: actually throw an error
		}
	}

	public void init() {
		this.model.initializeLevelInfo();
		HashMap<String, Double> settings = this.loader.getGameSetting();
		//initGUIDummy(settings);
		this.enemyManager.setCurrentCell(this.model.getGrid().getStartPoint());
		initGUI();
		//this.enemyController = new EnemyController(this.enemyManager, this.view.getGrid());
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
		this.mainScene = view.init(this.model.getGold(), this.model.getLife(), this.model.getCurrentLevel(),
				getTowerImages());
		this.mainScene.setOnMouseClicked(e -> handleMouseClicked(e.getX(), e.getY()));
		
		this.view.getGrid().populatePath(model.getGrid().getStartPoint()); 
		this.dropController = new DragDropController(this.view, this.model,this.getTowerImageMap());
		
		
		//testing stuff
		this.model.createDummyEnemies();
	}
	
	private void handleMouseClicked(double x, double y){
		List<Tower> towersOnGrid = this.model.getTowerOnGrid();
		for(Tower t: towersOnGrid){
			if((t.getX() -20 < x || x < t.getX()+20)  && (t.getY()-20 < y || y <t.getY() + 20)){
				t.toggleInfoVisibility();
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
		if (o instanceof GamePlayModel) {
			double newLevel = ((GamePlayModel) o).getCurrentLevel();
			// update level in display
			this.view.updateStatsDisplay(((GamePlayModel) o).getGold(), ((GamePlayModel) o).getLife(),
					((GamePlayModel) o).getCurrentLevel());
			this.view.updateCurrentLevelStats(((GamePlayModel) o).getCurrentLevel());
			if (this.oldLevel != newLevel){
				
				this.oldLevel = newLevel;
				this.view.newLevelPopUp(e->{
					//System.out.println("New level");
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
		this.model.getGrid().printGrid();
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
			((Pane) this.view.getGrid().getGrid()).getChildren().clear(); //clear everything
			this.currentWave = this.model.getPackOfEnemyComing();

			
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
/*
			List<Enemy>enemyRedraw = this.enemyManager.getEnemyOnGrid(); 
			List<Tower>towerRedraw = this.model.getTowerOnGrid();
			List<IDrawable> reEnemyDraw = convertEnemyDrawable(enemyRedraw);//probably need to add bullets here too
			List<IDrawable> reTowerDraw = convertTowerDrawable(towerRedraw);
			
			this.view.reRender(reEnemyDraw);
			this.view.reRenderTower(reTowerDraw);
			
			this.view.getGrid().populatePath(this.model.getGrid().getStartPoint());
			*/
		});
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		this.animation = animation;
		animation.play();
	}
	
	private void redrawEverything(){
		//redraw path
		//this.view.getGrid().populatePath(this.model.getGrid().getStartPoint());
		this.view.getGrid().getGrid().getChildren().addAll(this.view.getGrid().getPathImages());
		List<Enemy>enemyRedraw = this.enemyManager.getEnemyOnGrid(); 
		List<Tower>towerRedraw = this.model.getTowerOnGrid();
		List<Weapon>bulletRedraw = this.model.getWeaponOnGrid();
		
		System.out.println(bulletRedraw.size());
		for(int i=0;i<bulletRedraw.size();i++){
			System.out.println("bullet "+i+": "+bulletRedraw.get(i).getImage());
		}
		
		
		List<IDrawable> reEnemyDraw = convertEnemyDrawable(enemyRedraw);//probably need to add bullets here too
		List<IDrawable> reTowerDraw = convertTowerDrawable(towerRedraw);
		List<IDrawable> reBulletDraw = convertWeaponDrawable(bulletRedraw);
		
		this.view.reRender(reEnemyDraw);
		this.view.reRender(reBulletDraw);
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
	
	private List<IDrawable> convertEnemyDrawable(List<Enemy> enemies){
		ArrayList<IDrawable> ret = new ArrayList<>(); 
		for(Enemy e: enemies){
			ret.add(e);
		}
		return ret; 
	}
	
	private List<IDrawable> convertTowerDrawable(List<Tower>towers){
		ArrayList<IDrawable> ret = new ArrayList<>(); 
		for(Tower t: towers){
			ret.add(t);
		}
		return ret; 
	}


}
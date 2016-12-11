package authoring.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.EnemyAuthoringViewController;
import authoring.editorview.enemy.IEnemyUpdateView;
import authoring.editorview.gamesettings.GameSettingsAuthoringViewController;
import authoring.editorview.gamesettings.IGameSettingsUpdateView;
import authoring.editorview.level.ILevelUpdateView;
import authoring.editorview.level.LevelAuthoringViewController;
import authoring.editorview.path.IPathUpdateView;
import authoring.editorview.path.PathAuthoringViewController;
import authoring.editorview.tower.ITowerUpdateView;
import authoring.editorview.tower.TowerAuthoringViewController;
import authoring.editorview.weapon.IWeaponUpdateView;
import authoring.editorview.weapon.WeaponAuthoringViewController;
import authoring.toolbar.IToolbar;
import authoring.view.ViewController;
import engine.GameAuthoringData;
import engine.ModelAuthoringController;
import engine.ModelController;
import engine.enemy.Enemy;
import engine.enemy.EnemyManager;
import engine.enemy.EnemyManagerController;
import engine.level.LevelManager;
import engine.level.LevelManagerController;
import engine.path.PathManager;
import engine.path.PathManagerController;
import engine.settings.GameModeManager;
import engine.settings.GameModeManagerController;
import engine.tower.TowerManager;
import engine.tower.TowerManagerController;
import engine.weapon.WeaponManager;
import engine.weapon.WeaponManagerController;
import javafx.scene.Scene;
import statswrapper.Wrapper;


public class AuthoringController {
    private ModelController modelController;
    private ViewController viewController;
    private IToolbar toolbar;

    public AuthoringController (int size) {
        modelController = new ModelAuthoringController();
        try {
            viewController = new ViewController(size, size);
            connectDataInterfaces(viewController);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        configureToolbar();

    }

    private void configureToolbar () {
        toolbar = this.viewController.getView().getMyToolbar();

        toolbar.setOnPressedSave(e -> saveAsXMLFile());

        
        toolbar.setOnPressedLoad(e -> {
        	loadData("player.samplexml/load.xml");
        });


    }

    public void saveAsXMLFile ()  {
        String fileContent = this.modelController.SaveData();
        toolbar.saveFile(fileContent);
        // TODO Lucy: add api call to record game in web app
        
        try {
        	String gameData = xmlToString(fileContent);
			Wrapper.getInstance().createGame(gameData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public void loadData(String filePath) {
		//TODO GameModeManagerController ConstructTypeProperties is empty because it needs methods to call in front end.
		//TODO Creates a null pointer exception currently. Also need controllers instead of Views!!!!
		GameAuthoringData data = modelController.loadData(filePath);
		 modelController.getModelController(EnemyManagerController.class)
		 	.loadManagerData(data.getManagerMediator().getManager(EnemyManager.class), 
		 							(IEnemyUpdateView) viewController.getControllers().get("enemy").getUpdateView());
		 
		 modelController.getModelController(TowerManagerController.class)
		 	.loadManagerData(data.getManagerMediator().getManager(TowerManager.class),
		 						(ITowerUpdateView) viewController.getControllers().get("tower").getUpdateView());
		 modelController.getModelController(WeaponManagerController.class)
		 	.loadManagerData(data.getManagerMediator().getManager(WeaponManager.class), 
		 						(IWeaponUpdateView) viewController.getControllers().get("weapon").getUpdateView());
		 modelController.getModelController(PathManagerController.class)
		 	.loadManagerData(data.getManagerMediator().getManager(PathManager.class), 
		 						(IPathUpdateView) viewController.getControllers().get("path").getUpdateView());
		 modelController.getModelController(LevelManagerController.class)
		 	.loadManagerData(data.getManagerMediator().getManager(LevelManager.class), 
		 						(ILevelUpdateView) viewController.getControllers().get("level").getUpdateView());
//		 modelController.getModelController(GameModeManagerController.class)
//		 	.loadManagerData(data.getManagerMediator().getManager(GameModeManager.class),
//		 						(IGameSettingsEditorView) viewController.getControllers().get("setup").getUpdateView());
	}
    
    private String xmlToString(String textContent) throws IOException{
    	BufferedReader br = new BufferedReader(new StringReader(textContent));
    	String line;
    	StringBuilder sb = new StringBuilder();

    	while((line=br.readLine())!= null){
    	    sb.append(line.trim());
    	}
    	return sb.toString();
    }

    private void connectDataInterfaces (ViewController authoringVC) {

        HashMap<String, EditorViewController> editorVCs = authoringVC.getControllers();
        PathAuthoringViewController pathVC = (PathAuthoringViewController) editorVCs.get("path");
        LevelAuthoringViewController levelVC = (LevelAuthoringViewController) editorVCs.get("level");
        WeaponAuthoringViewController weaponVC = (WeaponAuthoringViewController) editorVCs.get("weapon");
        EnemyAuthoringViewController enemyVC = (EnemyAuthoringViewController) editorVCs.get("enemy");
        TowerAuthoringViewController towerVC = (TowerAuthoringViewController) editorVCs.get("tower");
        GameSettingsAuthoringViewController setupVC =
                (GameSettingsAuthoringViewController) editorVCs.get("setup");

        PathManagerController pathModel =
                modelController.getModelController(PathManagerController.class);
        LevelManagerController levelModel =
                modelController.getModelController(LevelManagerController.class);
        WeaponManagerController weaponModel =
                modelController.getModelController(WeaponManagerController.class);
        EnemyManagerController enemyModel =
                modelController.getModelController(EnemyManagerController.class);
        TowerManagerController towerModel =
                modelController.getModelController(TowerManagerController.class);
        GameModeManagerController settingsModel =
                modelController.getModelController(GameModeManagerController.class);

        pathVC.setPathDataSource(pathModel);
        enemyVC.setEnemyDataSource(enemyModel);
        levelVC.setEnemyDataSource(enemyModel);
        levelVC.setLevelDataSource(levelModel);
        weaponVC.setWeaponDataSource(weaponModel);
        towerVC.setTowerDataSource(towerModel);
        setupVC.setGameSettingsDataSource(settingsModel);
    }

    public Scene getScene () {
        return this.viewController.getView().getScene();
    }
}

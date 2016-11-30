package authoring.main;

import java.io.IOException;
import java.util.HashMap;

import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.EnemyEditorViewController;
import authoring.editorview.level.LevelEditorViewController;
import authoring.editorview.path.PathEditorViewController;
import authoring.editorview.tower.TowerEditorViewController;
import authoring.editorview.weapon.WeaponEditorViewController;
import authoring.view.AuthoringViewController;
import engine.ManagerTypeMediator;
import engine.ModelAuthoringController;
import engine.ModelController;
import engine.enemy.EnemyManagerController;
import engine.level.LevelManagerController;
import engine.path.PathManagerController;
import engine.tower.TowerManagerController;
import engine.weapon.WeaponManagerController;
import javafx.scene.Scene;

public class AuthoringController {
    private ModelController modelController;
    
    AuthoringController(int size) {
        modelController = new ModelAuthoringController();
        AuthoringViewController mainVC;
		try {
			mainVC = new AuthoringViewController(size, size);
	        connectDataInterfaces(mainVC);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		    
			e.printStackTrace();
		}
        
    }
    
    private void connectDataInterfaces(AuthoringViewController authoringVC) {

		HashMap<String, EditorViewController> editorVCs = authoringVC.getControllers();
		PathEditorViewController pathVC = (PathEditorViewController) editorVCs.get("path");
		LevelEditorViewController levelVC = (LevelEditorViewController) editorVCs.get("level");
		WeaponEditorViewController weaponVC = (WeaponEditorViewController) editorVCs.get("weapon");
		EnemyEditorViewController enemyVC = (EnemyEditorViewController) editorVCs.get("enemy");
		TowerEditorViewController towerVC = (TowerEditorViewController) editorVCs.get("tower");
		
		ModelAuthoringController modelController = new ModelAuthoringController();
		
		pathVC.setPathDataSource(modelController.getModelController(PathManagerController.class));
		levelVC.setLevelDataSource(modelController.getModelController(LevelManagerController.class));
		weaponVC.setWeaponDataSource(modelController.getModelController(WeaponManagerController.class));
		enemyVC.setEnemyDataSource(modelController.getModelController(EnemyManagerController.class));
		towerVC.setTowerDataSource(modelController.getModelController(TowerManagerController.class));
		
	}
}

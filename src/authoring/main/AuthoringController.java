package authoring.main;

import java.io.IOException;
import java.util.HashMap;
import authoring.editorview.EditorViewController;
import authoring.editorview.IEditorView;
import authoring.editorview.IUpdateView;
import authoring.editorview.enemy.EnemyEditorViewController;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.editorview.gamesettings.GameSettingsEditorViewController;
import authoring.editorview.gamesettings.IGameSettingsEditorView;
import authoring.editorview.level.ILevelEditorView;
import authoring.editorview.level.LevelEditorViewController;
import authoring.editorview.path.IPathSetView;
import authoring.editorview.path.IPathEditorView;
import authoring.editorview.path.PathEditorViewController;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewController;
import authoring.editorview.weapon.IWeaponEditorView;
import authoring.editorview.weapon.WeaponEditorViewController;
import authoring.toolbar.IToolbar;
import authoring.view.AuthoringViewController;
import engine.ModelAuthoringController;
import engine.ModelController;
import engine.enemy.EnemyManagerController;
import engine.level.LevelManagerController;
import engine.path.PathManagerController;
import engine.settings.GameModeManagerController;
import engine.tower.TowerManagerController;
import engine.weapon.WeaponManagerController;
import javafx.scene.Scene;


public class AuthoringController {
    private ModelController modelController;
    private AuthoringViewController viewController;
    private IToolbar toolbar;

    AuthoringController (int size) {
        modelController = new ModelAuthoringController();
        try {
            viewController = new AuthoringViewController(size, size);
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

    }

    private void saveAsXMLFile () {
        String fileContent = this.modelController.SaveData();
        toolbar.saveFile(fileContent);
    }

    private void connectDataInterfaces (AuthoringViewController authoringVC) {

        HashMap<String, EditorViewController> editorVCs = authoringVC.getControllers();
        PathEditorViewController pathVC = (PathEditorViewController) editorVCs.get("path");
        LevelEditorViewController levelVC = (LevelEditorViewController) editorVCs.get("level");
        WeaponEditorViewController weaponVC = (WeaponEditorViewController) editorVCs.get("weapon");
        EnemyEditorViewController enemyVC = (EnemyEditorViewController) editorVCs.get("enemy");
        TowerEditorViewController towerVC = (TowerEditorViewController) editorVCs.get("tower");
        GameSettingsEditorViewController settingsVC =
                (GameSettingsEditorViewController) editorVCs.get("settings");

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
        settingsVC.setGameSettingsDataSource(settingsModel);
    }

    public Scene getScene () {
        return this.viewController.getView().getScene();
    }
}

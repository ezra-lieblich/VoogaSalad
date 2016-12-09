package authoring.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.EnemyEditorViewController;
import authoring.editorview.gamesettings.GameSettingsEditorViewController;
import authoring.editorview.level.LevelEditorViewController;
import authoring.editorview.path.PathEditorViewController;
import authoring.editorview.tower.TowerEditorViewController;
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
import statswrapper.Wrapper;


public class AuthoringController {
    private ModelController modelController;
    private AuthoringViewController viewController;
    private IToolbar toolbar;

    public AuthoringController (int size) {
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
        toolbar.setOnPressedSave(e -> {
            try {
                saveAsXMLFile();
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

    }

    private void saveAsXMLFile () throws IOException {
        String fileContent = this.modelController.SaveData();
        toolbar.saveFile(fileContent);
        // TODO Lucy: add api call to record game in web app
        String gameData = xmlToString(fileContent);
        Wrapper.getInstance().createGame(gameData);
    }

    private String xmlToString (String textContent) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(textContent));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line.trim());
        }
        return sb.toString();
    }

    private void connectDataInterfaces (AuthoringViewController authoringVC) {

        HashMap<String, EditorViewController> editorVCs = authoringVC.getControllers();
        PathEditorViewController pathVC = (PathEditorViewController) editorVCs.get("path");
        LevelEditorViewController levelVC = (LevelEditorViewController) editorVCs.get("level");
        WeaponEditorViewController weaponVC = (WeaponEditorViewController) editorVCs.get("weapon");
        EnemyEditorViewController enemyVC = (EnemyEditorViewController) editorVCs.get("enemy");
        TowerEditorViewController towerVC = (TowerEditorViewController) editorVCs.get("tower");
        GameSettingsEditorViewController setupVC =
                (GameSettingsEditorViewController) editorVCs.get("setup");

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

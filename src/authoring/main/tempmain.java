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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import engine.*;
import engine.weapon.*;
import engine.tower.*;
import engine.enemy.*;
import engine.path.*;
import engine.level.*;


public class tempmain extends Application {

    public static final String TITLE = "VOOGASquad";
    private static final int SIZE = 700;

    @Override
    public void start (Stage s) throws IOException {

        // ManagerTypeMediator mainMediator = new ManagerTypeMediator();
        //
        // AuthoringViewController mainVC = new AuthoringViewController(SIZE, SIZE);
        // IAuthoringView mainView = mainVC.getView();
        //
        // this.createManagersAndControllers(mainMediator, mainVC);
        AuthoringController generalController = new AuthoringController(SIZE);

        Scene scene = generalController.getScene();
        s.setTitle(TITLE);
        s.setScene(scene);
        s.setResizable(true);
        s.setHeight(SIZE);
        s.setWidth(SIZE + 145);
        s.show();

    }

//    private void createManagersAndControllers (MediatorManager mainMediator,
//                                               AuthoringViewController authoringVC) {
//
//        HashMap<String, EditorViewController> editorVCs = authoringVC.getControllers();
//        PathEditorViewController pathVC = (PathEditorViewController) editorVCs.get("path");
//        LevelEditorViewController levelVC = (LevelEditorViewController) editorVCs.get("level");
//        WeaponEditorViewController weaponVC = (WeaponEditorViewController) editorVCs.get("weapon");
//        EnemyEditorViewController enemyVC = (EnemyEditorViewController) editorVCs.get("enemy");
//        TowerEditorViewController towerVC = (TowerEditorViewController) editorVCs.get("tower");
//
//        ModelAuthoringController modelController = new ModelAuthoringController();
//
//        pathVC.setPathDataSource(modelController.getModelController(PathManagerController.class));
//        levelVC.setLevelDataSource(modelController
//                .getModelController(LevelManagerController.class));
//        weaponVC.setWeaponDataSource(modelController
//                .getModelController(WeaponManagerController.class));
//        enemyVC.setEnemyDataSource(modelController
//                .getModelController(EnemyManagerController.class));
//        towerVC.setTowerDataSource(modelController
//                .getModelController(TowerManagerController.class));
//
//    }

    public static void main (String[] args) {
        launch(args);
    }

}

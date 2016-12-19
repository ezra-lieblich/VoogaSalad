package authoring.editorview.enemy;

import authoring.editorview.EditorViewController;
import authoring.editorview.ListCellData;
import authoring.editorview.ListDataSource;
import authoring.editorview.collisioneffects.EffectAuthoringViewController;
import engine.effect.EffectManagerController;
import engine.enemy.*;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public class EnemyAuthoringViewController extends EditorViewController
        implements EnemyAuthoringViewDelegate, ListDataSource {

    private EnemyManagerController enemyDataSource;
    private EffectManagerController effectDataSource;
    private int currentEnemyID;
    private EnemyUpdateView enemyView;

    public EnemyAuthoringViewController (int editorWidth, int editorHeight) {
        enemyView = EnemyAuthoringViewFactory.build(editorWidth, editorHeight);
        enemyView.setDelegate(this);
        enemyView.setEnemyListDataSource(this);
        this.view = enemyView;
    }

    public void setEnemyDataSource (EnemyManagerController source) {
        this.enemyDataSource = source;
        this.enemyDataSource.addTypeBankListener(this.enemyView);
        effectDataSource = enemyDataSource.getEffectManagerController();
        onUserPressedCreateEnemy();
    }

    public void refreshView () {
        enemyView.updateImagePathDisplay(enemyDataSource.getImagePath(currentEnemyID));
        enemyView.updateNameDisplay(enemyDataSource.getName(currentEnemyID));
        enemyView.updateSizeDisplay(enemyDataSource.getSize(currentEnemyID));
        enemyView.updateEnemyDamage(enemyDataSource.getEnemyDamage(currentEnemyID));
        enemyView.updateEnemySpeed(enemyDataSource.getEnemySpeed(currentEnemyID));
        enemyView.updateEnemyRewardMoney(enemyDataSource.getEnemyRewardMoney(currentEnemyID));
        enemyView.updateEnemyRewardPoints(enemyDataSource.getEnemyRewardScore(currentEnemyID));
        enemyView.updateEnemyHealthDisplay(enemyDataSource.getEnemyHealth(currentEnemyID));
    }

    @Override
    public void onUserPressedCreateEnemy () {
        currentEnemyID = enemyDataSource.createType(enemyView);
        refreshView();
    }

    @Override
    public void onUserEnteredEnemySpeed (String enemySpeed) {
        enemyDataSource.setEnemySpeed(currentEnemyID, Double.parseDouble(enemySpeed));
    }

    @Override
    public void onUserEnteredEnemyHealth (String enemyHealth) {
        enemyDataSource.setEnemyHealth(currentEnemyID, Double.parseDouble(enemyHealth));
    }

    @Override
    public void onUserEnteredEnemyDamage (String enemyDamage) {
        enemyDataSource.setEnemyDamage(currentEnemyID, Double.parseDouble(enemyDamage));
    }

    @Override
    public void onUserEnteredEnemyPoints (String enemyRewardPoints) {
        enemyDataSource.setEnemyRewardScore(currentEnemyID, Double.parseDouble(enemyRewardPoints));
    }

    @Override
    public void onUserEnteredEnemyMoney (String enemyRewardMoney) {
        enemyDataSource.setEnemyRewardMoney(currentEnemyID,
                                            Double.parseDouble(enemyRewardMoney));
    }

    @Override
    public void onUserEnteredEnemyImagePath (String enemyImagePath) {
        enemyDataSource.setImagePath(currentEnemyID, enemyImagePath);
    }

    @Override
    public void onUserEnteredEnemyName (String enemyName) {
        enemyDataSource.setName(currentEnemyID, enemyName);
    }

    @Override
    public void onUserPressedDeleteEnemy () {
        int nextID = this.enemyView.getNearestAvailableItemID(currentEnemyID);
        enemyDataSource.deleteType(currentEnemyID);
        currentEnemyID = nextID;
        this.refreshView();
    }

    @Override
    public void onUserEnteredEnemySize (String enemySize) {
        enemyDataSource.setSize(currentEnemyID,
                                Double.parseDouble(enemySize));
    }

    @Override
    public ListCellData getCellDataForSubject (int enemyID) {
        ListCellData cellData = new ListCellData();
        cellData.setName(enemyDataSource.getName(enemyID));
        cellData.setImagePath(enemyDataSource.getImagePath(enemyID));
        cellData.setId(enemyID);
        return cellData;
    }

    @Override
    public void onUserSelectedEnemy (int enemyID) {
        currentEnemyID = enemyID;
        refreshView();
    }

    @Override
    public void onUserPressedAddEffect () {
        EffectAuthoringViewController effectAuthoringView =
                new EffectAuthoringViewController(effectDataSource);
        effectDataSource.createType(effectAuthoringView.getEffectAuthoringView());
        effectAuthoringView.setEffectOptions(effectDataSource.getCreatedTypeIds());
        effectAuthoringView.setAvailClasses(effectDataSource.getAvailableClasses());
        effectAuthoringView.setAvailDataObjects(effectDataSource.getAvailableDataObjects());
        effectAuthoringView.openEffectView();
    }

}

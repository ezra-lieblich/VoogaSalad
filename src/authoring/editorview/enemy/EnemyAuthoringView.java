package authoring.editorview.enemy;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.ListDataSource;
import authoring.editorview.enemy.subviews.EnemyEditorView;
import authoring.editorview.enemy.subviews.EnemyImageBank;
import authoring.editorview.enemy.subviews.editorfields.EnemyHealthField;
import authoring.editorview.enemy.subviews.editorfields.EnemyImageView;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardMoneyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardPointsField;
import authoring.editorview.enemy.subviews.editorfields.EnemySizeField;
import authoring.editorview.enemy.subviews.editorfields.DeleteEnemy;
import authoring.editorview.enemy.subviews.editorfields.EnemyDamageField;
import authoring.editorview.enemy.subviews.editorfields.EnemySpeedField;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * @author Kayla Schulz
 * @author Diane Hadley
 * 
 */

public class EnemyAuthoringView implements IEnemyUpdateView {
    @SuppressWarnings("unused")
    private EnemyAuthoringViewDelegate delegate;
    private BorderPane enemyEditorView;
    private EnemyImageBank enemyBank;
    private EnemyNameField enemyName;
    private EnemySpeedField enemySpeed;
    private EnemyImageView enemyImage;
    private EnemyEditorView enemyEffectView;
    private EnemyDamageField enemyDamage;
    private EnemyHealthField enemyHealth;
    private EnemyRewardMoneyField enemyRewardMoney;
    private EnemyRewardPointsField enemyRewardPoints;
    private EnemySizeField enemySize;
    private DeleteEnemy deleteEnemy;

    public EnemyAuthoringView () {
        String ENEMY_EFFECT_RESOURCE_PATH = "resources/GameAuthoringEnemy";
        ResourceBundle labelsResource = ResourceBundle.getBundle(ENEMY_EFFECT_RESOURCE_PATH);

        enemyEditorView = new BorderPane();
        enemyBank = new EnemyImageBank();
        enemyName = new EnemyNameField(labelsResource);
        enemySpeed = new EnemySpeedField(labelsResource);
        enemyImage = new EnemyImageView(labelsResource);
        enemyDamage = new EnemyDamageField(labelsResource);
        enemyHealth = new EnemyHealthField(labelsResource);
        enemyRewardMoney = new EnemyRewardMoneyField(labelsResource);
        enemyRewardPoints = new EnemyRewardPointsField(labelsResource);
        enemySize = new EnemySizeField(labelsResource);
        deleteEnemy = new DeleteEnemy(labelsResource);
        enemyEffectView =
                new EnemyEditorView(enemyImage, enemyName,
                                    enemySpeed, enemyDamage, enemyHealth, enemyRewardMoney,
                                    enemyRewardPoints, enemySize, deleteEnemy);
        setBorderPane();
    }

    private void setBorderPane () {
        enemyEditorView.setLeft(enemyBank.getInstanceAsNode());
        enemyEditorView.setCenter(enemyEffectView.getInstanceAsNode());
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyEditorView;
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        enemyBank.setDelegate(delegate);
        enemyEffectView.setDelegate(delegate);
        enemyName.setDelegate(delegate);
        enemySpeed.setDelegate(delegate);
        enemyImage.setDelegate(delegate);
        enemyDamage.setDelegate(delegate);
        enemyHealth.setDelegate(delegate);
        enemyRewardMoney.setDelegate(delegate);
        enemyRewardPoints.setDelegate(delegate);
        enemySize.setDelegate(delegate);
        deleteEnemy.setDelegate(delegate);
    }

    @Override
    public void updateEnemySpeed (double speed) {
        this.enemySpeed.updateField(Double.toString(speed));
    }

    @Override
    public void updateEnemyBank (List<Integer> activeEnemies) {
        enemyBank.updateEnemyBank(activeEnemies);
    }

    @Override
    public void createNewEnemy () {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateEnemyHealthDisplay (double enemyHealth) {
        this.enemyHealth.updateField(Double.toString(enemyHealth));
    }

    @Override
    public void updateEnemyDamage (double damage) {
        this.enemyDamage.updateField(Double.toString(damage));
    }

    @Override
    public void updateEnemyRewardMoney (double rewardMoney) {
        this.enemyRewardMoney.updateField(Double.toString(rewardMoney));
    }

    @Override
    public void updateEnemyRewardPoints (double rewardPoints) {
        this.enemyRewardPoints.updateField(Double.toString(rewardPoints));
    }

    @Override
    public void updateNameDisplay (String name) {
        this.enemyName.updateName(name);
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        this.enemyImage.updateEnemyImagePath(imagePath);
    }

    @Override
    public void updateSizeDisplay (double size) {
        this.enemySize.updateField(Double.toString(size));
    }

    @Override
    public void setEnemyListDataSource (ListDataSource source) {
        this.enemyBank.setListDataSource(source);
    }

    @Override
    public void deleteEnemy () {
        enemyEffectView.clearView();
        System.out.println("Getting here");
    }

    @Override
    public void updateBank (List<Integer> ids) {
        this.enemyBank.updateBank(ids);
        System.out.println(ids.size());
        //enemyEffectView.clearView();
    }

    @Override
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub
        
    }

}

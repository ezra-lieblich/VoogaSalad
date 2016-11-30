package authoring.editorview.enemy;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.enemy.subviews.EnemyEffectView;
import authoring.editorview.enemy.subviews.EnemyImageBank;
import authoring.editorview.enemy.subviews.editorfields.EnemyHealthField;
import authoring.editorview.enemy.subviews.editorfields.EnemyImageView;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardMoneyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardPointsField;
import authoring.editorview.enemy.subviews.editorfields.EnemySizeField;
import authoring.editorview.enemy.subviews.editorfields.EnemyCollisionEffectField;
import authoring.editorview.enemy.subviews.editorfields.EnemyDamageField;
import authoring.editorview.enemy.subviews.editorfields.EnemySpeedField;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import authoring.editorview.enemy.subviews.EnemyListDataSource;


/**
 * @author Kayla Schulz
 * @author Diane Hadley
 * 
 */

public class EnemyEditorView implements IEnemyEditorView {
    private EnemyEditorViewDelegate delegate;
    private BorderPane enemyEditorView;
    private EnemyImageBank enemyBank;
    private EnemyNameField enemyName;
    private EnemySpeedField enemySpeed;
    private EnemyImageView enemyImage;
    private EnemyEffectView enemyEffectView;
    private EnemyCollisionEffectField enemyReactions;
    private EnemyDamageField enemyDamage;
    private EnemyHealthField enemyHealth;
    private EnemyRewardMoneyField enemyRewardMoney;
    private EnemyRewardPointsField enemyRewardPoints;
    private EnemySizeField enemySize;

    public EnemyEditorView () throws IOException {
        String ENEMY_EFFECT_RESOURCE_PATH = "resources/GameAuthoringEnemy";
        ResourceBundle labelsResource = ResourceBundle.getBundle(ENEMY_EFFECT_RESOURCE_PATH);
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");

        enemyEditorView = new BorderPane();
        enemyBank = new EnemyImageBank(labelsResource, dialogueBoxResource);
        enemyName = new EnemyNameField(labelsResource);
        enemySpeed = new EnemySpeedField(labelsResource);
        enemyReactions = new EnemyCollisionEffectField(labelsResource);
        enemyImage = new EnemyImageView(labelsResource);
        enemyDamage = new EnemyDamageField(labelsResource);
        enemyHealth = new EnemyHealthField(labelsResource);
        enemyRewardMoney = new EnemyRewardMoneyField(labelsResource);
        enemyRewardPoints = new EnemyRewardPointsField(labelsResource);
        enemySize = new EnemySizeField(labelsResource);
        enemyEffectView =
                new EnemyEffectView(enemyImage, enemyName, enemyReactions,
                                    enemySpeed, enemyDamage, enemyHealth, enemyRewardMoney,
                                    enemyRewardPoints, enemySize);
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
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
        enemyBank.setDelegate(delegate);
        enemyEffectView.setDelegate(delegate);
        enemyName.setDelegate(delegate);
        enemySpeed.setDelegate(delegate);
        enemyImage.setDelegate(delegate);
        enemyReactions.setDelegate(delegate);
        enemyDamage.setDelegate(delegate);
        enemyHealth.setDelegate(delegate);
        enemyRewardMoney.setDelegate(delegate);
        enemyRewardPoints.setDelegate(delegate);
        enemySize.setDelegate(delegate);
    }

    @Override
    public void updateEnemyReactions (String enemyReactions) {
        this.enemyReactions.updateEnemyReaction(enemyReactions);

    }

    @Override
    public void updateEnemySpeed (double speed) {
        this.enemySpeed.updateEnemySpeed(Double.toString(speed));
    }

    @Override
    public void updateEnemyBank (List<Integer> activeEnemies) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createNewEnemy () {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateEnemyHealthDisplay (double enemyHealth) {
        this.enemyHealth.updateEnemyHealth(Double.toString(enemyHealth));
    }

    @Override
    public void updateEnemyDamage (double damage) {
        this.enemyDamage.updateEnemyFrequency(Double.toString(damage));
    }

    @Override
    public void updateEnemyRewardMoney (double rewardMoney) {
        this.enemyRewardMoney.updateEnemyRewardMoney(Double.toString(rewardMoney));
    }

    @Override
    public void updateEnemyRewardPoints (double rewardPoints) {
        this.enemyRewardPoints.updateEnemyRewardPoints(Double.toString(rewardPoints));
    }

    @Override
    public void updateEnemyCollisionEffect (String collisionEffect) {
        this.enemyReactions.updateEnemyReaction(collisionEffect);
    }

    @Override
    public void updateNameDisplay (String name) {
        this.enemyName.updateEnemyName(name);
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        this.enemyImage.updateEnemyImagePath(imagePath);
    }

    @Override
    public void updateSizeDisplay (double size) {
        this.enemySize.updateEnemySize(Double.toString(size));
    }

    @Override
    public void setEnemyListDataSource (EnemyListDataSource source) {
        this.enemyBank.setListDataSource(source);
    }

    @Override
    public void deleteEnemy () {
        // TODO Auto-generated method stub
        
    }

}

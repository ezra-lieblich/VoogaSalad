package authoring.editorview.enemy.subviews;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.editorview.enemy.subviews.editorfields.EnemyFrequencyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyHealthField;
import authoring.editorview.enemy.subviews.editorfields.EnemyImageView;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardMoneyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardPointsField;
import authoring.editorview.enemy.subviews.editorfields.EnemyCollisionEffectField;
import authoring.editorview.enemy.subviews.editorfields.EnemyDamageField;
import authoring.editorview.enemy.subviews.editorfields.EnemySpeedField;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */

public class EnemyEffectView extends PhotoFileChooser implements IEnemyEditorView {

    private ScrollPane enemyEffectView;
    private VBox vbox;
    private EnemyEditorViewDelegate delegate;
    private File chosenFile;

    private EnemyFrequencyField enemyFrequency;
    private EnemyImageView enemyImage;
    private EnemyNameField enemyName;
    private EnemyCollisionEffectField enemyReactions;
    private EnemySpeedField enemySpeed;
    private EnemyDamageField enemyDamage;
    private EnemyHealthField enemyHealth;
    private EnemyRewardMoneyField enemyRewardMoney;
    private EnemyRewardPointsField enemyRewardPoints;

    private ResourceBundle labelsResource;
    private final String ENEMY_EFFECT_RESOURCE_PATH = "resources/GameAuthoringEnemy";

    public EnemyEffectView (EnemyFrequencyField enemyFrequency,
                            EnemyImageView enemyImage,
                            EnemyNameField enemyName,
                            EnemyCollisionEffectField enemyReactions,
                            EnemySpeedField enemySpeed,
                            EnemyDamageField enemyDamage,
                            EnemyHealthField enemyHealth,
                            EnemyRewardMoneyField enemyRewardMoney,
                            EnemyRewardPointsField enemyRewardPoints) {
        enemyEffectView = new ScrollPane();
        vbox = new VBox(10);
        enemyEffectView.setContent(vbox);

        this.enemyFrequency = enemyFrequency;
        this.enemyImage = enemyImage;
        this.enemyName = enemyName;
        this.enemyReactions = enemyReactions;
        this.enemySpeed = enemySpeed;
        this.enemyDamage = enemyDamage;
        this.enemyHealth = enemyHealth;
        this.enemyRewardMoney = enemyRewardMoney;
        this.enemyRewardPoints = enemyRewardPoints;

        labelsResource = ResourceBundle.getBundle(ENEMY_EFFECT_RESOURCE_PATH);

        buildViewComponents();
    }

    private void buildViewComponents () {
        Node myImageView = enemyImage.getInstanceAsNode();

        vbox.getChildren().add(myImageView);
        vbox.getChildren().add(ButtonFactory.makeButton(labelsResource.getString("Image"),
                                                        e -> {
                                                            try {
                                                                selectFile("Select new enemy image",
                                                                           "Photos: ");
                                                            }
                                                            catch (IOException e1) {
                                                                DialogueBoxFactory
                                                                        .createErrorDialogueBox("Unable to open file chooser",
                                                                                                "Try again");
                                                            }
                                                        }));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Name"),
                                                           enemyName.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Frequency"),
                                                           enemyFrequency.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Reaction"),
                                                           enemyReactions.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Speed"),
                                                           enemySpeed.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Damage"),
                                                           enemyDamage.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Health"),
                                                           enemyHealth.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("RewardMoney"),
                                                           enemyRewardMoney.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("RewardPoints"),
                                                           enemyRewardPoints.getInstanceAsNode()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyEffectView;
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        chosenFile = chooseFile.showOpenDialog(new Stage());

    }

}

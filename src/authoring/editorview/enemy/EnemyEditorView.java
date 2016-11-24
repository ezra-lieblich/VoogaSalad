package authoring.editorview.enemy;

import java.io.IOException;
import authoring.editorview.enemy.subviews.EnemyEffectView;
import authoring.editorview.enemy.subviews.EnemyImageBank;
import authoring.editorview.enemy.subviews.editorfields.EnemyFrequencyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyImageView;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import authoring.editorview.enemy.subviews.editorfields.EnemyReactionsView;
import authoring.editorview.enemy.subviews.editorfields.EnemySpeedField;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


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
    private EnemyFrequencyField enemyFrequency;
    private EnemyReactionsView enemyReactions;

    public EnemyEditorView () throws IOException {
        enemyEditorView = new BorderPane();
        enemyBank = new EnemyImageBank();
        enemyName = new EnemyNameField();
        enemySpeed = new EnemySpeedField();
        enemyFrequency = new EnemyFrequencyField();
        enemyReactions = new EnemyReactionsView();
        enemyImage = new EnemyImageView();
        enemyEffectView = new EnemyEffectView(enemyFrequency, enemyImage, enemyName, enemyReactions, enemySpeed);
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
        enemyName.setDelegate(delegate);
        enemySpeed.setDelegate(delegate);
        enemyImage.setDelegate(delegate);
        enemyFrequency.setDelegate(delegate);
        enemyReactions.setDelegate(delegate);
    }

}

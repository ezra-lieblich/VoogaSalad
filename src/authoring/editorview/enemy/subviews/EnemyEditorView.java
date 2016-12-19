package authoring.editorview.enemy.subviews;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.EnemySubView;
import authoring.editorview.enemy.subviews.editorfields.EnemyHealthField;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardMoneyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyRewardPointsField;
import authoring.editorview.enemy.subviews.editorfields.EnemySizeField;
import authoring.editorview.enemy.subviews.editorfields.AddEnemyEffectView;
import authoring.editorview.enemy.subviews.editorfields.DeleteEnemy;
import authoring.editorview.enemy.subviews.editorfields.EnemyDamageField;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */

public class EnemyEditorView extends PhotoFileChooser implements EnemySubView {

    private AnchorPane rootBuffer;
    private VBox vbox;
    private EnemyAuthoringViewDelegate delegate;
    private File chosenFile;

    private DeleteEnemy deleteEnemy;
    private EnemyNameField enemyName;
    private EnemyDamageField enemyDamage;
    private EnemyHealthField enemyHealth;
    private EnemyRewardMoneyField enemyRewardMoney;
    private EnemyRewardPointsField enemyRewardPoints;
    private EnemySizeField enemySize;
    private AddEnemyEffectView addEnemyEffect;
    private Class<?> enemySpeed;
    private Object enemySpeedObject;

    private ResourceBundle labelsResource;
    private static final double BUFFER = 10.0;

    public EnemyEditorView (ResourceBundle labelsResource, Map<String, Class<?>> myClasses) {
        rootBuffer = new AnchorPane();
        vbox = new VBox(10);
        rootBuffer.getChildren().add(vbox);

        this.enemySpeed = myClasses.get("speed");
        try {
            enemySpeedObject = enemySpeed.getConstructor(ResourceBundle.class).newInstance(labelsResource);
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.enemyName = new EnemyNameField(labelsResource);
        this.enemyDamage = new EnemyDamageField(labelsResource);
        this.enemyHealth = new EnemyHealthField(labelsResource);
        this.enemyRewardMoney = new EnemyRewardMoneyField(labelsResource);
        this.enemyRewardPoints = new EnemyRewardPointsField(labelsResource);
        this.enemySize = new EnemySizeField(labelsResource);
        this.deleteEnemy = new DeleteEnemy(labelsResource);
        this.addEnemyEffect = new AddEnemyEffectView(labelsResource);

        this.labelsResource = labelsResource;

        buildViewComponents();
    }

    private void buildViewComponents () {

        AnchorPane.setLeftAnchor(vbox, BUFFER);
        AnchorPane.setTopAnchor(vbox, BUFFER);

        rootBuffer
                .setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID,
                                                       CornerRadii.EMPTY, new BorderWidths(0.5))));
        rootBuffer
                .setBackground(new Background(new BackgroundFill(Color.rgb(235, 235, 235),
                                                                 CornerRadii.EMPTY, Insets.EMPTY)));

        Button imageButton = ButtonFactory.makeButton(labelsResource.getString("Image"),
                                                      e -> {
                                                          try {
                                                              selectFile("Select new enemy image",
                                                                         "Photos: ");
                                                          }
                                                          catch (Exception e1) {
                                                              DialogueBoxFactory
                                                                      .createErrorDialogueBox("Unable to open file chooser",
                                                                                              "Try again");
                                                          }
                                                      });
        imageButton.setPrefWidth(280);
        

        try {
            Method method = enemySpeed.getDeclaredMethod("getInstanceAsNode", null);
            vbox.getChildren().add((Node) method.invoke(enemySpeedObject, null));
        }
        catch ( IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        
        vbox.getChildren().addAll(
                                  imageButton,
                                  enemyName.getInstanceAsNode(),
                                  enemySize.getInstanceAsNode(),
                                  enemyDamage.getInstanceAsNode(),
                                  enemyHealth.getInstanceAsNode(),
                                  enemyRewardMoney.getInstanceAsNode(),
                                  enemyRewardPoints.getInstanceAsNode(),
                                  addEnemyEffect.getInstanceAsNode(),
                                  deleteEnemy.getInstanceAsNode());
    }
    

    public void clearView () {
        vbox.getChildren().clear();
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        enemyName.setDelegate(delegate);
        enemyDamage.setDelegate(delegate);
        enemyHealth.setDelegate(delegate);
        enemyRewardMoney.setDelegate(delegate);
        enemyRewardPoints.setDelegate(delegate);
        enemySize.setDelegate(delegate);
        deleteEnemy.setDelegate(delegate);
        addEnemyEffect.setDelegate(delegate);
        
        try { 
            Class[] methodParameters = new Class[] { EnemyAuthoringViewDelegate.class };
            Method method = enemySpeed.getDeclaredMethod("setDelegate", methodParameters);
            Object[] params = new Object[] { delegate };
            method.invoke(enemySpeedObject, params);
        }
        catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public Node getInstanceAsNode () {
        return rootBuffer;
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            delegate.onUserEnteredEnemyImagePath(chosenFile.toURI().getPath());
        }
    }
}

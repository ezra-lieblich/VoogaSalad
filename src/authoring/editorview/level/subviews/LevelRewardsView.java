package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class LevelRewardsView implements ILevelSetView {

    private VBox vbox;
    private LevelEditorViewDelegate delegate;

    private TextField rewardHealthTextField;
    private TextField rewardMoneyTextField;
    private TextField rewardPointsTextField;
    private double rewardHealth;
    private double rewardMoney;
    private double rewardPoints;

    // TODO: reduce duplicated code

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";
    private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    public LevelRewardsView () {
        vbox = new VBox(10);
        makeHealthRewardTextField();
        makeMoneyRewardTextField();
        makePointsRewardTextField();
    }

    @Override
    public Node getInstanceAsNode () {
        return vbox;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void makeHealthRewardTextField () {
        rewardHealthTextField = TextFieldFactory.makeTextField("",
                                                               e -> submitRewardHealth(rewardHealthTextField
                                                                       .getText()));
        rewardHealthTextField.setMaxWidth(75);
        HBox rewardHealthBox =
                BoxFactory.createHBoxWithLabelandNode(
                                                      levelResource
                                                              .getString("RewardHealthTextField"),
                                                      rewardHealthTextField);

        vbox.getChildren().add(rewardHealthBox);

    }

    private void makeMoneyRewardTextField () {
        rewardMoneyTextField = TextFieldFactory.makeTextField("",
                                                              e -> submitRewardMoney(rewardMoneyTextField
                                                                      .getText()));
        rewardMoneyTextField.setMaxWidth(75);
        HBox rewardMoneyBox =
                BoxFactory
                        .createHBoxWithLabelandNode(levelResource.getString("RewardMoneyTextField"),
                                                    rewardMoneyTextField);

        vbox.getChildren().add(rewardMoneyBox);

    }

    private void makePointsRewardTextField () {
        rewardPointsTextField = TextFieldFactory.makeTextField("",
                                                               e -> submitRewardPoints(rewardPointsTextField
                                                                       .getText()));
        rewardPointsTextField.setMaxWidth(75);
        HBox rewardPointsBox =
                BoxFactory.createHBoxWithLabelandNode(
                                                      levelResource
                                                              .getString("RewardPointsTextField"),
                                                      rewardPointsTextField);

        vbox.getChildren().add(rewardPointsBox);

    }

    private void submitRewardHealth (String healthString) {
        delegate.onUserEnteredRewardHealth(healthString);
    }

    private void submitRewardMoney (String moneyString) {
        delegate.onUserEnteredRewardMoney(moneyString);
    }

    private void submitRewardPoints (String pointsString) {
        delegate.onUserEnteredRewardPoints(pointsString);
    }

    public void setRewardHealth (double rewardHealth) {
        this.rewardHealth = rewardHealth;
        rewardHealthTextField.setText(Double.toString(rewardHealth));
    }

    public void setRewardMoney (double rewardMoney) {
        this.rewardMoney = rewardMoney;
        rewardMoneyTextField.setText(Double.toString(rewardMoney));
    }

    public void setRewardPoints (double points) {
        this.rewardPoints = points;
        rewardPointsTextField.setText(Double.toString(rewardPoints));
    }
}

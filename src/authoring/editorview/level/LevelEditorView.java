package authoring.editorview.level;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.editorview.level.subviews.LevelChooserView;
import authoring.editorview.level.subviews.LevelDesign;
import authoring.editorview.level.subviews.LevelEnemyFrequencyField;
import authoring.editorview.level.subviews.LevelNameView;
import authoring.editorview.level.subviews.LevelRewardsView;
import authoring.editorview.level.subviews.LevelTransitionTimeField;
import authoring.editorview.level.subviews.CreateNewLevelView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;


public class LevelEditorView implements ILevelEditorView {

    private VBox vbox;
    private LevelChooserView levelChooser;
    private LevelDesign levelDesign;
    private LevelRewardsView levelRewardsView;
    private LevelNameView levelNameView;
    private CreateNewLevelView createNewLevelView;
    private LevelTransitionTimeField transitionTimeField;
    private LevelEnemyFrequencyField enemyFrequencyField;
    private ResourceBundle levelsResource =
            ResourceBundle.getBundle("resources/GameAuthoringLevels");

    LevelEditorView (int width, int height) {
        this.vbox = new VBox(10);
        this.levelChooser = new LevelChooserView(levelsResource);
        this.levelDesign = new LevelDesign(levelsResource);
        this.levelRewardsView = new LevelRewardsView(levelsResource);
        this.levelNameView = new LevelNameView(levelsResource);
        this.createNewLevelView = new CreateNewLevelView(levelsResource);
        this.transitionTimeField = new LevelTransitionTimeField(levelsResource);
        this.enemyFrequencyField = new LevelEnemyFrequencyField(levelsResource);
        setLevelView();
    }

    @Override
    public Node getInstanceAsNode () {
        return vbox;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        levelNameView.setDelegate(delegate);
        levelRewardsView.setDelegate(delegate);
        levelChooser.setDelegate(delegate);
        levelDesign.setDelegate(delegate);
        createNewLevelView.setDelegate(delegate);
        transitionTimeField.setDelegate(delegate);
        enemyFrequencyField.setDelegate(delegate);
    }

    private void setLevelView () {
        vbox.getChildren().addAll(createNewLevelView.getInstanceAsNode(),
                                  levelChooser.getInstanceAsNode(),
                                  levelNameView.getInstanceAsNode(),
                                  levelRewardsView.getInstanceAsNode(),
                                  levelDesign.getInstanceAsNode(),
                                  transitionTimeField.getInstanceAsNode(),
                                  enemyFrequencyField.getInstanceAsNode());
    }

    @Override
    public void updateNameDisplay (String name) {
        levelNameView.setLevelName(name);
        // also level chooser

    }

    @Override
    public void updateEnemy (Map<Integer, Integer> enemyCounts) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateRewardPoints (double winPoints) {
        levelRewardsView.setRewardPoints(Double.toString(winPoints));

    }

    @Override
    public void updateRewardHealth (double winHealth) {
        levelRewardsView.setRewardHealth(Double.toString(winHealth));

    }

    @Override
    public void updateRewardMoney (double winMoney) {
        levelRewardsView.setRewardMoney(Double.toString(winMoney));

    }

    @Override
    public void updatePath (int pathID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTransitionTime (double time) {
        transitionTimeField.updateTransitionTimeField(Double.toString(time));
    }

    @Override
    public void updateEnemyFrequency (double enemyFrequency) {
        enemyFrequencyField.updateEnemyFrequencyField(Double.toString(enemyFrequency));
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        // Don't worry about this right now

    }

    @Override
    public void updateSizeDisplay (double size) {
        // Don't worry about this right now
    }

    @Override
    public void updateBank (List<Integer> ids) {
        // TODO Auto-generated method stub
        System.out.println("No level bank currently implemented");
    }

}

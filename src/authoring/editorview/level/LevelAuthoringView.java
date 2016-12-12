package authoring.editorview.level;

import java.util.List;
import java.util.ResourceBundle;
import authoring.utilityfactories.ButtonFactory;
import engine.level.wave.Wave;
import engine.level.wave.WaveString;
import authoring.editorview.ListDataSource;
import authoring.editorview.level.subviews.editorfields.AddLevelEffectView;
import authoring.editorview.level.subviews.editorfields.CreateNewLevelView;
import authoring.editorview.level.subviews.editorfields.LevelNameView;
import authoring.editorview.level.subviews.editorfields.LevelRewardsView;
import authoring.editorview.level.subviews.editorfields.LevelTransitionTimeField;
import authoring.editorview.level.subviews.editorfields.PreviewLevelView;
import authoring.editorview.level.subviews.editorfields.WaveTableView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class LevelAuthoringView implements LevelUpdateView {

    private LevelAuthoringViewDelegate delegate;

    private VBox vbox;
    private LevelRewardsView levelRewardsView;
    private LevelNameView levelNameView;
    private CreateNewLevelView createNewLevelView;
    private PreviewLevelView previewLevelView;
    private LevelTransitionTimeField transitionTimeField;
    private WaveTableView waveTableView;
    private AddLevelEffectView addLevelEffect;

    private ResourceBundle levelsResource =
            ResourceBundle.getBundle("resources/GameAuthoringLevels");

    LevelAuthoringView (int width, int height) {
        this.vbox = new VBox(10);
        this.levelRewardsView = new LevelRewardsView(levelsResource);
        this.levelNameView = new LevelNameView(levelsResource);
        this.createNewLevelView = new CreateNewLevelView(levelsResource);
        this.transitionTimeField = new LevelTransitionTimeField(levelsResource);
        this.waveTableView = new WaveTableView(levelsResource, width);
        this.previewLevelView = new PreviewLevelView();
        this.addLevelEffect = new AddLevelEffectView(levelsResource);
        setLevelView();
    }

    @Override
    public Node getInstanceAsNode () {
        return vbox;
    }

    @Override
    public void setDelegate (LevelAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        levelNameView.setDelegate(delegate);
        levelRewardsView.setDelegate(delegate);
        createNewLevelView.setDelegate(delegate);
        transitionTimeField.setDelegate(delegate);
        waveTableView.setDelegate(delegate);
        addLevelEffect.setDelegate(delegate);
    }

    private void setLevelView () {
        vbox.getChildren().addAll(createNewLevelView.getInstanceAsNode(),
        						  
                                  levelNameView.getInstanceAsNode(),
                                  levelRewardsView.getInstanceAsNode(),
                                  transitionTimeField.getInstanceAsNode(),
                                  addLevelEffect.getInstanceAsNode(),
                                  ButtonFactory.makeButton("New Wave",
                                                           e -> delegate.onUserEnteredAddWave()),
                                  previewLevelView.getInstanceAsNode(),
                                  waveTableView.getInstanceAsNode()
                          
        							);
    }

    @Override
    public void updateNameDisplay (String name) {
        levelNameView.updateName(name);
        // also level chooser

    }

    @Override
    public void updateRewardScore (double winScore) {
        levelRewardsView.setRewardScore(Double.toString(winScore));
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
    public void updateTransitionTime (double time) {
        transitionTimeField.updateTransitionTimeField(Double.toString(time));
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
        System.out.println("No level bank currently implemented");
    }

    @Override
    public void updateLevelOptions (List<Integer> levelOptions) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLevelListDataSource (ListDataSource source) {
        System.out.println("No level bank currently implemented");
    }

    // WAVE

    @Override
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateWaves (List<WaveString> waves) {
        waveTableView.updateWaveTableView(waves);
    }

    @Override
    public Integer getNearestAvailableItemID (int id) {
        System.out.println("No level bank implemented");
        return null;
    }

}

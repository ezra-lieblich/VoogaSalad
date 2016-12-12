package authoring.editorview.level;

import java.util.List;
import java.util.ResourceBundle;
import authoring.utilityfactories.ButtonFactory;
import engine.level.wave.Wave;
import engine.level.wave.WaveString;
import authoring.editorview.ListDataSource;
import authoring.editorview.level.subviews.LevelBank;
import authoring.editorview.level.subviews.LevelEditorView;
import authoring.editorview.level.subviews.editorfields.AddLevelEffectView;
import authoring.editorview.level.subviews.editorfields.CreateNewLevelView;
import authoring.editorview.level.subviews.editorfields.LevelNameView;
import authoring.editorview.level.subviews.editorfields.LevelRewardsView;
import authoring.editorview.level.subviews.editorfields.LevelTransitionTimeField;
import authoring.editorview.level.subviews.editorfields.PreviewLevelView;
import authoring.editorview.level.subviews.editorfields.WaveTableView;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class LevelAuthoringView implements LevelUpdateView {

    private static final int EDITOR_SIZE = 300;

	
    private LevelAuthoringViewDelegate delegate;

    private GridPane levelView;
    private VBox vbox;
    private LevelRewardsView levelRewardsView;
    private LevelNameView levelNameView;
    private LevelBank levelBank;
    private CreateNewLevelView createNewLevelView;
    private PreviewLevelView previewLevelView;
    private LevelTransitionTimeField transitionTimeField;
    private WaveTableView waveTableView;
    private AddLevelEffectView addLevelEffect;
    private LevelEditorView levelEditorView;

    private ResourceBundle levelsResource =
            ResourceBundle.getBundle("resources/GameAuthoringLevels");

    LevelAuthoringView (int width, int height) {
    	this.levelView = new GridPane();
        this.vbox = new VBox(10);
        this.levelBank = new LevelBank();
        this.levelRewardsView = new LevelRewardsView(levelsResource);
        this.levelNameView = new LevelNameView(levelsResource);
        //should be with bank
        this.createNewLevelView = new CreateNewLevelView(levelsResource);
        this.transitionTimeField = new LevelTransitionTimeField(levelsResource);
        this.waveTableView = new WaveTableView(levelsResource, width);
        this.previewLevelView = new PreviewLevelView();
        this.addLevelEffect = new AddLevelEffectView(levelsResource);
       // this.levelEditorView = new LevelEditorView(levelRewardsView, levelNameView, transitionTimeField,
        								//waveTableView, previewLevelView, addLevelEffect);
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
    	ColumnConstraints bankColumn = new ColumnConstraints();
        bankColumn.setMinWidth(150);

        ColumnConstraints editorColumn = new ColumnConstraints();
        editorColumn.setPrefWidth(400);

        ColumnConstraints previewColumn = new ColumnConstraints();

        RowConstraints fullRow = new RowConstraints();

        fullRow.setMinHeight(700);
        
        levelView.getColumnConstraints().addAll(bankColumn, editorColumn, previewColumn);
        levelView.getRowConstraints().add(fullRow);
        
        levelView.add(levelBank.getInstanceAsNode(), 0, 0);
        //levelView.add(levelEditorView.getInstanceAsNode(), 1, 0);
        //levelView.add(levelImageView.getInstanceAsNode(), 2, 0);
        levelView.add(levelNameView.getInstanceAsNode(), 1, 1);
        vbox.getChildren().addAll(createNewLevelView.getInstanceAsNode(),
        						  
        		
        						  //lev.add(enemyBank.getInstanceAsNode(), 0, 0);
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
        this.levelBank.updateBank(ids);
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

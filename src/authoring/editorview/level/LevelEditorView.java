package authoring.editorview.level;

import authoring.editorview.level.subviews.LevelChooser;
import authoring.editorview.level.subviews.LevelDesign;
import authoring.editorview.level.subviews.LevelRewards;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class LevelEditorView implements ILevelEditorView {
    private LevelEditorViewDelegate delegate;
    private BorderPane levelPane;
    private LevelChooser levelChooser;
    private LevelDesign levelDesign;
    private LevelRewards levelRewards;

    LevelEditorView (int width, int height) {
        levelPane = new BorderPane();
        levelChooser = new LevelChooser();
        levelDesign = new LevelDesign();
        levelRewards = new LevelRewards();
    }

    @Override
    public Node getInstanceAsNode () {
        return levelPane;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}

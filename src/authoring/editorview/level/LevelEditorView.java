package authoring.editorview.level;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class LevelEditorView implements ILevelEditorView {
    private LevelEditorViewDelegate delegate;
    private BorderPane levelPane;

    LevelEditorView (int width, int height) {
        levelPane = new BorderPane();
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

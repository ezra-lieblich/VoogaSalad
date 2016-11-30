package authoring.editorview.level;

import authoring.editorview.level.subviews.LevelChooserView;
import authoring.editorview.level.subviews.LevelDesign;
import authoring.editorview.level.subviews.LevelRewards;
import javafx.scene.Node;
import javafx.scene.layout.VBox;


public class LevelEditorView implements ILevelEditorView {
    private LevelEditorViewDelegate delegate;
    private VBox root;
    private LevelChooserView levelChooser;
    private LevelDesign levelDesign;
    private LevelRewards levelRewards;

    LevelEditorView (int width, int height) {
        this.root = new VBox();
        this.levelChooser = new LevelChooserView();
        this.levelDesign = new LevelDesign();
        this.levelRewards = new LevelRewards();
        setLevelView();
       
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }
    
    private void setLevelView(){
	       
        root.getChildren().addAll(levelChooser.getInstanceAsNode(), levelRewards.getInstanceAsNode(),
        		levelDesign.getInstanceAsNode());
       
            
    }

}

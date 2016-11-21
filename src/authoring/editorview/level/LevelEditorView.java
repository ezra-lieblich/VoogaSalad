package authoring.editorview.level;

import javafx.scene.Node;

public class LevelEditorView implements ILevelEditorView {
	private LevelEditorViewDelegate delegate;
    LevelEditorView(int width, int height) {
        
    }
    
    @Override
    public Node getInstanceAsNode () {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public void setDelegate(LevelEditorViewDelegate delegate) {
		this.delegate = delegate;
	}

}

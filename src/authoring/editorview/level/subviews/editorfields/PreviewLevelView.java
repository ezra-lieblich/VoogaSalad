package authoring.editorview.level.subviews.editorfields;



import authoring.editorview.level.LevelAuthoringViewDelegate;
import authoring.editorview.level.LevelSetView;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class PreviewLevelView implements LevelSetView{

	private Button previewButton;
	private LevelAuthoringViewDelegate delegate;
	
	public PreviewLevelView(){
		buildPreviewButton();
	}

	@Override
	public Node getInstanceAsNode() {
		return previewButton;
	}

	
	private void buildPreviewButton(){
		previewButton = ButtonFactory.makeButton("Preview Level", null);
	}

	@Override
	public void setDelegate(LevelAuthoringViewDelegate delegate) {
		this.delegate = delegate;
		
	}
	
}

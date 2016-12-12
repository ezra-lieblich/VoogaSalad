package authoring.editorview.level.subviews.editorfields;


import authoring.editorview.INodeView;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class PreviewLevelView implements INodeView{

	private Button previewButton;
	
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
	
}

package authoring.editorview.level.subviews;


import authoring.editorview.INodeView;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
		previewButton = ButtonFactory.makeButton("Preview Level", e -> {
			Stage s = new Stage(); 
			s.setHeight(600);
			s.setWidth(600);
			s.show(); 
		});
	}
	
}

package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.path.PathSetView;
import authoring.editorview.path.PathAuthoringViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NewPathView implements PathSetView {

	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private PathAuthoringViewDelegate delegate;
	private VBox root;
	
	public NewPathView(){
		this.root = new VBox();
		buildViewComponents();
	}
	
	@Override
	public Node getInstanceAsNode(){
		return root;
	}
	
	@Override
	public void setDelegate(PathAuthoringViewDelegate delegate){
		this.delegate = delegate;
	}

	private void buildViewComponents() {		
		Button createPathButton =
				ButtonFactory.makeButton(pathResource.getString("NewPathButton"),
                 e -> {
					createNewPath();		
				});
		createPathButton.setPrefWidth(280);
	    root.getChildren().add(createPathButton);
	    createPathButton.setFocusTraversable(false);
	}
	
	private void createNewPath(){
		int activeID = delegate.onUserEnteredCreatePath();				
		delegate.onUserEnteredEditPath(activeID);
		
	}
}

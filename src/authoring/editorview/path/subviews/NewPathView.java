package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.path.IPathSetView;
import authoring.editorview.path.PathEditorViewDelegate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NewPathView implements IPathSetView {

	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private PathEditorViewDelegate delegate;
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
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}

	private void buildViewComponents() {
		
		Button createPathButton =
				createButton(pathResource.getString("NewPathButton"),
                 e -> {
					createNewPath();		
				});
	    root.getChildren().add(createPathButton);
	    createPathButton.setTranslateY(5);
	    createPathButton.setTranslateX(5);
	    createPathButton.setFocusTraversable(false);
	}
	
	private void createNewPath(){
		int activeID = delegate.onUserEnteredCreatePath();				
		delegate.onUserEnteredEditPath(activeID);
		
	}
	 
    private Button createButton (String label, EventHandler<ActionEvent> event) {
        Button button = new Button(label);
        button.setOnAction(event);
        return button;
    }
}

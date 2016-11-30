package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.path.PathEditorViewDelegate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NewPathView {

	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private PathEditorViewDelegate delegate;
	private VBox root;
	private int activePathID;
	
	public NewPathView(){
		this.root = new VBox();
		buildViewComponents();
	}
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActivePathId(int pathID){
		this.activePathID = pathID;
	}
	
	
	private void buildViewComponents() {
		
		Button createPathButton =
				createButton(pathResource.getString("NewPathButton"),
                 e -> {
					//createNewPath();		
				});
	    root.getChildren().add(createPathButton);
	    createPathButton.setTranslateY(5);
	    createPathButton.setTranslateX(5);
	    createPathButton.setFocusTraversable(false);
	}
	
	public void createNewPath(){
		delegate.onUserEnteredCreatePath();		
		
		delegate.onUserEnteredEditPath(activePathID);
		
	}
	 
    private Button createButton (String label, EventHandler<ActionEvent> event) {
        Button button = new Button(label);
        button.setOnAction(event);
        return button;
    }
}

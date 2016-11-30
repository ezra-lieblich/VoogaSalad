package authoring.editorview.level.subviews;

import java.util.ResourceBundle;

import authoring.editorview.level.LevelEditorViewDelegate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NewLevelView {

	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";	
	private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	
	private LevelEditorViewDelegate delegate;
	private VBox root;
	private int activeLevelID;
	
	public NewLevelView(){
		this.root = new VBox();
		buildViewComponents();
	}
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	public void setDelegate(LevelEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActiveLevelId(int levelID){
		this.activeLevelID = levelID;
	}
	
	
	private void buildViewComponents() {
		
		Button createLevelButton =
				createButton(levelResource.getString("NewLevelButton"),
                 e -> {
					createNewLevel();		
				});
	    root.getChildren().add(createLevelButton);
	    createLevelButton.setTranslateY(5);
	    createLevelButton.setTranslateX(5);
	    createLevelButton.setFocusTraversable(false);
	}
	
	public void createNewLevel(){
		delegate.onUserEnteredCreateLevel();				
		delegate.onUserEnteredEditLevel(activeLevelID);
		
	}
	 
    private Button createButton (String label, EventHandler<ActionEvent> event) {
        Button button = new Button(label);
        button.setOnAction(event);
        return button;
    }
	
	
}

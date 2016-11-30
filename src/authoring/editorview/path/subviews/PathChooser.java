package authoring.editorview.path.subviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.util.ResourceBundle;

import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;

public class PathChooser{
	
	private VBox root;
	private PathEditorViewDelegate delegate;
	
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	
	public PathChooser(){
		this.root = new VBox();
		buildViewComponents();
		
			   
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public Node getInstanceAsNode () {
		return root;
	}
	
	public void updatePathComboBox(){
		
	}
	
	private void buildViewComponents(){
		
		ObservableList<Object> pathList= FXCollections.observableArrayList();
		
		//TODO: change event
		ComboBox<Object> pathComboBox = ComboBoxFactory.makeComboBox(
				pathResource.getString("ComboBoxText"), 
				e -> updatePathComboBox(), 
				pathList);
		pathComboBox.setTranslateX(5);
		root.getChildren().add(pathComboBox);
	}

	
	
}

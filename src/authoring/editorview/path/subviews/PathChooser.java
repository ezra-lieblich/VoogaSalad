package authoring.editorview.path.subviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import authoring.editorview.path.IPathSetView;
import authoring.editorview.path.NameIdPair;
import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;

/**
 * 
 * @author Diane Hadley
 *
 */

public class PathChooser implements IPathSetView{
	
	private VBox root;
	private PathEditorViewDelegate delegate;
	private List<NameIdPair> nameIdList;
	private ObservableList<Object> pathList;
	private ComboBox<Object> pathComboBox;
	
	private int activePathID;
	
	
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	//TODO: delete path
	
	public PathChooser(){
		this.root = new VBox();
		buildViewComponents();
		//TODO: add binding
		nameIdList = new ArrayList<NameIdPair>();
		
			   
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActivePathId(int pathID){
		this.activePathID = pathID;
	}
	
	public Node getInstanceAsNode () {
		return root;
	}
		
	public void updatePathComboBox(String pathName){		
		NameIdPair newPair = new NameIdPair(pathName, activePathID);
		boolean newPath = true;
		for (NameIdPair pair : nameIdList){		
			if (pair.getId() == activePathID){
				newPath = false;
				nameIdList.set(nameIdList.indexOf(pair), newPair);
				pathList.set(pathList.indexOf(pair.getName()), pathName);				
				break;
			}
		}	
		if (newPath){
			pathList.add(pathName);
			nameIdList.add(newPair);
		}
		pathComboBox.setValue(pathName);
	}
	
	private void setEditView(String pathName){
		for (NameIdPair pair : nameIdList){
			if (pair.getName() == pathName){
				int id = pair.getId();
				delegate.onUserEnteredEditPath(id);
				break;
			}
		}	
	}
	
	private void buildViewComponents(){		
		pathList = FXCollections.observableArrayList();
		pathComboBox = ComboBoxFactory.makeComboBox(pathResource.getString("ComboBoxText"), 
				e -> setEditView(pathComboBox.getValue().toString()), pathList);
		
		pathComboBox.setTranslateX(5);
		root.getChildren().add(pathComboBox);
	}

	
	
}

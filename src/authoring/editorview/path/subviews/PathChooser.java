package authoring.editorview.path.subviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import authoring.editorview.path.NameIdPair;
import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.DialogueBoxFactory;

/**
 * 
 * @author Diane Hadley
 *
 */

public class PathChooser{
	
	private VBox root;
	private PathEditorViewDelegate delegate;
	private List<NameIdPair> nameIdList;
	private ObservableList<String> pathList;
	private ComboBox<String> pathComboBox;
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
		
		//boolean duplicateName = checkIfDuplicateName(pathName);
		//if (!duplicateName){
			pathList.add(pathName);
			NameIdPair newPair = new NameIdPair(pathName, activePathID);
			nameIdList.add(newPair);
			for (NameIdPair pair : nameIdList){
				if (pair != newPair && pair.getId() == activePathID){
					nameIdList.remove(pair);
					pathList.remove(pair.getName());
					break;
				}
			}		
		//}
		//else {
			//Alert duplicateNameAlert = DialogueBoxFactory.createErrorDialogueBox("This path name is already used", "Duplicate name");
			//duplicateNameAlert.show();
		//}
			
		
		
	}
	
//	private boolean checkIfDuplicateName(String pathName){
//		boolean duplicate = false;
//		for (NameIdPair pair : nameIdList){
//			if (pair.getName() == pathName){
//				duplicate = true;
//				break;
//			}
//		}
//		return duplicate;
//	}
	
	private void setEditView(String pathName){
		for (NameIdPair pair : nameIdList){
			if (pair.getName() == pathName){
				int id = pair.getId();
				delegate.onUserEnteredEditPath(id);
				break;
			}
		}	
		System.out.println(pathComboBox.getValue());
		System.out.println(pathList);
	}
	
	private void buildViewComponents(){
		
		pathList = FXCollections.observableArrayList();
		
		pathComboBox = new ComboBox<String>(pathList);
		pathComboBox.setOnAction(e -> setEditView(pathComboBox.getValue()));
        pathComboBox.setPromptText(pathResource.getString("ComboBoxText"));
		
		
//		pathComboBox = ComboBoxFactory.makeComboBox(pathResource.getString("ComboBoxText"), 
//				e -> setEditView(pathComboBox.getValue().toString()), pathList);
		
		pathComboBox.setTranslateX(5);
		root.getChildren().add(pathComboBox);
	}

	
	
}

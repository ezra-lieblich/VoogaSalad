package authoring.editorview.gamesettings.subviews;

import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.GridFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class GamePathTypeView {

	private ObservableList<Object> pathTypeList;
	private ComboBox<Object> pathTypeComboBox;
	private GridPane root;
	
	public GamePathTypeView(){
		makeComboBox();
	}
	
	private void makeComboBox(){
		
		pathTypeList = FXCollections.observableArrayList();
		pathTypeList.addAll("Free", "Set");
		pathTypeComboBox = ComboBoxFactory.makeComboBox("" , 
				e -> setEditView(pathTypeComboBox.getValue().toString()), pathTypeList);
		pathTypeComboBox.setPrefWidth(105);
		root = GridFactory.createRowWithLabelandNode("Path type: ", pathTypeComboBox);
		
	}
	
	public Node getInstanceAsNode(){
		return root;
	}

	private Object setEditView(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

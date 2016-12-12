package authoring.editorview.gamesettings.subviews.editorfields;

import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.GridFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class GamePathTypeView implements IGameSettingsSetView {

	
	private GameSettingsAuthoringViewDelegate delegate;
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
				e -> delegate.onUserEnteredGamePathType(pathTypeComboBox.getValue().toString()), pathTypeList);
		pathTypeComboBox.setPrefWidth(105);
		root = GridFactory.createRowWithLabelandNode("Path type: ", pathTypeComboBox, 125); //TODO resource file
		
	}
	
	@Override
	public Node getInstanceAsNode(){
		return root;
	}

	@Override
	public void setDelegate(GameSettingsAuthoringViewDelegate delegate) {
		this.delegate = delegate;
		
	}
	
	public void updatePathType(String pathType){
		pathTypeComboBox.setValue(pathType);
	}
	
	
}

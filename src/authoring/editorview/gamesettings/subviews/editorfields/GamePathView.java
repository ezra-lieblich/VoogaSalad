package authoring.editorview.gamesettings.subviews.editorfields;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import authoring.editorview.NameIdPair;
import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.GridFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class GamePathView implements IGameSettingsSetView {

	private GridPane root;
	private GameSettingsAuthoringViewDelegate delegate;
	private CheckComboBox<Object> pathCheckComboBox;
	private ObservableList<Object> pathList;
	private List<NameIdPair> pathNameIdList;
	
	public GamePathView(ResourceBundle settingsResource){
		root = new GridPane();
		pathNameIdList = new ArrayList<NameIdPair>();
		buildView(settingsResource);
	}
	
	private void buildView(ResourceBundle settingsResource){		
		pathList = FXCollections.observableArrayList();		
		
		
		pathCheckComboBox = ComboBoxFactory.makeCheckComboBox(pathList, a -> setPathIDFromName((String) a));
		pathCheckComboBox.setPrefWidth(105);
		root = GridFactory.createRowWithLabelandNode(settingsResource.getString("Path"), pathCheckComboBox, 125);
		
	}

	@Override
	public Node getInstanceAsNode() {
		return root;
	}

	@Override
	public void setDelegate(GameSettingsAuthoringViewDelegate delegate) {
		this.delegate = delegate;	
	}
	
	private void setPathIDFromName(String pathName){
		for (NameIdPair pair : pathNameIdList){
			if (pair.getName() == pathName){
				delegate.onUserEnteredPath(pair.getId());
			}
		}		
	}
	
	
	public void setPathList(List<Integer> pathList){
		for (Integer id : pathList){
			NameIdPair pair = new NameIdPair(delegate.getPathName(id), id);
			this.pathNameIdList.add(pair);
			pathCheckComboBox.getCheckModel().check(pair.getName());
			//this.pathList.add(delegate.getPathName(id));
		}
	}

}

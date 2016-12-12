package authoring.editorview.gamesettings.subviews.editorfields;

import java.util.ResourceBundle;

import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.GameSettingsSetView;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.GridFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class GameLosingConditionsView implements GameSettingsSetView{

    // GROOVY
	
	private ObservableList<Object> losingConditionList;
	private ComboBox<Object> losingConditionComboBox;
    private GameSettingsAuthoringViewDelegate delegate;
	private GridPane root;

    public GameLosingConditionsView (ResourceBundle settingsResource) {
    	makeComboBox();
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    @Override
    public void setDelegate (GameSettingsAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }
    
    private void makeComboBox(){
		
    	losingConditionList = FXCollections.observableArrayList();
    	
    	losingConditionComboBox = ComboBoxFactory.makeComboBox("" , 
				e -> setLosingCondition(losingConditionComboBox.getValue().toString()), losingConditionList);
    	losingConditionComboBox.setPrefWidth(105);
		root = GridFactory.createRowWithLabelandNode("Losing condition: ", losingConditionComboBox);
		
	}

	private Object setLosingCondition(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

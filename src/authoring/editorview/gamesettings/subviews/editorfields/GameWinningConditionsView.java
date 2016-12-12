package authoring.editorview.gamesettings.subviews.editorfields;

import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.GridFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class GameWinningConditionsView implements IGameSettingsSetView {

    // GROOVY
	
	private ObservableList<Object> winningConditionList;
	private ComboBox<Object> winningConditionComboBox;
    private GameSettingsAuthoringViewDelegate delegate;
	private GridPane root;

    public GameWinningConditionsView (ResourceBundle settingsResource) {
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
		
    	winningConditionList = FXCollections.observableArrayList();
    	
    	
    	
    	winningConditionComboBox = ComboBoxFactory.makeComboBox("" , 
				e -> setWinningCondition(winningConditionComboBox.getValue().toString()), winningConditionList);
    	winningConditionComboBox.setPrefWidth(105);
		root = GridFactory.createRowWithLabelandNode("Winning condition: ", winningConditionComboBox);
		
	}

	private void setWinningCondition(String string) {
		delegate.onUserEnteredWinningConditions(string);
	}

	    
}

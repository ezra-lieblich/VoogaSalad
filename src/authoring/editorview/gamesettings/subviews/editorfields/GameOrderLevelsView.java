package authoring.editorview.gamesettings.subviews.editorfields;

import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.GameSettingsSetView;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class GameOrderLevelsView implements GameSettingsSetView{

	private Button orderLevelsButton;
	private GameSettingsAuthoringViewDelegate delegate;
	
	public GameOrderLevelsView(){
		orderLevelsButton = ButtonFactory.makeButton("Set Order of Levels", e -> createOrderLevelsStage());
	}

	@Override
	public Node getInstanceAsNode() {
		return orderLevelsButton;
	}

	@Override
	public void setDelegate(GameSettingsAuthoringViewDelegate delegate) {
		this.delegate = delegate;
		
	}
	
	private void createOrderLevelsStage(){
		
		GameOrderLevels popup = new GameOrderLevels();
		
	}
	
}

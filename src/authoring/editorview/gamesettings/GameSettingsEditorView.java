package authoring.editorview.gamesettings;

import java.util.List;

import authoring.editorview.EditorViewController;
import authoring.editorview.IUpdateView;
import authoring.editorview.gamesettings.subviews.GameNameView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class GameSettingsEditorView implements IGameUpdateView, IGameSettingsEditorView {

    
    private VBox gameConditionsRoot;
    private GameNameView gameNameView;

    public GameSettingsEditorView (int aWidth, int aHeight) {
        this.gameConditionsRoot = new VBox(10);
        this.gameNameView = new GameNameView();
    }



    
    private void addViewComponents(){
    	gameConditionsRoot.getChildren().add(gameNameView.getInstanceAsNode());
    }




	@Override
	public Node getInstanceAsNode() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void setDelegate(GameSettingsEditorViewDelegate delegate) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateNameDisplay(String name) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateImagePathDisplay(String imagePath) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateSizeDisplay(double size) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateBank(List<Integer> ids) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateGameName(String name) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateNumberofLives(int lives) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateGameImage(String imagePath) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateImageSize(double imageSize) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateWinningConditions(List<String> winningConditions) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateLosingConditions(List<String> losingConditions) {
		// TODO Auto-generated method stub
		
	}

}

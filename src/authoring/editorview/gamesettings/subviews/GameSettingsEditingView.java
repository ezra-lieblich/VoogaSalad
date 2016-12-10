package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;

import authoring.editorview.gamesettings.GameSettingsEditorViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameSettingsEditingView implements IGameSettingsSetView {
	
	
	private VBox root;
	private AnchorPane rootBuffer;
	private GameNameView gameNameView;
	private GamePathTypeView gamePathTypeView;
	private GameImageView gameImageView;
	private GameInitialLivesView gameInitialLivesView;
	private GameInitialMoneyView gameInitialMoneyView;
	private GameWinningConditionsView gameWinningConditionsView;
	private GameLosingConditionsView gameLosingConditionsView;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringSettings";	
	private ResourceBundle settingsResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	
	public GameSettingsEditingView(){
		
		this.root = new VBox(10);
		
		this.rootBuffer = new AnchorPane();
		this.gameNameView = new GameNameView(settingsResource);
		this.gameImageView = new GameImageView();
		this.gamePathTypeView = new GamePathTypeView();
		this.gameInitialLivesView = new GameInitialLivesView(settingsResource);
		this.gameInitialMoneyView = new GameInitialMoneyView(settingsResource);
		this.gameWinningConditionsView = new GameWinningConditionsView(settingsResource);
		this.gameLosingConditionsView = new GameLosingConditionsView(settingsResource);
		
		
		
		rootBuffer.getChildren().add(root);
    	AnchorPane.setLeftAnchor(root, 10.0);
    	AnchorPane.setTopAnchor(root, 10.0);
    	
    	
    	
    	rootBuffer.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0.5))));
    	rootBuffer.setBackground(new Background(new BackgroundFill(Color.rgb(235, 235, 235), CornerRadii.EMPTY, Insets.EMPTY)));
		
		
		
		
		root.getChildren().addAll(
				gameNameView.getInstanceAsNode(), 
				gameImageView.getInstanceAsNode(),
				gameInitialLivesView.getInstanceAsNode(),
				gameInitialMoneyView.getInstanceAsNode(),
				gameWinningConditionsView.getInstanceAsNode(),
				gameLosingConditionsView.getInstanceAsNode(),
				gamePathTypeView.getInstanceAsNode()
				);
		
	}


	@Override
	public Node getInstanceAsNode() {
		return rootBuffer;
	}


	@Override
	public void setDelegate(GameSettingsEditorViewDelegate delegate) {
		gameNameView.setDelegate(delegate);
		
	}
	
	

}

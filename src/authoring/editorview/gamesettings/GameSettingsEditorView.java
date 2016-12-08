package authoring.editorview.gamesettings;

import java.util.List;
import java.util.ResourceBundle;

import authoring.editorview.ListDataSource;
import authoring.editorview.gamesettings.subviews.GameNameView;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class GameSettingsEditorView implements IGameSettingsEditorView, IGameSettingsSetView {

    private VBox gameConditionsRoot;
    private GameNameView gameNameView;
    private BorderPane gameSettingsView;
    private GameSettingsEditorViewDelegate delegate;
    
    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringSettings";	
	private ResourceBundle settingsResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);




    public GameSettingsEditorView (int aWidth, int aHeight) {
        gameSettingsView = new BorderPane();
        this.gameConditionsRoot = new VBox(10);
        this.gameNameView = new GameNameView(settingsResource);
        addViewComponents();
    }

    private void addViewComponents () {
        gameConditionsRoot.getChildren().add(gameNameView.getInstanceAsNode());
        gameSettingsView.setTop(gameConditionsRoot);
    }

    @Override
    public Node getInstanceAsNode () {
        return gameSettingsView;
    }

    @Override
    public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        this.delegate = delegate;
        gameNameView.setDelegate(delegate);
    }

    @Override
    public void updateBank (List<Integer> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateGameName (String name) {
        this.gameNameView.updateName(name);
    }

    @Override
    public void updateNumberofLives (int lives) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateGameImage (String imagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateImageSize (double imageSize) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateWinningConditions (List<String> winningConditions) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateLosingConditions (List<String> losingConditions) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setGameSettingsListDataSource (ListDataSource source) {
        // TODO Auto-generated method stub
        System.out.println("Game settings doesn't have an image bank implemented!");
    }

    @Override
    public void updateNameDisplay (String name) {
        // Don't worry about this
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        // Don't worry about this
    }

    @Override
    public void updateSizeDisplay (double size) {
        // Don't worry about this
    }

}

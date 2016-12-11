package authoring.editorview.gamesettings;

import java.util.List;
import authoring.editorview.ListDataSource;
import authoring.editorview.gamesettings.subviews.GameSettingsEditingView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class GameSettingsAuthoringView implements IGameSettingsUpdateView, IGameSettingsSetView {

    private Group gameSettingsPreview;

    private GridPane gameSettingsView;
    private GameSettingsAuthoringViewDelegate delegate;

    private GameSettingsEditingView gameSettingsEditor;

    public GameSettingsAuthoringView (int width, int height) {
        gameSettingsView = new GridPane();

        this.gameSettingsEditor = new GameSettingsEditingView();
        this.gameSettingsPreview = new Group();

        addViewComponents();
    }

    private void addViewComponents () {

        ColumnConstraints editorColumn = new ColumnConstraints();
        editorColumn.setMinWidth(250);
        ColumnConstraints previewColumn = new ColumnConstraints();
        RowConstraints fullRow = new RowConstraints();
        fullRow.setMinHeight(700);
        gameSettingsView.getColumnConstraints().addAll(editorColumn, previewColumn);
        gameSettingsView.getRowConstraints().add(fullRow);

        gameSettingsView.add(gameSettingsEditor.getInstanceAsNode(), 0, 0);
        gameSettingsView.add(gameSettingsPreview, 1, 0);
    }

    @Override
    public Node getInstanceAsNode () {
        return gameSettingsView;
    }

    @Override
    public void setDelegate (GameSettingsAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        gameSettingsEditor.setDelegate(delegate);
    }

    @Override
    public void updateBank (List<Integer> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateGameName (String name) {
        gameSettingsEditor.updateName(name);
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

    @Override
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub

    }

}

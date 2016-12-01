package authoring.editorview.gamesettings;

import java.util.List;
import authoring.editorview.IUpdateView;


public interface IGameSettingsEditorView extends IGameSettingsSetView, IUpdateView {

    public void updateGameName (String name);

    public void updateNumberofLives (int lives);

    public void updateGameImage (String imagePath);

    public void updateImageSize (double imageSize);

    public void updateWinningConditions (List<String> winningConditions);

    public void updateLosingConditions (List<String> losingConditions);

}

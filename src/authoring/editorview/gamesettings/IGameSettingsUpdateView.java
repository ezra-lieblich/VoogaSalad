package authoring.editorview.gamesettings;

import java.util.List;
import authoring.editorview.IUpdateView;
import authoring.editorview.ListDataSource;


public interface IGameSettingsUpdateView extends IGameSettingsSetView, IUpdateView {

    public void updateGameName (String name);

    public void updateNumberofLives (int lives);
    
    public void updateInitialMoney (int money);

    public void updateGameImage (String imagePath);
    
    public void updateGridSize (int size);
    
    public void updatePathList (List<Integer> pathList);
    
    public void updatePathType (String pathType);

    public void updateWinningConditions (List<String> winningConditions);

    public void updateLosingConditions (List<String> losingConditions);

    public void setGameSettingsListDataSource (ListDataSource source);

}

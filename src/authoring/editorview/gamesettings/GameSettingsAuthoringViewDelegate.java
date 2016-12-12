package authoring.editorview.gamesettings;

import java.util.List;

public interface GameSettingsAuthoringViewDelegate {

    public void onUserEnteredGameLives (int lives);

    public void onUserEnteredGameMoney (int money);

    public void onUserEnteredGameName (String name);

    public void onUserEnteredGameImage (String imagePath);
    
    public void onUserEnteredGameGridSize (int size);
    
    public void onUserEnteredGamePathType (String type);

    public void onUserEnteredWinningConditions (String winConditions);

    public void onUserEnteredLosingConditions (String loseConditions);
    
    public void onUserEnteredPath (int pathID);
    
    public String getPathName (int pathID);
    
    public String getPathImage (int pathID);
    
    public List<Integer> getAvailablePathList ();

}

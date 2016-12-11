package authoring.editorview.gamesettings;

public interface GameSettingsAuthoringViewDelegate {

    public void onUserEnteredGameLives (int lives);

    public void onUserEnteredGameMoney (int money);

    public void onUserEnteredGameNames (String name);

    public void onUserEnteredGameImage (String imagePath);
    
    public void onUserEnteredGridSize (int size);

    public void onUserEnteredWinningConditions (String winConditions);

    public void onUserEnteredLosingConditions (String loseConditions);

}

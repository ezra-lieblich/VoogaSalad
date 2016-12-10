package authoring.editorview.gamesettings;

public interface GameSettingsEditorViewDelegate {

    public void onUserEnteredGameLives (String lives);

    public void onUserEnteredGameMoney (String money);

    public void onUserEnteredGameNames (String name);

    public void onUserEnteredGameImage (String imagePath);

    public void onUserEnteredImageSize (String imageSize);

    public void onUserEnteredWinningConditions (String winConditions);

    public void onUserEnteredLosingConditions (String loseConditions);

}

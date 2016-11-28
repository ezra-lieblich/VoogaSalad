package authoring.editorview.gamesettings;

public interface GameSettingsDataSource {
	public void getGameName();
	public void setGameName(String name);
	public void setGameLives(int lives);
	public int getGameLives();
}

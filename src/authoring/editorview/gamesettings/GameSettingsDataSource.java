package authoring.editorview.gamesettings;

public interface GameSettingsDataSource {
	
	public void getGameName ();
	
	public void setGameName (String name);
	
	public void setNumberofLives (int lives);
	
	public int getNumberofLives ();
	
	public void setNumberofLevels (int numLevels);
	
	public int getNumberofLevels ();
	
	public void setEffectBetweenLevels (String effectBetweenLevels);
	
	public String getEffectBetweenLevels ();
	
	//TODO: Allow user to decide: if lives reset between levels?, if they want the game to include money?
}

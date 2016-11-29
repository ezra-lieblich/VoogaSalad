package authoring.editorview.gamesettings;

import java.util.List;

public interface GameSettingsDataSource {
	
	public void getGameName ();
	
	public void setGameName (String name);
	
	public void setNumberofLives (int lives);
	
	public int getNumberofLives ();
	
	public void setGameImage (String imagePath);
	
	public String getGameImage ();
	
	public void setImageSize (double imageSize);
	
	public double getImageSize ();
	
	public void addWinningCondition (String winningCondition);
    
    public void addLosingCondition (String losingCondition);
    
    public void removeWinningCondition (String winningCondition);
    
    public void removeLosingCondition (String losingCondition);
    
    public List<String> getWinningConditions ();
    
    public List<String> getLosingConditons ();
	
	//TODO: Allow user to decide: if lives reset between levels?, if they want the game to include money?
    
//	public void setEffectBetweenLevels (String effectBetweenLevels);
//	
//	public String getEffectBetweenLevels ();
}

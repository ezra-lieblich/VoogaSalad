package authoring.editorview.path;

import java.util.List;

public interface PathDataSource {

	
	/**
     * @return path id
     */
    public int createNewPath();
	
    /**
     * Pass the background image to game engine
     * 
     * @param background image set by user
     */
    public void setBackgroundImage (int pathID, String backgroundImagePath);

    /**
     * @param pathImage set by the user
     */
    public void setPathImage (int pathID, String pathImagePath);
    
    public void setNumberofColumns (int pathID, int numColumns);
    
    public void setNumberofRows (int pathID, int numRows);
    
    public void setPathName (int pathID, String pathName);
    
    public boolean setPathCoordinates (List<Coordinate> pathCoordinates);
    
    public void clearPaths ();
    
    public String getBackgroundImagePath (int pathID);
    
    public String getPathImagePath (int pathID);
    
    public int getNumberofColumns (int pathID);
    
    public int getNumberofRows (int pathID);
    
    public int getPathName (int pathID);
    
    public List<Coordinate> getPathCoordinates (int pathID);
    
    
    
    
}

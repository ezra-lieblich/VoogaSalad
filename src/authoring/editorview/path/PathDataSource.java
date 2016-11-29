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
    public void setPathImage (String pathImagePath);
    
    public void setNumberofColumns (int numColumns);
    
    public void setNumberofRows (int numRows);
    
    public void setPathName (String pathName);
    
    public boolean setPathCoordinates (List<Coordinate> pathCoordinates);
    
    public void clearPaths ();
    
    public String getBackgroundImagePath ();
    
    public String getPathImagePath ();
    
    public int getNumberofColumns ();
    
    public int getNumberofRows ();
    
    public int getPathName ();
    
    public List<Coordinate> getPathCoordinates ();
    
    public void setActiveID(int pathId);
    
    public int getActiveID ();
    
    
    
    
}

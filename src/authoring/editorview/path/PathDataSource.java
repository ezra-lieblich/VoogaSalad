package authoring.editorview.path;

import java.util.List;

import engine.path.Coordinate;

public interface PathDataSource {

	
	/**
     * @return path id
     */
    public int createNewPath(IPathEditorView iPathEditorView);
    

    /**
     * @param pathImage set by the user
     */
    public void setPathImage (int pathID, String pathImagePath);
    
    public void setNumberofColumns (int pathID, int numColumns);
    
    public void setNumberofRows (int pathID, int numRows);
    
    public void setPathName (int pathID, String pathName);
    
    public boolean setPathCoordinates (int pathID, List<Coordinate<Integer>> pathCoordinates);
    
    public void removePath (int pathID);
    
    public String getPathImagePath (int pathID);
    
    public int getNumberofColumns (int pathID);
    
    public int getNumberofRows (int pathID);
    
    public String getPathName (int pathID);
    
    public List<Coordinate<Integer>> getPathCoordinates (int pathID);
    
    
}

package authoring.editorview.path;

import java.util.List;

public interface PathDataSource {

    /**
     * Pass the background image to game engine
     * 
     * @param background image set by user
     */
    public void setGameBackground (int pathID, String backgroundImagePath);

    /**
     * 
     * @param pathImage set by the user
     */
    public void setPathImage (int pathID, String pathImagePath);
    
    public boolean addPathCoordinates(List<Coordinate> pathCoordinates);
    
    public void clearPaths();
    
    
}

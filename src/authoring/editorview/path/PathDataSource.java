package authoring.editorview.path;

import java.util.List;

public interface PathDataSource {

    /**
     * Pass the background image to game engine
     * 
     * @param background image set by user
     */
    public void setGameBackground (int backgroundID);

    /**
     * 
     * @param pathImage set by the user
     */
    public void setPathImage (int pathImageID);
    
    public boolean addPath(List<Coordinate> pathCoordinates);
    
    public void clearPaths();
}

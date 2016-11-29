package engine.path;

import java.util.List;
import authoring.editorview.path.Coordinate;
import authoring.editorview.path.PathDataSource;

public class PathTypeManagerController implements PathDataSource{
    private PathManager pathManager;
    
    PathTypeManagerController(PathManager pathManager) {
        this.pathManager = pathManager;
    }

    @Override
    public int createNewPath () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setBackgroundImage (int pathID, String backgroundImagePath) {        
    }

    @Override
    public void setPathImage (String pathImagePath) {
        pathManager.getActiveEntity().setImagePath(pathImagePath);
    }

    @Override
    public void setNumberofColumns (int numColumns) {
        pathManager.getActiveEntity().setImagePath(pathImagePath);
    }

    @Override
    public void setNumberofRows (int numRows) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPathName (String pathName) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean setPathCoordinates (List<Coordinate> pathCoordinates) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clearPaths () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getBackgroundImagePath () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPathImagePath () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getNumberofColumns () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNumberofRows () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getPathName () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Coordinate> getPathCoordinates () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setActiveID (int pathId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getActiveID () {
        // TODO Auto-generated method stub
        return 0;
    }

}

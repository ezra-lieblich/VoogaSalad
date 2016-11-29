package engine.path;

import java.util.List;
import authoring.editorview.path.PathDataSource;

public class PathTypeManagerController implements PathDataSource{
    private PathManager pathManager;
    private PathBuilder pathBuilder;
    
    PathTypeManagerController(PathManager pathManager) {
        this.pathManager = pathManager;
        this.pathBuilder = new PathTypeBuilder();
    }

    @Override
    public int createNewPath () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setPathImage (int pathID, String pathImagePath) {
        pathManager.getEntity(pathID).setImagePath(pathImagePath);
    }

    @Override
    public void setNumberofColumns (int pathID, int numColumns) {
        pathManager.getEntity(pathID).setGridColumns(numColumns);
    }

    @Override
    public void setNumberofRows (int pathID, int numRows) {
        pathManager.getEntity(pathID).setGridRows(numRows);
    }

    @Override
    public void setPathName (int pathID, String pathName) {
        pathManager.getEntity(pathID).setName(pathName);
    }

    @Override
    public boolean setPathCoordinates (int pathID, List<Coordinate<Integer>> pathCoordinates) {
        pathManager.getEntity(pathID).setCoordinates(pathCoordinates);
    }

    @Override
    public void clearPaths () {
    }

    @Override
    public String getPathImagePath (int pathID) {
        return pathManager.getEntity(pathID).getImagePath();
    }

    @Override
    public int getNumberofColumns (int pathID) {
        return pathManager.getEntity(pathID).getGridColumns();
    }

    @Override
    public int getNumberofRows (int pathID) {
        return pathManager.getEntity(pathID).getGridRows();
    }

    @Override
    public String getPathName (int pathID) {
        return pathManager.getEntity(pathID).getName();
    }

    @Override
    public List<Coordinate> getPathCoordinates (int pathID) {
        return pathManager.getEntity(pathID).getCoordinates();
    }


}
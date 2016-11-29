package engine.path;

import java.util.List;
import authoring.editorview.path.IPathEditorView;
import authoring.editorview.path.PathDataSource;
import authoring.editorview.tower.ITowerUpdateView;
import engine.tower.Tower;


public class PathTypeManagerController implements PathDataSource {
    private PathTypeManager pathManager;
    private PathBuilder pathBuilder;

    PathTypeManagerController (PathTypeManager pathManager) {
        this.pathManager = pathManager;
        this.pathBuilder = new PathTypeBuilder();
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

    private Path createPath (IPathEditorView iPathEditorView) {
        return pathBuilder.addCoordinatesListener((oldValue, newValue) -> iPathEditorView.setPathCoordinates(newValue))
        .addGridRowsListener((oldValue, newValue) -> iPathEditorView.setNumRows(newValue))
        .addGridColumnsListener((oldValue, newValue) -> iPathEditorView.setNumColumns(newValue))
        .build();
    }

    
    @Override//TODO - setType in iPath
    public int createNewPath (IPathEditorView iPathEditorView) {
        return pathManager.addEntry(createPath(iPathEditorView));
    }

    @Override
    public boolean setPathCoordinates (int pathID, List<Coordinate<Integer>> pathCoordinates) {
        pathManager.getEntity(pathID).setCoordinates(pathCoordinates);
        return true; // TODO - validate this
    }

    @Override
    public void removePath (int pathID) {
        pathManager.removeEntry(pathID);
    }

    @Override
    public List<Coordinate<Integer>> getPathCoordinates (int pathID) {
        return pathManager.getEntity(pathID).getCoordinates();
    }

}

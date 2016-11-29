package engine.path;

import java.util.List;
import authoring.editorview.path.IPathEditorView;
import authoring.editorview.tower.ITowerUpdateView;
import engine.AbstractTypeManagerController;
import engine.tower.Tower;


public class PathTypeManagerController
        extends AbstractTypeManagerController<PathManager, PathBuilder, Path> implements PathManagerController {

    PathTypeManagerController (PathTypeManager pathManager) {
        super(pathManager, new PathTypeBuilder());
    }

    @Override
    public void setNumberofColumns (int pathID, int columns) {
        getTypeManager().getEntity(pathID).setGridColumns(columns);
    }

    @Override
    public void setNumberofRows (int pathID, int rows) {
        getTypeManager().getEntity(pathID).setGridRows(rows);
    }
    
    @Override
    public void setType (int pathID, String type) {
        getTypeManager().getEntity(pathID).setType(type);        
    }
    
    @Override
    public boolean setNewPathCoordinate (int pathID, int x, int y) {
        getTypeManager().getEntity(pathID).addCoordinate(new GridCoordinate(x, y));
        return true; // TODO - validate this
    }

    @Override
    public int getNumberofColumns (int pathID) {
        return getTypeManager().getEntity(pathID).getGridColumns();
    }

    @Override
    public int getNumberofRows (int pathID) {
        return getTypeManager().getEntity(pathID).getGridRows();
    }

    @Override
    public void getType (int pathID) {
        getTypeManager().getEntity(pathID).getType();        
    }
    
    @Override
    public List<Coordinate<Integer>> getPathCoordinates (int pathID) {
        return getTypeManager().getEntity(pathID).getCoordinates();
    }
    
    @Override
    protected PathBuilder constructTypeProperties (ViewFiller viewViller,
                                                   PathBuilder typeBuilder) {
        return typeBuilder
                .addCoordinatesListener( (oldValue, newValue) -> viewViller
                        .setPathCoordinates(newValue))
                .addGridRowsListener( (oldValue, newValue) -> viewViller
                        .setNumRows(newValue))
                .addGridColumnsListener( (oldValue, newValue) -> viewViller
                        .setNumColumns(newValue));
    }

}

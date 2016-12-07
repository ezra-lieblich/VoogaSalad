package engine.path;

import java.util.List;
import java.util.function.Predicate;
import authoring.editorview.IUpdateView;
import authoring.editorview.path.IPathEditorView;
import authoring.editorview.path.IPathUpdateView;
import authoring.editorview.tower.ITowerEditorView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;
import engine.tower.Tower;


public class PathTypeManagerController
        extends AbstractTypeManagerController<PathManager, PathBuilder, Path, IPathUpdateView> implements PathManagerController {

    public PathTypeManagerController (ManagerMediator managerMediator) {
        super(new PathTypeManager(), new PathTypeBuilder(), managerMediator);
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
        GridCoordinate newCoordinate = new GridCoordinate(x, y);
        return handleRequest(validatePath(pathID, a -> newCoordinate.isCardinalTo(a) , true), a -> a.getEntity(pathID).addCoordinate(newCoordinate));
    }
    
//    private boolean validatePathAddition(int pathID, GridCoordinate gridCoordinate) {
//        List<Coordinate<Integer>> coordinates = getTypeManager().getEntity(pathID).getCoordinates();
//        if(coordinates.size()==0){
//            return true;
//        }
//        Coordinate<Integer> lastCoordinate = coordinates.get(coordinates.size()-1);
//        return gridCoordinate.isCardinalTo(lastCoordinate);
//    }

    private boolean validatePath(int pathID, Predicate<Coordinate<Integer>> condition, boolean isEmptyFlag) {
        List<Coordinate<Integer>> coordinates = getTypeManager().getEntity(pathID).getCoordinates();
        if(coordinates.size()==0){
            return isEmptyFlag;
        }
        Coordinate<Integer> lastCoordinate = coordinates.get(coordinates.size()-1);
        return condition.test(lastCoordinate);
    }
    
//    private boolean validatePathRemoval(int pathID, int x, int y) {
//        List<Coordinate<Integer>> coordinates = getTypeManager().getEntity(pathID).getCoordinates();
//        Coordinate<Integer> lastCoordinate = coordinates.get(coordinates.size()-1);
//        return lastCoordinate.getX() == x && lastCoordinate.getY() == y;  
//    }
    
    @Override
    public boolean removePathCoordinate (int pathID, int x, int y) {
        GridCoordinate newCoordinate = new GridCoordinate(x, y);
        return handleRequest(validatePath(pathID, a -> a.equals(newCoordinate), false), a -> a.getEntity(pathID).removeCoordinate(newCoordinate));
//        List<Coordinate<Integer>> coordinates = getTypeManager().getEntity(pathID).getCoordinates();
//        boolean isValidRemove  = coordinates.get(coordinates.size()-1).getX() == x && coordinates.get(coordinates.size()-1).getY() == y;
//        if(isValidRemove){
//            getTypeManager().getEntity(pathID).removeCoordinate(new GridCoordinate(x, y));
//        }
//        //System.out.println(getTypeManager().getEntity(pathID).getCoordinates().size());
//        return isValidRemove; // TODO - validate this
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
    protected PathBuilder constructTypeProperties (IPathUpdateView updateView,
                                                   PathBuilder typeBuilder) {
        return typeBuilder
                .addCoordinatesListener( (oldValue, newValue) -> updateView
                        .updatePathCoordinates(newValue))
                .addGridRowsListener( (oldValue, newValue) -> updateView
                        .updateNumRows(newValue))
                .addGridColumnsListener( (oldValue, newValue) -> updateView
                        .updateNumColumns(newValue));
    }

}

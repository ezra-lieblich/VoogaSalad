package engine.path;

import java.util.List;
import authoring.editorview.path.IPathEditorView;
import authoring.editorview.path.IPathUpdateView;
import engine.ManagerController;

public interface PathManagerController extends ManagerController<PathManager, PathBuilder, Path, IPathUpdateView>{

    public boolean setNewPathCoordinate (int pathID, int x, int y);
    
    public boolean removePathCoordinate (int pathID, int x, int y);

    public void setType(int pathID, String type);
    
    public void setNumberofColumns (int pathID, int columns);
    
    public void setNumberofRows (int pathID, int rows);
                    
    public List<Coordinate<Integer>> getPathCoordinates (int pathID);
    
    public void getType(int pathID);
    
    public int getNumberofColumns (int pathID);
    
    public int getNumberofRows (int pathID);    
    
}

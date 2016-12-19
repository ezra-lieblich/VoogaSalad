package engine.path;

import java.util.List;
import engine.TypeBuilder;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface PathBuilder extends TypeBuilder<Path, PathBuilder>, BindablePath { //TODO - Add bindable interface

    PathBuilder buildType (PathOption type);

    PathBuilder buildCoordinates (List<Coordinate<Integer>> coordinates);
    
    PathBuilder buildCoordinates (@SuppressWarnings("unchecked") Coordinate<Integer>... coordinates);
    
    PathBuilder buildGridSizeRows (Integer gridRows);
    
    PathBuilder buildGridSizeColumns (Integer gridColumns);

}

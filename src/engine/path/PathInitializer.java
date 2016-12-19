package engine.path;

import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface PathInitializer extends TypeInitializer{

    ObservableProperty<PathOption> getType ();

    ObservableList<Coordinate<Integer>> getCoordinates ();
    
    ObservableProperty<Integer> getGridRows ();
    
    ObservableProperty<Integer> getGridColumns ();


}

package engine.path;

import java.util.List;
import engine.TypeInitializer;
import engine.observer.ObservableProperty;


public interface PathInitializer extends TypeInitializer{

    ObservableProperty<String> getType ();

    ObservableProperty<List<Coordinate<Integer>>> getCoordinates ();
    
    ObservableProperty<Integer> getGridRows ();
    
    ObservableProperty<Integer> getGridColumns ();


}

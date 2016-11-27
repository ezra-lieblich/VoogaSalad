package engine;

import engine.observer.ObservableProperty;

public interface TypeInitializer {

    ObservableProperty<String> getName ();

    ObservableProperty<String> getImagePath ();

    ObservableProperty<Double> getSize ();
    
    int getNextId ();
    
}

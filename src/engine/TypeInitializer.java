package engine;

import engine.observer.ObservableProperty;

/**
 * This interface handles the methods for initializing a Type object
 * 
 * @author seanhudson
 *
 */
public interface TypeInitializer {

    /**
     * Initializes the observable name property
     * 
     * @return
     */
    ObservableProperty<String> getName ();

    /**
     * Initializes the observable ImagePath property
     * 
     * @return
     */
    ObservableProperty<String> getImagePath ();

    /**
     * Initializes the observable Size property
     * 
     * @return
     */
    ObservableProperty<Double> getSize ();
    
    /**
     * Initializes the observable Sound property
     * 
     * @return
     */
    ObservableProperty<String> getSound ();
    
    /**
     * Initializes the id property
     * 
     * @return
     */
    int getId ();
    
}

package engine.observer;

import java.util.function.BiConsumer;

/**
 * 
 * 
 * @author seanhudson
 *
 * @param <U>
 */
public interface ObservableProperty<U> extends Observable<U> {

    U getProperty ();

    void setProperty (U property);
    
    public void addListener (BiConsumer<U, U> listener);
    
    public void removeListener (BiConsumer<U, U> listener);
}

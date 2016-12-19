// This entire file is part of my masterpiece.
// Sean Hudson
package engine.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * This class is part of my master piece because I provides a good implementation of the Observer pattern that was crucial to the funtionality
 * of out program. I implemented my own observer pattern for a couple of reasons.
 *      1) I did not want to use any javafx properties in the back-end since that increases dependencies between the model and view.
 *      2) I wanted to avoid the unpleasant cast that occurs in the update call since the Java Observable class passes in an Object.
 * In implementing my own observable properties I added the capability to add listeners through functional interfaces. They take in Biconsumers for the
 * property's old and new value and are called any time the property is set.
 * 
 * 
 * 
 * This class provides an implementation of ObservableProprties that uses generics and doesn't use any javafx imports.
 * 
 * @author seanhudson
 *
 * @param <U> Property Type
 */
public class ObservableObjectProperty<U> extends AbstractObservable<U> implements ObservableProperty<U>{
    
    private List<BiConsumer<U, U>> listeners;
    private U property;

    public ObservableObjectProperty(U value) {
        this.property = value;
        this.listeners = new ArrayList<BiConsumer<U, U>>();
    }
    
    @Override
    public U getProperty () {
        return property;
    }

    @Override
    public void setProperty (U property) {
        U temp = this.property;
        this.property = property;
        notifyListenersAndObservers(temp, property);
    }
    
    @Override
    public void addListener (BiConsumer<U, U> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener (BiConsumer<U, U> listener) {
        listeners.remove(listener);
    }
    
    protected void notifyListenersAndObservers(U oldValue, U newValue) {
        listeners.forEach(a -> a.accept(oldValue, newValue));
        super.notifyObservers(newValue);
    }
    
    
    @Override
    public void notifyObservers (U value) {
        notifyListenersAndObservers(property, value);
    }
}

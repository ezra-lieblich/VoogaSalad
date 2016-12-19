package engine;

import java.util.Map;
import java.util.function.BiConsumer;

/**
 * This interface provides the method for adding bank listeners to the manager
 * 
 * @author seanhudson
 *
 * @param <E>
 */
public interface BindableManager<E> {

    void addEntitiesListener (BiConsumer<Map<Integer, E>, Map<Integer, E>> listener);
    
}

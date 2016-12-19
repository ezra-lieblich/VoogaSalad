package engine;

import java.util.function.BiConsumer;

/**
 * This class handles binding the observable properties inside of the builder pattern
 * 
 * @author seanhudson
 *
 * @param <R> F-Bounded Builder interface
 */
public interface BindableType<R extends BindableType<R>> {

    R addNameListener (BiConsumer<String, String> listener);

    R addImagePathListener (BiConsumer<String, String> listener);

    R addSizeListener (BiConsumer<Double, Double> listener);
    
    R addSoundListener (BiConsumer<String, String> listener);
}

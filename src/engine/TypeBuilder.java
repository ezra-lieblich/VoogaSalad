package engine;

import java.util.function.BiConsumer;

public interface TypeBuilder<E extends Type, R extends TypeBuilder<E, R>> {

    R buildName (String name);

    R buildImagePath (String imagePath);

    R buildSize (double size);

    E build ();

    R addNameListener (BiConsumer<String, String> listener);

    R addImagePathListener (BiConsumer<String, String> listener);

    R addSizeListener (BiConsumer<Double, Double> listener);

}

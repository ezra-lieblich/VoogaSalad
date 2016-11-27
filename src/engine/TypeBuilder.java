package engine;

import java.util.function.BiConsumer;

public interface TypeBuilder<E extends Type, R extends TypeBuilder<E, R>> extends BindableType<R> {

    R buildName (String name);

    R buildImagePath (String imagePath);

    R buildSize (double size);

    E build ();

}

package engine.path;

import java.util.List;
import java.util.function.BiConsumer;
import engine.BindableType;


public interface BindablePath extends BindableType<PathBuilder>{

    PathBuilder addTypeListener (BiConsumer<String, String> listener);

    PathBuilder addCoordinatesListener (BiConsumer<List<Coordinate<Integer>>, List<Coordinate<Integer>>> listener);

}

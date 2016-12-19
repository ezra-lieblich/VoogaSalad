package engine.path;

import java.util.List;
import java.util.function.BiConsumer;
import engine.Manager;

public interface PathManager extends Manager<PathKind> {

    void addAvailablePathListener(BiConsumer<List<Integer>, List<Integer>> listener);
    
    List<Integer> getAvailablePaths();
    
}

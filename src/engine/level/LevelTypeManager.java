package engine.level;

import engine.AbstractTypeManager;

import java.util.List;

/**
 *
 * Created by ezra on 11/17/16.
 */
public class LevelTypeManager extends AbstractTypeManager<Level> implements LevelManager{
    private List<Level> levels;

    @Override
    protected Level createInstance() {
        return null;
    }

}

package engine.level;

import engine.AbstractTypeManager;
import engine.ManagerMediator;
import java.util.List;

/**
 *
 * Created by ezra on 11/17/16.
 */
public class LevelTypeManager extends AbstractTypeManager<Level> implements LevelManager{
    private List<Level> levels;
    
    protected LevelTypeManager (ManagerMediator managerMediator) {
        super(managerMediator);
        // TODO Auto-generated constructor stub
    }


}

package engine.path;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import engine.AbstractTypeManager;
import engine.ManagerMediator;
import engine.observer.ObservableList;
import engine.observer.ObservableListProperty;
import engine.settings.GameModeManager;
import engine.weapon.WeaponManager;

public class PathTypeManager extends AbstractTypeManager<Path> implements PathManager {
        
    private ObservableList<Integer> availablePaths;
    
    PathTypeManager() {
        availablePaths = new ObservableListProperty<Integer>();
    }
    
    public void visitGridSize(GameModeManager manager, Integer index) {
        availablePaths.setProperty(getEntities().values().stream()
                                   .filter(a -> a.getType().equals(manager.getEntity(index).getGameType()) && a.getGridRows() == manager.getEntity(index).getGridSize() && a.getGridColumns()==(manager.getEntity(index).getGridSize()))
                                   .map(Path::getId)
                                   .collect(Collectors.toList()));  
        System.out.println("HERERER");
    }
    
    @Override 
    public void addAvailablePathListener(BiConsumer<List<Integer>, List<Integer>> listener) {
        availablePaths.addListener(listener);
    }
    
    protected void updateActivePaths() {
        
    }
    
    
    @Override
    public List<Integer> getAvailablePaths() {
        return availablePaths.getProperty();
    }
    
    public enum PathOption {
        SET,
        FREE;
    }
}
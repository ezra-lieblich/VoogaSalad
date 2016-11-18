package engine;

public class TowerTypeManager extends EntityManager<TowerType> {

    @Override
    protected TowerType createInstance () {
        return new TowerType();
    }
    
    

}

package engine;

public class EntityBuilder<E extends Entity> {
    private E entity;
    
    EntityBuilder(E entity) {
        this.entity = entity;
        
    }
    
    public void buildName(String name) {
        entity.setName(name);
    }
    
    public void buildImagePath(String imagePath) {
        entity.setImagePath(imagePath);
    }
    
    public void buildId(int id) {
        entity.setId(id);
    }
    
    public void buildSize(int size) {
        entity.setSize(size);
    }
    
    
    protected E getEntity() {
        return entity;
    }

}

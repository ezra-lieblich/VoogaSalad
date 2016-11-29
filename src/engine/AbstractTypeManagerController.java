package engine;

import java.util.List;

public abstract class AbstractTypeManagerController<E extends Manager<T>, U extends TypeBuilder<T, U>, T extends Type> implements ManagerController<E, U, T> {

    private E typeManager;
    private U typeBuilder;

    protected AbstractTypeManagerController (E typeManager, U typeBuilder) {
        this.typeManager = typeManager;
        this.typeBuilder = typeBuilder;
    }

    @Override
    public <V extends ViewFiller> int createType (V viewFiller) {
        return typeManager.addEntry(constructType(viewFiller));
    }

    protected <V extends ViewFiller> T constructType (V viewFiller) {
        return constructTypeProperties(viewFiller, typeBuilder)
                .addNameListener( (oldValue, newValue) -> viewFiller
                        .updateNameDisplay(newValue))
                .addImagePathListener( (oldValue, newValue) -> viewFiller
                        .updateImagePathDisplay(newValue))
                .addSizeListener( (oldValue, newValue) -> viewFiller
                        .updateSizeDisplay(newValue))
                .build();
    }

    @Override
    public void deleteType (int id) {
        typeManager.removeEntry(id);
    }

    @Override
    public String getName (int id) {
        return typeManager.getEntity(id).getName();
    }

    @Override
    public String getImagePath (int id) {
        return typeManager.getEntity(id).getImagePath();
    }

    @Override
    public Double getSize (int id) {
        return typeManager.getEntity(id).getSize();
    }
    
    @Override
    public List<Integer> getCreatedTypeIds () {
        return typeManager.getEntityIds();
    }

    @Override
    public void setName (int id, String name) {
        typeManager.getEntity(id).setName(name);
    }

    @Override
    public void setImagePath (int id, String imagePath) {
        typeManager.getEntity(id).setName(imagePath);
    }

    @Override
    public void setSize (int id, double size) {
        typeManager.getEntity(id).setSize(size);
    }

    protected E getTypeManager () {
        return typeManager;
    }

    //TODO - try and not need this
    protected U getTypeBuilder () {
        return typeBuilder;
    }

    protected abstract U constructTypeProperties (ViewFiller viewViller, U typeBuilder);

    protected interface ViewFiller {
        void updateNameDisplay (String name);

        void updateImagePathDisplay (String imagePath);

        void updateSizeDisplay (double size);
    }
}

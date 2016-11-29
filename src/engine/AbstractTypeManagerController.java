package engine;

public abstract class AbstractTypeManagerController<E extends Manager<T>, U extends TypeBuilder<T, U>, T extends Type> implements ManagerController<E, U, T> {

    private E typeManager;
    private U typeBuilder;

    protected AbstractTypeManagerController (E typeManager, U typeBuilder) {
        this.typeManager = typeManager;
        this.typeBuilder = typeBuilder;
    }

    @Override
    public int createType (ViewFiller viewFiller) {
        return typeManager.addEntry(constructType(viewFiller));
    }

    protected T constructType (ViewFiller viewFiller) {
        return constructTypeProperties(viewFiller, typeBuilder)
                .addNameListener( (oldValue, newValue) -> viewFiller
                        .updateName(newValue))
                .addImagePathListener( (oldValue, newValue) -> viewFiller
                        .updateImagePath(newValue))
                .addSizeListener( (oldValue, newValue) -> viewFiller
                        .updateSize(newValue))
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

    protected U getTypeBuilder () {
        return typeBuilder;
    }

    protected abstract U constructTypeProperties (ViewFiller viewViller, U typeBuilder);

    protected interface ViewFiller {
        void updateName (String name);

        void updateImagePath (String imagePath);

        void updateSize (double size);
    }
}

package engine;

import java.util.List;
import authoring.editorview.IUpdateView;

public abstract class AbstractTypeManagerController<E extends Manager<T>, U extends TypeBuilder<T, U>, T extends Type, V extends IUpdateView> implements ManagerController<E, U, T, V> {

    private E typeManager;
    private U typeBuilder;

    protected AbstractTypeManagerController (E typeManager, U typeBuilder, ManagerMediator managerMediator) {
        this.typeManager = typeManager;
        this.typeBuilder = typeBuilder;
        managerMediator.addManager(typeManager);
    }

    @Override
    public int createType (V updateView) {
        return typeManager.addEntry(constructType(updateView));
    }

    protected T constructType (V updateView) {
        return constructTypeProperties(updateView, typeBuilder)
                .addNameListener( (oldValue, newValue) -> updateView
                        .updateNameDisplay(newValue))
                .addImagePathListener( (oldValue, newValue) -> updateView
                        .updateImagePathDisplay(newValue))
                .addSizeListener( (oldValue, newValue) -> updateView
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
        typeManager.getEntity(id).setImagePath(imagePath);
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

    protected abstract U constructTypeProperties (V updateView, U typeBuilder);

    protected interface ViewFiller {
        void updateNameDisplay (String name);

        void updateImagePathDisplay (String imagePath);

        void updateSizeDisplay (double size);
    }
}

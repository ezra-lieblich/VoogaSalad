package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import authoring.editorview.IUpdateView;


public abstract class AbstractTypeManagerController<E extends Manager<T>, U extends TypeBuilder<T, U>, T extends Type, V extends IUpdateView>
        implements ManagerController<E, U, T, V> {

    private E typeManager;
    private U typeBuilder;

    protected AbstractTypeManagerController (E typeManager,
                                             U typeBuilder,
                                             ManagerMediator managerMediator) {
        this.typeManager = typeManager;
        this.typeBuilder = typeBuilder;
        managerMediator.addManager(typeManager);
        // typeManager.addEntry(typeBuilder.build()); //Testing XML
    }

    @Override
    public int createType (V updateView) {
        return typeManager.addEntry(constructType(updateView));
    }

    @Override
    public void addTypeBankListener(V updateView) {
        typeManager.addEntitiesListener((oldValue, newValue) -> updateView.updateBank(new ArrayList<Integer>(newValue.keySet())));
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
    public boolean setName (int id, String name) {
        return isUnique(Type::getName, name) ? typeManager.getEntity(id).setName(name) : typeManager.getEntity(id).setName(typeManager.getEntity(id).getName());
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

    // TODO - try and not need this
    protected U getTypeBuilder () {
        return typeBuilder;
    }

    protected abstract U constructTypeProperties (V updateView, U typeBuilder);

    protected interface ViewFiller {
        void updateNameDisplay (String name);

        void updateImagePathDisplay (String imagePath);

        void updateSizeDisplay (double size);
    }
    
    protected <R> boolean isUnique(Function<T, R> getter, R value) {
        return !typeManager.getEntityIds().stream().map(a -> typeManager.getEntity(a)).anyMatch(b -> getter.apply(b).equals(value));
    }
}

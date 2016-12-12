package authoring.editorview.collisioneffects;

import java.util.List;
import authoring.editorview.EditorViewController;
import authoring.editorview.ListCellData;
import authoring.editorview.ListDataSource;
import engine.effect.EffectManagerController;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAuthoringViewController extends EditorViewController
        implements EffectAuthoringViewDelegate, ListDataSource {

    private EffectManagerController effectsDataSource;
    private int currentEffectID;
    private EffectUpdateView effectAuthoringView;

    public EffectAuthoringViewController (EffectManagerController effectsDataSource) {
        this.effectsDataSource = effectsDataSource;
        effectAuthoringView = EffectAuthoringViewFactory.build();
        effectAuthoringView.setDelegate(this);
        effectAuthoringView.setEffectListDataSource(this);
        // TODO - fix this
        currentEffectID = 0;
        this.effectsDataSource.addTypeBankListener(this.effectAuthoringView);
    }

    public void setEffectOptions (List<Integer> effects) {
        effectAuthoringView.updateEffectBank(effects);
    }

    public void setAvailClasses (List<String> classes) {
        effectAuthoringView.updateListedAvailableClasses(classes);
    }

    public void setAvailMethods (List<String> methods) {
        effectAuthoringView.updateAvailableMethods(methods);
    }

    public void setAvailDataObjects (List<String> dataObjects) {
        effectAuthoringView.updateAvailableDataObjects(dataObjects);
    }

    public EffectUpdateView getEffectAuthoringView () {
        return effectAuthoringView;
    }

    public void openEffectView () {
        effectAuthoringView.openEffectView();
    }

    @Override
    public void onUserSelectedAvailableClass (String selectedClass) {
        effectsDataSource.setAvailableClass(selectedClass);
        // TODO: This also needs to update the available methods
    }

    @Override
    public void onUserEnteredEffectName (String name) {
        effectsDataSource.setName(currentEffectID, name);
    }

    @Override
    public void onUserEnteredCondition (String condition) {
        effectsDataSource.setCondition(currentEffectID, condition);
    }

    @Override
    public void onUserSelectedEffect (int effectID) {
        currentEffectID = effectID;
        refreshView();
    }

    @Override
    public ListCellData getCellDataForSubject (int id) {
        ListCellData cellData = new ListCellData();
        System.out.println("id: " + id + " effectsDS: " + effectsDataSource);
        cellData.setName(effectsDataSource.getName(id));
        cellData.setImagePath(effectsDataSource.getImagePath(id));
        cellData.setId(id);
        return cellData;
    }

    @Override
    public void refreshView () {
        effectAuthoringView.updateNameDisplay(effectsDataSource.getImagePath(currentEffectID));
    }

    @Override
    public void onUserEnteredEffectText (String effect) {
        effectsDataSource.setEffect(currentEffectID, effect);
    }

}

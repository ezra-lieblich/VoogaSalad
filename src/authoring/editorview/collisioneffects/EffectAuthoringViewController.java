package authoring.editorview.collisioneffects;

import java.util.List;
import authoring.editorview.EditorViewController;
import authoring.editorview.imagebank.ListDataSource;
import engine.effect.EffectManagerController;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAuthoringViewController extends EditorViewController
        implements EffectAuthoringViewDelegate, ListDataSource {

    private EffectManagerController effectDataSource;
    private int currentEffectID;
    private EffectUpdateView effectAuthoringView;

    public EffectAuthoringViewController (EffectManagerController effectsDataSource) {
        this.effectDataSource = effectsDataSource;
        effectAuthoringView = EffectAuthoringViewFactory.build();
        effectAuthoringView.setDelegate(this);
        effectAuthoringView.setEffectListDataSource(this);
        this.effectDataSource.addTypeBankListener(this.effectAuthoringView);
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
        refreshView();
        effectAuthoringView.openEffectView();
    }

    @Override
    public void onUserSelectedAvailableClass (String selectedClass) {
        effectDataSource.setAvailableClass(selectedClass);
        //System.out.println(selectedClass);
        effectAuthoringView.getEffectAvailMethods()
                .updateAvailMethods(effectDataSource.getAvailableClassMethods(selectedClass));
        // effectAuthoringView.effectDataSource.getAvailableClassMethods(selectedClass)
        // TODO: This also needs to update the available methods
    }

    @Override
    public void onUserEnteredEffectName (String name) {
        effectDataSource.setName(currentEffectID, name);
    }

    @Override
    public void onUserEnteredCondition (String condition) {
        effectDataSource.setCondition(currentEffectID, condition);
    }

    @Override
    public void onUserSelectedEffect (int effectID) {
        currentEffectID = effectID;
        refreshView();
    }


    @Override
    public void refreshView () {
        effectAuthoringView.updateNameDisplay(effectDataSource.getImagePath(currentEffectID));
        effectAuthoringView.updateConditionField(effectDataSource.getCondition(currentEffectID));
        effectAuthoringView.updateEffectField(effectDataSource.getEffect(currentEffectID));
        effectAuthoringView.updateAvailableDataObjects(effectDataSource.getAvailableDataObjects());
        // effectAuthoringView.updateEffectBank(effectDataSource.getCreatedTypeIds());
    }

    @Override
    public void onUserEnteredEffectText (String effect) {
        effectDataSource.setEffect(currentEffectID, effect);
    }

	@Override
	public String getName(int id) {
		return this.effectDataSource.getName(id);
	}

	@Override
	public String getImagePath(int id) {
		return this.effectDataSource.getImagePath(id);
	}

}

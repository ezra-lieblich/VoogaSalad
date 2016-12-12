package authoring.editorview.collisioneffects;

import java.util.List;
import authoring.editorview.ListDataSource;
import authoring.editorview.collisioneffects.subviews.EffectAvailableClassesView;
import authoring.editorview.collisioneffects.subviews.EffectAvailableDataObjectsView;
import authoring.editorview.collisioneffects.subviews.EffectAvailableMethodsView;
import authoring.editorview.collisioneffects.subviews.EffectBank;
import javafx.scene.layout.GridPane;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAuthoringView implements EffectUpdateView {

    private GridPane effectsPane;
    private EffectBank effectsBank;
    private EffectAvailableClassesView effectAvailClasses;
    private EffectAvailableDataObjectsView effectDataObjects;
    private EffectAvailableMethodsView effectAvailMethods;

    public EffectAuthoringView () {
        effectsBank = new EffectBank();
        effectAvailClasses = new EffectAvailableClassesView();
        effectDataObjects = new EffectAvailableDataObjectsView();
        effectAvailMethods = new EffectAvailableMethodsView();
        setPane();
    }

    private void setPane () {
        effectsPane.add(effectsBank.getInstanceAsNode(), 0, 0, 1, 1);
        effectsPane.add(effectAvailClasses.getInstanceAsNode(), 1, 0, 1, 1);
        effectsPane.add(effectDataObjects.getInstanceAsNode(), 2, 0, 1, 1);
        effectsPane.add(effectAvailMethods.getInstanceAsNode(), 3, 0, 1, 1);
    }

    @Override
    public void updateEffectName (String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createNewEffect () {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteEffect () {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEffectListDataSource (ListDataSource source) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateConditionField (String condition) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateEffectField (String effect) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateListedEffects (List<String> effects) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateListedAvailableClasses (List<String> availClasses) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateSelectedAvailableClass (String selectedClass) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateAvailableMethods (List<String> availMethods) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateAvailableDataObjects (List<String> availDataObjects) {
        // TODO Auto-generated method stub

    }

}

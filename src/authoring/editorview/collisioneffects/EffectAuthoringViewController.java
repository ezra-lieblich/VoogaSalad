package authoring.editorview.collisioneffects;

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
    private EffectAuthoringView effectAuthoringView;

    public EffectAuthoringViewController () {
        effectAuthoringView = new EffectAuthoringView();
        effectAuthoringView.setDelegate(this);
        // TODO - fix this
        currentEffectID = 0;
    }

    public void setEffectDataSource (EffectManagerController source) {
        this.effectsDataSource = source;
        // this.effectsDataSource.addTypeBankListener(this.effectAuthoringView);
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
    public void onUserEnteredEffect (String effect) {
        effectsDataSource.setEffect(currentEffectID, effect);
    }

    @Override
    public ListCellData getCellDataForSubject (int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refreshView () {
        // TODO Auto-generated method stub

    }

}

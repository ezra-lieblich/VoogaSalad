package authoring.editorview.collisioneffects;

import authoring.editorview.ListDataSource;
import authoring.editorview.collisioneffects.subviews.EffectsBank;
import javafx.scene.layout.GridPane;


public class EffectsAuthoringView implements IEffectsUpdateView {

    private GridPane effectsPane;
    private EffectsBank effectsBank;

    public EffectsAuthoringView () {
        effectsBank = new EffectsBank();
        setPane();
    }

    private void setPane () {
        effectsPane.add(effectsBank.getInstanceAsNode(), 0, 0);
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

}

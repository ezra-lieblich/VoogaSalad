package authoring.editorview.collisioneffects;

import authoring.editorview.ListDataSource;
import authoring.editorview.collisioneffects.subviews.EffectBank;
import javafx.scene.layout.GridPane;


public class EffectAuthoringView implements EffectUpdateView {

    private GridPane effectsPane;
    private EffectBank effectsBank;

    public EffectAuthoringView () {
        effectsBank = new EffectBank();
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

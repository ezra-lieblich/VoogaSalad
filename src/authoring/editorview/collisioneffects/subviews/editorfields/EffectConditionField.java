package authoring.editorview.collisioneffects.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class EffectConditionField extends TextFieldView implements EffectSetView {

    private TextField conditionField;
    private EffectAuthoringViewDelegate delegate;

    public EffectConditionField (ResourceBundle resource) {
        super(resource);
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void updateField (String newData) {
        conditionField.setText(newData);
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
        conditionField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                               e -> delegate
                                                       .onUserEnteredCondition(conditionField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Condition"),
                                                      conditionField);
    }

}

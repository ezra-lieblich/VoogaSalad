package authoring.editorview.collisioneffects.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class EffectField extends TextFieldView implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;
    private TextField effectTextField;

    public EffectField (ResourceBundle resource) {
        super(resource);
    }

    @Override
    public void updateField (String newData) {
        effectTextField.setText(newData);
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
        effectTextField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                               e -> delegate
                                                       .onUserEnteredEffect(effectTextField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Effect"),
                                                      effectTextField);
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

}

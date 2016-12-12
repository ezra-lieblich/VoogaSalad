package authoring.editorview.collisioneffects.subviews;

import java.util.ResourceBundle;
import authoring.editorview.ImageBank;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import authoring.editorview.collisioneffects.subviews.editorfields.EffectNameField;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectDataView implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;
    private BorderPane effectDataPane;
    private EffectNameField nameField;
    private ResourceBundle labelsResource;

    public EffectDataView () {
        labelsResource = ResourceBundle.getBundle("resources/GameAuthoringEffect");
        effectDataPane = new BorderPane();
        nameField = new EffectNameField(labelsResource);
        setPane();
    }

    @Override
    public Node getInstanceAsNode () {
        return effectDataPane;
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        nameField.setDelegate(delegate);
    }

    private void setPane () {
        effectDataPane.setTop(nameField.getInstanceAsNode());
    }

}

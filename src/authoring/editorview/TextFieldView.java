package authoring.editorview;

import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public abstract class TextFieldView implements IEditorView {

    protected HBox hbox;

    protected ResourceBundle resource;

    public TextFieldView (ResourceBundle resource) {
        this.resource = resource;
        makeTextField(resource);
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    public abstract void updateField (String newData);

    protected abstract void makeTextField (ResourceBundle labelsResource);

}

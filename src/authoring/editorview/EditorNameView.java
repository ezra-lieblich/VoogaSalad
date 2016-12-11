package authoring.editorview;

import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public abstract class EditorNameView implements INodeView {

    protected HBox root;
    protected TextField nameTextField;

    protected ResourceBundle resource;

    public EditorNameView (ResourceBundle resource) {
        this.resource = resource;
        makeNameTextField();

    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    public void updateName (String name) {
        nameTextField.setText(name);
    }

    protected abstract void makeNameTextField ();

}

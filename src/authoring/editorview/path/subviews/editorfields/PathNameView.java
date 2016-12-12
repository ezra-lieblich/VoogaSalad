package authoring.editorview.path.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.path.PathSetView;
import authoring.editorview.path.PathAuthoringViewDelegate;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PathNameView  implements PathSetView {

    private PathAuthoringViewDelegate delegate;
    private GridPane root;
    private TextField nameTextField;
    private ResourceBundle resource;

    public PathNameView (ResourceBundle pathResource) {
    	this.resource = pathResource;
    	makeNameTextField();
    }

    @Override
    public void setDelegate (PathAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }
    
   
    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    public void updateName (String name) {
        nameTextField.setText(name);
    }
    
    private void makeNameTextField () {
        nameTextField = TextFieldFactory.makeTextField("",
                                                       e -> delegate
                                                               .onUserEnteredPathName(nameTextField
                                                                       .getText()));
        nameTextField.setMaxWidth(155);
        root = GridFactory.createRowWithLabelandNode(resource.getString("NameTextField"), nameTextField);
        
    }

}

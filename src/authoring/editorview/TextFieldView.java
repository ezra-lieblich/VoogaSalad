// This entire file is part of my masterpiece.
// Diane Hadley

package authoring.editorview;

import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


/**
 * 
 * This is a parent class for any ui element that contains a label and a text field. An example
 * of its implementation is EditorNameView (where masterpiece is discussed in more detail). Kayla
 * made this class during the project, but I found even more duplicated code that could be moved out 
 * of the children classes and into the parent class. The previous commit was 417c598f. 
 * 
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public abstract class TextFieldView implements INodeView {

    protected GridPane root;
    protected TextField textField;
    protected int textFieldWidth;
    protected int labelWidth;

    protected ResourceBundle resource;

    public TextFieldView (ResourceBundle resource) {
        this.resource = resource;
        makeTextField(resource);
    }
    
    public TextFieldView (ResourceBundle resource, int textFieldWidth, int labelWidth){
    	this.textFieldWidth = textFieldWidth;
    	this.labelWidth = labelWidth;
    	this.resource = resource;  	
    	makeTextField(resource);
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    public void updateField (String newData) {
        textField.setText(newData);
    }

    protected abstract void makeTextField (ResourceBundle resource);

}

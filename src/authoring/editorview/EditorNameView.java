// This entire file is part of my masterpiece.
// Diane Hadley

package authoring.editorview;

import java.util.ResourceBundle;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;

/**
 * This class is implemented by every view package because they (path, enemy, weapon, etc.) all
 * have a name element. It creates a text field in which the user can input a name for that
 * entity
 * 
 * I included this in my master piece because I was able to reduce a great amount of 
 * duplicated code after refactoring and because it also implements an inheritance hierarchy.
 * When I first started, I actually had EditorNameView as a parent class and each package had
 * a child class for its name element. However, as I refactored more and more, I realized it could
 * be a class on its own if I made a hierarchy in the interfaces that contained a general interface
 * (EditorViewDelegate, included in masterpiece) with general methods (like onUserEnteredName) 
 * that all the packages could
 * use. In doing this, I was able to delete 7 other nameView classes. Besides deleting hundreds of lines
 * of duplicated code, this also makes our design more extensible. If a person wanted to add another 
 * element to the game and create a new package, they could implement the already existing EditorNameView
 * class instead of having to write one. What I am most proud of is the power in its simplicity.
 * 
 *
 * 
 * @author Diane Hadley
 *
 */


public class EditorNameView extends TextFieldView implements INodeView {

    private EditorViewDelegate delegate;       
    private static final String EMPTY_STRING = "";
   
    public EditorNameView (ResourceBundle resource, int textFieldWidth, int labelWidth) {
        super(resource, textFieldWidth, labelWidth);
    }

    public void setDelegate (EditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    protected void makeTextField (ResourceBundle resource){
    	textField = TextFieldFactory.makeTextField(EMPTY_STRING,
    													e -> delegate.onUserEnteredName(textField.getText()));
    	textField.setPrefWidth(textFieldWidth);
    	root = GridFactory.createRowWithLabelandNode(resource.getString("NameTextField"),
    												textField, 
                									labelWidth);
    }

}

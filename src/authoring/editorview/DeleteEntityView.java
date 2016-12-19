// This entire file is part of my masterpiece.
// Diane Hadley

package authoring.editorview;

import java.util.ResourceBundle;

import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * 
 * This is another example of being able to implement one class in multiple packages. By writing
 * this class, I was able to delete 6 other classes. (Master piece is discussed further in EditorNameView)
 * 
 * @author Diane Hadley
 *
 */

public class DeleteEntityView implements EditorSetView {

	private EditorViewDelegate delegate;
    private Button deleteButton;
	
    private ResourceBundle resource;
	
	public DeleteEntityView(ResourceBundle resource, int buttonWidth){
		this.resource = resource;
		makeDeleteButton(buttonWidth);
	}	
	
	@Override
	public Node getInstanceAsNode() {
		return deleteButton;
	}

	@Override
	public void setDelegate(EditorViewDelegate delegate) {
		this.delegate = delegate;
		
	}
	
	private void makeDeleteButton(int buttonWidth){
		deleteButton = ButtonFactory.makeButton(resource.getString("Delete"),
												e -> delegate.onUserPressedDeleteEntity());
        deleteButton.setPrefWidth(buttonWidth);
				
	}

}

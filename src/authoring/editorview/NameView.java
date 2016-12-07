package authoring.editorview;

import javafx.scene.Node;
import javafx.scene.control.TextField;

public class NameView implements IEditorView {

	protected TextField nameTextField;
	
	public NameView(){
		
	}

	@Override
	public Node getInstanceAsNode() {
		
		return nameTextField;
	}
	
	public void updateName(String name){
		nameTextField.setText(name);		
	}
	
	
	
}

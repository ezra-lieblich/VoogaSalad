package authoring.editorview.weapon;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class WeaponEditorView implements IWeaponEditorView {

	private BorderPane root;
	
	public WeaponEditorView(){
		root = new BorderPane();
	}
	
	
    @Override
    public Node getInstanceAsNode () {
        return root;
    }

}

package authoringview.weapon;

import authoringview.EditorView;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class WeaponEditorView extends EditorView implements IWeaponEditorView {

	private BorderPane root;
	
	public WeaponEditorView(){
		root = new BorderPane();
	}
	
	
    @Override
    public Node getInstanceAsNode () {
        return root;
    }

}

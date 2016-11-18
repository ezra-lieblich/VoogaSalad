package gameauthoringenvironment.view.weapon;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class WeaponView implements IWeaponView {

	private BorderPane root;
	
	public WeaponView(){
		root = new BorderPane();
	}
	
	
    @Override
    public Node getInstanceAsNode () {
        return root;
    }

}

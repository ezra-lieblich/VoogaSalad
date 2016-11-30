package authoring.editorview.tower.subviews;

import java.util.List;

import authoring.editorview.ImageBank;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.control.Button;

/**
 * 
 * @author Kayla Schulz, Andrew Bihl
 *
 */
public class TowerImageBank extends ImageBank {

    private TowerEditorViewDelegate delegate;

    public TowerImageBank () {
    	super();
        Button createTowerButton =
                ButtonFactory.makeButton("New Tower",
                                         e -> {
                                             delegate.onUserPressedCreateNewTower();
                                         });
        items.add(createTowerButton);
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void setListDataSource (TowerListDataSource source) {
        this.dataSource = source;
    }
    
    public void updateTowerBank (List<Integer> createdTowers) {
    	super.updateBank(createdTowers);
    }

	@Override
	protected void userSelectedRow(int index) {
		int selectedTowerID = this.itemIDs.get(index);
		this.delegate.onUserSelectedTower(selectedTowerID);
	}

}

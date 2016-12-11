package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;

import authoring.editorview.ImageBank;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerAuthoringViewDelegate;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Kayla Schulz
 * @author andrewbihl
 *
 */
public class TowerUpgradeBank extends ImageBank implements ITowerSetView {

    private HBox towerUpgradeBox;
    private TowerAuthoringViewDelegate delegate;
    private ResourceBundle labelsResource;

    public TowerUpgradeBank (ResourceBundle labelsResource) {
    	super();
    	this.listView.setOrientation(Orientation.HORIZONTAL);
        this.labelsResource = labelsResource;
        towerUpgradeBox = new HBox(5);
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerUpgradeBox;
    }

	@Override
	protected void userSelectedRow(int index) {
		this.delegate.onUserSelectedTower(this.itemIDs.get(index));
	}
}

package authoring.editorview.tower.subviews;

import java.io.IOException;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.editorview.tower.subviews.editorfields.TowerBuyPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerFireRateField;
import authoring.editorview.tower.subviews.editorfields.TowerFrequencyField;
import authoring.editorview.tower.subviews.editorfields.TowerImageView;
import authoring.editorview.tower.subviews.editorfields.TowerNameField;
import authoring.editorview.tower.subviews.editorfields.TowerRangeField;
import authoring.editorview.tower.subviews.editorfields.TowerSellPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerUnlockLevelField;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;


public class TowerEffectView extends PhotoFileChooser {

    private TowerEditorViewDelegate delegate;
    private TowerNameField towerName;
    private TowerFrequencyField towerFrequency;
    private TowerImageView towerImage;
    private TowerRangeField towerRange;
    private TowerBuyPriceField towerBuyPrice;
    private TowerFireRateField towerFireRate;
    private TowerSellPriceField towerSellPrice;
    private TowerUnlockLevelField towerUnlockLevel;
    private ScrollPane completeView;

    public TowerEffectView (TowerNameField towerName,
                            TowerFrequencyField towerFrequency,
                            TowerImageView towerImage,
                            TowerRangeField towerRange,
                            TowerBuyPriceField towerBuyPrice,
                            TowerFireRateField towerFireRate,
                            TowerSellPriceField towerSellPrice,
                            TowerUnlockLevelField towerUnlockLevel) {
        this.towerName = towerName;
        this.towerFrequency = towerFrequency;
        this.towerImage = towerImage;
        this.towerRange = towerRange;
        this.towerBuyPrice = towerBuyPrice;
        this.towerFireRate = towerFireRate;
        this.towerSellPrice = towerSellPrice;
        this.towerUnlockLevel = towerUnlockLevel;
        completeView = new ScrollPane();
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        // TODO Auto-generated method stub

    }
    
    public Node getInstanceAsNode () {
        return completeView;
    }

}

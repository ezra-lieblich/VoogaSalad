package authoring.editorview.tower;

import java.util.List;


public interface ITowerUpdateView extends ITowerEditorView {

    public void updateFireRateDisplay (int rate);

    public void updateUnlockLevelDisplay (int unlockLevel);

    public void updateFrequencyDisplay (int frequency);

    public void updateRangeDisplay (int range);

    public void updateTowerImagePath (String imagePath);

    public void updateTowerName (String towerName);

    public void updateTowerBuyPriceDisplay (int buyPrice);

    public void updateTowerSellPriceDisplay (int sellPrice);

    public void updateTowerBank (List<Integer> activeTowers);

    public void createNewTower ();

}

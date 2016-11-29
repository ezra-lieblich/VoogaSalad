package engine.tower;

import java.util.List;
import authoring.editorview.tower.ITowerUpdateView;
import authoring.editorview.tower.TowerDataSource;

public class TowerTypeManagerController implements TowerDataSource {
    private TowerManager towerManager;
    private ITowerUpdateView towerView;
    private TowerBuilder towerBuilder;
    
    TowerTypeManagerController(TowerManager towerManager, ITowerUpdateView towerView) {
        this.towerManager = towerManager;
        this.towerView = towerView;
        this.towerBuilder = new TowerTypeBuilder();
    }
    
    public int create( ) {
        towerBuilder.addCostListener((oldValue, newValue) ->  towerView.updateTowerBuyPriceDisplay(newValue));
    }

    public setFireRate() {
        towerManager.getActiveEntity().setCost(cost);
    }
}

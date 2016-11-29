package engine.tower;

import java.util.List;
import com.oracle.webservices.internal.api.databinding.Databinding.Builder;
import authoring.editorview.tower.ITowerUpdateView;
import engine.AbstractTypeManagerController;


public class TowerTypeManagerController extends AbstractTypeManagerController<TowerManager, TowerBuilder, Tower, ITowerUpdateView> implements TowerManagerController {

    TowerTypeManagerController (TowerManager towerManager) {
        super(towerManager, new TowerTypeBuilder());
    }

    @Override
    public double getTowerBuyPrice (int towerID) {
        return getTypeManager().getEntity(towerID).getCost();
    }

    @Override
    public double getTowerSellPrice (int towerID) {
        return getTypeManager().getEntity(towerID).getSellAmount();
    }

    @Override
    public int getTowerUnlockLevel (int towerID) {
        return getTypeManager().getEntity(towerID).getUnlockLevel();
    }

    @Override
    public List<Integer> getTowerUpgrades (int towerID) {
        return getTypeManager().getEntity(towerID).getUpgrades();
    }

    @Override
    public List<Integer> getTowerChosenWeapons (int towerID) {
        return getTypeManager().getEntity(towerID).getWeapons();
    }

    @Override
    public List<Integer> getTowerAbilities (int towerID) {
        return getTypeManager().getEntity(towerID).getAbilities();
    }

    @Override
    public void setTowerBuyPrice (int towerID, double towerBuyPrice) {
        getTypeManager().getEntity(towerID).setCost(towerBuyPrice);
    }

    @Override
    public void setTowerSellPrice (int towerID, double towerSellPrice) {
        getTypeManager().getEntity(towerID).setSellAmount(towerSellPrice);
    }

    @Override
    public void setTowerUnlockLevel (int towerID, int towerLevel) {
        getTypeManager().getEntity(towerID).setUnlockLevel(towerLevel);
    }

    @Override
    public void setTowerChosenAbility (int towerID, int towerAbility) {
        getTypeManager().getEntity(towerID).addAbility(towerAbility);
    }

    @Override
    public void removeTowerChosenAbility (int towerID, int towerAbility) {
        getTypeManager().getEntity(towerID).removeAbility(towerAbility);
    }

    @Override
    public void setTowerChosenWeapon (int towerID, int towerChosenWeaponID) {
        getTypeManager().getEntity(towerID).addWeapon(towerChosenWeaponID);
    }

    @Override
    public void removeTowerWeapon (int towerID, int towerChosenWeaponID) {
        getTypeManager().getEntity(towerID).removeWeapon(towerChosenWeaponID);
    }

    // TODO - edit createNewTower to work with both versions
    @Override
    public int createTowerUpgrade (ITowerUpdateView towerUpdater, int parentTowerID) {
        return getTypeManager().addUpgrade(createType(towerUpdater), parentTowerID);
    }

    @Override
    public void removeTowerUpgrade (int parentTowerID, int childTowerID) {
        getTypeManager().removeUpgrade(childTowerID, parentTowerID);
    }
    
    @Override
    protected TowerBuilder constructTypeProperties (ITowerUpdateView towerUpdater,
                                                    TowerBuilder typeBuilder) {
            return typeBuilder
                .addWeaponsListener( (oldValue, newValue) -> towerUpdater
                        .updateTowerChosenWeapon(newValue))
                .addAbilitiesListener( (oldValue, newValue) -> towerUpdater
                        .updateTowerAbility(newValue))
                .addUpgradesListener( (oldValue, newValue) -> towerUpdater
                        .updateTowerUpgradeBank(newValue))
                .addCostListener((oldValue, newValue) -> towerUpdater
                        .updateTowerBuyPriceDisplay(newValue))
                .addSellAmountListener((oldValue, newValue) -> towerUpdater
                        .updateTowerSellPriceDisplay(newValue))
                .addUnlockLevelListener((oldValue, newValue) -> towerUpdater
                        .updateUnlockLevelDisplay(newValue));
    }

    @Override
    public int createType (ITowerUpdateView updateView) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteType (int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getName (int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getImagePath (int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double getSize (int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> getCreatedTypeIds () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setName (int id, String name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setImagePath (int id, String imagePath) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSize (int id, double size) {
        // TODO Auto-generated method stub
        
    }


}

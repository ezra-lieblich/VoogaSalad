package engine.tower;

import java.util.List;
import com.oracle.webservices.internal.api.databinding.Databinding.Builder;
import authoring.editorview.tower.ITowerUpdateView;
import authoring.editorview.tower.TowerDataSource;


public class TowerTypeManagerController implements TowerDataSource {
    private TowerManager towerManager;
    private TowerBuilder towerBuilder;

    TowerTypeManagerController (TowerManager towerManager, ITowerUpdateView towerView) {
        this.towerManager = towerManager;
        this.towerBuilder = new TowerTypeBuilder();
    }

    @Override
    public String getTowerName (int towerID) {
        return towerManager.getEntity(towerID).getName();
    }

    @Override
    public double getTowerSize (int towerID) {
        return towerManager.getEntity(towerID).getSize();
    }

    @Override
    public String getTowerImagePath (int towerID) {
        return towerManager.getEntity(towerID).getImagePath();
    }

    @Override
    public double getTowerBuyPrice (int towerID) {
        return towerManager.getEntity(towerID).getCost();
    }

    @Override
    public double getTowerSellPrice (int towerID) {
        return towerManager.getEntity(towerID).getSellAmount();
    }

    @Override
    public int getTowerUnlockLevel (int towerID) {
        return towerManager.getEntity(towerID).getUnlockLevel();
    }

    @Override
    public List<Integer> getTowerUpgrades (int towerID) {
        return towerManager.getEntity(towerID).getUpgrades();
    }

    @Override
    public List<Integer> getTowerChosenWeapons (int towerID) {
        return towerManager.getEntity(towerID).getWeapons();
    }

    @Override
    public List<Integer> getTowerAbilities (int towerID) {
        return towerManager.getEntity(towerID).getAbilities();
    }

    @Override
    public List<Integer> getCreatedTowers () {
        return towerManager.getEntityIds();
    }

    private Tower createTower (ITowerUpdateView towerUpdater) {
        return towerBuilder
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
                        .updateUnlockLevelDisplay(newValue))
                .build();
    }

    @Override
    public int createNewTower (ITowerUpdateView towerUpdater) {
        return towerManager.addEntry(createTower(towerUpdater));
    }

    @Override
    public void deleteTower (int towerID) {
        towerManager.removeEntry(towerID);
    }

    @Override
    public void setTowerSize (int towerID, double towerSize) {
        towerManager.getEntity(towerID).setSize(towerSize);
    }

    @Override
    public void setTowerName (int towerID, String towerName) {
        towerManager.getEntity(towerID).setName(towerName);
    }

    @Override
    public void setTowerImagePath (int towerID, String towerImagePath) {
        towerManager.getEntity(towerID).setImagePath(towerImagePath);
    }

    @Override
    public void setTowerBuyPrice (int towerID, double towerBuyPrice) {
        towerManager.getEntity(towerID).setCost(towerBuyPrice);
    }

    @Override
    public void setTowerSellPrice (int towerID, double towerSellPrice) {
        towerManager.getEntity(towerID).setSellAmount(towerSellPrice);
    }

    @Override
    public void setTowerUnlockLevel (int towerID, int towerLevel) {
        towerManager.getEntity(towerID).setUnlockLevel(towerLevel);
    }

    @Override
    public void setTowerChosenAbility (int towerID, int towerAbility) {
        towerManager.getEntity(towerID).addAbility(towerAbility);
    }

    @Override
    public void removeTowerChosenAbility (int towerID, int towerAbility) {
        towerManager.getEntity(towerID).removeAbility(towerAbility);
    }

    @Override
    public void setTowerChosenWeapon (int towerID, int towerChosenWeaponID) {
        towerManager.getEntity(towerID).addWeapon(towerChosenWeaponID);
    }

    @Override
    public void removeTowerWeapon (int towerID, int towerChosenWeaponID) {
        towerManager.getEntity(towerID).removeWeapon(towerChosenWeaponID);
    }

    // TODO - edit createNewTower to work with both versions
    @Override
    public int createTowerUpgrade (ITowerUpdateView towerUpdater, int parentTowerID) {
        return towerManager.addUpgrade(createTower(towerUpdater), parentTowerID);
    }

    @Override
    public void removeTowerUpgrade (int parentTowerID, int childTowerID) {
        towerManager.removeUpgrade(childTowerID, parentTowerID);
    }

}

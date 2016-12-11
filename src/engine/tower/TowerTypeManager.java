package engine.tower;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import engine.AbstractTypeManager;
import engine.ManagerMediator;
import engine.ability.Ability;
import engine.ability.AbilityManager;
import engine.ability.AbilityType;
import engine.effect.EffectManager;
import engine.effect.EffectManagerFactory;
import engine.effect.EffectTypeManager;
import engine.enemy.EnemyManager;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponManager;
import engine.weapon.WeaponType;

public class TowerTypeManager extends AbstractTypeManager<Tower> implements TowerManager {

    private Map<Integer, Tower> upgrades;
    private EffectManager abilityManager;
    
    public TowerTypeManager() {
        this.upgrades = new HashMap<Integer, Tower>();
        this.abilityManager = new EffectManagerFactory().create();
        TowerBuilder testFactory = new TowerTypeBuilder(); //TODO - get rid of this
        upgrades.put(10, testFactory.build()); //TODO - get rid of this
        upgrades.put(15, testFactory.build()); //TODO - get rid of this
    }
    
    @Override
    public Tower getEntity(int id) {
        return upgrades.containsKey(id) ? upgrades.get(id) : super.getEntity(id);
    }
    
    public void visitRemoveEntry(WeaponManager manager, Integer index) {
        applyToAllEntities(a -> a.removeWeapon(index));
    }
    
    public void visitRemoveEntry(AbilityManager manager, Integer index) {
        applyToAllEntities(a -> a.removeAbility(index));
    }
        //TODO - Flatten hierarchy maybe? void or int?

    @Override
    public int addUpgrade(Tower upgrade, int parentId) {
        upgrades.put(upgrade.getId(), upgrade);
        getEntity(parentId).addUpgrade(upgrade.getId());
        return parentId;
    }

    @Override
    public void removeUpgrade (int id, int parentId) {
        upgrades.remove(id);
        getEntity(parentId).removeUpgrade(id);
    }
    
    @Override
    public Map<Integer, Tower> getUpgrades() {
        return upgrades;
    }
    
    @Override
    public int getMaxId() {
        return upgrades.keySet().isEmpty() ? -1 : Math.max(Collections.max(upgrades.keySet()), super.getMaxId());
    }

    @Override
    public EffectManager getEffectManager () {
        return abilityManager;
    }

}

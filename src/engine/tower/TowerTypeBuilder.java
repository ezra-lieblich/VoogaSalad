package engine.tower;

import engine.AbstractTypeBuilder;
import engine.ability.Ability;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.Weapon;

public class TowerTypeBuilder extends AbstractTypeBuilder<Tower> implements TowerBuilder{

    @Override
    public TowerBuilder buildUpgrade(Tower... upgrades) {
        addList(getEntity()::addUpgrade, upgrades);
        return this;
    }

    @Override
    public TowerBuilder buildWeapons(Weapon... weapons) {
        addList(getEntity()::addWeapon, weapons);
        return this;
    }
    
    @Override
    public TowerBuilder buildTargets(Enemy... targets) {
        addList(getEntity()::addEnemy, targets);
        return this;
    }
    
    @Override
    public TowerBuilder buildAbilities(Ability... targets) {
        addList(getEntity()::addAbility, targets);
        return this;
    }
    
    @Override
    public TowerBuilder buildCost(double cost) {
        getEntity().setCost(cost);
        return this;
    }
    
    @Override
    public TowerBuilder buildSellAmount(double sellAmount) {
        getEntity().setSellAmount(sellAmount);
        return this;
    }
    
    @Override
    public TowerBuilder buildUnlockLevel(int unlockLevel) {
        getEntity().setCost(unlockLevel);
        return this;
    }

    @Override
    protected Tower setNextEntityToBuild () {
        return new TowerType();
    }

    
}

package engine.weapon;

import java.util.List;
import authoring.editorview.weapon.IWeaponUpdateView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;
import engine.effect.EffectManagerController;
import engine.effect.EffectTypeManagerController;


public class WeaponTypeManagerController extends
        AbstractTypeManagerController<WeaponManager, WeaponBuilder, Weapon, IWeaponUpdateView>
        implements WeaponManagerController {

    private EffectManagerController weaponEffectManagerController;
    
    public WeaponTypeManagerController (ManagerMediator managerMediator) {
        super(new WeaponTypeManager(), new WeaponTypeBuilder(), managerMediator);
        weaponEffectManagerController = new EffectTypeManagerController(managerMediator, getTypeManager().getWeaponEffectManager());
    }

    @Override
    protected WeaponBuilder constructTypeProperties (IWeaponUpdateView weaponUpdater,
                                                     WeaponBuilder typeBuilder) {
        return typeBuilder
                .addReloadTimeListener( (oldValue, newValue) -> weaponUpdater
                        .updateFireRateDisplay(newValue))
                .addRangeListener( (oldValue, newValue) -> weaponUpdater
                        .updateRangeDisplay(newValue))
                .addSpeedListener( (oldValue, newValue) -> weaponUpdater
                        .updateSpeedDisplay(newValue))
                .addTargetsListener( (oldValue, newValue) -> weaponUpdater
                        .updateTargetEnemies(newValue))
                .addTrajectoryListener( (oldValue, newValue) -> weaponUpdater
                        .updateWeaponTrajectory(newValue));
    }

    @Override
    public void setWeaponRange (int weaponID, double weaponRange) {
        getTypeManager().getEntity(weaponID).setRange(weaponRange);
    }

    @Override
    public void setWeaponFireRate (int weaponID, double weaponFireRate) {
        getTypeManager().getEntity(weaponID).setReloadTime(weaponFireRate);
    }

    @Override
    public void setWeaponSpeed (int weaponID, double weaponSpeed) {
        getTypeManager().getEntity(weaponID).setSpeed(weaponSpeed);
    }

    @Override
    public void setWeaponCollisionEffect (int weaponID, String weaponCollisionEffect) {
        getTypeManager().getEntity(weaponID).setEffect(weaponCollisionEffect);
    }

    @Override
    public void setWeaponTrajectory (int weaponID, String weaponTrajectory) {
        getTypeManager().getEntity(weaponID).setTrajectory(weaponTrajectory);
    }

    @Override
    public void setNewWeaponTargetEnemy (int weaponID, int enemyID) {
        getTypeManager().getEntity(weaponID).addTarget(enemyID);
    }

    @Override
    public void removeWeaponTargetEnemy (int weaponID, int enemyID) {
        getTypeManager().getEntity(weaponID).removeTarget(enemyID);
    }

    @Override
    public double getWeaponRange (int weaponID) {
        return getTypeManager().getEntity(weaponID).getRange();
    }

    @Override
    public double getWeaponReloadTime (int weaponID) {
        return getTypeManager().getEntity(weaponID).getReloadTime();
    }

    @Override
    public double getWeaponSpeed (int weaponID) {
        return getTypeManager().getEntity(weaponID).getSpeed();
    }

    @Override
    public String getWeaponCollisionEffect (int weaponID) {
        return getTypeManager().getEntity(weaponID).getEffect();
    }

    @Override
    public String getWeaponTrajectory (int weaponID) {
        return getTypeManager().getEntity(weaponID).getTrajectory();
    }

    @Override
    public List<Integer> getTargetEnemies (int weaponID) {
        return getTypeManager().getEntity(weaponID).getTargets();
    }
    
    @Override
    public EffectManagerController getEffectManagerController () {
        return weaponEffectManagerController;
    }

}

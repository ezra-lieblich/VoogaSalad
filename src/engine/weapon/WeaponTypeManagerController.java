package engine.weapon;

import java.util.List;
import engine.AbstractTypeManagerController;

public class WeaponTypeManagerController extends AbstractTypeManagerController<WeaponManager, WeaponBuilder, Weapon> implements WeaponManagerController{
    
    WeaponTypeManagerController(WeaponManager weaponManager) {
        super(weaponManager, new WeaponTypeBuilder());
    }

    @Override
    protected WeaponBuilder constructTypeProperties (engine.AbstractTypeManagerController.ViewFiller viewFiller,
                                                     WeaponBuilder typeBuilder) {
        return typeBuilder
                .addEffectListener((oldValue, newValue) -> viewFiller
                                   .updateEffect(newValue))
                .addFireRateListener((oldValue, newValue) -> viewFiller
                                     .updateFireRate(newValue))
                .addRangeListener((oldValue, newValue) -> viewFiller
                                     .updateRange(newValue))
                .addSpeedListener((oldValue, newValue) -> viewFiller
                                     .updateSpeed(newValue))
                .addTargetsListener((oldValue, newValue) -> viewFiller
                                     .updateTargets(newValue))
                .addTrajectoryListener((oldValue, newValue) -> viewFiller
                                       .updateTrajectory(newValue));     
    }

    @Override
    public void setWeaponRange (int weaponID, double weaponRange) {
        getTypeManager().getEntity(weaponID).setRange(weaponRange);
    }

    @Override
    public void setWeaponFireRate (int weaponID, double weaponFireRate) {
        getTypeManager().getEntity(weaponID).setFireRate(weaponFireRate);        
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
        getTypeManager().getEntity(weaponID).addTarget(enemyID);;                                
    }

    @Override
    public void removeWeaponTargetEnemy (int weaponID, int enemyID) {
        getTypeManager().getEntity(weaponID).removeTarget(enemyID);;                                
    }

    @Override
    public double getWeaponRange (int weaponID) {
        return getTypeManager().getEntity(weaponID).getRange();                             
    }

    @Override
    public double getWeaponFireRate (int weaponID) {
        return getTypeManager().getEntity(weaponID).getFireRate();                             
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
}
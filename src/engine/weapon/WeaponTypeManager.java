package engine.weapon;

import engine.AbstractTypeManager;

public class WeaponTypeManager extends AbstractTypeManager<Weapon> implements Weapon{


    @Override
    protected Weapon createInstance () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getFireRate () {
        return getActiveEntity().getFireRate();
    }

    @Override
    public void setFireRate (double fireRate) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getPath () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPath (String path) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getEffect () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEffect (String effect) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getSpeed () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setSpeed (double speed) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getRange () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setRange (double range) {
        // TODO Auto-generated method stub
        
    }
	
}

package engine.weapon;

import java.util.List;
import engine.Type;

public interface Weapon extends Type{
    
    void removeTarget (int target);

    void addTarget (int target);

    List<Integer> getTargets ();

    double getReloadTime ();

    void setReloadTime (double fireRate);

    String getTrajectory ();

    void setTrajectory (String trajectory);

    String getEffect ();

    void setEffect (String effect);

    double getSpeed ();

    void setSpeed (double speed);

    double getRange ();

    void setRange (double range);

}

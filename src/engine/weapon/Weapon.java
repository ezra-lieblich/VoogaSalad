package engine.weapon;

import engine.Type;

public interface Weapon extends Type{

    double getFireRate ();

    void setFireRate (double fireRate);

    String getPath ();

    void setPath (String path);

    String getEffect ();

    void setEffect (String effect);

    double getSpeed ();

    void setSpeed (double speed);

    double getRange ();

    void setRange (double range);

}

package engine;

import java.util.Arrays;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import engine.enemy.EnemyManager;
import engine.level.LevelManager;
import engine.path.PathManager;
import engine.tower.TowerManager;
import engine.weapon.WeaponManager;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


public class GameData {

    private String Title;
    private ManagerMediator typeManagerMediator;
    
    @XStreamOmitField
    private XStream Serializer = new XStream(new DomDriver());

    GameData(Manager<? extends Type>... managers) {
        Arrays.asList(managers).forEach(a -> typeManagerMediator.addManager(a));
    }
    
    public String SaveData () {
        return Serializer.toXML(this);
    }
}

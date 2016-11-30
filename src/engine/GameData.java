package engine;

import java.util.Arrays;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import engine.enemy.EnemyManager;
import engine.level.LevelTypeManager;
import engine.path.PathManager;
import engine.tower.TowerManager;
import engine.weapon.WeaponTypeManager;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


public class GameData {
    private GameSettings settings;
    private ManagerMediator typeManagerMediator;
    @XStreamOmitField
    private XStream Serializer = new XStream(new DomDriver());

    GameData(GameSettings settings, Manager<? extends Type>... managers) {
        Arrays.asList(managers).forEach(a -> typeManagerMediator.addManager(a));
        this.settings = settings;
    }
    
    public String SaveData () {
        return Serializer.toXML(this);
    }
}

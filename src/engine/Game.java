package engine;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import engine.enemy.EnemyManager;
import engine.level.LevelTypeManager;
import engine.path.PathManager;
import engine.tower.TowerManager;
import engine.weapon.WeaponTypeManager;
import com.thoughtworks.xstream.annotations.XStreamOmitField;



public class Game {
	private GameSettings settings;
	private EnemyManager enemies;
	private WeaponTypeManager weapons;
	private TowerManager towers;
	private PathManager path;
	private LevelTypeManager levels;

    @XStreamOmitField
    private XStream Serializer = new XStream(new DomDriver());




    public String SaveData() {
        return Serializer.toXML(this);
    }
}


package engine;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import engine.enemy.EnemyManager;
import engine.level.LevelManager;
import engine.path.PathManager;
import engine.settings.GameModeType;
import engine.tower.TowerManager;
import engine.weapon.WeaponManager;
import com.thoughtworks.xstream.annotations.XStreamOmitField;



public class GameData {
	private GameModeType settings;
	private EnemyManager enemies;
	private WeaponManager weapons;
	private TowerManager towers;
	private PathManager path;
	private LevelManager levels;

    @XStreamOmitField
    private XStream Serializer = new XStream(new DomDriver());




    public String SaveData() {
        return Serializer.toXML(this);
    }
}


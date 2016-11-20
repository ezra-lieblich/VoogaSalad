package engine;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.annotations.XStreamOmitField;



public class Game {
	private GameSettings settings;
	private EnemyTypeManager enemies;
	private WeaponTypeManager weapons;
	private TowerTypeManager towers;
	private PathManager path;
	private LevelManager levels;

    @XStreamOmitField
    private XStream Serializer = new XStream(new DomDriver());




    public String SaveData() {
        return Serializer.toXML(this);
    }
}


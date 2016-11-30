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
    private ManagerMediator managerMediator;
    
    GameData(ManagerMediator managerMediator) {
        this.managerMediator = managerMediator;
    }

    public String getTitle () {
        return Title;
    }

    public void setTitle (String title) {
        Title = title;
    }
}

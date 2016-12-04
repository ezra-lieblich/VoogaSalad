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


public class GameAuthoringData implements GameData {

    private String title;
    private String Author;
    private ManagerMediator managerMediator;
    
    GameAuthoringData(ManagerMediator managerMediator) {
        this.managerMediator = managerMediator;
    }

    @Override
    public String getTitle () {
        return title;
    }

    @Override
    public void setTitle (String title) {
        this.title = title;
    }

    @Override
    public String getAuthor () {
        return Author;
    }

    @Override
    public void setAuthor (String author) {
        Author = author;
    }

    @Override
    public ManagerMediator getManagerMediator () {
        return managerMediator;
    }
}

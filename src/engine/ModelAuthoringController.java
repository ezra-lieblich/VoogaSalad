package engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import engine.ability.AbilityManagerController;
import engine.ability.AbilityTypeManagerController;
import engine.enemy.EnemyManagerController;
import engine.enemy.EnemyTypeManagerController;
import engine.level.LevelManagerController;
import engine.level.LevelTypeManagerController;
import engine.path.PathManagerController;
import engine.path.PathTypeManagerController;
import engine.settings.GameModeManagerController;
import engine.settings.GameModeTypeManagerController;
import engine.tower.TowerManagerController;
import engine.tower.TowerTypeManagerController;
import engine.weapon.WeaponManagerController;
import engine.weapon.WeaponTypeManagerController;

/**
 * This is the master level model authoring controller that handles interactions between the model and the master view controllers
 * 
 * @author seanhudson
 *
 */
public class ModelAuthoringController implements ModelController {
    private Map<Class<?>, ManagerController<?, ?, ?, ?>> modelControllers;
    private GameData gameData;
    private XStream Serializer = new XStream(new DomDriver());
    
    public ModelAuthoringController() {
        modelControllers = new HashMap<Class<?>, ManagerController<?, ?, ?, ?>>();
        ManagerMediator managerMediator = new ManagerTypeMediator();
        gameData = new GameAuthoringData(managerMediator);
        initializeControllers(managerMediator);
    }
    
    @Override
    public <R> R getModelController(Class<R> key) {
        return key.cast(modelControllers.get(key));
    }
    
    @Override
    public String SaveData () {
        return Serializer.toXML(gameData);
    }
    
    //TODO - reflection
    private void initializeControllers(ManagerMediator managerMediator) {
        modelControllers.put(GameModeManagerController.class, new GameModeTypeManagerController(managerMediator));
        modelControllers.put(TowerManagerController.class, new TowerTypeManagerController(managerMediator));
        modelControllers.put(WeaponManagerController.class, new WeaponTypeManagerController(managerMediator));
        modelControllers.put(AbilityManagerController.class, new AbilityTypeManagerController(managerMediator));
        modelControllers.put(PathManagerController.class, new PathTypeManagerController(managerMediator));
        modelControllers.put(EnemyManagerController.class, new EnemyTypeManagerController(managerMediator));
        modelControllers.put(LevelManagerController.class, new LevelTypeManagerController(managerMediator));
    }

	@Override
	public GameAuthoringData loadData(String filePath) throws FileNotFoundException {
			File xmlFile = new File(filePath);
			GameAuthoringData data = (GameAuthoringData) Serializer.fromXML(new FileInputStream(xmlFile));
			return data;
	}

	@Override
	public GameData getGameData() {
		return gameData;
	}
}

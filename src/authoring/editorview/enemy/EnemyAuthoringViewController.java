package authoring.editorview.enemy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.editorview.ListCellData;
import authoring.editorview.ListDataSource;
import authoring.editorview.collisioneffects.EffectAuthoringViewController;
import engine.effect.EffectManagerController;
import engine.effect.Reflection;
import engine.effect.ReflectionException;
import engine.enemy.*;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public class EnemyAuthoringViewController extends EditorViewController
        implements EnemyAuthoringViewDelegate, ListDataSource, EnemyUpdateView {

    private EnemyManagerController enemyDataSource;
    private EffectManagerController effectDataSource;
    private int currentEnemyID;
    private EnemyAuthoringView enemyView;
    private ResourceBundle labelsResource =
            ResourceBundle.getBundle("resources/GameAuthoringEnemy");
    private ResourceBundle reflectTest = ResourceBundle.getBundle("resources/EnemyReflection");
    private Map<String, Class<?>> myClasses;

    private static final String NO_MATCHING_PUBLIC_METHOD = "No matching public method %s for %s";
    private static final String INCORRECTLY_NAMED_CLASS = "Incorrectly named class %s";

    public EnemyAuthoringViewController (int editorWidth, int editorHeight) {
        makeFields();
        enemyView = new EnemyAuthoringView(myClasses);
        enemyView.setDelegate(this);
        enemyView.setEnemyListDataSource(this);
        this.view = enemyView;
    }

    public void setEnemyDataSource (EnemyManagerController source) {
        this.enemyDataSource = source;
        this.enemyDataSource.addTypeBankListener(this);
        effectDataSource = enemyDataSource.getEffectManagerController();
        onUserPressedCreateEnemy();
    }

    @Override
    public void onUserPressedCreateEnemy () {
        currentEnemyID = enemyDataSource.createType(this);
        refreshView();
    }

    @Override
    public void onUserEnteredEnemySpeed (String enemySpeed) {
        enemyDataSource.setEnemySpeed(currentEnemyID, Double.parseDouble(enemySpeed));
    }

    @Override
    public void onUserEnteredEnemyHealth (String enemyHealth) {
        enemyDataSource.setEnemyHealth(currentEnemyID, Double.parseDouble(enemyHealth));
    }

    @Override
    public void onUserEnteredEnemyDamage (String enemyDamage) {
        enemyDataSource.setEnemyDamage(currentEnemyID, Double.parseDouble(enemyDamage));
    }

    @Override
    public void onUserEnteredEnemyPoints (String enemyRewardPoints) {
        enemyDataSource.setEnemyRewardScore(currentEnemyID, Double.parseDouble(enemyRewardPoints));
    }

    @Override
    public void onUserEnteredEnemyMoney (String enemyRewardMoney) {
        enemyDataSource.setEnemyRewardMoney(currentEnemyID,
                                            Double.parseDouble(enemyRewardMoney));
    }

    @Override
    public void onUserEnteredEnemyImagePath (String enemyImagePath) {
        enemyDataSource.setImagePath(currentEnemyID, enemyImagePath);
    }

    @Override
    public void onUserEnteredEnemyName (String enemyName) {
        enemyDataSource.setName(currentEnemyID, enemyName);
    }

    @Override
    public void onUserPressedDeleteEnemy () {
        enemyDataSource.deleteType(currentEnemyID);
        this.refreshView();
    }

    @Override
    public void onUserEnteredEnemySize (String enemySize) {
        enemyDataSource.setSize(currentEnemyID,
                                Double.parseDouble(enemySize));
    }

    public void refreshView () {
        updateImagePathDisplay(enemyDataSource.getImagePath(currentEnemyID));
        updateNameDisplay(enemyDataSource.getName(currentEnemyID));
        updateSizeDisplay(enemyDataSource.getSize(currentEnemyID));
        updateEnemyDamage(enemyDataSource.getEnemyDamage(currentEnemyID));
        updateEnemySpeed(enemyDataSource.getEnemySpeed(currentEnemyID));
        updateEnemyRewardMoney(enemyDataSource.getEnemyRewardMoney(currentEnemyID));
        updateEnemyRewardPoints(enemyDataSource.getEnemyRewardScore(currentEnemyID));
        updateEnemyHealthDisplay(enemyDataSource.getEnemyHealth(currentEnemyID));
    }

    @Override
    public ListCellData getCellDataForSubject (int enemyID) {
        ListCellData cellData = new ListCellData();
        cellData.setName(enemyDataSource.getName(enemyID));
        cellData.setImagePath(enemyDataSource.getImagePath(enemyID));
        cellData.setId(enemyID);
        return cellData;
    }

    @Override
    public void onUserSelectedEnemy (int enemyID) {
        currentEnemyID = enemyID;
        refreshView();
    }

    @Override
    public void onUserPressedAddEffect () {
        EffectAuthoringViewController effectAuthoringView =
                new EffectAuthoringViewController(effectDataSource);
        effectDataSource.createType(effectAuthoringView.getEffectAuthoringView());
        effectAuthoringView.setEffectOptions(effectDataSource.getCreatedTypeIds());
        effectAuthoringView.setAvailClasses(effectDataSource.getAvailableClasses());
        effectAuthoringView.setAvailDataObjects(effectDataSource.getAvailableDataObjects());
        effectAuthoringView.openEffectView();
    }

    private void makeFields () {
        myClasses = new HashMap<>();
        for (String packageName : reflectTest.keySet()) {
            Object testing;
            try {
                testing = Reflection.createInstance(packageName, labelsResource);
                testing =
                        testing.getClass().getConstructor(ResourceBundle.class)
                                .newInstance(labelsResource);
                myClasses.put(reflectTest.getString(packageName).toLowerCase(), testing.getClass());
            }
            catch (IllegalArgumentException | SecurityException | InstantiationException
                    | InvocationTargetException | IllegalAccessException e) {
                throw new ReflectionException(e, INCORRECTLY_NAMED_CLASS);
            }
            catch (NoSuchMethodException e) {
                throw new ReflectionException(e, NO_MATCHING_PUBLIC_METHOD);
            }
        }
    }

    @Override
    public void updateEnemySpeed (double speed) {
        Class<?> enemySpeed = myClasses.get("speed");
        updateFieldsThroughReflection(enemySpeed, Double.toString(speed));
    }

    @Override
    public void updateEnemyBank (List<Integer> activeEnemies) {
        Class<?> enemyBank = myClasses.get("bank");
        updateFieldsThroughReflection(enemyBank, activeEnemies);
    }

    @Override
    public void updateEnemyHealthDisplay (double health) {
        Class<?> enemyHealth = myClasses.get("health");
        updateFieldsThroughReflection(enemyHealth, Double.toString(health));
    }

    @Override
    public void updateEnemyDamage (double damage) {
        Class<?> enemyDamage = myClasses.get("damage");
        updateFieldsThroughReflection(enemyDamage, Double.toString(damage));
    }

    @Override
    public void updateEnemyRewardMoney (double rewardMoney) {
        Class<?> enemyRewardMoney = myClasses.get("money");
        updateFieldsThroughReflection(enemyRewardMoney, Double.toString(rewardMoney));
    }

    @Override
    public void updateEnemyRewardPoints (double rewardPoints) {
        Class<?> enemyRewardPoints = myClasses.get("points");
        updateFieldsThroughReflection(enemyRewardPoints, Double.toString(rewardPoints));
    }

    @Override
    public void updateNameDisplay (String name) {
        Class<?> enemyName = myClasses.get("name");
        updateFieldsThroughReflection(enemyName, name);
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        Class<?> enemyImagePath = myClasses.get("image");
        updateFieldsThroughReflection(enemyImagePath, imagePath);
    }

    @Override
    public void updateSizeDisplay (double size) {
        Class<?> enemySize = myClasses.get("size");
        updateFieldsThroughReflection(enemySize, Double.toString(size));
    }

    @Override
    public void updateBank (List<Integer> ids) {
        Class<?> enemyBank = myClasses.get("bank");
        updateFieldsThroughReflection(enemyBank, ids);
    }

    private void updateFieldsThroughReflection (Class<?> classToUpdate, Object updatedData) {
        try {
            Object enemySpeedObject =
                    classToUpdate.getConstructor(ResourceBundle.class).newInstance(labelsResource);
            Class<?>[] methodParameters = new Class[] { String.class };
            Method method = classToUpdate.getDeclaredMethod("updateField", methodParameters);
            Object[] params = new Object[] { updatedData };
            method.setAccessible(true);
            method.invoke(enemySpeedObject, params);
        }
        catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | InstantiationException | SecurityException e) {
            throw new ReflectionException(e, NO_MATCHING_PUBLIC_METHOD);
        }
    }

}

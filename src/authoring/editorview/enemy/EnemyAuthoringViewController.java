// This entire file is a part of my masterpiece
// Kayla Schulz

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
 * I chose this file as a part of my masterpiece, because it shows vast improvements from the way
 * this controller was previously implemented. Previously, all of the enemy subfields (such as
 * delete enemy,
 * enemy size, etc.) were individually initialized as instance variables. They would then be passed
 * to another
 * class to show on the scene. There was a good amount of initialization and a lot of duplicated
 * code. Through
 * reflection, I have eliminated the large amount of duplicated code and unnecessary initialization
 * of all
 * of those fields.
 * 
 * Another improvement was error checking. Previously, we would check for incorrect inputs in this
 * controller.
 * (Inside of each onUserEntered.... method, we would try to parse the double (when necessary) and
 * throw
 * a dialogue box if they put in an incorrect input. Now, that functionality is built into each text
 * field so
 * there is no longer duplicated error checking in the controller. Instead, it happens right when
 * the text field is created.
 * 
 * Another huge improvement was moving the update fields to the controller. Previously, we sent all
 * of the information
 * to the back end through this controller, but the back end controller directly updated our view.
 * Later on
 * through our project, we ran into problems where our program would be more flexible if everything
 * was run
 * through the controller. With this use of reflection and updating, the program is immensely more
 * flexible,
 * allowing for more functionality and communication with the back end.
 * 
 * 
 * Finally, this controller shows a good example of inheritance and the use of interfaces. The
 * controller
 * is simply the centerpiece of our project. (Well in this case, the centerpiece of the enemy view.)
 * All of the
 * other components come together in the controller and it is important it maintains order while
 * communicating
 * with the back end. The EnemyAuthoringViewDelegate and EnemyUpdateView show exactly how our
 * information is
 * passed from the model and the view and give a good picture of how to add to our program when a new field is desired.
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
        ResourceBundle enemyClasses = ResourceBundle.getBundle("resources/EnemyReflection");
        for (String packageName : enemyClasses.keySet()) {
            Object testing;
            try {
                testing = Reflection.createInstance(packageName, labelsResource);
                myClasses.put(enemyClasses.getString(packageName).toLowerCase(),
                              testing.getClass());
            }
            catch (IllegalArgumentException | SecurityException e) {
                throw new ReflectionException(e, INCORRECTLY_NAMED_CLASS);
            }
        }
    }

    @Override
    public void updateEnemySpeed (double speed) {
        updateFieldsThroughReflection(myClasses.get("speed"), Double.toString(speed));
    }

    @Override
    public void updateEnemyBank (List<Integer> activeEnemies) {
        updateFieldsThroughReflection(myClasses.get("bank"), activeEnemies);
    }

    @Override
    public void updateEnemyHealthDisplay (double health) {
        updateFieldsThroughReflection(myClasses.get("health"), Double.toString(health));
    }

    @Override
    public void updateEnemyDamage (double damage) {
        updateFieldsThroughReflection(myClasses.get("damage"), Double.toString(damage));
    }

    @Override
    public void updateEnemyRewardMoney (double rewardMoney) {
        updateFieldsThroughReflection(myClasses.get("money"), Double.toString(rewardMoney));
    }

    @Override
    public void updateEnemyRewardPoints (double rewardPoints) {
        updateFieldsThroughReflection(myClasses.get("points"), Double.toString(rewardPoints));
    }

    @Override
    public void updateNameDisplay (String name) {
        updateFieldsThroughReflection(myClasses.get("name"), name);
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        updateFieldsThroughReflection(myClasses.get("image"), imagePath);
    }

    @Override
    public void updateSizeDisplay (double size) {
        updateFieldsThroughReflection(myClasses.get("size"), Double.toString(size));
    }

    @Override
    public void updateBank (List<Integer> ids) {
        updateFieldsThroughReflection(myClasses.get("bank"), ids);
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

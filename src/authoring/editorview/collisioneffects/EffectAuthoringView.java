package authoring.editorview.collisioneffects;

import java.util.List;
import authoring.editorview.ListDataSource;
import authoring.editorview.collisioneffects.subviews.EffectAvailableClassesView;
import authoring.editorview.collisioneffects.subviews.EffectAvailableDataObjectsView;
import authoring.editorview.collisioneffects.subviews.EffectAvailableMethodsView;
import authoring.editorview.collisioneffects.subviews.EffectBank;
import authoring.editorview.collisioneffects.subviews.EffectDataView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAuthoringView implements EffectUpdateView {

    private GridPane effectsPane;
    private EffectBank effectBank;
    private EffectAvailableClassesView effectAvailClasses;
    private EffectAvailableDataObjectsView effectDataObjects;
    private EffectAvailableMethodsView effectAvailMethods;
    private EffectDataView effectDataView;
    private Scene myScene;

    public EffectAuthoringView () {
        effectBank = new EffectBank();
        effectsPane = new GridPane();
        effectAvailClasses = new EffectAvailableClassesView();
        effectDataObjects = new EffectAvailableDataObjectsView();
        effectAvailMethods = new EffectAvailableMethodsView();
        effectDataView = new EffectDataView();
        setPane();
        myScene = new Scene(effectsPane);
    }

    private void setPane () {
        effectsPane.add(effectBank.getInstanceAsNode(), 0, 0, 1, 1);
        effectsPane.add(effectAvailClasses.getInstanceAsNode(), 1, 0, 1, 1);
        effectsPane.add(effectDataObjects.getInstanceAsNode(), 2, 0, 1, 1);
        effectsPane.add(effectAvailMethods.getInstanceAsNode(), 3, 0, 1, 1);
        effectsPane.add(effectDataView.getInstanceAsNode(), 0, 1, GridPane.REMAINING, 1);
    }

    public Scene getScene () {
        return myScene;
    }

    public void openEffectView () {
        Stage stage = new Stage();
        // setDelegate(); this needs to be controller
        Scene myScene = getScene();
        stage.setScene(myScene);
        stage.show();
    }

    @Override
    public void updateEffectName (String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createNewEffect () {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteEffect () {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEffectListDataSource (ListDataSource source) {
        this.effectBank.setListDataSource(source);
    }

    @Override
    public void updateConditionField (String condition) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateEffectField (String effect) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateEffectBank (List<Integer> effects) {
        effectBank.updateBank(effects);
    }

    @Override
    public void updateListedAvailableClasses (List<String> availClasses) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateSelectedAvailableClass (String selectedClass) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateAvailableMethods (List<String> availMethods) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateAvailableDataObjects (List<String> availDataObjects) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        effectDataView.setDelegate(delegate);
        effectAvailMethods.setDelegate(delegate);
        effectAvailClasses.setDelegate(delegate);
        effectDataObjects.setDelegate(delegate);
    }

    @Override
    public Node getInstanceAsNode () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateNameDisplay (String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateSizeDisplay (double size) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateBank (List<Integer> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub

    }

    @Override
    public Integer getNearestAvailableItemID (int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateTriggers (List<String> triggers) {
        // TODO Auto-generated method stub

    }

}

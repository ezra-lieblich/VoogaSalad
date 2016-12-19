package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.EnemySetView;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyRewardPointsField extends TextFieldView implements EnemySetView {

    private EnemyAuthoringViewDelegate delegate;

    public EnemyRewardPointsField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
    	textField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyPoints(textField
                                                               .getText()));
    	textField.setPrefWidth(110);
        root = GridFactory.createRowWithLabelandNode(
                                                     labelsResource.getString("RewardPoints"),
                                                     textField,
                                                     170);
    }

}

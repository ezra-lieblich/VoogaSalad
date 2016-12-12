package authoring.editorview.collisioneffects;

import java.util.List;
import authoring.editorview.IUpdateView;
import authoring.editorview.ListDataSource;


/**
 * 
 * @author Kayla Schulz
 *
 */
public interface EffectUpdateView extends EffectSetView, IUpdateView {

    public void createNewEffect ();

    public void deleteEffect ();

    public void updateEffectName (String name);

    public void updateConditionField (String condition);

    public void updateEffectField (String effect);

    public void updateListedEffects (List<Integer> effects);

    public void updateListedAvailableClasses (List<String> availClasses);

    public void updateSelectedAvailableClass (String selectedClass);

    public void updateAvailableMethods (List<String> availMethods);

    public void updateAvailableDataObjects (List<String> availDataObjects);

    public void setEffectListDataSource (ListDataSource source);

    public void openEffectView ();
    
    public void updateTriggers(List<String> triggers);

}

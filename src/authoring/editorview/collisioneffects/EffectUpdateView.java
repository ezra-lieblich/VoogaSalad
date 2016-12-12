package authoring.editorview.collisioneffects;

import java.util.List;
import authoring.editorview.ListDataSource;


public interface EffectUpdateView {

    public void createNewEffect ();

    public void deleteEffect ();

    public void updateEffectName (String name);

    public void updateConditionField (String condition);

    public void updateEffectField (String effect);

    public void updateListedEffects (List<String> effects);

    public void updateListedAvailableClasses (List<String> availClasses);

    public void updateSelectedAvailableClass (String selectedClass);

    public void updateAvailableMethods (List<String> availMethods);

    public void updateAvailableDataObjects (List<String> availDataObjects);

    public void setEffectListDataSource (ListDataSource source);

}

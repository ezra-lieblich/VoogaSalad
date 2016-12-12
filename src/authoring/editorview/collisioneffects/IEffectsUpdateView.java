package authoring.editorview.collisioneffects;

import authoring.editorview.ListDataSource;


public interface IEffectsUpdateView {

    public void updateEffectName (String name);

    public void createNewEffect ();

    public void deleteEffect ();

    public void setEffectListDataSource (ListDataSource source);

}

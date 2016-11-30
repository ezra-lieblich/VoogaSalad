package authoring.editorview.enemy;

import authoring.editorview.IEditorView;
import authoring.editorview.enemy.subviews.EnemyListDataSource;


/**
 * The Enemy View interface will detail the components of the enemy creation. The interface
 * determines a portion of our internal API.
 * 
 * @author Kayla Schulz
 *
 */
public interface IEnemySetView extends IEditorView {

    public void setDelegate (EnemyEditorViewDelegate delegate);
    

}

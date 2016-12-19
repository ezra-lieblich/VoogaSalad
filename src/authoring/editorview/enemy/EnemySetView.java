package authoring.editorview.enemy;

import authoring.editorview.ListDataSource;


/**
 * The Enemy View interface will detail the components of the enemy creation. The interface
 * determines a portion of our internal API.
 * 
 * @author Kayla Schulz
 *
 */
public interface EnemySetView extends EnemySubView {

    public void setEnemyListDataSource (ListDataSource source);

}

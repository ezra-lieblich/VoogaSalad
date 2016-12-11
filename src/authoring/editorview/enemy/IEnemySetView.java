package authoring.editorview.enemy;

import authoring.editorview.INodeView;


/**
 * The Enemy View interface will detail the components of the enemy creation. The interface
 * determines a portion of our internal API.
 * 
 * @author Kayla Schulz
 *
 */
public interface IEnemySetView extends INodeView {

    public void setDelegate (EnemyAuthoringViewDelegate delegate);

}

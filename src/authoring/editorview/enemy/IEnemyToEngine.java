package authoring.editorview.enemy;

public interface IEnemyToEngine {

    /**
     * Sets the enemy image in the game engine
     * @param enemyImageID from the user
     */
    public void setEnemyImage(int enemyImageID);
    
    //public void placeEnemyImageInMap(int enemyImageID, )
    
    /**
     * Creates new enemy
     */
    public void initNewEnemy();
}
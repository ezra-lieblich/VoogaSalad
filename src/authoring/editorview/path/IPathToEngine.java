package authoring.editorview.path;

public interface IPathToEngine {

    /**
     * Pass the background image to game engine
     * 
     * @param background image set by user
     */
    public void setGameBackground (int backgroundID);

    /**
     * 
     * @param pathImage set by the user
     */
    public void setPathImage (int pathImageID);
}

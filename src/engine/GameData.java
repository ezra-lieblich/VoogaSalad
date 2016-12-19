package engine;

/**
 * This interface provides the methods for accessing the data inside of GameData
 * 
 * @author seanhudson
 *
 */
public interface GameData {

    String getTitle ();

    void setTitle (String title);

    String getAuthor ();

    void setAuthor (String author);

    ManagerMediator getManagerMediator();
}

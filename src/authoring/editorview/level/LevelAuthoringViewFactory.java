package authoring.editorview.level;

/**
 * 
 * @author Kayla Schulz
 *
 */
public class LevelAuthoringViewFactory {

    public static ILevelUpdateView build (int width, int height) {

        return new LevelAuthoringView(width, height);

    }

}

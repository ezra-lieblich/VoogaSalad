package authoring.editorview.level;

/**
 * 
 * @author Kayla Schulz
 *
 */
public class LevelEditorViewFactory {

    public static ILevelEditorView build (int width, int height) {

        return new LevelEditorView(width, height);

    }

}

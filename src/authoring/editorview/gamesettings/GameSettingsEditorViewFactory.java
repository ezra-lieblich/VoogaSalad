package authoring.editorview.gamesettings;

/**
 * 
 * @author Kayla Schulz
 *
 */
public class GameSettingsEditorViewFactory {

    private GameSettingsEditorViewFactory () {
        // Does Nothing
    }

    public static IGameSettingsEditorView build (int width, int height) {
        return new GameSettingsEditorView(width, height);
    }

}

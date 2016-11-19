package authoring.editorview.gamesettings;

public class GameSettingsEditorViewFactory {

    private GameSettingsEditorViewFactory () {
        // Does Nothing
    }

    public static IGameSettingsEditorView build (int width, int height) {
        return new GameSettingsEditorView(width, height);
    }

}

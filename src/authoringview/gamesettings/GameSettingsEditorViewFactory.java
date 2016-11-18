package authoringview.gamesettings;

public class GameSettingsEditorViewFactory {

    private GameSettingsEditorViewFactory () {
        // Does Nothing
    }

    public static IGameSettingsEditorView build (int aWidth, int aHeight) {
        return new GameSettingsEditorView(aWidth, aHeight);
    }

}

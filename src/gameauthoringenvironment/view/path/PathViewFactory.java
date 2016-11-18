package gameauthoringenvironment.view.path;

public class PathViewFactory {

    private PathViewFactory () {
        // Does Nothing
    }

    public static IPathView build (int aWidth, int aHeight) {
        return new PathEditorView(aWidth, aHeight);
    }

}

package authoring.editorview.path;

public class PathEditorViewFactory {

    private PathEditorViewFactory () {
        // Does Nothing
    }

    public static IPathEditorView build (int aWidth, int aHeight) {
        return new PathEditorView(aWidth, aHeight);
    }

}

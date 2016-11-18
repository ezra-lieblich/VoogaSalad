package gameauthoringenvironment.view.createscene.editortabpane;

public class EditorTabPaneFactory {

    private EditorTabPaneFactory () {
        // Does Nothing
    }

    public static IEditorTabPane build (int aWidth, int aHeight) {
        return new EditorTabPane(aWidth, aHeight);
    }

}

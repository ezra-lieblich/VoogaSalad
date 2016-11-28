package authoring.editortabpane;

import java.util.List;

public class EditorTabPaneFactory {

    private EditorTabPaneFactory () {
        // Does Nothing
    }

    public static IEditorTabPane build (int aWidth, int aHeight, List<String> tabs) {
        return new EditorTabPane(aWidth, aHeight, tabs);
    }

}

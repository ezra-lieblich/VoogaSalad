package gameauthoringenvironment.view.createscene;


public class ToolbarFactory {

    private ToolbarFactory () {
        // Does Nothing
    }

    public static IToolbar build (int aWidth, int aHeight) {
        return new Toolbar(aWidth, aHeight);
    }

    
}

package gameauthoringenvironment.view.createscene.sidetabbedtoolbar;

public class SideTabbedToolbarFactory {

    private SideTabbedToolbarFactory () {
        // Does Nothing
    }

    public static ISideTabbedToolbar build (int aWidth, int aHeight) {
        return new SideTabbedToolbar(aWidth, aHeight);
    }

}

package gameauthoringenvironment.view.createscene.sidetabbedtoolbar;

import javafx.scene.Node;
import javafx.scene.control.TabPane;

public class SideTabbedToolbar implements ISideTabbedToolbar {

    private TabPane myTabPane;
    
    public SideTabbedToolbar(int aWidth, int aHeight) {
        myTabPane = new TabPane();
        myTabPane.setPrefSize(aWidth, aHeight);
    }

    @Override
    public Node getInstanceAsNode () {
        return myTabPane;
    }
    
}

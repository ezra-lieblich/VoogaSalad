package gameauthoringenvironment.view.createscene.sidetabbedtoolbar;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class SideTabbedToolbar implements ISideTabbedToolbar {

    private TabPane myTabPane;

    public SideTabbedToolbar (int aWidth, int aHeight) {
        myTabPane = new TabPane();
        myTabPane.setPrefSize(aWidth, aHeight);
        setTabs();
    }

    private void setTabs () {
        Tab myTestTab = new Tab();
        myTestTab.setText("Enemy");
        myTabPane.getTabs().addAll(myTestTab);
        myTabPane.setSide(Side.RIGHT);
    }

    @Override
    public Node getInstanceAsNode () {
        return myTabPane;
    }

}

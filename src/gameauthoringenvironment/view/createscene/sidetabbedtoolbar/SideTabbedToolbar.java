package gameauthoringenvironment.view.createscene.sidetabbedtoolbar;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


/**
 * Much of this and the idea for the ribbon menu comes from the following link:
 * https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 * 
 * @author Kayla Schulz
 *
 */
public class SideTabbedToolbar implements ISideTabbedToolbar {
    //TODO: TabPane or Ribbon Menu?
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

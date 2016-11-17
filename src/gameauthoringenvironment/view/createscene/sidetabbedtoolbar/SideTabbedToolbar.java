package gameauthoringenvironment.view.createscene.sidetabbedtoolbar;

import gameauthoringenvironment.view.enemy.EnemyView;
import gameauthoringenvironment.view.enemy.EnemyViewFactory;
import gameauthoringenvironment.view.enemy.IEnemyView;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;


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
    private IEnemyView enemyView;

    public SideTabbedToolbar (int aWidth, int aHeight) {
        myTabPane = new TabPane();
        myTabPane.setPrefSize(aWidth, aHeight);
        setTabs();
    }

    private void setTabs () {
        Tab myTestTab = new Tab();
        myTestTab.setText("Enemy");
        enemyView = EnemyViewFactory.build();    
        myTestTab.setContent(enemyView.getNodeAsInstance());
        

        
        myTabPane.getTabs().addAll(myTestTab);
        myTabPane.setSide(Side.RIGHT);
        
        
    }

    @Override
    public Node getInstanceAsNode () {
        return myTabPane;
    }

}

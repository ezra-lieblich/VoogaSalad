package gameauthoringenvironment.view.createscene.sidetabbedtoolbar;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


/**
 * Much of this and the idea for the ribbon menu comes from the following link:
 * https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 * 
 * @author Kayla Schulz
 *
 */
public class SideTabbedToolbar implements ISideTabbedToolbar {

    private Button enemyButton;
    private TabPane tabPane;

    public SideTabbedToolbar (int width, int height) {
        tabPane = new TabPane();
        //tabPane.setMaxSize(width/10, height);
        //tabPane.setPrefSize(width/10, height);
        tabPane.setSide(Side.RIGHT);
        buildRibbonMenu();
    }

    private void buildRibbonMenu () {
        HBox myTestBox = new HBox();
        
        this.enemyButton = new Button();
        this.enemyButton.setText("Enemy");
        Image enemy = new Image(getClass().getClassLoader().getResourceAsStream("enemy.png"));
        ImageView enemyImage = new ImageView(enemy);
        enemyImage.setFitHeight(30);
        enemyImage.setFitWidth(30);
        this.enemyButton.setGraphicTextGap(5.0);
        this.enemyButton.setGraphic(enemyImage);
        Tab testTab = new Tab();
        //testTab.setText("Enemy");
        //testTab.setGraphic(enemyImage);
        myTestBox.getChildren().add(enemyButton);
        testTab.setContent(myTestBox);
       
        testTab.setClosable(false);
        tabPane.getTabs().add(testTab);
        
        //this.towerButton = new 
    }

    @Override
    public Node getInstanceAsNode () {
        return tabPane;
    }

}

/*
 * //TODO: TabPane or Ribbon Menu?
 * private TabPane myTabPane;
 * 
 * public SideTabbedToolbar (int aWidth, int aHeight) {
 * myTabPane = new TabPane();
 * myTabPane.setPrefSize(aWidth, aHeight);
 * setTabs();
 * }
 * 
 * private void setTabs () {
 * Tab myTestTab = new Tab();
 * myTestTab.setText("Enemy");
 * myTabPane.getTabs().addAll(myTestTab);
 * myTabPane.setSide(Side.RIGHT);
 * }
 * 
 * @Override
 * public Node getInstanceAsNode () {
 * return myTabPane;
 * }
 */

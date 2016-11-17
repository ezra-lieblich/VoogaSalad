package gameauthoringenvironment.view.createscene.sidetabbedtoolbar;


import gameauthoringenvironment.view.tower.ITowerView;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Much of this and the idea for the ribbon menu comes from the following link:
 * https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 * 
 * @author Kayla Schulz
 *
 */
public class SideTabbedToolbar implements ISideTabbedToolbar {

    //private ITowerView towerView;

    private Button enemyButton;
    private Button towerButton;
    private TabPane tabPane;

    public SideTabbedToolbar (int width, int height) {
        tabPane = new TabPane();
        //tabPane.setMaxSize(width/10, height);
        //tabPane.setMinSize(width/10, height);
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabMaxHeight(100);
        tabPane.setTabMaxWidth(30);
        
        tabPane.setTabMinHeight(100);
        tabPane.setTabMinWidth(30);
   
        buildRibbonMenu();
    }

    private void buildRibbonMenu () {
        
        this.enemyButton = buildButton("Enemy", "enemy.png");
        this.towerButton = buildButton("Tower", "tower.png");

        Tab testTab = new Tab();
        Tab testTab2 = new Tab();

        testTab.setGraphic(enemyButton);
        testTab2.setGraphic(towerButton);
        
        tabPane.getTabs().add(testTab);
        tabPane.getTabs().add(testTab2);
       
        testTab.setClosable(false);
        testTab2.setClosable(false);

}
    private Button buildButton(String text, String fileName) {
        Button button = new Button();
        button.setText(text);
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(fileName));
        ImageView curImage = new ImageView(image);
        curImage.setFitHeight(30);
        curImage.setFitWidth(30);
        button.setGraphic(curImage);
        button.setGraphicTextGap(5); 
        button.setMinSize(100, 30);
        return button;
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


/*this.enemyButton = new Button();
this.enemyButton.setText("Enemy");
Image enemy = new Image(getClass().getClassLoader().getResourceAsStream("enemy.png"));
ImageView enemyImage = new ImageView(enemy);
enemyImage.setFitHeight(30);
enemyImage.setFitWidth(30);

this.towerButton = new Button();
this.towerButton.setText("Tower");
Image tower = new Image(getClass().getClassLoader().getResourceAsStream("tower.png"));
ImageView towerImage = new ImageView(tower);
towerImage.setFitHeight(30);
towerImage.setFitWidth(20);

this.towerButton.setGraphicTextGap(5.0);
this.towerButton.setGraphic(towerImage);
this.towerButton.setPrefWidth(180);

this.enemyButton.setGraphicTextGap(5.0);
this.enemyButton.setGraphic(enemyImage);
//this.enemyButton.setMaxWidth(Region.USE_PREF_SIZE);
 **/

/*
 *         Tab myTestTab = new Tab();
        myTestTab.setText("Tower");
        towerView = TowerViewFactory.build();    
        myTestTab.setContent(towerView.getNodeAsInstance());
        */

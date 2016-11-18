package authoring.editortabpane;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * Much of this and the idea for the ribbon menu comes from the following link:
 * https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 * 
 * @author Kayla Schulz
 *
 */
public class EditorTabPane implements IEditorTabPane {

    // private ITowerView towerView;

    private TabPane tabPane;
    private ResourceBundle GUIResources;
    private EditorTabPaneDelegate delegate;

    public EditorTabPane (int width, int height) {
        String initFile = "resources";
        String fileName = "/GameAuthoringToolbar";
        GUIResources = ResourceBundle.getBundle(initFile + fileName);
        tabPane = new TabPane();

        tabPane.setSide(Side.RIGHT);
        tabPane.setTabMaxHeight(120);
        tabPane.setTabMaxWidth(30);

        tabPane.setTabMinHeight(120);
        tabPane.setTabMinWidth(30);

        buildRibbonMenu();
    }

    private Button enemyButton;
    private void buildRibbonMenu () {

        enemyButton = buildButton(GUIResources.getString("Enemy"), "enemy.png");
        Button towerButton = buildButton(GUIResources.getString("Tower"), "tower.png");
        Button pathButton = buildButton(GUIResources.getString("Path"), "path.png");
        Button weaponsButton = buildButton(GUIResources.getString("Weapons"), "weapons.png");
        Button settingsButton =
                buildButton(GUIResources.getString("GameSettings"), "gamesettings.png");
        Button levelButton = buildButton(GUIResources.getString("Level"), "level.png");

        buildTabs(enemyButton);
        buildTabs(towerButton);
        buildTabs(pathButton);
        buildTabs(weaponsButton);
        buildTabs(settingsButton);
        buildTabs(levelButton);

    }

    private void buildTabs (Button button) {
        Tab tab = new Tab();
        tab.setGraphic(button);
        tab.setClosable(false);
        tabPane.getTabs().add(tab);
    }

    private Button buildButton (String text, String fileName) {
        Button button = new Button();
        button.setText(text);
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(fileName));
        ImageView curImage = new ImageView(image);
        curImage.setFitHeight(30);
        curImage.setFitWidth(30);
        button.setGraphic(curImage);
        button.setGraphicTextGap(5);
        button.setMinSize(120, 30);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                //send to applicationController with String text to determine which scene to open
            }
        });
        return button;
    }

    @Override
    public Node getInstanceAsNode () {
        return tabPane;
    }

    @Override
    public void setDelegate (EditorTabPaneDelegate delegate) {
        this.delegate = delegate;
    }

}

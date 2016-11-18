package authoringview.editortabpane;

import java.util.ResourceBundle;
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
        tabPane.setTabMaxHeight(100);
        tabPane.setTabMaxWidth(30);

        tabPane.setTabMinHeight(100);
        tabPane.setTabMinWidth(30);
        

        buildRibbonMenu();
    }

    private void buildRibbonMenu () {

        Button enemyButton = buildButton(GUIResources.getString("Enemy"), "enemy.png");
        Button towerButton = buildButton(GUIResources.getString("Tower"), "tower.png");

        buildTabs(enemyButton);
        buildTabs(towerButton);

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
        button.setMinSize(100, 30);
        return button;
    }

    @Override
    public Node getInstanceAsNode () {
        return tabPane;
    }

	@Override
	public void setDelegate(EditorTabPaneDelegate delegate) {
		this.delegate = delegate;
	}

}

/*
 * Tab myTestTab = new Tab();
 * myTestTab.setText("Tower");
 * towerView = TowerViewFactory.build();
 * myTestTab.setContent(towerView.getNodeAsInstance());
 */

package authoring.editorview.enemy.subviews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz, Andrew Bihl
 *
 */
public class EnemyImageBank extends PhotoFileChooser {
	private EnemyListDataSource dataSource;
    private EnemyEditorViewDelegate delegate;
    private ListView<Node> enemyListView;
    
    
    private ObservableList<Node> enemies;    
    
    private VBox vbox;
    private File chosenFile;
    private final int CELL_HEIGHT = 60;
    private final int CELL_WIDTH = 60;
    private final int TOWER_BANK_WIDTH = 120;
    private final String DEFAULT_TOWER_IMAGE_PATH = "./Images/questionmark.png";

    public EnemyImageBank (ResourceBundle labelsResource, ResourceBundle dialogueBoxResource) {

    	Button newEnemyButton = ButtonFactory.makeButton("New Enemy", e -> {
    		delegate.onUserPressedCreateEnemy();
    	});
    	
//        Button createNewEnemy =
//                ButtonFactory.makeButton(labelsResource.getString("NewEnemy"),
//                                         e -> {
//                                             try {
//                                                 selectFile(labelsResource.getString("Photos"),
//                                                            labelsResource.getString("Image"));
//                                             }
//                                             catch (IOException e1) {
//                                                 DialogueBoxFactory
//                                                         .createErrorDialogueBox(dialogueBoxResource
//                                                                 .getString("UnableToOpen"),
//                                                                                 dialogueBoxResource
//                                                                                         .getString("TryAgain"));
//                                             }
//                                         });
        enemyListView = new ListView<Node>();
        enemyListView.setMaxWidth(TOWER_BANK_WIDTH);
        enemies = FXCollections.observableArrayList();
        //First cell is a button
        enemies.add(newEnemyButton);
        enemyListView.setItems(enemies);
//        vbox = BoxFactory.createVBox(labelsResource.getString("EnemyBank"));
//        vbox.getChildren().add(newEnemyButton);
//        enemyBank.setContent(vbox);
    }
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }
    
    public void setListDataSource(EnemyListDataSource source){
    	this.dataSource = source;
    }

    public Node getInstanceAsNode () {
        return enemyListView;
    }

    public void updateEnemyBank (List<Integer> activeEnemies) {
    	this.enemies.remove(1, enemies.size()-1);
    	for (int i = 0; i < activeEnemies.size(); i++) {
    		EnemyListCellData cellData = dataSource.getCellDataForEnemy(activeEnemies.get(i));
    		Node cell = createCellFromData(cellData);
    		enemies.add(cell);
    	}
    }
    
    private Node createCellFromData(EnemyListCellData data){
    	ImageView cell = new ImageView();
    	String imageFilePath = data.getImagePath();
    	if (imageFilePath.equals(null) || imageFilePath.length()<1){
    		imageFilePath = DEFAULT_TOWER_IMAGE_PATH;
    	}
		File file = new File(data.getImagePath());
		Image image = new Image(file.toURI().toString());
    	cell.setImage(image);
    	cell.setPreserveRatio(true);
    	cell.setFitHeight(CELL_HEIGHT);
    	cell.setFitWidth(CELL_WIDTH);
    	return cell;
    }

    private void addImageToBank(Image image){
    	ImageView cell = new ImageView();
    	cell.setImage(image);
    	cell.setPreserveRatio(true);
    	cell.setFitHeight(CELL_HEIGHT);
    	cell.setFitWidth(CELL_WIDTH);
    	enemies.add(cell);
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            // give this image an id, keep it in bank
            BufferedImage imageRead;
            ImageView imageView = new ImageView();
            try {
                imageRead = ImageIO.read(chosenFile);
                Image image2 = SwingFXUtils.toFXImage(imageRead, null);
                this.addImageToBank(image2);
                
                // enemyBank.setContent(imageView);
                // TODO: These should be correct but are erring out currently
                // delegate.onUserPressedCreateEnemy();
                // delegate.onUserEnteredEnemyImage(chosenFile.toURI().toString());
            }
            catch (Exception e) {
                System.out.println("You failed");
                imageRead =
                        ImageIO.read(getClass().getClassLoader()
                                .getResourceAsStream("butterfly.png"));
                Image image2 = SwingFXUtils.toFXImage(imageRead, null);
                imageView.setImage(image2);
                // TODO: Fix this output to be better for the user
            }
        }
    }

}

package authoring.editorview;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author andrewbihl
 *
 */

public abstract class ImageBank implements ChangeListener<Number> {
	    protected ListDataSource dataSource;
	    
	    protected ListView<Node> listView;
	    protected ObservableList<Node> items;
	    
	    //Index represents the enemies index in the list view, value represents the corresponding enemy's id
	    protected ArrayList<Integer> itemIDs;

	    protected final int DEFAULT_CELL_HEIGHT = 60;
	    protected final int DEFAULT_CELL_WIDTH = 60;
	    protected final int DEFAULT_BANK_WIDTH = 120;
	    protected final String DEFAULT_SUBJECT_IMAGE_PATH = "./Images/questionmark.png";

	    public ImageBank () {
	        items = FXCollections.observableArrayList();
	        itemIDs = new ArrayList<Integer>();
	        listView = new ListView<Node>();
	        listView.setItems(items);
	        listView.setPrefWidth(DEFAULT_BANK_WIDTH);
	        listView.getSelectionModel().selectedIndexProperty().addListener(this);
	    }

	    public void setListDataSource (ListDataSource source) {
	        this.dataSource = source;
	    }

	    public Node getInstanceAsNode () {
	        return listView;
	    }
	    
	    public void updateBank (List<Integer> ids) {
	        this.items.remove(1, items.size() - 1);
	        itemIDs = new ArrayList<Integer>();
	        for (int i = 0; i < ids.size(); i++) {
	            ListCellData cellData = dataSource.getCellDataForSubject(ids.get(i));
	            Node cell = createCellFromData(cellData);
	            items.add(cell);
	            itemIDs.set(items.size()-1, cellData.getId());
	        }
	    }

	    protected Node createCellFromData (ListCellData data) {
	        ImageView cell = new ImageView();
	        String imageFilePath = data.getImagePath();
	        if (imageFilePath.equals(null) || imageFilePath.length() < 1) {
	            imageFilePath = DEFAULT_SUBJECT_IMAGE_PATH;
	        }
	        File file = new File(data.getImagePath());
	        Image image = new Image(file.toURI().toString());
	        cell.setImage(image);
	        cell.setPreserveRatio(true);
	        cell.setFitHeight(DEFAULT_CELL_HEIGHT);
	        cell.setFitWidth(DEFAULT_CELL_WIDTH);
	        return cell;
	    }
	    
	    protected abstract void userSelectedRow(int index);

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			userSelectedRow(newValue.intValue());
		}
		
}

package authoring.editorview.imagebank;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
 * @author Andrew Bihl
 *
 *         This class allows the user to implement a simple list view where cells are based off a
 *         list of data object IDs.
 *         The ListCellData object represents the information that should be presented in the list
 *         view, and is retrieved from a class implementing the
 *         dataSource interface.
 *         To change the way the list cells looks, override createCellFromData().
 *         If any initial cells hold non-data cells at all times, the CONTENT_OFFSET value must be
 *         set. For example, there may button in
 *         the first cell that is clicked to create a new object. The CONTENT_OFFSET should be set
 *         to 1 after this button cell is added so
 *         that the mapping of indices to data id's can be maintained.
 *
 */

public abstract class ImageBank implements ChangeListener<Number> {
    protected ListDataSource dataSource;
    protected ListView<Node> listView;
    protected ObservableList<Node> items;
    protected Map<Integer, Node> staticCells;

    // Mapping of indices of items in the table to their corresponding itemIDs.
    protected Map<Integer, Integer> itemIDs;

    protected final int DEFAULT_CELL_HEIGHT = 60;
    protected final int DEFAULT_CELL_WIDTH = 60;
    protected final int DEFAULT_BANK_WIDTH = 120;
    protected final String DEFAULT_SUBJECT_IMAGE_PATH = "./Images/questionmark.png";

    public ImageBank () {
        items = FXCollections.observableArrayList();
        itemIDs = new LinkedHashMap<Integer, Integer>();
        staticCells = new HashMap<Integer, Node>();
        listView = new ListView<Node>();
        listView.setItems(items);
        listView.setPrefWidth(DEFAULT_BANK_WIDTH);
        listView.getSelectionModel().selectedIndexProperty().addListener(this);
    }
    
    /**
     * Add a non-item permanent cell to the list view. For example, a button that creates new instances of the item type.
     * @param index – row where the cell will go
     * @param cell – visual node that displayed in the row
     */
    protected void addStaticCell(Node cell){
    	int index = this.items.size();
    	this.items.add(cell);
    	this.staticCells.put(index, cell);
    }

    public void setListDataSource (ListDataSource source) {
        this.dataSource = source;
    }

    public Node getInstanceAsNode () {
        return listView;
    }
    
    /**
     * Clear list of items excluding static cells
     */
    protected void clearItems(){
        this.itemIDs.clear();
    }

    /**
     * Refresh existing cells
     */
    public void updateBank () {
        for (int i = 0; i < this.items.size(); i++){
        	if (!this.staticCells.containsKey(i)){
        		Integer id = this.itemIDs.get(i);
        		if (id != null){
            		Node cell = this.createCellForItemID(id);
            		this.items.set(i, cell);
        		}
        	}
        }
    }
    
    public void updateBank (List<Integer> ids) {
        if (dataSource == null) {
            return;
        }
        clearItems();
        for (int i = 0; i < this.items.size(); i++){
        	if (!this.staticCells.containsKey(i)){
        		this.items.remove(i);
        	}
        }
        int index = this.staticCells.size();
        for (int i = 0; i < ids.size(); i++) {
        	int id = ids.get(i);
            Node cell = createCellForItemID(id);
            if (index < this.items.size()){
                items.set(index, cell);
            }
            else{
            	this.items.add(cell);
            	index = this.items.size()-1;
            }
            this.itemIDs.put(index, id);  
            index++;
        }
    }

    public Integer getIndexForItemWithID (int id) {
        for (int i = 0; i < this.itemIDs.size(); i++) {
            if (this.itemIDs.get(i) == id) {
                return i;
            }
        }
        return null;
    }

    /**
     * 
     * @param index of item
     * @return ID of the data object represented at that index. Will be null if there is no item
     *         there.
     */
    public Integer getIDForItemAtIndex (int index) {
        Integer result = this.itemIDs.get(index);
        if (result < 0 || result == null) {
            return null;
        }
        return result;
    }

    /**
     * 
     * Override this class to change what cells look like.
     * 
     * @param id for item represented in the cell
     * @return visual representation of the item
     */
    protected Node createCellForItemID (int id) {
        ImageView cell = new ImageView();
        String imageFilePath = dataSource.getImagePath(id);
        if (imageFilePath.equals(null) || imageFilePath.length() < 1) {
            imageFilePath = DEFAULT_SUBJECT_IMAGE_PATH;
        }
        File file = new File(imageFilePath);
        Image image = new Image(file.toURI().toString());
        cell.setImage(image);
        cell.setPreserveRatio(true);
        cell.setFitHeight(DEFAULT_CELL_HEIGHT);
        cell.setFitWidth(DEFAULT_CELL_WIDTH);
        return cell;
    }

    protected abstract void userSelectedRow (int index);

    @Override
    public void changed (ObservableValue<? extends Number> observable,
                         Number oldValue,
                         Number newValue) {
    	if (this.itemIDs.containsKey(newValue.intValue())){
            userSelectedRow(newValue.intValue());
    	}
    }

}

package authoring.editorview.collisioneffects.subviews;

import java.util.ArrayList;
import java.util.List;
import authoring.editorview.ImageBank;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAvailableDataObjectsView extends ImageBank implements EffectSetView {

    @SuppressWarnings("unused")
    private EffectAuthoringViewDelegate delegate;
    private ListView<Node> listView;

    public EffectAvailableDataObjectsView () {
        listView = new ListView<Node>();
    }

    @Override
    public Node getInstanceAsNode () {
        return listView;
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void userSelectedRow (int index) {
        // TODO Auto-generated method stub

    }
    
    public void updateAvailDataObjects (List<String> list) {
        if (dataSource == null) {
            System.out.println("Table data source not set");
            return;
        }
        this.items.remove(CONTENT_OFFSET, items.size());
        itemIDs = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {
            Label temp = new Label(list.get(i));
            Node cell = temp;
            items.add(cell);
        }
    }

}

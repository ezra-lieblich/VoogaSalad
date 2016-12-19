package authoring.editorview.collisioneffects.subviews;

import java.util.ArrayList;
import java.util.List;

import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import authoring.editorview.imagebank.ImageBank;
import javafx.scene.Node;
import javafx.scene.control.Label;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAvailableClassesView extends ImageBank implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;
    private List<String> listItems;

    public EffectAvailableClassesView () {
        super();
        Label effectLabel = new Label("Available Classes");
        this.addStaticCell(effectLabel);
        listView.setPrefWidth(200);
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void userSelectedRow (int index) {
        String selectedClass = this.listItems.get(index);
        this.delegate.onUserSelectedAvailableClass(selectedClass);
    }

    @Override
    protected Node createCellForItemID (int id) {
        Label cell = new Label();
        String name = this.dataSource.getName(id);
        if (name.equals(null) || name.length() < 1) {
            name = DEFAULT_SUBJECT_IMAGE_PATH;
        }
        cell.setText(name);
        return cell;
    }

    public void updateAvailClasses (List<String> list) {
        if (dataSource == null) {
            //System.out.println("Table data source not set");
            return;
        }
        this.clearItems();

        for (int i = 0; i < list.size(); i++) {
            Label temp = new Label(list.get(i));
            listItems.add(list.get(i));
            Node cell = temp;
//            items.add(cell);
        }
    }

}

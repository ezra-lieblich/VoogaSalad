package engine;

import java.util.List;
import engine.AbstractTypeManagerController.ViewFiller;


public interface ManagerController<E extends Manager<T>, U extends TypeBuilder<T, U>, T extends Type> {

    <V extends ViewFiller> int createType (V viewFiller);

    void deleteType (int id);

    String getName (int id);

    String getImagePath (int id);

    Double getSize (int id);
    
    List<Integer> getCreatedTypeIds();

    void setName (int id, String name);

    void setImagePath (int id, String imagePath);

    void setSize (int id, double size);

}

package engine;

public interface ModelController {

    <R> R getModelController (Class<R> key);

    String SaveData ();
    
    GameAuthoringData loadData (String filePath);
}

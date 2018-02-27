package save;

public class SaveData {
    
    private int saveFileNo;
    private String name;
    private SceneRecord[] records;
    
    public SaveData(int saveFileNo, String name, SceneRecord[] records) {
	this.saveFileNo = saveFileNo;
	this.name = name;
	this.records = records;
    }
    
    public SceneRecord getSceneRecord(int sceneIndex) {
	return records[sceneIndex];
    }
    
    public String getName() {
	return name;
    }
    
    public int getSaveFileNo() {
	return saveFileNo;
    }

}

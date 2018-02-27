package managers;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import save.SaveData;
import save.SceneRecord;

public final class SaveManager {

    public static SaveData currentSaveData;
    
    public static void writeSaveFile() {
	String filepath = "res/savefiles/save" + currentSaveData.getSaveFileNo();
	Writer w = null;
	try {
	    w = new FileWriter(new File(filepath));
	    
	    int saveNo = currentSaveData.getSaveFileNo();
	    String name = currentSaveData.getName();
	    SceneRecord[] records = new SceneRecord[] { currentSaveData.getSceneRecord(0) };
	    
	    String output = "" + saveNo + "\n"
		    + name + "\n";
	    for (int i = 0; i < records.length; i++) {
		output += records[i].toString() + "\n";
	    }
	    w.write(output);
	    w.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}

package loaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import managers.ResourceManager;
import save.SaveData;
import save.SceneRecord;

public final class SaveFileLoader {

    public static SaveData loadSaveFile(String filepath) {
	InputStream in = ResourceManager.class.getResourceAsStream("/savefiles/" + filepath + ".txt");
	if (in == null) System.out.println("null input stream");
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
	SaveData save = null;
	
	try {
	    int saveNo = Integer.parseInt(br.readLine());
	    String name = br.readLine();
	    SceneRecord[] records = new SceneRecord[] { new SceneRecord(Integer.parseInt(br.readLine())) };
	    save = new SaveData(saveNo, name, records);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return save;
	
    }

}

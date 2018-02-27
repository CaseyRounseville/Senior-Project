package loaders;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import map.Scene;

public final class SceneLoader {

    public static Scene loadScene(String filepath) {
	InputStream in = SceneLoader.class.getResourceAsStream("/scenes/" + filepath + ".txt");
	if (in == null) System.out.println("null input stream");
	BufferedReader br = new BufferedReader(new InputStreamReader(in));

	
	// load file
	List<String> resourceData = loadResourceData(br);
	List<List<String>> sceneData = loadRoomData(br);
	System.out.println("loading scene");
	return new Scene(resourceData, sceneData);
	
    }
    
    private static List<String> loadResourceData(BufferedReader br) {
	List<String> resourceData = new ArrayList<String>();
	try {
	    String line = br.readLine().trim();
	    while (!line.equals("end")) {
		line = line.trim();
		if (line.startsWith("#") || line.equals("") || line.equals("resources")) {
		    line = br.readLine();
		    continue;
		} else {
		    resourceData.add(line);
		}
		line = br.readLine();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	for (String s : resourceData) {
	    System.out.println(s + "#######");
	}
	return resourceData;
    }

    private static List<List<String>> loadRoomData(BufferedReader br) {
	List<List<String>> sceneData = new ArrayList<List<String>>();
	try {
	    String line = br.readLine().trim();

	    while (line != null) {
		line = line.trim();
		if (line.startsWith("#") || line.equals("")) {
		    line = br.readLine();
		    continue;
		} else {
		    if (line.startsWith("room")) {
			sceneData.add(new ArrayList<String>());
		    }
		    sceneData.get(sceneData.size() - 1).add(line);
		}
		line = br.readLine();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return sceneData;
    }

}

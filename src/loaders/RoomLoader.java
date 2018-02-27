package loaders;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import entity.Actor;
import entity.Coin;
import entity.Door;
import entity.Key;
import entity.Player;
import entity.RoomExitDoor;
import entity.WaterBox;
import managers.ActorManager;
import managers.SaveManager;
import managers.SceneManager;
import map.Room;
import map.TileMap;

public final class RoomLoader {
    private static int currentLine;
    private static List<String> roomData;
    private static Room room;
    
    public static Room loadRoom(int roomIndex) {
	System.out.println("LOADROOM");
	if (SceneManager.currentScene == null) System.out.println("CUURRENTSCENE_NUL");
	roomData = SceneManager.currentScene.getRoomData(roomIndex);
//	for (int i = 0; i < roomData.size(); i++) {
//	    System.out.println(roomData.get(i));
//	}
	currentLine = 0;
	//ActorManager.clearActors();
	room = new Room(null);
	
	while (currentLine < roomData.size()) {
	    System.out.println(roomData.get(currentLine));
	    String[] tokens = roomData.get(currentLine).split("\\t+");
	    decideAction(tokens);
	    currentLine++;
	}
	
	return room;
    }
    
    private static void decideAction(String[] tokens) {
	switch (tokens[0]) {
	case "tilemap":
	    addTileMap(tokens);
	    break;
	case "actor":
	    addActor(tokens);
	    break;
	case "end":
	    break;
	}
    }

    private static void addActor(String[] tokens) {// remember to account for permanent flags in save record
	String[] aargs = tokens[2].split(", ");

	Actor a = null;
	float x = Float.parseFloat(aargs[0]);
	float y = Float.parseFloat(aargs[1]);
	TileMap tm = room.getTileMap();
	int recordPos = 0;
	if (aargs.length > 2) {
	    recordPos = Integer.parseInt(aargs[2]);
	}

	switch (tokens[1]) {
	case "coin":
	    if (!SaveManager.currentSaveData.getSceneRecord(0).actorFlagIsSet(recordPos)) {
		a = new Coin(x, y, tm, recordPos);
	    }
	    break;
	case "key":
	    if (!SaveManager.currentSaveData.getSceneRecord(0).actorFlagIsSet(recordPos)) {
		a = new Key(x, y, tm, recordPos);
	    }
	    break;
	case "door":
	    if (!SaveManager.currentSaveData.getSceneRecord(0).actorFlagIsSet(recordPos)) {
		a = new Door(x, y, tm);
	    }
	    break;
	case "roomexitdoor":
	    float psx = Float.parseFloat(aargs[3]);
	    float psy = Float.parseFloat(aargs[4]);
	    int otherRoomIndex = Integer.parseInt(aargs[2]);
	    int transType = Integer.parseInt(aargs[5]);
	    a = new RoomExitDoor(x, y, tm, otherRoomIndex, psx, psy, transType);
	    break;
	case "waterbox":
	    int collWidth = Integer.parseInt(aargs[2]);
	    int collHeight = Integer.parseInt(aargs[3]);
	    a = new WaterBox(x, y, tm, collWidth, collHeight);
	    break;
	}
	
	if (a != null) ActorManager.addActor(a);
    }

    private static void addTileMap(String[] tokens) {
	    String[] tmargs = tokens[1].split(", ");
	    room.setTileMap(new TileMap(tmargs[0], tmargs[1]));
//	    Player p = ActorManager.getPlayer();
//	    if (p != null)
//	    p.setTileMap(room.getTileMap());
//	    else
		
    }
    
    
    

}

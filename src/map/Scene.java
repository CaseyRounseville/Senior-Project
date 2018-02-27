package map;

import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

import loaders.RoomLoader;
import managers.ResourceManager;
import save.SceneRecord;

public class Scene {

    private List<String> resourceData;
    private List<List<String>> roomData;
    private Room currentRoom;
    private SceneRecord record;
    
    public Scene(List<String> resources, List<List<String>> roomData) {
	this.resourceData = resources;
	this.roomData = roomData;
    }
    
    public void setCurrentRoom(int index) {
	currentRoom = getRoom(index);
    }
    
    public void setCurrentRoom(Room nextRoom) {
	currentRoom = nextRoom;
    }
    
    public List<String> getRoomData(int roomIndex) {
	return roomData.get(roomIndex);
    }
    
    public Room getRoom(int index) {
	return RoomLoader.loadRoom(index);
    }

    public void draw(Graphics2D g) {
	if(currentRoom == null) System.out.println("RROOOMM NUUUUUUUUUUUUULL");
	currentRoom.draw(g);
    }

    public void loadResources() {
	ResourceManager.clearTextures();
	ResourceManager.clearTileMaps();
	
	for (int i = 0; i < resourceData.size(); i++) {
	    ResourceManager.loadResource(resourceData.get(i));
	}
    }

    public void tick() {
	currentRoom.tick();
    }

    public Room getCurrentRoom() {
	return currentRoom;
    }

}

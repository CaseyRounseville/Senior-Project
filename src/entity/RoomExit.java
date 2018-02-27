package entity;

import map.TileMap;

public abstract class RoomExit extends Exit {

    private int otherRoom;
    
    public RoomExit(float x, float y, TileMap tm, float playerSpawnX, float playerSpawnY, int otherRoom, int transitionType) {
	super(x, y, tm, "spritesheet_roomexitdoor", 32, 48, 32,
		48, playerSpawnX, playerSpawnY, transitionType);
	this.otherRoom = otherRoom;
	initAnimations();
    }

    public RoomExit(float x, float y, TileMap tm, String controlfile, float playerSpawnX, float playerSpawnY, int otherRoom, int transitionType) {
	super(x, y, tm, "spritesheet_roomexitdoor", controlfile, 32, 48,
		32, 48, playerSpawnX, playerSpawnY, transitionType);
	this.otherRoom = otherRoom;
    }
    
    
    public int getOtherRoomIndex() {
	return otherRoom;
    }

}

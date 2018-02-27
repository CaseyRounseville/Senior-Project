package entity;

import java.util.ArrayList;

import sprite.Animation;
import map.TileMap;

public class RoomExitDoor extends RoomExit {
	
	public RoomExitDoor(float x, float y, TileMap tm, int otherRoomIndex, float playerSpawnX, float playerSpawnY, int transitionType) {
		super(x, y, tm, playerSpawnX, playerSpawnY, otherRoomIndex, transitionType);
		// TODO Auto-generated constructor stub
	}

	public RoomExitDoor(float x, float y, TileMap tm, String controlLoc, float playerSpawnX, float playerSpawnY, int otherRoomIndex, int transitionType) {
		super(x, y, tm, controlLoc, playerSpawnX, playerSpawnY, otherRoomIndex, transitionType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAnimations() {
		animations = new ArrayList<Animation>();
		animations.add(new Animation(sprites, new int[] {0}, new int[] {1}));
		currentAnimation = 0;
	}

}

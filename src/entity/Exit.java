package entity;

import map.TileMap;

public abstract class Exit extends Actor {
    
    private int transitionType;
    
    private float playerSpawnX;
    private float playerSpawnY;

    public Exit(float x, float y, TileMap tm, String spriteLoc,
	    int spriteWidth, int spriteHeight, int collWidth, int collHeight, float playerSpawnX, float playerSpawnY, int transitionType) {
	super(x, y, tm, spriteLoc, spriteWidth, spriteHeight, collWidth,
		collHeight);
	this.playerSpawnX = playerSpawnX;
	this.playerSpawnY = playerSpawnY;
	this.transitionType = transitionType;
    }

    public Exit(float x, float y, TileMap tm, String spriteLoc,
	    String controlLoc, int spriteWidth, int spriteHeight,
	    int collWidth, int collHeight, float playerSpawnX, float playerSpawnY, int transitionType) {
	super(x, y, tm, spriteLoc, controlLoc, spriteWidth, spriteHeight,
		collWidth, collHeight);
	this.playerSpawnX = playerSpawnX;
	this.playerSpawnY = playerSpawnY;
	this.transitionType = transitionType;
    }

    @Override
    public abstract void initAnimations();

    public float getPlayerSpawnX() {
        return playerSpawnX;
    }

    public float getPlayerSpawnY() {
        return playerSpawnY;
    }

    @Override
    public void initVelocity() {
	// exits do not move
    }

    @Override
    public void move() {
	// exits do not move
    }

    @Override
    public boolean stepY(float interval) {
	return false;
    }

    @Override
    public boolean stepX(float interval) {
	return false;
    }

    @Override
    public void tick() {
	// do nothing for now
    }

    public int getTransitionType() {
	return transitionType;
    }

}

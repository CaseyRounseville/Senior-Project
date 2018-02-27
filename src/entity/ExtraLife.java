package entity;

import map.TileMap;

public class ExtraLife extends Item {

    public ExtraLife(float x, float y, TileMap tm, int recordPos)//, String spriteLoc,
	   // int[] idleFrames, int[] idleDelays, int[] collectedFrames,
	   // int[] collectedDelays, int spriteWidth, int spriteHeight,
    {// int collWidth, int collHeight) {
	super(x, y, tm, "spritesheet_extralife",
		new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
		new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
		new int[] {0},
		new int[] {1},
		16,
		16,
		16,
		16,
		recordPos
	);
	
    }

    @Override
    public void initVelocity() {
	vx = 0.0f;
	vy = 0.0f;
	vy_max = 0.5f;
	vx_max = 0.0f;
	speedUpX = 0.0f;
	speedUpY = GRAVITY;
	slowDownX = 0.0f;
	slowDownY = 0.0f;

    }

    @Override
    public void move() {
	if (isFalling) {
	    vy += GRAVITY;
	    if (vy > vy_max) {
		vy = vy_max;
	    }
	} else {
	    vy = 0.0f;
	}
	checkTileCollisions();
	//xpix = (int) (xtile * TileMap.TILE_SIZE) + 1;
	//ypix = (int) (ytile * TileMap.TILE_SIZE) + 1;
    }

    @Override
    public void tick() {
	animations.get(currentAnimation).tick();
    }

    @Override
    public boolean stepY(float interval) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean stepX(float interval) {
	// TODO Auto-generated method stub
	return false;
    }

}

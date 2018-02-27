package entity;

import map.TileMap;

public class Key extends Item {

    
    public Key(float x, float y, TileMap tm, int recordPos) {
	super(x,
		y,
		tm,
		"spritesheet_key",
		new int[] {0, 1, 2, 3, 4, 5, 6},
		new int[] {10, 10, 10, 10, 10, 10, 10},
		new int[] {7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
		new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
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
	vy_max = 1.5f;
	vx_max = 0.75f;
	speedUpX = 0.02f;
	speedUpY = GRAVITY;
	slowDownX = 0.2f;
	slowDownY = 0.17f;
    }

    @Override
    public void move() {
	// keys don't move
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

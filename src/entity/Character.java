package entity;

import map.TileMap;

public abstract class Character extends Actor {

    public Character(float x, float y, TileMap tm, String spriteLoc,
	    int spriteWidth, int spriteHeight, int collWidth, int collHeight) {
	super(x, y, tm, spriteLoc, spriteWidth, spriteHeight, collWidth,
		collHeight);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void initAnimations() {
	// TODO Auto-generated method stub

    }

    @Override
    public void initVelocity() {
	// TODO Auto-generated method stub

    }

    @Override
    public void move() {
	// TODO Auto-generated method stub

    }

    @Override
    public void tick() {
	// TODO Auto-generated method stub

    }

}

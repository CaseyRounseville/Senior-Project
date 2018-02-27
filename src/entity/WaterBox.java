package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import sprite.Animation;
import map.TileMap;

public class WaterBox extends Actor {

    // collWidth should be integer multiples of 16
    public WaterBox(float x, float y, TileMap tm, int collWidth, int collHeight) {
	super(x, y, tm, "spritesheet_waterbox", 16, 16, collWidth,
		collHeight);
	initAnimations();
	// TODO Auto-generated constructor stub
    }

    // useless
    public WaterBox(float x, float y, TileMap tm, String spriteLoc,
	    String controlLoc, int spriteWidth, int spriteHeight,
	    int collWidth, int collHeight) {
	super(x, y, tm, spriteLoc, controlLoc, spriteWidth, spriteHeight,
		collWidth, collHeight);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void initAnimations() {
	animations = new ArrayList<Animation>();
	// alternate when drawing ( 0 -- 1 -- 0 -- 1 -- 0 )
	animations.add(new Animation(sprites, new int[] {0, 1, 2, 3, 7, 6, 5, 6, 7, 3, 2, 1}, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
	animations.add(new Animation(sprites, new int[] {5, 6, 7, 3, 2, 1, 0, 1, 2, 3, 7, 6}, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    @Override
    public void initVelocity() {
	// don't move

    }

    @Override
    public void move() {
	// don't move

    }

    @Override
    public boolean stepY(float interval) {
	// don't move
	return false;
    }

    @Override
    public boolean stepX(float interval) {
	// don't move
	return false;
    }

    @Override
    public void tick() {
	animations.get(0).tick();
	animations.get(1).tick();
    }
    
    @Override
    public void draw(Graphics2D g) {
	g.setColor(new Color(0, 148, 255, 175));
	g.fillRect(getXPix() - collWidth / 2 - map.getCamX(), getYPix() - collHeight / 2 - map.getCamY(), collWidth, collHeight);
	// draw waves
	for (int i = 0; i < collWidth / 16; i++) {
	    int boxL = getXPix() - collWidth / 2 - map.getCamX();
	    int boxT = getYPix() - collHeight / 2 - map.getCamY();
	    int animIndex = i % 2;
	    animations.get(animIndex).draw(g, boxL + i * 16, boxT - 16, 16, 16);
	}
    }

}

package entity;

import java.awt.Rectangle;

import map.Tile;

public class Exit_OLD {
    
    // position
    private float x;
    private float y;
    private String areaName;// area to go to
    private int otherEnd;// room to go to
    private float playerSpawnX;
    private float playerSpawnY;
    
    // size in pixels
    private int width;
    private int height;
    
    private Rectangle rectangle;
    
    public Exit_OLD(float x, float y, int width, int height, String areaName, int otherEnd, float playerSpawnX, float playerSpawnY) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.areaName = areaName;
	this.otherEnd = otherEnd;
	this.playerSpawnX = playerSpawnX;
	this.playerSpawnY = playerSpawnY;
	
	rectangle = new Rectangle(getXPix() - width / 2, getYPix() - height / 2, width, height);
    }
    
    public boolean contains(Actor actor) {
	return rectangle.contains(actor.getBoundingBox());
    }
    
    public int getXPix() {
	return Tile.convertTilesToPixels(x);
    }
    
    public int getYPix() {
	return Tile.convertTilesToPixels(y);
    }

}

package entity;

import map.TileMap;

public abstract class Enemy extends Actor {
    
    public Enemy(float x, float y, TileMap tm, String spriteLoc, int spriteWidth, int spriteHeight, int collWidth, int collHeight) {
	super(x, y, tm, spriteLoc, spriteWidth, spriteHeight, collWidth, collHeight);
    }
    
    
}

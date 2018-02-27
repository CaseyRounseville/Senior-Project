package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import main.Screen;
import map.Tile;
import map.TileMap;
import sprite.Animation;
import sprite.SpriteSheet;

public abstract class Actor {

    // map coordinates(in tiles)
    protected float xtile;
    protected float ytile;

    // map coordinates(in pixels)
    //protected int xpix;
    //protected int ypix;

    // movement
    protected float vx;
    protected float vy;
    protected float vx_max;
    protected float vy_max;
    protected float speedUpX;
    protected float slowDownX;
    protected float speedUpY;
    protected float slowDownY;
    protected static final float GRAVITY = 0.04f;
    protected boolean isFalling;

    public void setFalling(boolean isFalling) {
        this.isFalling = isFalling;
    }

    // direction / keys
    protected boolean holdingLeft;
    protected boolean holdingRight;
    protected boolean holdingDown;
    protected boolean holdingUp;
    protected boolean holdingJump;

    // animations
    protected List<Animation> animations;
    protected int currentAnimation;

    // sprites
    protected SpriteSheet sprites;

    // map
    protected TileMap map;

    // direction
    protected boolean isFacingRight;

    // collision
    protected int collWidth;
    protected int collHeight;

    
//    protected Point2D.Float[] topPoints;
//    protected Point2D.Float[] bottomPoints;
//    protected Point2D.Float[] leftPoints;
//    protected Point2D.Float[] rightPoints;
    Collider collider;

    // sprite size
    protected int spriteWidth;
    protected int spriteHeight;

    public Actor(float x, float y, TileMap tm, String spriteLoc, int spriteWidth, int spriteHeight, int collWidth, int collHeight) {
	xtile = x;
	ytile = y;
	//xpix = (int) (xtile * TileMap.TILE_SIZE) + 1;
	//ypix = (int) (ytile * TileMap.TILE_SIZE) + 1;
	vx = 0.0f;
	vy = 0.0f;
	map = tm;
	initSprites(spriteLoc, spriteWidth, spriteHeight);
	this.spriteWidth = spriteWidth;
	this.spriteHeight = spriteHeight;
	//initAnimations();
	this.collWidth = collWidth;
	this.collHeight = collHeight;
	holdingUp = holdingDown = holdingLeft = holdingRight = holdingJump = false;
	collider = new Collider(collWidth, collHeight, tm);
	isFalling = false;
    }
    
    public Actor(float x, float y, TileMap tm, String spriteLoc, String controlLoc, int spriteWidth, int spriteHeight, int collWidth, int collHeight) {
	xtile = x;
	ytile = y;
	//xpix = (int) (xtile * TileMap.TILE_SIZE) + 1;
	//ypix = (int) (ytile * TileMap.TILE_SIZE) + 1;
	vx = 0.0f;
	vy = 0.0f;
	map = tm;
	initSprites(spriteLoc, controlLoc);
	this.spriteWidth = spriteWidth;
	this.spriteHeight = spriteHeight;
	//initAnimations();
	this.collWidth = collWidth;
	this.collHeight = collHeight;
	holdingUp = holdingDown = holdingLeft = holdingRight = holdingJump = false;
	collider = new Collider(collWidth, collHeight, tm);
	isFalling = false;
    }

    
    

    private void initSprites(String spriteLoc, String controlLoc) {
	sprites = new SpriteSheet(spriteLoc, controlLoc);
    }

    public boolean isHoldingUp() {
	return holdingUp;
    }

    public boolean isHoldingDown() {
	return holdingDown;
    }

    public boolean isHoldingRight() {
	return holdingRight;
    }

    public boolean isHoldingLeft() {
	return holdingLeft;
    }

    public boolean isHoldingJump() {
	return holdingJump;
    }

    public void setHoldingUp(boolean up) {
	holdingUp = up;
    }

    public void setHoldingDown(boolean down) {
	holdingDown = down;
    }

    public void setHoldingRight(boolean right) {
	holdingRight = right;
    }

    public void setHoldingLeft(boolean left) {
	holdingLeft = left;
    }

    public void setHoldingJump(boolean jump) {
	holdingJump = jump;
    }

    public Rectangle getBoundingBox() { return new Rectangle(getXPix() - collWidth / 2, getYPix() - collHeight / 2, collWidth, collHeight); }

    private void initSprites(String spriteLoc, int spriteWidth, int spriteHeight) {
	sprites = new SpriteSheet(spriteLoc, spriteWidth, spriteHeight);
    }

    public boolean collidesWith(Actor actor) {
	return getBoundingBox().intersects(actor.getBoundingBox());
    }
    
    public boolean contains(Actor actor) {
	return getBoundingBox().contains(actor.getBoundingBox());
    }

    protected void checkCorners(float x, float y) {

    }

    public void checkTileCollisions() {
	
    }

    public void draw(Graphics2D g) {
	//if (this instanceof RoomExitDoor) {if (this == null) {System.out.println("RROOMMEEXXIITTDDOORR");}}
	//map.setFocusPoint(getXTile(), getYTile());
	//System.out.println("============" + map.getCamera().getX() + "---------" + getXPix() + "       " + getXTile());
	if (isFacingRight)
	    animations.get(currentAnimation).draw(g, getXPix() - animations.get(currentAnimation).getCurrentSpriteWidth() / 2 - map.getCamX(), getYPix() - animations.get(currentAnimation).getCurrentSpriteHeight() / 2 - map.getCamY(), animations.get(currentAnimation).getCurrentSpriteWidth(), animations.get(currentAnimation).getCurrentSpriteHeight());
	else
	    animations.get(currentAnimation).draw(g, getXPix() - map.getCamX() + animations.get(currentAnimation).getCurrentSpriteWidth() / 2, getYPix() - map.getCamY() - animations.get(currentAnimation).getCurrentSpriteHeight() / 2, -animations.get(currentAnimation).getCurrentSpriteWidth(), animations.get(currentAnimation).getCurrentSpriteHeight());
//	g.setColor(Color.GREEN);
//	g.fillRect(getXPix() - spriteWidth / 2 - map.getCamX(), getYPix() - spriteHeight - map.getCamY(), spriteWidth, spriteHeight);
//	g.setColor(Color.BLUE);
//	g.drawLine(getXPix() - map.getCamX(), getYPix() - map.getCamY(), getXPix() - map.getCamX(), getYPix() - map.getCamY());
//	g.drawLine(getXPix() - spriteWidth / 2 - map.getCamX(), getYPix() - spriteHeight - map.getCamY(), getXPix() - spriteWidth / 2 - map.getCamX(), getYPix() - spriteHeight - map.getCamY());
//	g.drawLine(0, 32, 0, 32);
//	g.fillRect(0, 0, 16, 32);
	//if (this instanceof Player)
	//boundingBox.draw(g);

    }

    // getters
    public float getXTile() { return xtile; }
    public float getYTile() { return ytile; }
    public float getVX() { return vx; }
    public float getVY() { return vy; }
    /*
    public float getVX_max() { return vx_max; }
    public float getVY_max() { return vy_max; }
    public float getSpeedUpX() { return speedUpX; }
    public float getSlowDownX() { return slowDownX; }
    public float getSpeedUpY() { return speedUpY; }
    public float getSlowDownY() { return slowDownY; }
     */
    public boolean getIsFacingRight() { return isFacingRight; }
    
    public boolean isFalling() {
	return isFalling;
    }

    public int getCurrentAnimation_int() { return currentAnimation; }
    public Animation getCurrentAnimation_animation() { return animations.get(currentAnimation); }

    // setters
    public void setXTile(float xtile) { this.xtile = xtile; }
    public void setYTile(float ytile) { this.ytile = ytile; }
    public void setVX(float vx) { this.vx = vx; }
    public void setVY(float vy) { this.vy = vy; }
    public int getXPix() { return (int) ((xtile /*+ 1f / 16f*/) * 16f); }
    public int getYPix() { return (int) ((ytile /*+ 1f / 16f*/) * 16f); }
    /*
    public void setVX_max(float vx_max) { this.vx_max = vx_max; }
    public void setVY_max(float vy_max) { this.vy_max = vy_max; }
    public void setSpeedUpX(float speedUpX) { this.speedUpX = speedUpX; }
    public void setSlowDownX(float slowDownX) { this.slowDownX = slowDownX; }
    public void setSpeedUpY(float speedUpY) { this.speedUpY = speedUpY; }
    public void setSlowDownY(float slowDownY) { this.slowDownY = slowDownY; }
    public void setIsFacingRight(boolean isFacingRight) { this.isFacingRight = isFacingRight; }
     */
    
    public int getCollWidth() {
	return collWidth;
    }
    
    public int getCollHeight() {
	return collHeight;
    }
    public void setCurrentAnimation(int currentAnimation) { this.currentAnimation = currentAnimation; }

    public boolean isOnScreen(Player player) {
	return Math.abs(player.getXTile() / 16 - xtile
		/ 16) <= Screen.WIDTH
		/ 16 / 2
		&& Math.abs(player.getYTile() / 16 - ytile
			/ 16) <= Screen.HEIGHT
			/ 16 / 2;
    }
    
    public TileMap getTileMap() { return map; }
    
    public void setTileMap(TileMap tm) {
	map = tm;
	collider.setTileMap(tm);
    }

    public abstract void initAnimations();

    public abstract void initVelocity();

    public abstract void move();
    
    public abstract boolean stepY(float interval);
    
    public abstract boolean stepX(float interval);

    public abstract void tick();


}

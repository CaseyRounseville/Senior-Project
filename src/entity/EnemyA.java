package entity;

import java.util.ArrayList;

import sprite.Animation;
import map.Tile;
import map.TileMap;

public class EnemyA extends Enemy {

    //animation constants
    public static final int ANIMATION_STANDING = 0;
    public static final int ANIMATION_WALKING = 1;
    public static final int ANIMATION_JUMPING = 2;
    
    // frames
    int[] frames = {0, 1, 2, 3, 4, 5};
    
    // delays
    int[] delays = {10, 10, 10, 10, 10, 10};
    
    public EnemyA(float x, float y, TileMap tm) {
	super(x,
		y,
		tm,
		"spritesheet_enemyA_test",
		16,
		16,
		16,
		16
	);
	initVelocity();
	initAnimations();
	holdingLeft = false;
	holdingRight = false;
	holdingDown = false;
	holdingUp = false;
	isFacingRight = true;
    }
    
    @Override
    public void initAnimations() {
	animations = new ArrayList<Animation>();
	animations.add(new Animation(sprites, frames, delays));
	animations.add(new Animation(sprites, frames, delays));
	animations.add(new Animation(sprites, frames, delays));
	currentAnimation = ANIMATION_STANDING;
    }

    @Override
    public void initVelocity() {
	vx = 0.0f;
	vy = 0.0f;
	vy_max = 0.5f;
	vx_max = 0.3f;
	speedUpX = 0.00f;
	speedUpY = GRAVITY;
	slowDownX = 0.00f;
	slowDownY = 0.17f;
    }

    @Override
    public void move() {
	
	// vertical movement
	if (isFalling) {
	    currentAnimation = ANIMATION_JUMPING;
	    vy += GRAVITY;
	    if (vy > vy_max) {
		vy = vy_max;
	    }
	} else {
	    
	}
	
	// horizontal movement
	if (isFalling) {
	    if (holdingLeft) {
		isFacingRight = false;
		vx -= speedUpX;
		if (vx < -vx_max) {
		    vx = -vx_max;
		}
	    } else if (holdingRight) {
		isFacingRight = true;
		vx += speedUpX;
		if (vx > vx_max) {
		    vx = vx_max;
		}
	    }
	} else {
	    if (holdingLeft) {
		currentAnimation = ANIMATION_WALKING;
		isFacingRight = false;
		vx -= speedUpX;
		if (vx < -vx_max) {
		    vx = -vx_max;
		}
	    } else if (holdingRight) {
		currentAnimation = ANIMATION_WALKING;
		isFacingRight = true;
		vx += speedUpX;
		if (vx > vx_max) {
		    vx = vx_max;
		}
	    } else {
		currentAnimation = ANIMATION_STANDING;
		vx = 0;
	    }
	}
    }
    
    public boolean stepY(float interval) {
	float ny = ytile + interval;
	collider.calculateTileData(xtile, ny);
	if (isFalling) {
	    if (vy < 0) {
		if (collider.tileData[Collider.TOP] == Tile.BLOCKED) {
		    vy = 0;
		    ytile = (float) Math.floor(ytile - Tile.convertPixelsToTiles(collHeight / 2)) + 1.0f;
		    return true;
		}
	    } else if (vy > 0) {
		if (collider.tileData[Collider.TOP] == Tile.BLOCKED) {
		    vy = 0;
		    ytile = (float) Math.floor(ytile + 15.0f / 16.0f);
		    isFalling = false;
		    return true;
		}
	    } else {
		
	    }
	} else {
	    if (collider.tileData[Collider.FLOOR_CHECK] == Tile.CLEAR) {
		isFalling = true;
		return false;
	    }
	}
	return false;
    }
    
    public boolean stepX(float interval) {
	return true;
    }
    
    @Override
    public void checkTileCollisions() {
	
	float nx = xtile + vx;
	float ny = ytile + vy;
	
	// vertical movement
	
	checkCorners(xtile, ny);
	
	if (isFalling) {
	    if (vy < 0) {
		if (collider.tileData[Collider.TOP] == Tile.BLOCKED) {
		    vy = 0;
		    ytile = (float) ((int) (ny + 1));
		} else if (collider.tileData[Collider.TOP] == Tile.DEATH) {
		    die();
		}
	    } else if (vy > 0) {
		if (collider.tileData[Collider.BOTTOM] == Tile.BLOCKED) {
		    vy = 0;
		    ytile = (int) (ny);
		    isFalling = false;
		}
	    } else {
		
	    }
	} else {
	    
	}
	
	
	// horizontal movement
	
	checkCorners(nx, ytile);
	if (isFalling) {
	    if (vx < 0) {
		
	    } else if (vx > 0) {
		
	    } else {
		
	    }
	} else {
	    
	}
    }
    

    public void die() {
	
    }

    @Override
    public void tick() {
	animations.get(currentAnimation).tick();
    }


}

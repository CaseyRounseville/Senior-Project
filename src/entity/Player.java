package entity;

import java.util.ArrayList;
import java.util.Arrays;

import managers.GamePad;
import map.Tile;
import map.TileMap;
import sprite.Animation;

public class Player extends Actor {

    // animation constants
    public static final int ANIMATION_STANDING = 0;
    public static final int ANIMATION_WALKING = 1;
    public static final int ANIMATION_JUMPING = 2;
    public static final int ANIMATION_CLIMBING = 3;
    public static final int ANIMATION_DEAD = 4;
    public static final int ANIMATION_SWIMMING = 5;



    public boolean isSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean isSwimming) {
        this.isSwimming = isSwimming;
    }

    // lives & health
    private int lives;
    private boolean dead;
    private static final int MAX_LIVES = 99;
    private int health;
    private static final int MAX_HEALTH = 24;
    private int coins;
    private static final int MAX_COINS = 999;
    private int keys;
    private static final int MAX_KEYS = 9; 

    private boolean isClimbing;
    private boolean isSwimming;

    public Player(float x, float y, TileMap tm) {
	super(
		x,
		y,
		tm,
		"spritesheet_player_test_2",
		"spritesheet_player_control_2",
		16,
		32,
		16,
		32
		);
	initVelocity();
	initAnimations();
	holdingLeft = false;
	holdingRight = false;
	holdingDown = false;
	holdingUp = false;
	isFacingRight = true;
	lives = 3;
	health = MAX_HEALTH;
	coins = 0;
	keys = 0;
	dead = false;
	isClimbing = false;
	isSwimming = false;
    }

    @Override
    public void tick() {
	animations.get(currentAnimation).tick();
    }

    @Override
    public void move() {     

	// vertical movement
	if (isFalling) { 
	    if (!dead) {
		currentAnimation = ANIMATION_JUMPING;
	    }
	    vy += GRAVITY;
	    if (vy > vy_max) {
		vy = vy_max;
	    }
	} else if (isClimbing) {
	    currentAnimation = ANIMATION_CLIMBING;
	    if (GamePad.isDownNow(GamePad.BUTTON_UP)) {
		vy = -0.1f;
	    } else if (GamePad.isDownNow(GamePad.BUTTON_DOWN)) {
		vy = 0.1f;
	    } else if (GamePad.wasJustPressed(GamePad.BUTTON_X)) {
		currentAnimation = ANIMATION_JUMPING;
		vy = 0;
		isFalling = true;
		isClimbing = false;
	    } else {
		vy = 0;
	    }
	} else {
	    if (GamePad.wasJustPressed(GamePad.BUTTON_X)) {
		if (!isFalling) {
		    vy = -vy_max;
		    isFalling = true;
		}
	    }
	}




	// horizontal movement
	if (isFalling) {
	    if (GamePad.isDownNow(GamePad.BUTTON_LEFT)) {
		isFacingRight = false;
		vx -= speedUpX;
		if (vx < -vx_max) {
		    vx = -vx_max;
		}
	    } else if (GamePad.isDownNow(GamePad.BUTTON_RIGHT)) {
		isFacingRight = true;
		vx += speedUpX;
		if (vx > vx_max) {
		    vx = vx_max;
		}
	    }
	} else if (isClimbing) {
	    // do nothing
	} else {
	    if (GamePad.isDownNow(GamePad.BUTTON_LEFT)) {
		currentAnimation = ANIMATION_WALKING;
		isFacingRight = false;
		vx -= speedUpX;
		if (vx < -vx_max) {
		    vx = -vx_max;
		}
	    } else if (GamePad.isDownNow(GamePad.BUTTON_RIGHT)) {
		currentAnimation = ANIMATION_WALKING;
		isFacingRight = true;
		vx += speedUpX;
		if (vx > vx_max) {
		    vx = vx_max;
		}
	    } else {
		if (!dead) {
		    currentAnimation = ANIMATION_STANDING;
		}
		vx = 0;
	    }
	}


	/*

	//            <---------   FIX SAME WAY TILECOLLISIONS WERE FIXED
	// vertical movement
	if (holdingUp) {
	    if (isClimbing) {
		currentAnimation = ANIMATION_CLIMBING;
		vy = -0.1f;
	//    } else {
	//	currentAnimation = ANIMATION_JUMPING;
	//	vy -= speedUpY;
	//	if (vy < -vy_max) {
	//	    vy = -vy_max;
	//	}
	    }
	} else if (holdingDown) {
	    if (isClimbing) {
		currentAnimation = ANIMATION_CLIMBING;
		vy = 0.1f;
	    } else {
		currentAnimation = ANIMATION_JUMPING;
		/*vy += speedUpY;
	    if (vy > vy_max) {
		vy = vy_max;
	    }
	    }
	} else if (holdingJump) {
	    //if () {
	    currentAnimation = ANIMATION_JUMPING;
	    if (!isClimbing) {
		vy = -vy_max;
	    } else {
		isClimbing = false;
	    }
	    isFalling = true;
	    //}
	} else {
	    if (isFalling) {
		currentAnimation = ANIMATION_JUMPING;
		vy += GRAVITY;
		if (vy > vy_max) {
		    vy = vy_max;
		}
	    } else {
		if (!holdingLeft && !holdingRight) {
		    currentAnimation = ANIMATION_STANDING;
		}
		vy = 0.0f;
	    }
	}

	// horizontal movement
	if (holdingRight) {
	    if (!isFalling && !isClimbing) {
		currentAnimation = ANIMATION_WALKING;
	    }
	    if (!isClimbing) {
		vx += speedUpX;
	    }
	    if (vx > vx_max) {
		vx = vx_max;
	    }
	    isFacingRight = true;
	} else if (holdingLeft) {
	    if (!isFalling && !isClimbing) {
		currentAnimation = ANIMATION_WALKING;
	    }
	    if (!isClimbing) {
		vx -= speedUpX;
	    }
	    if (vx < -vx_max) {
		vx = -vx_max;
	    }
	    isFacingRight = false;
	} else {
	    if (!holdingUp && !holdingDown && !isFalling && !isClimbing) {
		currentAnimation = ANIMATION_STANDING;
	    }
	    vx = 0.0f;
	}


	 */


	//	checkTileCollisions();
	//xpix = (int) ((xtile + 1.0f / 16.0f) * 16f);
	//ypix = (int) ((ytile + 1.0f / 16.0f) * 16f);
    }

    public boolean isClimbing() {
	return isClimbing;
    }

    public void setClimbing(boolean isClimbing) {
	this.isClimbing = isClimbing;
    }

    public void takeDamage(Enemy e) {
	if (!dead) {
	    if (e instanceof EnemyA)
		health -= 1;
	    if (health < 0) {
		health = 0;
	    }
	    if (health == 0) {
		die();
	    }
	}
    }

    public void die() {
	if (!dead) {
	    lives--;
	    currentAnimation = ANIMATION_DEAD;
	    holdingLeft = holdingRight = holdingUp = holdingDown = holdingJump = false;
	    if (isClimbing) {
		isClimbing = false;
		isFalling = true;
	    }
	    dead = true;
	}
    }

    @Override
    public void initAnimations() {
	animations = new ArrayList<Animation>();
	animations.add(new Animation(sprites, new int[] {12, 13}, new int[] {90, 10}));// standing
	animations.add(new Animation(sprites, new int[] {16, 14, 15, 14}, new int[] {10, 10, 10, 10}));// walking
	animations.add(new Animation(sprites, new int[] {17}, new int[] {1}));// jumping
	animations.add(new Animation(sprites, new int[] {18}, new int[] {1}));// climbing
	animations.add(new Animation(sprites, new int[] {19}, new int[] {20}));// dead
	animations.add(new Animation(sprites, new int[] {26}, new int[] {10}));// swimming
	currentAnimation = ANIMATION_STANDING;
    }

    @Override
    public void initVelocity() {
	vx = 0.0f;
	vy = 0.0f;
	vy_max = 0.55f;
	vx_max = 0.4f;
	speedUpX = 0.02f;
	speedUpY = GRAVITY;
	slowDownX = 0.03f;
	slowDownY = 0.06f;
    }

    public void reset() {
	dead = false;	
	initAnimations();	
	health = MAX_HEALTH;
    }

    public void collectHeart() {
	health += 4;
	if (health > MAX_HEALTH)
	    health = MAX_HEALTH;
    }

    public void collectCoin() {
	coins++;
	if (coins > MAX_COINS)
	    coins = MAX_COINS;
    }

    public void collectExtraLife() {
	lives++;
	if (lives > MAX_LIVES)
	    lives = MAX_LIVES;
    }

    public void collectKey() {
	keys++;
	if(keys > MAX_KEYS)
	    keys = MAX_KEYS;
    }

    public void useKey() {
	keys--;
	// should never happen
	if ( keys < 0)
	    keys = 0;
    }

    public int getHealth() { return health; }
    public int getLives() { return lives; }
    public int getCoins() { return coins; }
    public int getKeys() { return keys; }
    public boolean isDead() { return dead; }

    //@Override
    public boolean stepY(float interval) {
	//float tileSizeMinusOne = (float) (TileMap.TILE_SIZE - 1) / (float) (TileMap.TILE_SIZE);
	// next position
	//float nx = x + xtile;
	float ny = interval + ytile;

	//	boolean wasCollision = false;
	// vertical movement
	checkCorners(xtile, ny);
	collider.calculateTileData(xtile, ny);


	if (isFalling) {
	    //System.out.println(vy);
	    if (vy < 0) {
		if (collider.tileData[Collider.TOP] == Tile.BLOCKED) {
		    vy = 0;
		    //ytile = (float) ((int) (ny + 1));
		    ytile = (float) Math.floor(ytile - Tile.convertPixelsToTiles(collHeight / 2)) + 1.0f;
		    return true;
		} else if (collider.tileData[Collider.TOP] == Tile.DEATH) {
		    die();
		    return true;
		} /*else if(corner_TL == Tile.ONEWAY || corner_TR == Tile.ONEWAY) {
		    //System.out.println("it happened");
		    ytile = ny;
		}*/ else if (collider.tileData[Collider.TOP] == Tile.LADDER || collider.tileData[Collider.BOTTOM] == Tile.LADDER/*corner_TL == Tile.LADDER || corner_TR == Tile.LADDER*/) {
		    if (GamePad.isDownNow(GamePad.BUTTON_UP) || GamePad.isDownNow(GamePad.BUTTON_DOWN)) {
			//if (corner_TL == Tile.LADDER && corner_TR == Tile.LADDER) {
			vx = 0;
			xtile = (int) xtile + 0.5f;
			isClimbing = true;
			isFalling = false;
			return true;
			/*} else if (corner_TL == Tile.LADDER) {
			    vx = 0;
			    xtile = (int) xtile - 0.5f - 1.0f / 16.0f;
			    isClimbing = true;
			    isFalling = false;
			} else if (corner_TR == Tile.LADDER) {
			    vx = 0;
			    xtile = (int) (xtile) + 1.0f + 0.5f - 1.0f / 16.0f;
			    isClimbing = true;
			    isFalling = false;
			}*/
		    } else {
			ytile = ny;
		    }
		} else {
		    isClimbing = false;
		    ytile = ny;
		}
	    } else if (vy > 0) {
		if (collider.tileData[Collider.BOTTOM] == Tile.BLOCKED) {
		    vy = 0;
		    //ytile = (int) (ny);
		    ytile = (float) Math.floor(ytile + 15.0f / 16.0f);
		    isFalling = false;
		    return true;
		    //isClimbing = false;
		} else if (collider.tileData[Collider.BOTTOM] == Tile.DEATH) {
		    die();
		    return true;
		} else if (collider.tileData[Collider.BOTTOM] == Tile.ONEWAY) {
		    if (Math.floor(ytile + 15.0f / 16.0f) < Math.floor(ny + 15.0f / 16.0f)) {
			vy = 0;
			//ytile = (int) (ny);
			ytile = (float) Math.floor(ytile + 15.0f / 16.0f);
			isFalling = false;
			return true;
		    } else {
			ytile = ny;
		    }
		} else if ((collider.tileData[Collider.BOTTOM] == Tile.LADDER) && Math.floor(ytile) < Math.floor(ny) && map.getTileID((int) (Math.floor(ytile)), (int) Math.floor(xtile)) == -1   /*&& (corner_TL != Tile.LADDER && corner_TR != Tile.LADDER)*/) {
		    // if (corner_TL != Tile.LADDER && corner_TR != Tile.LADDER) {
		    //System.out.println("ladder feet" + corner_BL_M1 + "   " + corner_BR_M1);
		    // if (Math.floor(ytile) < Math.floor(ny) && map.getTileID((int) (Math.floor(ytile)), (int) Math.floor(xtile)) == Tile.CLEAR) {
		    //System.out.println(map.getTileID((int) (Math.floor(ytile)), (int) Math.floor(xtile)));
		    vy = 0;
		    //ytile = (int) (ny);
		    ytile = (float) Math.floor(ytile + 15.0f / 16.0f);
		    isFalling = false;
		    return true;

		    //}
		    //		    } else {
		    //			if (corner_TM == Tile.LADDER) {
		    //			    if (holdingUp || holdingDown) {
		    //				vx = 0;
		    //				xtile = (int) xtile + 0.5f - 1.0f / 16.0f;
		    //				isClimbing = true;
		    //				isFalling = false;
		    //			    } else {
		    //				ytile = ny;
		    //			    }
		    //			} 
		    //}
		} else if (collider.tileData[Collider.TOP] == Tile.LADDER) {
		    if (GamePad.isDownNow(GamePad.BUTTON_UP) || GamePad.isDownNow(GamePad.BUTTON_DOWN)) {
			vx = 0;
			xtile = (int) xtile + 0.5f;
			isClimbing = true;
			isFalling = false;
			return true;
		    } else {
			ytile = ny;
		    }
		} else {
		    ytile = ny;
		}
	    } else {
		System.out.println("vy0falling1");
	    }

	} else if (isClimbing) {
	    if (vy < 0) {
		if (collider.tileData[Collider.TOP] == Tile.BLOCKED) {
		    vy = 0;
		    ytile = (float) ((int) (ny + 1));
		    return true;
		} else if (collider.tileData[Collider.TOP] == Tile.DEATH) {
		    die();
		    return true;
		} else if (collider.tileData[Collider.TOP] == Tile.LADDER) {
		    ytile = ny;
		} else if (collider.tileData[Collider.TOP] == Tile.CLEAR) {
		    if (collider.tileData[Collider.BOTTOM] == Tile.CLEAR) {
			ytile = (float) Math.floor(ytile);
			vy = 0;
			isClimbing = false;
			return true;
		    } else {
			ytile = ny;
		    }
		}
	    } else if (vy > 0) {
		if (collider.tileData[Collider.BOTTOM] == Tile.BLOCKED) {
		    vy = 0;
		    ytile = (int) (ny);
		    //isFalling = false;
		    isClimbing = false;
		    return true;
		} else if (collider.tileData[Collider.BOTTOM] == Tile.DEATH) {
		    die();
		    return true;
		} else if (collider.tileData[Collider.BOTTOM] == Tile.ONEWAY) {
		    vy = 0;
		    ytile = (int) (ny);
		    isClimbing = false;
		    return true;
		} else if (collider.tileData[Collider.BOTTOM] == Tile.LADDER) {
		    ytile = ny;
		} else if (collider.tileData[Collider.BOTTOM] == Tile.CLEAR) {
		    if (collider.tileData[Collider.TOP] == Tile.CLEAR) {
			//vy = 0;						<------ FIX ME FIX ME FIX ME FIX ME FIX ME FIX ME
			isClimbing = false;
			isFalling = true;
		    } else {
			ytile = ny;
		    }
		}
	    } else {
		ytile = ny;
	    }
	} else {
	    if (collider.tileData[Collider.BOTTOM] == Tile.LADDER/*corner_BL == Tile.LADDER && corner_BR == Tile.LADDER*/) {
		if (GamePad.isDownNow(GamePad.BUTTON_DOWN)) {
		    xtile = (int) xtile + 0.5f;
		    isClimbing = true;
		    return true;
		    //isFalling = false;
		}
	    } else if (collider.tileData[Collider.TOP] == Tile.LADDER/*corner_TL == Tile.LADDER && corner_TR == Tile.LADDER*/) {
		if (GamePad.isDownNow(GamePad.BUTTON_UP)) {
		    xtile = (int) xtile + 0.5f;
		    isClimbing = true;
		    return true;
		    //isFalling = false;
		}
	    } else if (collider.tileData[Collider.FLOOR_CHECK] == Tile.CLEAR) {
		isFalling = true;
	    }
	}
	return false;
    }

    public boolean stepX(float interval) {
	// horizontal movement/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	float nx = interval + xtile;

	//checkCorners(nx, ytile);
	collider.calculateTileData(nx, ytile);
	//System.out.println(Arrays.toString(boundingBox.tileData));
	//System.out.println(boundingBox);                                           <--- print bb

	if (isFalling) {
	    if (vx < 0) {
		if (collider.tileData[Collider.LEFT] == Tile.BLOCKED) {
		    vx = 0;
		    //xtile = (float) ((int) xtile) + 0.5f - (1.0f / 16.0f);
		    xtile = (float) ((Math.floor(xtile - 0.5f)) + 0.5f);
		    return true;
		} else if (collider.tileData[Collider.LEFT] == Tile.DEATH) {
		    die();
		    return true;
		} else {
		    xtile = nx;
		}
	    } else if (vx > 0) {
		if (collider.tileData[Collider.RIGHT] == Tile.BLOCKED) {
		    vx = 0;
		    //xtile = (float) ((int) nx) + 0.5f - 1.0f / 16.0f;
		    xtile = (float) (Math.floor(xtile + 0.4375) + 0.5f);
		    return true;
		} else if (collider.tileData[Collider.RIGHT] == Tile.DEATH) {
		    die();
		    return true;
		} else {
		    xtile = nx;
		}
	    } else {
		xtile = nx;
	    }
	} else if (isClimbing) {
	    if (vx < 0) {
		vx = 0;
		return true;
	    } else if (vx > 0) {
		vx = 0;
		return true;
	    } else {
		// do nothing
	    }
	} else {
	    if (vx < 0) {
		if (collider.tileData[Collider.LEFT] == Tile.BLOCKED) {
		    vx = 0;
		    //xtile = (float) ((int) xtile) + 0.5f - (1.0f / 16.0f);
		    System.out.print(xtile);
		    float x = xtile;
		    xtile = (float) Math.floor(xtile - 0.5f);
		    xtile += 0.5f;
		    System.out.print("\t" + xtile + "\t" + interval);
		    if (x > xtile) {
			System.out.println("\t<-- glitch");
		    } else {
			System.out.println();
		    }
		    return true;
		} else if (collider.tileData[Collider.LEFT] == Tile.DEATH) {
		    die();
		    return true;
		} else {
		    xtile = nx;
		}
	    } else if (vx > 0) {
		if (collider.tileData[Collider.RIGHT] == Tile.BLOCKED) {
		    vx = 0;
		    //xtile = (float) ((int) nx) + 0.5f - 1.0f / 16.0f;
		    xtile = (float) Math.floor(xtile + 0.4375) + 0.5f;
		    return true;
		} else if (collider.tileData[Collider.RIGHT] == Tile.DEATH) {
		    die();
		    return true;
		} else {
		    xtile = nx;
		}
	    } else {
		xtile = nx;
	    }
	}
	return false;
    }
}
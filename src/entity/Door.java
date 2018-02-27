package entity;

import java.util.ArrayList;

import sprite.Animation;
import map.TileMap;

public class Door extends Actor {
    
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;
    
    private int[] lockedDelays = {1};
    //private int animation_locked_startSprite = 0;
    //private int animation_locked_endSprite = 0;
    
    private int[] unlockedDelays = {3, 3, 3, 3, 3, 3, 3};
    //private int animation_unlocked_startSprite = 1;
    //private int animation_unlocked_endSprite = 2;
    
    // frames
    private int[] lockedFrames = {0};
    private int[] unlockedFrames = {1, 2, 3, 4, 5, 6, 7};

    public Door(float x, float y, TileMap tm) {
	super(
		x,
		y,
		tm,
		"spritesheet_door",
		16,
		48,
		16,
		48
	);
	initVelocity();
	initAnimations();
	isFacingRight = true;
    }

    @Override
    public void initAnimations() {
	animations = new ArrayList<Animation>();
	animations.add(new Animation(sprites, lockedFrames, lockedDelays));
	animations.add(new Animation(sprites, unlockedFrames, unlockedDelays));
	currentAnimation = LOCKED;
    }

    @Override
    public void initVelocity() {
	// TODO Auto-generated method stub

    }

    @Override
    public void move() {
	// doors don't move
    }

    @Override
    public void tick() {
	animations.get(currentAnimation).tick();
    }
    
    public void open() {
	currentAnimation = UNLOCKED;
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

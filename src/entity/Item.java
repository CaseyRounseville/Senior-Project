package entity;

import java.util.ArrayList;

import managers.SaveManager;
import map.TileMap;
import sprite.Animation;

public abstract class Item extends Actor {

    // animations
    // List<Animation> animations;
    /*
     * private Animation animation_idle; private Animation animation_collected;
     */

    // animation constants
    public static final int ANIMATION_IDLE = 0;
    public static final int ANIMATION_COLLECTED = 1;
    
    private int recordPos;

    // current animation
    // private Animation currentAnimation;

    private int[] idleDelays;
    private int[] collectedDelays;
    
    private int[] idleFrames;
    private int[] collectedFrames;

    // coordinates
    //private float x;
   // private float y;

    /*
     * public Item(SpriteSheet sprites, int animation_idle_delay, int
     * startSprite_idle, int endSprite_idle, int animation_collected_delay, int
     * startSprite_collected, int endSprite_collected, float x, int y) {
     */
    public Item(float x, float y, TileMap tm, String spriteLoc, int[] idleFrames, 
	    int[] idleDelays, int[] collectedFrames, int[] collectedDelays,
	    int spriteWidth, int spriteHeight, int collWidth, int collHeight, int recordPos) {
	super(x, y, tm, spriteLoc, spriteWidth, spriteHeight, collWidth, collHeight);
	//this.x = x;
	//this.y = y;
/*	this.animation_idle_delay = animation_idle_delay;
	this.animation_collected_delay = animation_collected_delay;
	this.startSprite_idle = startSprite_idle;
	this.startSprite_collected = startSprite_collected;
	this.endSprite_idle = endSprite_idle;
	this.endSprite_collected = endSprite_collected;*/
	this.idleFrames = idleFrames;
	this.idleDelays = idleDelays;
	this.collectedFrames = collectedFrames;
	this.collectedDelays = collectedDelays;
	initVelocity();
	initAnimations();
	this.recordPos = recordPos;
	isFacingRight = true;
    }

    public void collect() {
	currentAnimation = ANIMATION_COLLECTED;
	SaveManager.currentSaveData.getSceneRecord(0).setActorFlag(recordPos);
    }

    @Override
    public void initAnimations() {
	if (this.idleFrames == null) System.out.println("IDLEFRAMESNULL");
	animations = new ArrayList<Animation>();
	animations.add(new Animation(sprites, idleFrames, idleDelays));
	animations.add(new Animation(sprites, collectedFrames, collectedDelays));
	currentAnimation = ANIMATION_IDLE;
    }

    @Override
    public abstract void initVelocity();

    @Override
    public abstract void move();

    @Override
    public abstract void tick();

    /*
     * public void draw(Graphics2D g) { currentAnimation.draw(g, x, y); }
     */
}

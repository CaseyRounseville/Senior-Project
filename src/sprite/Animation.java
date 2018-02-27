package sprite;

import java.awt.Graphics2D;

public class Animation {

    private SpriteSheet sprites;

    //how many frames is each part of the animation
    private int maxFrames;
    
    // frames
    private int[] frames;
    
    // delays
    private int[] delays;

    //which frame is the animation currently on (count)
    private int currentDelay;
    private int delayCounter;

    //which picture the animation is currently on
    private int currentFrame;

    //private int startSprite;
   // private int endSprite;

    // has the animation been played once
    private boolean hasPlayedOnce;

    public Animation(SpriteSheet spriteSheet, int[] frames, int[] delays) {
	sprites = spriteSheet;
	maxFrames = frames.length;
	currentDelay = 0;
	delayCounter = 0;
	//currentSprite = 0;
	this.frames = frames;
	this.delays = delays;
	//startSprite = start;
	//endSprite = end;
	hasPlayedOnce = false;
    }

    public void tick() {
	delayCounter++;
	if (delayCounter == delays[currentDelay]) {
	    delayCounter = 0;
	    currentFrame++;
	    currentDelay++;
	    if (currentDelay >= delays.length) {
		currentDelay = 0;
	    }
	    if (currentFrame >= maxFrames) {
		currentFrame = 0;
		hasPlayedOnce = true;
	    }
	}
    }

    public void draw(Graphics2D g, int x0, int y0, int xf, int yf) {
	g.drawImage(sprites.getSprite(frames[currentFrame]), x0, y0, xf, yf, null);
	//tick();
    }

    public boolean hasBeenPlayedOnce() {
	return hasPlayedOnce;
    }
    
    public int getCurrentSpriteWidth() {
	return sprites.getSprite(frames[currentFrame]).getWidth();
    }
    
    public int getCurrentSpriteHeight() {
	return sprites.getSprite(frames[currentFrame]).getHeight();
    }

}

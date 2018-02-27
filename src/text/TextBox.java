package text;

import java.awt.Graphics2D;

import sprite.SpriteSheet;

public abstract class TextBox {
    
    // message
    protected Message message;
    
    
    
    // font
    protected static final int FONT_SIZE = 8;
    protected SpriteSheet sprites;
    
    // position in pixels
    protected int x;
    protected int y;
    

    
    public TextBox(String text, int lineLength, int x, int y) {
	message = new Message(text, lineLength);
	sprites = new SpriteSheet("spritesheet_text", FONT_SIZE, FONT_SIZE);
	this.x = x;
	this.y = y;
    }	
    
    public abstract void draw(Graphics2D g);
    
    public void tick() {
	
    }
    
}

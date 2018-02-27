package map;

import java.awt.image.BufferedImage;

public class Tile {
    
    // sprite
    private BufferedImage image;
    
    // type(blocked or clear)
    private byte type;
    public static final byte CLEAR = 0;
    public static final byte BLOCKED = 1;
    public static final byte DEATH = 2;
    public static final byte LADDER = 3;
    public static final byte ONEWAY = 4;
    public static final byte OUTOFBOUNDS_TOP = 5;
    public static final byte OUTOFBOUNDS_BOTTOM = 6;
    public static final byte OUTOFBOUNDS_LEFT = 7;
    public static final byte OUTOFBOUNDS_RIGHT = 8;
    
    
    
    public Tile(BufferedImage image, byte tileID) {
	this.image = image;
	type = (byte) (tileID % 5);
    }
    
    public static int convertTilesToPixels(float tiles) {
	return (int) (tiles * 16.0f);
    }
    
    public static float convertPixelsToTiles(int pixels) {
	return pixels / 16.0f;
    }
    
    public byte getType() { return type; } 
    
    public BufferedImage getImage() { return image; }
    
}

package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
    
    // image
    private BufferedImage image;
    // position
    private int xpix;
    private int ypix;
    
    // velocity
    private float vx;
    private float vy;
    private float depth;
    
    public Background(String fileLocation_sprites, float depth) {
	try {
	    image = ImageIO.read(new File(fileLocation_sprites));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	xpix = 0;
	ypix = 0;
	vx = 0.0f;
	vy = 0.0f;
	this.depth = depth;
    }
    
    public int getXPix() { return xpix; }
    public int getYPix() { return ypix; }
    public void setXPix(int x) { xpix = (int) (x * depth); }
    public void setYPix(int y) { ypix = (int) (y * depth); }
    public void setVX(float vx) { this.vx = vx; }
    public void setVY(float vy) { this.vy = vy; }
    
    public void draw(Graphics2D g) {
	g.drawImage(
		image,
		xpix,
		ypix,
		null
	);
    }
    
    public void tick() {
	//xpix += (int) (vx * depth * 16);
	//ypix += (int) (vy * depth * 16);
	if (xpix < 0)
	    xpix = 0;
	if (ypix < 0)
	    ypix = 0;
    }
    
}

package map;

import java.awt.Color;
import java.awt.Graphics2D;

public class Camera {

    // pixels
    private int x;
    private int y;

    private int width;
    private int height;
    
    public Camera(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
    }
    
    public void setX(int x) {
	this.x = x;
    }
    
    public void setY(int y) {
	this.y = y;
    }
    
    public void fixBounds(int numRows, int numCols) {
	
	int xmin = 0;
	int xmax = Tile.convertTilesToPixels(numCols) - width;
	int ymin = 0;
	int ymax = Tile.convertTilesToPixels(numRows) - height;
	
	if (x < xmin) x = xmin;
	if (x > xmax) x = xmax;
	if (y < ymin) y = ymin;
	if (y > ymax) y = ymax;
	
    }
    
    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }
    
    public void draw(Graphics2D g, TileMap tilemap) {
	int startRow = (int) Tile.convertPixelsToTiles(y);
	int startCol = (int) Tile.convertPixelsToTiles(x);
	
	int endRow = (int) Tile.convertPixelsToTiles(y + height) + 1;
	int endCol = (int) Tile.convertPixelsToTiles(x + width) + 1;
	
	for (int row = startRow; row < endRow; row++) {
	    for (int col = startCol; col < endCol; col++) {
		if (tilemap.getTileID(row, col) == 0) continue;
		g.drawImage(tilemap.getTile(tilemap.getTileID(row, col)).getImage(), col * 16 - x, row * 16 - y, null);
	    }
	}
    }
}

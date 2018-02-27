package map;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import main.Screen;
import managers.ResourceManager;
import sprite.SpriteSheet;

public class TileMap {

    // tile size
    public static final int TILE_SIZE = 16;

    // sprites
    SpriteSheet sprites;

    // tile map
    private byte[][] map;
    
    // tiles
    private Tile[] tiles;

    private Camera camera;


    public TileMap(String fileLocation_sprites, String fileLocation_tiles) {
	//loadMap(fileLocation_tiles);
	map = ResourceManager.getTileMap(fileLocation_tiles);
	//System.out.println(Arrays.toString(map));

	sprites = new SpriteSheet(fileLocation_sprites, 16, 16);
	initTiles();
	camera = new Camera(0, 0, Screen.WIDTH, Screen.HEIGHT);
	setFocusPoint(0.0f, 0.0f);
    }
    
    private void initTiles() {
	tiles = new Tile[sprites.getMaxIndex()];
	for (int i = 0; i < tiles.length; i++) {
	    tiles[i] = new Tile(sprites.getSprite(i), (byte) i);
	}
    }
    


    public void setFocusPoint(float x, float y) {
	
	camera.setX(Tile.convertTilesToPixels(x) - 320 / 2);
	camera.setY(Tile.convertTilesToPixels(y) - 240 / 2);
	camera.fixBounds(map.length, map[0].length);

    }





    public boolean isBlocked() {
	return false;
    }

    public boolean isOutOfBounds() {
	return false;
    }

    public void draw(Graphics2D g) {
	//System.out.println("startX: " + startX + ", startY: " + startY);
	

	
	camera.draw(g, this);
	
    }

    public int getNumRows() { return map.length; }

    public int getNumCols() { return map[0].length; }

    public byte getTileID(int row, int col) {
	if (row >= map.length || col >= map[0].length || row < 0 || col < 0)
	    return Tile.BLOCKED;
	else if (map[row][col] == -1)
	    return Tile.CLEAR;
	else
	    return map[row][col];
    }
    
    public Tile getTile(int tileID) { return tiles[tileID]; }
    
    public int getCamX() { return camera.getX(); }
    
    public int getCamY() { return camera.getY(); }

    public Camera getCamera() {
	return camera;
    }

}

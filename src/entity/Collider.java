package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Arrays;

import map.Tile;
import map.TileMap;

public class Collider {

    // dimensions
    protected int width;
    protected int height;

    // collision points
    protected Point2D.Float[] topPoints;
    protected Point2D.Float[] bottomPoints;
    protected Point2D.Float[] leftPoints;
    protected Point2D.Float[] rightPoints;
    protected Point2D.Float[] floorCheckPoints;

    // tile collision data
    protected byte[] tileData;
    public static final byte TOP = 0;
    public static final byte BOTTOM = 1;
    public static final byte LEFT = 2;
    public static final byte RIGHT = 3;
    public static final byte FLOOR_CHECK = 4;
    
    // tile map
    TileMap map;

    public Collider(int width, int height, TileMap map) {
	this.width = width;
	this.height = height;
	
	initCollisionPoints();
	
	tileData = new byte[5];
	
	this.map = map;
    }

    public int getWidth() {
	return width;
    }
    
    public int getHeight() {
	return height;
    }
    
    private void initCollisionPoints() {

	int numPoints;

	// top & bottom
	numPoints = width / 16 + 2;
	topPoints = new Point2D.Float[numPoints];
	bottomPoints = new Point2D.Float[numPoints];

	// left & right
	numPoints = height / 16 + 2;
	leftPoints = new Point2D.Float[numPoints];
	rightPoints = new Point2D.Float[numPoints];
	
	// floor check
	numPoints = width / 16 + 2;
	floorCheckPoints = new Point2D.Float[numPoints];

    }

    private void setCollisionPoints(float x, float y) {

	int numPoints;
	// checkpoint
	// top & bottom
	numPoints = width / 16 + 2;
	topPoints[0] = new Point2D.Float(x - Tile.convertPixelsToTiles(width / 2), y - Tile.convertPixelsToTiles(height / 2));
	topPoints[topPoints.length - 1] = new Point2D.Float(x + Tile.convertPixelsToTiles(width / 2 - 1), y - Tile.convertPixelsToTiles(height / 2));
	bottomPoints[0] = new Point2D.Float(x - Tile.convertPixelsToTiles(width / 2), y + Tile.convertPixelsToTiles(height / 2 - 1));
	bottomPoints[bottomPoints.length - 1] = new Point2D.Float(x + Tile.convertPixelsToTiles(width / 2 - 1), y + Tile.convertPixelsToTiles(height / 2 - 1));
	for (int i = 1; i < numPoints - 1; i++) {
	    topPoints[i] = new Point2D.Float((float) topPoints[i - 1].getX() + 15.0f / 16.0f, (float) topPoints[i - 1].getY());
	    bottomPoints[i] = new Point2D.Float((float) bottomPoints[i - 1].getX() + 15.0f / 16.0f, (float) bottomPoints[i - 1].getY());
	}

	// left & right
	numPoints = height / 16 + 2;
	leftPoints[0] = new Point2D.Float(x - Tile.convertPixelsToTiles(width / 2), y - Tile.convertPixelsToTiles(height / 2));
	leftPoints[leftPoints.length - 1] = new Point2D.Float(x - Tile.convertPixelsToTiles(width / 2), y + Tile.convertPixelsToTiles(height / 2- 1));
	rightPoints[0] = new Point2D.Float(x + Tile.convertPixelsToTiles(width / 2 - 1), y - Tile.convertPixelsToTiles(height / 2));
	rightPoints[rightPoints.length - 1] = new Point2D.Float(x + Tile.convertPixelsToTiles(width / 2 - 1), y + Tile.convertPixelsToTiles(height / 2 - 1));
	for (int i = 1; i < numPoints - 1; i++) {
	    leftPoints[i] = new Point2D.Float((float) leftPoints[i - 1].getX(), (float) leftPoints[i - 1].getY() + 15.0f / 16.0f);
	    rightPoints[i] = new Point2D.Float((float) rightPoints[i - 1].getX(), (float) rightPoints[i - 1].getY() + 15.0f / 16.0f);
	}
	
	// floor check
	numPoints = width / 16 + 2;
	floorCheckPoints[0] = new Point2D.Float(x - Tile.convertPixelsToTiles(width / 2), y + Tile.convertPixelsToTiles(height / 2));
	floorCheckPoints[floorCheckPoints.length - 1] = new Point2D.Float(x + Tile.convertPixelsToTiles(width / 2 - 1), y + Tile.convertPixelsToTiles(height / 2));
	for (int i = 1; i < numPoints - 1; i++) {
	    floorCheckPoints[i] = new Point2D.Float((float) floorCheckPoints[i - 1].getX() + 15.0f / 16.0f, (float) floorCheckPoints[i - 1].getY());
	}
    }
    
    public void calculateTileData(float x, float y) {
	boolean blocked;
	boolean death;
	boolean ladder;
	boolean oneway;
	setCollisionPoints(x, y);
	Point2D.Float[][] sides = new Point2D.Float[][] {
	    topPoints,
	    bottomPoints,
	    leftPoints,
	    rightPoints,
	    floorCheckPoints
	};
	
//
//	for (int i = 0; i < sides.length; i++) {
//	    for (int j = 0; j < sides[i].length; j++) {
//		System.out.print(sides[i][j] + "\t");
//	    }
//	    System.out.println();
//	}

	for (int i = 0; i < sides.length; i++) {
	    blocked = death = ladder = oneway = false;
	    for (int j = 0; j < sides[i].length; j++) {
		byte tileID = map.getTileID((int) Math.floor(sides[i][j].getY()), (int) Math.floor(sides[i][j].getX()));
		//System.out.println(tileID);
		Tile t = map.getTile(tileID);
		byte tileType = t.getType();
		if (tileType == Tile.BLOCKED) { // might need to break into 4 functions because of order / tile precedence
		    blocked = true;
		} else if (tileType == Tile.DEATH) {
		    death = true;
		} else if (tileType == Tile.LADDER) {
		    ladder = true;
		} else if (tileType == Tile.ONEWAY){
		    oneway = true;
		} else {
		}
	    }
	    if (blocked) {
		tileData[i] = Tile.BLOCKED;
	    } else if (death) {
		tileData[i] = Tile.DEATH;
	    } else if (ladder) {
		tileData[i] = Tile.LADDER;
	    } else if (oneway) {
		tileData[i] = Tile.ONEWAY;
	    } else {
		tileData[i] = Tile.CLEAR;
	    }
	}
    }

    public void draw(Graphics2D g) {
	Point2D.Float[][] sides = new Point2D.Float[][] {
		topPoints,
		bottomPoints,
		leftPoints,
		rightPoints,
		floorCheckPoints
	};
	g.setColor(Color.pink);
	for (int i = 0; i < sides.length; i++) {
	    for (int j = 0; j < sides[i].length; j++) {
		g.drawLine(Tile.convertTilesToPixels((float) sides[i][j].getX()) - map.getCamX(), Tile.convertTilesToPixels((float) sides[i][j].getY()) - map.getCamY(), Tile.convertTilesToPixels((float) sides[i][j].getX()) - map.getCamX(), Tile.convertTilesToPixels((float) sides[i][j].getY()) - map.getCamY());		
	    }
	}
    }
    
    @Override
    public String toString() {
	String top, bottom, left, right, floor;
	String[] strings = new String[] {
		top = "",
		bottom = "",
		left = "",
		right = "",
		floor = ""
	};
	Point2D.Float[][] sides = new Point2D.Float[][] {
		topPoints,
		bottomPoints,
		leftPoints,
		rightPoints,
		floorCheckPoints
	};
	for (int i = 0; i < sides.length; i++) {
	    for (int j = 0; j < sides[i].length; j++) {
		strings[i] += "(" + sides[i][j].getX() + ", " + sides[i][j].getY() + ")\n";
	    }
	}
	return "top: \n" 
	+ strings[0]
		+ "bottom: \n"
		+strings[1]
			+ "left: \n"
			+strings[2]
				+ "right: \n"
				+ strings[3]
					+"floor: \n"
					+strings[4]
						+ "------------------------------\n";

    }

    public void setTileMap(TileMap map) {
	this.map = map;
    }
    
}

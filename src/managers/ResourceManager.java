package managers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;

public final class ResourceManager {

    public static Map<String, BufferedImage> textures = new HashMap<String, BufferedImage>();
    public static Map<String, byte[][]> tilemaps = new HashMap<String, byte[][]>();
    
    public static void loadResource(String filename) {
	if (filename.startsWith("spritesheet")) {
	    loadTexture(filename);
	} else if (filename.startsWith("tilemap")) {
	    loadTileMap(filename);
	}
    }
    
    public static void loadTexture(String fileName) {
	System.out.print("loading texture: " + fileName + " ... ");
	try {
	    //textures.put(fileName, ImageIO.read(new File("res/textures/" + fileName + ".png")));
	    textures.put(fileName, ImageIO.read(ResourceManager.class.getResourceAsStream("/textures/" + fileName + ".png")));
	    System.out.println("done");
	} catch (Exception e) {
	    //e.printStackTrace();
	    System.err.println("error loading texture: " + fileName);
	    System.exit(0);
	}
    }
    
    public static void loadTileMap(String fileName) {
	System.out.print("loading tilemap: " + fileName + " ... ");
	try {
	    InputStream in = ResourceManager.class.getResourceAsStream("/tilemaps/" + fileName + ".txt");
	    if (in == null) System.out.println("null input stream");
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
//	    Scanner input = new Scanner(new File("res/tilemaps/" + fileName + ".txt"));
//	    int numRows = input.nextInt();
//	    int numCols = input.nextInt();
	    int numRows = Integer.parseInt(br.readLine());
	    int numCols = Integer.parseInt(br.readLine());
	    byte[][] tilemap = new byte[numRows][numCols];
	    for (int row = 0; row < numRows; row++) {
		String s = br.readLine();
		//System.out.println(s);
		//System.out.println("s: " + s);
		String[] line = s.split("\\s+");
		//System.out.println(Arrays.toString(line));
		//System.out.println(numCols + ", " + line.length);
		for (int col = 0; col < numCols; col++) {
		    //System.out.println(line[col]);
		    tilemap[row][col] = (byte) Integer.parseInt(line[col]);
		}
	    }
//	    for (int row = 0; row < numRows; row++) {
//		for (int col = 0; col < numCols; col++) {
//		    tilemap[row][col] = (byte) br.read();//input.nextByte();
//		    System.out.println(tilemap[row][col]);
//		}
//	    }
	    //input.close();
	    br.close();
	    tilemaps.put(fileName, tilemap);
	    System.out.println("done");
	} catch (Exception e) {
	    e.printStackTrace();
	    System.err.println("error loding tm: " + fileName);
	    System.exit(0);
	}
    }
    
    public static BufferedImage getTexture(String filename) {
	return textures.get(filename);
    }
    
    public static byte[][] getTileMap(String filename) {
	return tilemaps.get(filename);
    }
    
    public static void clearTextures() {
	textures.clear();
    }
    
    public static void clearTileMaps() {
	tilemaps.clear();
    }
    
}

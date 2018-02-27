package sprite;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.*;

import managers.ResourceManager;

public class SpriteSheet {

    //public static final int TILE_SIZE = 16;
    private int width;
    private int height;
    private BufferedImage[][] sprites;

    public SpriteSheet(String fileLocation, int width, int height) {
	BufferedImage sheet;
	this.width = width;
	this.height = height;
	try {
	    sheet = ResourceManager.getTexture(fileLocation);
	    
		if (sheet == null) System.out.println("________________NNNNUUUUULLLLLLLLL" + fileLocation);
	    init_sprites(sheet);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public SpriteSheet(String spriteFile, String controlFile) {
	BufferedImage sheet;
	try {
	    sheet = ResourceManager.getTexture(spriteFile);
	    init_sprites(sheet, controlFile);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void init_sprites(BufferedImage image) {
	sprites = new BufferedImage[image.getHeight() / height][image
		.getWidth() / width];
	for (int row = 0; row < sprites.length; row++) {
	    for (int col = 0; col < sprites[row].length; col++) {
		sprites[row][col] = image.getSubimage(
						        col * width, row *
						        height,
						        width,
						        height
						     );
		//col * sprites[0].length, row * sprites.length,
		//	sprites[0].length * 4, sprites.length * 4);
	    }
	}
    }
    
    private void init_sprites(BufferedImage image, String controlFile) {
	try {
	    InputStream in = SpriteSheet.class.getResourceAsStream("/textures/control files/" + controlFile + ".txt");
	    if (in == null) System.out.println("null input stream");
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
//	    Scanner input = new Scanner(new File(controlFile));
//	    int numRows = Integer.parseInt(input.nextLine().substring(10));
//	    int numCols = Integer.parseInt(input.nextLine().substring(10));
	    int numRows = Integer.parseInt(br.readLine());
	    int numCols = Integer.parseInt(br.readLine());
	    sprites = new BufferedImage[numRows][numCols];
	    int spriteRow = 0;
	    int spriteCol = 0;
	    String line = br.readLine();
	    
	    while (line != null) {
//		input.nextLine();
//		input.nextLine();
		//br.readLine();
		//br.readLine();
		
		int[] spriteData = new int[4];// x, y, width, height
		//System.out.println
		//("iteration");
		//for (int i = 0; i < spriteData.length; i++) {
		    
		    String[] tokens = line.split(", ");
		    for (int i = 0; i < 4; i++) {
			spriteData[i] = Integer.parseInt(tokens[i]);
		    }
		//}
		//br.readLine();
//		
//		int topLeftX = Integer.parseInt(input.nextLine().split("\\s")[input.nextLine().split("\\s").length - 1]);
//		System.out.println("past no1");
//		int topLeftY = Integer.parseInt(input.nextLine().substring(6));
//		int spriteWidth = Integer.parseInt(input.nextLine().substring(10));
//		int spriteHeight = Integer.parseInt(input.nextLine().substring(11));
		//System.out.println(line);
		//System.out.println(Arrays.toString(spriteData));
		
		
		if (image == null) System.out.println("9999999IMAGE      NULLL(9999999");
		
		sprites[spriteRow][spriteCol] = image.getSubimage(
			spriteData[0],
			spriteData[1],
			spriteData[2],
			spriteData[3]
		);
		
//		input.nextLine();
		spriteCol++;
		if (spriteCol == numCols) {
		    spriteCol = 0;
		    spriteRow++;
		}
		line = br.readLine();
	    }
//	    input.close();
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	System.out.println("it over 9000!!!!");
    }

    public BufferedImage getSprite(int sprite) { // sprite = i * col + j
	//System.out.println(sprite);
	//////////return sprites[sprite % sprites.length][sprite / sprites[0].length];
	//return sprites[sprite / sprites[0].length][sprite % sprites.length];
	//return sprites[0][0];////////////////////////////////////////////////////                        <---  FIX ME !!!!!!!!!!! 6/23/2015
//	if (sprites[sprite / sprites[0].length][sprite % sprites[0].length] == null) {
//	    return sprites[0][0];
//	} else {
	    return sprites[sprite / sprites[0].length][sprite % sprites[0].length];
//	}	
    }

    public int getMaxIndex() {
	return sprites.length * sprites[0].length;
    }

}
